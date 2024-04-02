package tests;

import ratings.Song;
import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;
import ratings.Playlist;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestDataStructures2 {
    public boolean compareSongTrees(BinaryTreeNode<Song> tree,BinaryTreeNode<Song> tree1){
        if(tree == null && tree1 == null){
            return true;
        }
        if(tree==null || tree1==null){
            return false;
        }
        TestClasses1 object=new TestClasses1();
        TestDataStructures1 otherobject=new TestDataStructures1();
        
        boolean test=object.compareSongs(tree.getValue(), tree1.getValue());
        if (!test){
            return false;
        }
        boolean testrating=otherobject.compareListsOfRatings(tree.getValue().getRatings(), tree1.getValue().getRatings());
        if (!testrating){
            return false;
        }
        boolean left=compareSongTrees(tree.getLeft(), tree1.getLeft());
        if(!left){
            return false;
        }
        boolean right=compareSongTrees(tree.getRight(), tree1.getRight());
        if(!right){
            return false;
        }
        return true;
    }

    @Test
    public void testdecentNumberofSongs(){
        SongTitleComparator comparator=new SongTitleComparator();
        Playlist object=new Playlist(comparator);
        Song upsidedown=new Song("a", "IDK", "1");
        Song four=new Song("b", "ywep", "000");
        Song random=new Song("c", "sup", "-3--3");
        Song broke=new Song("d", "IDK", "1123");
        Song idk=new Song("e", "ywep", "21232");
        Song runningout=new Song("f", "sup", "3312");
        Song a=new Song("g", "IDK", "1123");
        Song b=new Song("h", "ywep", "21232");
        Song c=new Song("i", "sup", "3312");
        Song d=new Song("j", "IDK", "1123");
        Song e=new Song("k", "ywep", "21232");
        Song f=new Song("l", "sup", "3312");
        object.addSong(f);
        object.addSong(e);
        object.addSong(d);
        object.addSong(c);
        object.addSong(a);
        object.addSong(b);
        object.addSong(runningout);
        object.addSong(idk);
        object.addSong(upsidedown);
        object.addSong(four);
        object.addSong(random);
        object.addSong(broke);
        LinkedListNode<Song> Songlist = object.getSongList();

        SongTitleComparator comparator2=new SongTitleComparator();
        int count=0;
        Song pervious=null;
        while(Songlist!=null){
            count++;
            if (pervious!=null){
                assertTrue(comparator2.compare(pervious,Songlist.getValue()));
            }
            pervious=Songlist.getValue();
            Songlist=Songlist.getNext();
        }
        assertEquals(12,count);
    }
    @Test
    public void testPresentSongs(){
        SongTitleComparator comparator=new SongTitleComparator();
        Playlist object=new Playlist(comparator);
        Song upsidedown=new Song("UpsideDown", "IDK", "1");
        Song four=new Song("Dope", "ywep", "000");
        Song random=new Song("Brke", "sup", "-3--3");
        object.addSong(upsidedown);
        object.addSong(four);
        object.addSong(random);
        LinkedListNode<Song> Songlist = object.getSongList();
        boolean upsidedown_there=false;
        boolean four_there=false;
        boolean random_there=false;
        while(Songlist !=null){
            if(Songlist.getValue().equals(upsidedown)){
                upsidedown_there=true;
            }
            if(Songlist.getValue().equals(four)){
                four_there=true;
            }
            if (Songlist.getValue().equals(random)) {
                random_there=true;
            }
            Songlist=Songlist.getNext();
        }
        assertTrue(upsidedown_there);
        assertTrue(four_there);
        assertTrue(random_there);
    }
}
