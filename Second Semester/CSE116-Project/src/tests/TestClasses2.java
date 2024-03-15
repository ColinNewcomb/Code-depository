package tests;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import ratings.Movie;
import ratings.Ratable;
import ratings.datastructures.SongBayesianRatingComparator;

import ratings.Rating;
import ratings.Song;
import ratings.datastructures.SongTitleComparator;

public class TestClasses2 {
    
    public boolean compareArrayListsIgnoreCase(ArrayList<String> object1,ArrayList<String> object2){
        if(object1.size() != object2.size()){
            return false;
        }
        for (int x=0; x<object1.size(); x++){
            String a=object1.get(x);
            String b=object2.get(x);
            
            if(!a.equalsIgnoreCase(b)){
                return false;
            }
        }
        return true;
    }
    @Test
    public void testBayesianaverageMovie(){
        //Regular Test
        ArrayList<String> testData1 = new ArrayList<>(Arrays.asList("guy","girl"));
        Movie move=new Movie("Title",testData1);
        Rating rate3=new Rating("dope",4);
        Rating rate5=new Rating("Rich",5);
        move.addRating(rate3);
        move.addRating(rate5);
        assertEquals(3.75,move.bayesianAverageRating(2,3),.001);
    }
    @Test
    public void testBayesianaveraveMovieInvalid(){
        //First one being invalid NumExtraRatings 
        ArrayList<String> testData1 = new ArrayList<>(Arrays.asList("guy","girl"));
        Movie move=new Movie("Title",testData1);
        Rating rate3=new Rating("dope",4);
        Rating rate5=new Rating("Rich",5);
        move.addRating(rate3);
        move.addRating(rate5);
        assertEquals(0.0,move.bayesianAverageRating(-1,3),.001);
        //Invalid valExtraRating
        ArrayList<String> testData2 = new ArrayList<>(Arrays.asList("guy","girl"));
        Movie move1=new Movie("Title",testData2);
        Rating rate1=new Rating("dope",4);
        Rating rate2=new Rating("Rich",5);
        move.addRating(rate1);
        move.addRating(rate2);
        assertEquals(0.0,move1.bayesianAverageRating(2,-1),.001);

    }
    @Test
    public void testBayesianAverageNotValid(){
        Rating rate3=new Rating("dope",-1);
        Rating rate5=new Rating("Rich",-1);
        Song something1 = new Song("History","guy","111");

        something1.addRating(rate3);
        something1.addRating(rate5);

        assertEquals(3.0,something1.bayesianAverageRating(2,3),.001);
    }
    @Test
    public void testBayesianaverageSong(){
        //Regular Test
        Rating rate3=new Rating("dope",4);
        Rating rate5=new Rating("Rich",5);
        Song something1 = new Song("History","guy","111");

        something1.addRating(rate3);
        something1.addRating(rate5);

        assertEquals(3.75,something1.bayesianAverageRating(2,3),.001);

    }
    @Test
    public void testBayesianaverageSongInvalid(){
        //First one being invalid NumExtraRatings 
        Rating rate3=new Rating("dope",4);
        Rating rate5=new Rating("Rich",5);
        Song something1 = new Song("History","guy","111");

        something1.addRating(rate3);
        something1.addRating(rate5);

        assertEquals(0.0,something1.bayesianAverageRating(-1,3),.001);

        //Invalid valExtraRating
        Rating rate1=new Rating("dope",4);
        Rating rate2=new Rating("Rich",5);
        Song something2 = new Song("History","guy","111");

        something2.addRating(rate1);
        something2.addRating(rate2);

        assertEquals(0.0,something2.bayesianAverageRating(1,-1),.001);

        Rating rate6=new Rating("dope",-1);
        Rating rate7=new Rating("Rich",-1);
        Song something3 = new Song("History","guy","111");

        something3.addRating(rate6);
        something3.addRating(rate7);

        assertEquals(0.0,something2.bayesianAverageRating(-1,-1),.001);

        Rating rate8=new Rating("dope",2);
        Rating rate9=new Rating("Rich",3);
        Song something4 = new Song("History","guy","111");

        something4.addRating(rate8);
        something4.addRating(rate9);

        assertEquals(0.0,something4.bayesianAverageRating(-1,-1),.001);

        Rating rate4=new Rating("dope",-1);
        Rating rate0=new Rating("Rich",-1);
        Song persona4 = new Song("History","guy","111");

        persona4.addRating(rate4);
        persona4.addRating(rate0);

        assertEquals(3.0,persona4.bayesianAverageRating(2,3),.001);
    }
    @Test
    public void testGetCastDifferntCase(){
        ArrayList<String> movie= new ArrayList<>(Arrays.asList("GUY","girl"));
        Movie move=new Movie("Title",movie);
        ArrayList<String> movie1 = new ArrayList<>(Arrays.asList("guy","GIRL"));
        Movie move1=new Movie("Title",movie1);

        ArrayList<String> cast=move.getCast();
        ArrayList<String> cast1=move1.getCast();

        assertTrue(compareArrayListsIgnoreCase(cast,cast1)==true);
    }
    @Test
    public void testGetCastOdd(){
        ArrayList<String> movie= new ArrayList<>(Arrays.asList("mhm","mhm","Awesome"));
        Movie move=new Movie("Title",movie);
        ArrayList<String> movie1 = new ArrayList<>(Arrays.asList("mhm","mhm","Awesome"));
        Movie move1=new Movie("Title",movie1);

        ArrayList<String> cast=move.getCast();
        ArrayList<String> cast1=move1.getCast();

        assertTrue(compareArrayListsIgnoreCase(cast,cast1)==true);

        ArrayList<String> movie2= new ArrayList<>(Arrays.asList("mhm","mhm","mhm","yep"));
        Movie move2=new Movie("Title",movie2);
        ArrayList<String> movie3 = new ArrayList<>(Arrays.asList("mhm","mhm","mhm","yep"));
        Movie move3=new Movie("Title",movie3);

        ArrayList<String> cast2=move2.getCast();
        ArrayList<String> cast3=move3.getCast();

        assertTrue(compareArrayListsIgnoreCase(cast2,cast3)==true);
    }
    @Test
    public void testGetCast(){
        ArrayList<String> movie= new ArrayList<>(Arrays.asList("mhm","COOL","Awesome"));
        Movie move=new Movie("Title",movie);
        ArrayList<String> movie1 = new ArrayList<>(Arrays.asList("mhm","Cool","Awesome"));
        Movie move1=new Movie("Title",movie1);

        ArrayList<String> cast=move.getCast();
        ArrayList<String> cast1=move1.getCast();

        assertTrue(compareArrayListsIgnoreCase(cast,cast1)==true);

        ArrayList<String> movie2= new ArrayList<>(Arrays.asList("11111","WOW","DOPE"));
        Movie move2=new Movie("Title",movie2);
        ArrayList<String> movie3 = new ArrayList<>(Arrays.asList("11111","wow","dope"));
        Movie move3=new Movie("Title",movie3);

        ArrayList<String> cast2=move2.getCast();
        ArrayList<String> cast3=move3.getCast();

        assertTrue(compareArrayListsIgnoreCase(cast2,cast3)==true);

        ArrayList<String> movie5= new ArrayList<>(Arrays.asList("11111"));
        Movie move5=new Movie("Title",movie5);
        ArrayList<String> movie6 = new ArrayList<>(Arrays.asList("11111"));
        Movie move6=new Movie("Title",movie6);

        ArrayList<String> cast5=move5.getCast();
        ArrayList<String> cast6=move6.getCast();

        assertTrue(compareArrayListsIgnoreCase(cast5,cast6)==true);
    }
    @Test
    public void testGetCastInvalid(){
        //Inequal length
        ArrayList<String> movie= new ArrayList<>(Arrays.asList("guy","girl","dude"));
        Movie move=new Movie("Title",movie);
        ArrayList<String> movie1 = new ArrayList<>(Arrays.asList("guy","girl"));
        Movie move1=new Movie("Title",movie1);

        ArrayList<String> cast=move.getCast();
        ArrayList<String> cast1=move1.getCast();

        assertTrue(compareArrayListsIgnoreCase(cast,cast1)==false);

        ArrayList<String> movie4= new ArrayList<>(Arrays.asList("guy","girl"));
        Movie move4=new Movie("Title",movie4);
        ArrayList<String> movie5 = new ArrayList<>(Arrays.asList("guy","girl","dude"));
        Movie move5=new Movie("Title",movie5);

        ArrayList<String> cast4=move4.getCast();
        ArrayList<String> cast5=move5.getCast();

        assertTrue(compareArrayListsIgnoreCase(cast4,cast5)==false);
    
        //Different Order
        ArrayList<String> movie2= new ArrayList<>(Arrays.asList("guy","girl","man","Child"));
        Movie move2=new Movie("Title",movie2);
        ArrayList<String> movie3 = new ArrayList<>(Arrays.asList("girl","guy","child","man"));
        Movie move3=new Movie("Title",movie3);

        ArrayList<String> cast2=move2.getCast();
        ArrayList<String> cast3=move3.getCast();

        assertTrue(compareArrayListsIgnoreCase(cast2,cast3)==false);

        ArrayList<String> movie7= new ArrayList<>(Arrays.asList("guy","girl","person"));
        Movie move7=new Movie("Title",movie7);
        ArrayList<String> movie8 = new ArrayList<>(Arrays.asList("girl","guy","person"));
        Movie move8=new Movie("Title",movie8);

        ArrayList<String> cast7=move7.getCast();
        ArrayList<String> cast8=move8.getCast();

        assertTrue(compareArrayListsIgnoreCase(cast7,cast8)==false);
    }
    @Test
    public void testSongBayesianRatingComparator(){
        Song song = new Song("History","a","111");
        Song song1 = new Song("History","b","111");

        Rating rate=new Rating("dope",4);
        Rating rate1=new Rating("Rich",5);
        Rating rate2=new Rating("dope",1);
        Rating rate3=new Rating("Rich",2);
        song.addRating(rate);
        song.addRating(rate1);
        song1.addRating(rate2);
        song1.addRating(rate3);
        SongBayesianRatingComparator comparator= new SongBayesianRatingComparator();
        assertTrue(comparator.compare(song,song1)==true);

    }
    @Test
    public void testSongBayesianRatingComparatorInvalid(){
        Song song = new Song("History","a","111");
        Song song1 = new Song("History","b","111");

        Rating rate=new Rating("dope",1);
        Rating rate1=new Rating("Rich",2);
        Rating rate2=new Rating("dope",4);
        Rating rate3=new Rating("Rich",5);
        song.addRating(rate);
        song.addRating(rate1);
        song1.addRating(rate2);
        song1.addRating(rate3);
        SongBayesianRatingComparator comparator= new SongBayesianRatingComparator();
        assertTrue(comparator.compare(song,song1)==false);

    }
    @Test
    public void testOrderofCastMutltpartnames(){
        ArrayList<String> movie= new ArrayList<>(Arrays.asList("James A. Genese","Dead Meat","Colin Newcomb"));
        Movie move=new Movie("Title",movie);
        ArrayList<String> movie1 = new ArrayList<>(Arrays.asList("James A. Genese","Dead Meat","Colin Newcomb"));
        Movie move1=new Movie("Title",movie1);

        ArrayList<String> cast=move.getCast();
        ArrayList<String> cast1=move1.getCast();

        assertTrue(compareArrayListsIgnoreCase(cast,cast1)==true);
    }
    @Test
    public void testAverageNoFake(){
        Rating rate3=new Rating("dope",4);
        Rating rate5=new Rating("Rich",5);
        Song something1 = new Song("History","guy","111");

        something1.addRating(rate3);
        something1.addRating(rate5);

        assertEquals(4.0,something1.bayesianAverageRating(1,3),.001);

        Rating rate1=new Rating("dope",5);
        Rating rate2=new Rating("Rich",1);
        Song something2 = new Song("History","guy","111");

        something2.addRating(rate1);
        something2.addRating(rate2);

        assertEquals(3.0,something2.bayesianAverageRating(2,3),.001);
    }
    @Test
    public void testNoValid(){
        Movie movie = new Movie("Title", new ArrayList<>());
        double average = movie.bayesianAverageRating(0, 3);
        assertEquals(0.0, average, 0.001);
    }
    @Test
    public void testEmpty(){
        Movie move=new Movie("Title",new ArrayList<>());
        assertEquals(0.0,move.getCast().size(),.001);
    }
    @Test
    public void MovieCast(){
        ArrayList<String> moviecast= new ArrayList<>(Arrays.asList("J' Newton","Dead, Meat","@Colin Newcomb"));
        Movie move2=new Movie("Title",new ArrayList<>(Arrays.asList("J' Newton","Dead, Meat","@Colin Newcomb")));
        ArrayList<String> cast=move2.getCast();
        
        assertTrue(compareArrayListsIgnoreCase(moviecast,cast)==true);
    }
    @Test
    public void testDifferentTitles(){
        SongTitleComparator comparator=new SongTitleComparator();
        Song song1=new Song("History","Alright","111");
        Song song2=new Song("History","Bought","111");

        assertTrue(comparator.compare(song1, song2));
    }
    @Test
    public void testSameTitle(){
        SongTitleComparator comparator=new SongTitleComparator();
        Song song1=new Song("History","Alright","111");
        Song song2=new Song("History","Alright","111");
        assertFalse(comparator.compare(song1, song2));
    }
    @Test
    public void testComparePrefix(){
        SongTitleComparator comparator=new SongTitleComparator();
        Song song1=new Song("History","Run","111");
        Song song2=new Song("History","Running","111");
        assertTrue(comparator.compare(song1, song2));
    }
    @Test
    public void testCapital(){
        SongTitleComparator comparator=new SongTitleComparator();
        Song song1=new Song("History","alright","111");
        Song song2=new Song("History","Bought","111");
        assertTrue(comparator.compare(song1, song2));
    }
    @Test
    public void testEmptyString(){
        SongTitleComparator comparator=new SongTitleComparator();
        Song song1=new Song("History","","111");
        Song song2=new Song("History","Alright","111");
        assertTrue(comparator.compare(song1, song2));
    }
}

