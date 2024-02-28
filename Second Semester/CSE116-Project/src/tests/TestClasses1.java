package tests;

import org.junit.Test;
import org.junit.internal.runners.TestClass;

import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TestClasses1 {
    public boolean compareSongs(Song Song1,Song Song2){
        assertEquals(Song1.getTitle(),Song2.getTitle()); 
        assertEquals(Song1.getArtist(),Song2.getArtist()); 
        assertEquals(Song1.getSongID(),Song2.getSongID());
        return true;
    }
    public boolean compareRatings(Rating Rating1,Rating Rating2){
        assertEquals(Rating1.getReviewerID(),Rating2.getReviewerID());
        assertEquals(Rating1.getRating(),Rating2.getRating());
        return true;
        
    }
    public boolean compareReviewers(Reviewer ID1,Reviewer ID2){
        assertEquals(ID1.getReviewerID(),ID2.getReviewerID());
        return true;
    }

    //TEST BELOW:

    @Test
    public void TestCompareSong(){
        Song Song1=new Song("a","b","c");
        Song Song2=new Song("a","b","c");
        Song Song3=new Song("111","111","111");
        Song Song4=new Song("111","111","111");
        Song Song5=new Song("something","word","111");
        Song Song6=new Song("something","word","111");
        
        TestClasses1 testClass = new TestClasses1();
        testClass.compareSongs(Song5,Song6);
        testClass.compareSongs(Song3,Song4);
        testClass.compareSongs(Song1,Song2);

    }
    @Test
    public void TestCompareRating(){
        Rating rate=new Rating("cool",5);
        Rating rate1=new Rating("cool",5);
        Rating rate2=new Rating("cool",100);
        Rating rate3=new Rating("cool",10);
        
        TestClasses1 testClass = new TestClasses1();
        testClass.compareRatings(rate, rate1);
        testClass.compareRatings(rate2, rate3);
    }
    @Test 
    public void TestCompareReviewer(){
        Reviewer person=new Reviewer("steve");
        Reviewer person1=new Reviewer("steve");

        TestClasses1 testClass = new TestClasses1();
        testClass.compareReviewers(person, person1);
    }
    @Test
    public void TestSetSong(){
        Song Song1=new Song("a","b","c");
        String Title="broke.";
        String artist="Chaz";
        String SongID="22 hours ago";
        Song1.setTitle(Title);
        Song1.setArtist(artist);
        Song1.setSongID(SongID);
        assertEquals(Title,Song1.getTitle());
        assertEquals(artist,Song1.getArtist());
        assertEquals(SongID,Song1.getSongID());
    }
    @Test
    public void TestSetRating(){
        Rating rate=new Rating("cool",5);
        Rating rate1=new Rating("cool",5);
        String ID="dope";
        int rating=1;
        int rating1=10;
        rate.setRating(rating);
        rate.setReviewerID(ID);
        rate1.setReviewerID(ID);
        rate1.setRating(rating1);
        assertEquals(ID,rate.getReviewerID());
        assertEquals(rating,rate.getRating());
        assertEquals(ID,rate1.getReviewerID());
        assertTrue(rate1.getRating()==(-1));
    }
    @Test
    public void TestInvalidRating(){
        Rating rate=new Rating("cool",0);
        Rating rate1=new Rating("cool",0);
        Rating rate2=new Rating("cool",0);
        Rating rate3=new Rating("cool",0);
        int rating=5;
        int rating1=1;
        int rating2=-5;
        int rating3=0;
        rate.setRating(rating);
        rate1.setRating(rating1);
        rate2.setRating(rating2);
        rate3.setRating(rating3);
        assertTrue(rate.getRating()==5);
        assertTrue(rate1.getRating()==1);
        assertTrue(rate2.getRating()==-1);
        assertTrue(rate3.getRating()==-1);

    }
    @Test
    public void TestSetReviewer(){
        Reviewer person=new Reviewer("steve");
        String ID="john";
        person.setReviewerID(ID);
        assertEquals(ID,person.getReviewerID());
    }
    @Test
    public void TestReviewerRate(){
        Reviewer person=new Reviewer("steve");
        Reviewer person1=new Reviewer("john");
        Reviewer person2=new Reviewer("kyle");
        Reviewer person3=new Reviewer("orange");
        Reviewer person4=new Reviewer("purple");
        
        int Rating=-1;//Test Negative/Below Bounds
        int Rating1=0;//Test Zero
        int Rating2=1;//Bounds
        int Rating3=5;//Bounds
        int Rating4=6;//Test Above Bounds
        
        Rating rate=person.rateSong(Rating);
        Rating rate1=person1.rateSong(Rating1);
        Rating rate2=person2.rateSong(Rating2);
        Rating rate3=person3.rateSong(Rating3);
        Rating rate4=person4.rateSong(Rating4);

        assertEquals("steve", rate.getReviewerID());
        assertEquals("john", rate1.getReviewerID());
        assertEquals("kyle", rate2.getReviewerID());
        assertEquals("orange", rate3.getReviewerID());
        assertEquals("purple", rate4.getReviewerID());
        assertTrue(rate.getRating()==-1);
        assertTrue(rate1.getRating()==-1);
        assertTrue(rate2.getRating()==1);
        assertTrue(rate3.getRating()==5);
        assertTrue(rate4.getRating()==-1);
        
    }
    
    @Test
    public void TestReviewerRateInvalid(){
        Reviewer person=new Reviewer("steve");
        int Rating=27;
        Rating rate=person.rateSong(Rating);
        assertTrue(rate.getRating()==-1);
    }
}
