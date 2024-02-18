package ratings;

public class Reviewer {
    private String ID;

    public Reviewer(String ID){
        this.ID=ID;
    }
    public String getReviewerID(){
        return this.ID;
    }
    public void setReviewerID(String ID){
        this.ID=ID;
    }
    public Rating rateSong(int rating){
        return new Rating(ID,rating);
    }

}

