package ratings;
import java.util.ArrayList;


public class Movie extends Ratable{
    
    private ArrayList<String> cast;
    
    public Movie(String Movietitle ,ArrayList<String> cast){
        this.setTitle(Movietitle);
        this.cast=cast;
    }
    public ArrayList<String> getCast(){
        return this.cast;
    }
    
}
