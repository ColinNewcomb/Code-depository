package ratings;

import java.util.LinkedList;

import ratings.datastructures.LinkedListNode;

public class Song {
    private String Title;
    private String artist;
    private String SongID;
    private LinkedListNode<Rating> node;
    
    
    public Song(String Title,String artist,String SongID){
        this.Title=Title;
        this.artist=artist;
        this.SongID=SongID;
    }
    public String getTitle(){
        return this.Title;
    }
    public void setTitle(String Title){
        this.Title=Title;
    }
    public String getArtist(){
        return this.artist;
    }
    public void setArtist(String artist){
        this.artist=artist;
    }
    public String getSongID(){
        return this.SongID;
    }
    public void setSongID(String SongID){
        this.SongID=SongID;
    }
    public void addRating(Rating rating){   
        if(this.node == null){
            this.node=new LinkedListNode<>(rating, null);
        }else{
            LinkedListNode<Rating> next=this.node;
            while(next.getNext() != null){
                next=next.getNext();
            }
            next.setNext(new LinkedListNode<>(rating,null));
        }
    }
    public LinkedListNode<Rating> getRatings(){
        return this.node;
    }
    public void setRatings(LinkedListNode<Rating> node){
        this.node=node;
    }
    public double averageRating(){
        double sum=0.0;
        int count=0;
        LinkedListNode<Rating> node=this.node;
        if(this.node == null){
            return 0.0;
        }
        while(node != null){
            int rating=node.getValue().getRating();
            if (rating>=1 && rating<=5){
                sum+=rating;
                count++;
            }
            node=node.getNext();
        }
        return sum/count;
    }
    
    public void removeRatingByReviewer(Reviewer reviewer){
        if (this.node == null){
            return;
        }
        LinkedListNode<Rating> node=this.node;
        while(node.getNext() !=null){
            if(node.getNext().getValue().getReviewerID().equals(reviewer.getReviewerID())){
                node.setNext(node.getNext().getNext());
                return;
            }
        }
    }
}

