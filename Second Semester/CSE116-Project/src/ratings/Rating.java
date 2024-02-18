package ratings;

public class Rating {
    private String ID;
    private int rating;

    public Rating(String ID,int rating){
        this.ID=ID;
        this.rating=rating;
    }   
    public String getReviewerID(){
            return this.ID;
    }
    public void setReviewerID(String ID){
        this.ID=ID;
    }
    public int getRating(){
        return this.rating;
    }
    public void setRating(int rating){
        if (rating < 1 || rating>5){
            this.rating=-1;
        }else{
            this.rating=rating;
        }
    }
}

