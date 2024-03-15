package ratings.datastructures;

import ratings.Song;
import ratings.Ratable;

public class SongTitleComparator extends Comparator<Song>{
    
    @Override
    public boolean compare(Song song1,Song song2){
        return (song1.getTitle().compareToIgnoreCase(song2.getTitle()))<0;
    }
}
