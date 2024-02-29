package tests;

import ratings.Reviewer;
import ratings.Rating;
import ratings.datastructures.LinkedListNode;
import static org.junit.Assert.*;
import java.util.LinkedList;
import ratings.Song;

import org.junit.Test;

public class TestDataStructures1 {

    public boolean compareListsOfRating(LinkedListNode<Rating> list1,LinkedListNode<Rating> list2){
        if(list1.getValue() == null && list2.getValue() == null){
            return true;
        }
        if(list1.getValue()==null || list2.getValue()==null){
            return false;
        }
        if(!(list1.getValue().getReviewerID().equals(list2.getValue().getReviewerID())) || 
        !(Math.abs(list1.getValue().getRating()-list2.getValue().getRating())<.001)){
            return false;
        }
        return compareListsOfRating(list1.getNext(), list2.getNext());
    }
    @Test
    public void testEmptyLinkedLists(){
        LinkedListNode<Rating> list1=new LinkedListNode<>(null,null);
        LinkedListNode<Rating> list2=new LinkedListNode<>(null,null);
        
        assertTrue(compareListsOfRating(list1, list2)==true);
    }
    @Test
    public void testaverageRating(){
        Rating rate=new Rating("cool",5);
        Rating rate1=new Rating("cool",5);
        Rating rate2=new Rating("cool",5);
        Song something = new Song("History","guy","111");

        something.addRating(rate);
        something.addRating(rate1);
        something.addRating(rate2);

        double average=something.averageRating();

        assertEquals(5.0,average,.001);
      
    }
    @Test
    public void testaverageRatingEdge(){
        
        Rating rate3=new Rating("cool",5);
        Rating rate6=new Rating("cool",5);
        Rating rate4=new Rating("cool",10);
        Rating rate5=new Rating("cool",0);
        Song something1 = new Song("History","guy","111");

        something1.addRating(rate3);
        something1.addRating(rate4);
        something1.addRating(rate5);
        something1.addRating(rate6);

        double average=something1.averageRating();
        assertEquals(5.0,average,.001);
    }
    @Test
    public void testremoveRatingByReviewer(){
        Reviewer person=new Reviewer("Rich");

        Rating rate3=new Rating("rich",5);
        Rating rate6=new Rating("cool",8);
        Rating rate4=new Rating("cool",9);
        Rating rate5=new Rating("cool",7);
        Song something1 = new Song("History","guy","111");

        something1.addRating(rate3);
        something1.addRating(rate4);
        something1.addRating(rate5);
        something1.addRating(rate6);

        something1.removeRatingByReviewer(person);

        double average=something1.averageRating();
        assertEquals(8.0,average,.001);
    }
}
