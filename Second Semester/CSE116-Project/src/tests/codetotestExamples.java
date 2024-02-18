package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class codetotestExamples {
    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class
    @Test//
    public void TestArrayPositive(){
        ArrayList<Double> testData = new ArrayList<>(Arrays.asList(1.0,2.0,3.0));
        ArrayList<Double> testData1 = new ArrayList<>(Arrays.asList(5.0,5.0));
        ArrayList<Double> testData2 = new ArrayList<>(Arrays.asList(6.5,6.5,8.5,8.5));
        assertTrue(ProblemSet.average(testData)==2.0);
        assertTrue(ProblemSet.average(testData1)==5.0);
        assertTrue(ProblemSet.average(testData2)==7.5);
    }
    @Test//
    public void TestArrayNegative(){
        ArrayList<Double> testData = new ArrayList<>(Arrays.asList(-1.0,-2.0,-3.0));
        ArrayList<Double> testData1 = new ArrayList<>(Arrays.asList(-5.0,-5.0));
        ArrayList<Double> testData2 = new ArrayList<>(Arrays.asList(-6.5,-6.5,-8.5,-8.5));
        assertTrue(ProblemSet.average(testData)==-2.0);
        assertTrue(ProblemSet.average(testData1)==-5.0);
        assertTrue(ProblemSet.average(testData2)==-7.5);
    }
    @Test//
    public void TestArrayZeros(){
        ArrayList<Double> testData = new ArrayList<>(Arrays.asList(1.0,1.0,1.0,0.0));
        ArrayList<Double> testData1 = new ArrayList<>(Arrays.asList(0.0,1.0,1.0,0.0));
        ArrayList<Double> testData2 = new ArrayList<>(Arrays.asList(0.0,0.0));
        ArrayList<Double> testData3 = new ArrayList<>(Arrays.asList());
        assertTrue(ProblemSet.average(testData)==0.75);
        assertTrue(ProblemSet.average(testData1)==0.50);
        assertTrue(ProblemSet.average(testData2)==0.00);
        assertTrue(ProblemSet.average(testData3)==0.00);
    }
    @Test
    public void TestZeros(){
        assertTrue(ProblemSet.sumOfDigits(0)==0);
        assertTrue(ProblemSet.sumOfDigits(01)==1);
        assertTrue(ProblemSet.sumOfDigits(101)==2);
        assertTrue(ProblemSet.sumOfDigits(000)==0);
        assertTrue(ProblemSet.sumOfDigits(110)==2);
    }
    @Test
    public void TestPositive(){
        assertTrue(ProblemSet.sumOfDigits(123)==6);
        assertTrue(ProblemSet.sumOfDigits(57)==12);
        assertTrue(ProblemSet.sumOfDigits(444)==12);
    }
    @Test
    public void TestNegative(){
        assertTrue(ProblemSet.sumOfDigits(-123)==6);
        assertTrue(ProblemSet.sumOfDigits(-36)==9);
        assertTrue(ProblemSet.sumOfDigits(-55)==10);
    }
    @Test
    public void TestEmpty(){
        HashMap<String,Integer> testdata1 = new HashMap<>(Map.of());
        assertTrue(ProblemSet.bestKey(testdata1)=="");
    }
    @Test//
    public void TestEqual(){
        HashMap<String,Integer> testdata1 = new HashMap<>(Map.of("CSE",100, "MTH", 100, "MGT", 10));
        HashMap<String,Integer> testdata2 = new HashMap<>(Map.of("cat", 5, "dog", 5, "fox", 4));
        assertTrue(ProblemSet.bestKey((testdata1))=="CSE");
        assertTrue(ProblemSet.bestKey((testdata2))=="dog");
    }
    @Test
    public void TestZero(){
        HashMap<String,Integer> testdata1 = new HashMap<>(Map.of("cat",9,"dog",0,"fox",0));
        HashMap<String,Integer> testdata2 = new HashMap<>(Map.of("cat",0,"dog",1,"fox",0));
        HashMap<String,Integer> testdata3 = new HashMap<>(Map.of("cat",0,"dog",4,"fox",9));
        assertTrue(ProblemSet.bestKey((testdata1))=="cat");
        assertTrue(ProblemSet.bestKey((testdata2))=="dog");
        assertTrue(ProblemSet.bestKey((testdata3))=="fox");
    }
    @Test
    public void TestNegativeHash(){
        HashMap<String,Integer> testdata1 = new HashMap<>(Map.of("cat",-1,"dog",-4,"fox",-30));
        HashMap<String,Integer> testdata2 = new HashMap<>(Map.of("cat",-1,"dog",-16,"fox",5));
        HashMap<String,Integer> testdata3 = new HashMap<>(Map.of("cat",5,"dog",-2,"fox",0));
        HashMap<String,Integer> testdata4 = new HashMap<>(Map.of("cat",0,"dog",-2,"fox",-10));
        assertTrue(ProblemSet.bestKey((testdata1))=="cat");
        assertTrue(ProblemSet.bestKey((testdata2))=="fox");
        assertTrue(ProblemSet.bestKey((testdata3))=="cat");
        assertTrue(ProblemSet.bestKey((testdata4))=="cat");
    }
}    