import java.util.Scanner;
import java.util.InputMismatchException;

public class Lab1 {
    public long ccnumber; 
    public static int valid = 0;

    Lab1(long ccnumber) {
        this.ccnumber = ccnumber;        
        if (String.valueOf(ccnumber).length() >= 8 && String.valueOf(ccnumber).length() <= 9) {
            System.out.println("It is of the valid length");
            valid = 1;          
        } 
        else {
            System.out.println("Invalid length");
        }
    }    

    void second() {
        System.out.println("Second level of validation");
        long last=ccnumber%10;
        System.out.println("the last digit is=");
        System.out.println(last);

        System.out.println("Step a:The cc number without its last digit=");
        System.out.println(String.valueOf(ccnumber).substring(0,String.valueOf(ccnumber).length()-1));
        ccnumber=Long.parseLong(String.valueOf(ccnumber).substring(0,String.valueOf(ccnumber).length()-1));
        
        long reverse = 0;  
        while(ccnumber != 0)   
        {  
            long remainder = ccnumber % 10;  
            reverse = reverse * 10 + remainder;  
            ccnumber = ccnumber/10;  
        }  
        System.out.println("step b:The reverse of the given number is: " + reverse);

        int length=String.valueOf(reverse).length();
        String odd=" ";
        int sum=0;       
        for(int i=0;i<length;i++){
            int a=Character.getNumericValue(String.valueOf(reverse).charAt(i));
            if (i % 2 == 0) {  
                a = a * 2;
                if (a > 9) {
                    a = a - 9; 
                }
                System.out.println("Doubled digit at index " + i + ": " + a);
            }
        
        else {
            System.out.println("Digit at index " + i + ": " + a);
        }
        
        odd += String.valueOf(a);
        sum+=a;
        
    }
    System.out.println("step c:Double the digits that are in the odd-numbered positions=");
        System.out.println(odd);
        System.out.println("step d:Add up all the digits=");
        System.out.println(sum);
        int random=sum%10;
        System.out.println("step e:subtracting the last digit obtained in step e from 10.");
        long sub=10-random;
        System.out.println(sub);
        System.out.println("step f:Compare the result of step e with the last digit obtained in step a");
        System.out.println("result of step e ");
        System.out.println(sub);
        System.out.println("last digit obtained in step a");
        System.out.println(last);
        if (sub!=last){
            System.out.println("invalid");
        }else{
            System.out.println("Valid");
        }

    }


    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a number: ");           
            long ccnumber = input.nextLong();            
            Lab1 s1 = new Lab1(ccnumber);           
            if (valid == 1) {
                s1.second();  
            }

        } catch (InputMismatchException e) {
            System.out.println("Enter a numerical value");
        }
    }
}

