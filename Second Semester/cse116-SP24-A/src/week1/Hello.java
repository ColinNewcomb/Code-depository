package week1;

public class Hello {
    public static int dumbMath(int input){
        int x=input*2;
        return x;
    }
    public static void main(String[] args) {
        System.out.println("Hello Nurse!");
        int x=42;
        x=x+4;
        double num=4.14;
        String str1="string me";
        x=4/6;
        System.out.println("x: "+x);
        boolean bool2=false;
        x=dumbMath(3);
        System.out.println(str1);
        System.out.println(num);
        System.out.println(bool2);
    }
}
