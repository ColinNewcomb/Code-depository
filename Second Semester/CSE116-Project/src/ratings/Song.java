package ratings;

public class Song {
    private String Title;
    private String artist;
    private String SongID;
    
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
}