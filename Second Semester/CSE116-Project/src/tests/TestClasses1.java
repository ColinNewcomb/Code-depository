package tests;

import org.junit.Test;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.plaf.TreeUI;


public class TestClasses1 {
    public boolean compareSongs(Song Song1,Song Song2){
        assert Song1.getTitle().equals(Song2.getTitle());
        assert Song1.getArtist().equals(Song2.getArtist());
        assert Song1.getSongID().equals(Song2.getSongID());
        return true;
    }
    public boolean compareRatings(Rating Rating1,Rating Rating2){
        assert Rating1.getReviewerID().equals(Rating2.getReviewerID());
        assert Rating1.getRating() == (Rating2.getRating());
        return true;
        
    }
    public boolean compareReviewers(Reviewer ID1,Reviewer ID2){
        assert ID1.getReviewerID().equals(ID2.getReviewerID());
        return true;
    }

    @Test
    public void TestSong(){
        Song Song1=new Song("a","b","c");
        Song Song2=new Song("a","b","c");
        Song Song3=new Song("dog","cat","fox");
        Song Song4=new Song("dog","cat","fox");
        Song Song5=new Song("something","word","111");
        Song Song6=new Song("something","word","111");
        
        assertTrue(compareSongs(Song5,Song6)==true);
        assertTrue(compareSongs(Song3,Song4)==true);
        assertTrue(compareSongs(Song1,Song2)==true);

    }
    @Test
    public void TestRating(){
        Rating rate=new Rating("cool",5);
        Rating rate1=new Rating("cool",5);
        
        assertTrue(compareRatings(rate, rate1)==true);
    }
    @Test 
    public void TestReviewer(){
        Reviewer person=new Reviewer("steve");
        Reviewer person1=new Reviewer("steve");

        assertTrue(compareReviewers(person, person1));
    }
}
