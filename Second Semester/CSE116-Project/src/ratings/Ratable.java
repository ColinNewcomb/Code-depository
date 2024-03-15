package ratings;

import ratings.datastructures.LinkedListNode;
import ratings.Rating;

public class Ratable {
    private String Title;
    private LinkedListNode<Rating> RatingList;

    public String getTitle(){
        return this.Title;
    }
    public void setTitle(String Title){
        this.Title=Title;
    }
    public void addRating(Rating rating){   
        if(this.RatingList == null){
            this.RatingList=new LinkedListNode<>(rating, null);
        }else{
            LinkedListNode<Rating> currentnode=this.RatingList;
            while(currentnode != null && currentnode.getNext() != null){
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
        LinkedListNode<Rating> currentnode=this.RatingList;
        if(this.RatingList == null){
            return 0.0;
        }
        while(currentnode != null){
            int rating=currentnode.getValue().getRating();
            if (rating>=1 && rating<=5){
                sum+=rating;
                count++;
            }
            currentnode=currentnode.getNext();
        }
        return sum/count;
    }
    
    public void removeRatingByReviewer(Reviewer reviewer){
        if (this.RatingList == null){
            return;
        }
        if (this.RatingList != null && this.RatingList.getValue().getReviewerID().equals(reviewer.getReviewerID())){
            this.RatingList=this.RatingList.getNext();
            return;
        }
        LinkedListNode<Rating> currentnode=this.RatingList;
        while(currentnode.getNext() !=null){
            if(currentnode !=null && currentnode.getNext().getValue().getReviewerID().equals(reviewer.getReviewerID())){
                currentnode.setNext(currentnode.getNext().getNext());
                return;
            }
            currentnode=currentnode.getNext();
        }
    }
    public double bayesianAverageRating(int numExtraRatings,int valExtraRating){
        if (this.RatingList==null && numExtraRatings==0){
            return 0.0;
        }
        if(numExtraRatings==0 && (valExtraRating>=1 && valExtraRating<=5)){
            return averageRating();
        }
        if (valExtraRating<1 || valExtraRating>5 || numExtraRatings<0){
            return 0.0;
        }
        double sum=0.0;
        int count=0;
        LinkedListNode<Rating> currentnode=this.RatingList;
        while(currentnode != null){
            int rating=currentnode.getValue().getRating();
            if (rating>=1 && rating<=5){
                sum+=rating;
                count++;
            }
            currentnode=currentnode.getNext();
        }
        sum+=numExtraRatings*valExtraRating;
        count+=numExtraRatings;
        return sum/count;
    }
}
