package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import ratings.Movie;
import ratings.Rating;
import ratings.Song;
import ratings.datastructures.LinkedListNode;
import ratings.FileReader;

public class TestFiles {
    
    public boolean compareMovieArrayLists(ArrayList<Movie> movies,ArrayList<Movie> movies1){
        if(movies.size()!=movies1.size()){
            return false;
            }
        for(Movie movie : movies){
            boolean found=false;
            for (Movie other : movies1){
                if(compareMovies(movie,other)){
                    found=true;
                }
            }
            if(!found){
                return false;
            }
        }
    
        for (Movie movie : movies1){
            boolean found=false;
            for(Movie other : movies){
                if(compareMovies(movie,other)){
                    found=true;
                }
            }
            if(!found){
                return false;
            }
        }
        return true;
    }


    private boolean compareMovies(Movie movie,Movie movie1){
        if(!movie.getTitle().equals(movie1.getTitle())){
            return false;
        }
        if(!movie.getCast().equals(movie1.getCast())){
            return false;
        }
        if(!compareListsOfRatings(movie.getRatings(), movie1.getRatings())){
            return false;
        }
        return true;
    }
    private boolean compareListsOfRatings(LinkedListNode<Rating> list1,LinkedListNode<Rating> list2){
        if(list1 == null && list2 == null){
            return true;
        }
        if(list1==null || list2==null){
            return false;
        }
        if(!(list1.getValue().getReviewerID().equals(list2.getValue().getReviewerID())) || 
        !(Math.abs(list1.getValue().getRating()-list2.getValue().getRating())<.001)){
            return false;
        }
        return compareListsOfRatings(list1.getNext(), list2.getNext());
    }
    @Test
    public void testdifferetsizearray(){
        ArrayList<Movie> movielist1 = new ArrayList<>(Arrays.asList(
            new Movie("Unbroken", new ArrayList<>(Arrays.asList("Person#4", "Person#5"))),
            new Movie("Willy Wonka", new ArrayList<>(Arrays.asList("Person#1", "Person#2")))));
        ArrayList<Movie> differentarray = new ArrayList<>();
        assertFalse(compareMovieArrayLists(movielist1, differentarray));
    }
    @Test
    public void testdifferentitles_cast(){
        ArrayList<Movie> movielist1 = new ArrayList<>(Arrays.asList(
            new Movie("Unbroken", new ArrayList<>(Arrays.asList("Person#4", "Person#5"))),
            new Movie("Willy Wonka", new ArrayList<>(Arrays.asList("Person#1", "Person#2")))));
            ArrayList<Movie> movielist2 = new ArrayList<>(Arrays.asList(
            new Movie("Wild West", new ArrayList<>(Arrays.asList("Person#1", "Person#2"))),
            new Movie("Rocky", new ArrayList<>(Arrays.asList("Person#1", "Person#2")))));
        assertFalse(compareMovieArrayLists(movielist1, movielist2));
    }
    @Test
    public void testdifferentratings(){
        Movie movie1=new Movie("Rocky", new ArrayList<>(Arrays.asList("Person#1", "Person#2")));
        Movie movie=new Movie("Wild West", new ArrayList<>(Arrays.asList("Person#1", "Person#2")));
        Rating rate=new Rating("cool",5);
        Rating rate1=new Rating("dope",3);
        movie1.addRating(rate);
        movie.addRating(rate1);
        ArrayList<Movie> movielist = new ArrayList<>(Arrays.asList(movie,movie1));
        ArrayList<Movie> movielist1= new ArrayList<>(Arrays.asList(movie1,movie));
        assertTrue(compareMovieArrayLists(movielist,movielist1));
        
    }
    @Test
    public void testdifferentorder(){
        Movie movie1=new Movie("Rocky", new ArrayList<>(Arrays.asList("Person#1", "Person#2")));
        Movie movie=new Movie("Wild West", new ArrayList<>(Arrays.asList("Person#1", "Person#2")));
        Rating rate=new Rating("cool",5);
        movie1.addRating(rate);
        movie.addRating(rate);
        ArrayList<Movie> movielist = new ArrayList<>(Arrays.asList(movie,movie1));
        ArrayList<Movie> movielist1= new ArrayList<>(Arrays.asList(movie1,movie));
        assertTrue(compareMovieArrayLists(movielist,movielist1));
    }
    @Test
    public void testSongInvalidfilename(){
        ArrayList<Song> testSong=ratings.FileReader.readSongs("Absolutely Nothing");
        ArrayList<Song> nothing=new ArrayList<>();
        assertEquals(nothing,testSong);
    }
    @Test
    public void testMovieInvalidFilename(){
        ArrayList<Movie> testMovie=ratings.FileReader.readMovies("Absolutely Nothing");
        ArrayList<Movie> nothing=new ArrayList<>();
        assertEquals(nothing,testMovie);
    }
    @Test
    public void testMovieRatingInvalidFilename(){
        ArrayList<Movie> movielist1 = new ArrayList<>(Arrays.asList(
            new Movie("Unbroken", new ArrayList<>(Arrays.asList("Person#4", "Person#5"))),
            new Movie("Willy Wonka", new ArrayList<>(Arrays.asList("Person#1", "Person#2")))));
        ArrayList<Movie> nothing=new ArrayList<>();
        ArrayList<Movie> testMovie=ratings.FileReader.readMovieRatings(movielist1, "Absolutely Nothing");
        assertEquals(nothing,testMovie);
    }
}
