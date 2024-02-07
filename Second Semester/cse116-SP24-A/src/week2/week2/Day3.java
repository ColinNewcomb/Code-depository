package week2;

import java.util.ArrayList;
import java.util.HashMap;

public class Day3 {
    /*
     * 1)Write a static method that takes a size as a parameter and returns 
     * an arraylist that many elements each of which is a random number from 0-100
     * 2) write a method that averages the elements of a list like you created in part 1
     * 3)write a method that creates a hashmap of strings to integers of a size given by a parameter,
     * String and ints should be random
     * 4)write a method that takes a hashmap and returns the key to the largest value 
     */
    public static ArrayList<Integer> randArray(int i) {
        ArrayList<Integer> arr1=new ArrayList<>();
        for (int x=0; x<i; x++){
            arr1.add((int)(Math.random()*101));
        }
        return arr1;
    }
    public static double average(ArrayList<Integer> numbers) {
        double total=0;
        if(numbers.size() == 0){
            return 0;
        }else{
            for (int x=0; x<numbers.size(); x++){
                total+=numbers.get(x)/numbers.size();
            }
            return total;
        }
    }
    public static HashMap<String, Integer> randhash(int size) {
         HashMap<String,Integer> out=new HashMap<>();
        return out;


    }
    
    public static void main(String[] args) {
        ArrayList<Integer> result=randArray(3);
        //System.out.println(randArray(result));
        double result2=average(result);
        System.out.println(result2);
        {

        }
    }
}

