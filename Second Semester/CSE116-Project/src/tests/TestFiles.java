package tests;

import java.util.ArrayList;

import org.junit.Test;

import ratings.Movie;

public class TestFiles {
    public boolean compareMovieArrayLists(ArrayList<Movie> movies,ArrayList<Movie> movies1){
        if(movies.size()!=movies1.size()){
            return false;
        }
        for (Movie movie : movies){
            if(!movies1.contains(movie)){
                return false;
            }
        }
        for (Movie movie : movies1){
            if(!movies.contains(movie)){
                return false;
            }
        }
        return true;
    }
    @Test
    public void testreadSongs(){

    }
    @Test
    public void testreadMovies(){

    }
    @Test
    public void testreadMovieRating(){
        
    }
}
