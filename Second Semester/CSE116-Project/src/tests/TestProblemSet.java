package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TestProblemSet {
    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class
    @Test
    public void TestArrayPositive(){
        //assertEquals(ProblemSet.average()==2.0);
    }
}

    // as a parameter and returns a key mapping to the largest Integer. Ties can be broken arbitrarily.
    //If the HashMap is empty, return the empty String
    //
    // Examples
    // {"CSE": 100, "MTH": 90, "MGT": 10} returns "CSE"
    // {"cat": 5, "dog": 5, "fox": 4} can return either "cat" or "dog"
    // {} returns ""

    //returns the sum of the digits of the input as an int
    //
    // Examples
    // 123 returns 6
    // 57 returns 12
    // -36 returns 9
    
    //If the ArrayList is empty, return 0.0
    //
    // Examples
    // [1.0,2.0,3.0] returns 2.0
    // [-5.0,5.0] returns 0.0
    // [6.5,6.5,8.5,8.5] returns 7.5
    // [] returns 0.0