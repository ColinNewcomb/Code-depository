package ratings;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import ratings.Song;



public class FileReader {
    public static ArrayList<Song> readSongs(String filename){
        ArrayList<Song> something=new ArrayList<>();
        HashMap<String, Song> SongHash=new HashMap<>();
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            for (String line : lines){
                String[] positions=line.split(",");
                String songArtist = positions[1];
                String SongID = positions[0];
                String Title = positions[2];
                String ReviewerID = positions[3];
                int rating = Integer.parseInt(positions[4]);
                
                Song song=SongHash.getOrDefault(SongID, new Song(Title,songArtist,SongID));
                song.addRating(new Rating(ReviewerID,rating));
                SongHash.putIfAbsent(SongID,song);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            return new ArrayList<>();
        }
        something.addAll(SongHash.values());
        return something;
    }
    public static ArrayList<Movie> readMovies(String filename){
        ArrayList<Movie> something=new ArrayList<>();
        try{
            ArrayList<String> lines=new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            for (String line : lines){
                String[] positions=line.split(",");
                String movieTitle=positions[0];
                ArrayList<String> cast=new ArrayList<>();
                for(int x=1;x<positions.length; x++){
                    cast.add(positions[x]);
                }
                Movie Movie=new Movie(movieTitle,cast);
                something.add(Movie);
            }
    
        }catch (IOException e){
            //e.printStackTrace();
            return new ArrayList<>();
        }
        return something;
    } 
    public static ArrayList<Movie> readMovieRatings(ArrayList<Movie> readmovies,String filename){
        ArrayList<Movie> something=new ArrayList<>();
        try{
            ArrayList<String> lines=new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            for (String line : lines){
                String[] positions=line.split(",");
                String movietitle=positions[0];
                String reviewerID=positions[1];
                int Rating=Integer.parseInt(positions[2]);
                boolean Found=false;
                for (Movie movie : readmovies){
                    if(movie.getTitle().equals(movietitle) && !Found){
                        movie.addRating(new Rating(reviewerID,Rating));

                        if(!something.contains(movie)){
                            something.add(movie);
                        }
                        Found=true;
                    }
                }
            }
        }catch (IOException e){
            //e.printStackTrace();
            return new ArrayList<>();
        }
        return something;
    }
}
