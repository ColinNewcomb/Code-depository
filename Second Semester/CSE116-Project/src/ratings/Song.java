package ratings;

import ratings.datastructures.LinkedListNode;

public class Song {
    private String Title;
    private String artist;
    private String SongID;
    private LinkedListNode<Rating> RatingList;
    
    
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
        if(this.RatingList == null){
            this.RatingList=new LinkedListNode<>(rating, null);
        }else{
            LinkedListNode<Rating> currentnode=this.RatingList;
            while(currentnode.getNext() != null){
                currentnode=currentnode.getNext();
            }
            currentnode.setNext(new LinkedListNode<>(rating,null));
        }
    }
    public LinkedListNode<Rating> getRatings(){
        return this.RatingList;
    }
    public void setRatings(LinkedListNode<Rating> node){
        this.RatingList=node;
    }
    public double averageRating(){
        double sum=0.0;
        int count=0;
        LinkedListNode<Rating> node=this.RatingList;
        if(this.RatingList == null){
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
        if (this.RatingList == null){
            return;
        }
        LinkedListNode<Rating> node=this.RatingList;
        while(node.getNext() !=null){
            if(node.getNext().getValue().getReviewerID().equals(reviewer.getReviewerID())){
                
                return;
            }
        }
    }
}

