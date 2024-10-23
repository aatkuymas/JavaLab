import java.util.Scanner;
public class ShareTrader {
    
    static int maxProfit = 0;

    
    public static int findMaxProfit(int[] prices) {
        int n = prices.length;

        
        if (n == 0 || n == 1) {
            return 0;
        }

        
        int[] profit1 = new int[n];
        int[] profit2 = new int[n];

        
        int buy1 = 0, sell1 = 0, buy2 = 0, sell2 = 0;

        
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] - minPrice > profit1[i - 1]) {
                profit1[i] = prices[i] - minPrice;
                buy1 = minPrice;
                sell1 = prices[i];
            } else {
                profit1[i] = profit1[i - 1];
            }
            minPrice = Math.min(minPrice, prices[i]);
        }

        
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (maxPrice - prices[i] > profit2[i + 1]) {
                profit2[i] = maxPrice - prices[i];
                buy2 = prices[i];
                sell2 = maxPrice;
            } else {
                profit2[i] = profit2[i + 1];
            }
            maxPrice = Math.max(maxPrice, prices[i]);
        }
        
        for (int i = 0; i < n; i++) {
            if (profit1[i] + profit2[i] > maxProfit) {
                maxProfit = profit1[i] + profit2[i];
            }
        }

        
        System.out.println("Trader earns " + maxProfit);
         return maxProfit;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);       
        System.out.println("Enter the number of prices:");
        int n = input.nextInt();     
        int[] prices = new int[n];   
        System.out.println("Enter the prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = input.nextInt();
        }
        findMaxProfit(prices);
    }
    
}