import java.util.Scanner;
public class Lab2a {
    static int[] myNum;
    public static void Frequent(int k) {
        int[] frequency = new int[myNum.length];       
        for (int i = 0; i < myNum.length; i++) {
            frequency[i] = 1; // Start frequency as 1 for each element
            for (int j = 0; j < myNum.length; j++) {
                if (i != j && myNum[i] == myNum[j]) {
                    frequency[i]++;
                }
            }
        }

        int[][] freqWithElements = new int[myNum.length][2]; 
        for (int i = 0; i < myNum.length; i++) {
            freqWithElements[i][0] = myNum[i];
            freqWithElements[i][1] = frequency[i];
        }        
        for (int i = 0; i < freqWithElements.length - 1; i++) {
            for (int j = 0; j < freqWithElements.length - 1 - i; j++) {
                if (freqWithElements[j][1] < freqWithElements[j + 1][1] || 
                   (freqWithElements[j][1] == freqWithElements[j + 1][1] && freqWithElements[j][0] < freqWithElements[j + 1][0])) {
                    int[] temp = freqWithElements[j];
                    freqWithElements[j] = freqWithElements[j + 1];
                    freqWithElements[j + 1] = temp;
                }
            }
        }

        System.out.println("Top " + k + " unique frequent elements:");
        int count = 0; 
        for (int i = 0; i < freqWithElements.length && count < k; i++) {
            if (i == 0 || freqWithElements[i][0] != freqWithElements[i - 1][0]) {
                System.out.print(freqWithElements[i][0] + " ");
                count++; 
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);   
        System.out.print("Enter the number of elements in the array: ");
        int n = input.nextInt();
        myNum = new int[n]; 
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            myNum[i] = input.nextInt();
        }      
        System.out.print("Enter the value of k: ");
        int k = input.nextInt();
        Frequent(k);
              
    }
}
