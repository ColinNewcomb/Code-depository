package ratings;

import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;

public class Playlist {
    private Comparator<Song> comparator;
    private BinaryTreeNode<Song> root;

    public Playlist(Comparator<Song> comparator){
        this.root=null;
        this.comparator=comparator;
    }
   
    public void addSong(Song song){
        if (this.root==null){
            this.root=new BinaryTreeNode<>(song,null,null);
        }else{
            this.insertHelper(this.root,song);
        }
    }
    
    private void insertHelper(BinaryTreeNode<Song> root,Song song){
        if (this.comparator.compare(song, root.getValue())) {
            if (root.getLeft() == null) {
                root.setLeft(new BinaryTreeNode<>(song, null, null));
            } else {
                insertHelper(root.getLeft(), song);
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(new BinaryTreeNode<>(song, null, null));
            } else {
                insertHelper(root.getRight(), song);
            }
        }
    }
    
    public BinaryTreeNode<Song> getSongTree(){
        return this.root;
    }
    public LinkedListNode<Song> getSongList(BinaryTreeNode<Song> tree){
        if(tree == null){
            return null;
        }
        return Traverse(tree);
    }
    private LinkedListNode<Song> Traverse(BinaryTreeNode<Song> tree){
        if (tree==null){
            return null;
        }
        LinkedListNode<Song> left=Traverse(tree.getLeft());
        LinkedListNode<Song> currentNode=new LinkedListNode<Song>(tree.getValue(), null);
        if (left != null){
            LinkedListNode<Song> current=left;
            while (current.getNext() != null){
                current=current.getNext();
            }
            current.setNext(currentNode);
        }else{
            left=currentNode;
        }
        LinkedListNode<Song> right=Traverse(tree.getRight());
        currentNode.setNext(right);

        return left;
    }
    public LinkedListNode<Song> getSongList(){
        return getSongList(this.root);
    }
    
}
