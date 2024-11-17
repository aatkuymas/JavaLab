import java.util.*;

abstract class Robber {
    void RobbingClass()
    {
        System.out.println("MScAI&ML");
    }
    
    abstract int RowHouses(int[] money);
    abstract int RoundHouses(int[] money);
    abstract int SquareHouse(int[] grid);
    abstract int MultiHouseBuilding(int[][] money);
    public void MachineLearning() 
    {
        System.out.println("I Love Machine Learning"); 
        
    }
}

class JAVAProfessionalRobber extends Robber {
    @Override
    public int RowHouses(int[] money) {
        int n = money.length;
        if (n == 0) return 0;
        if (n == 1) return money[0];
        int[] dp = new int[n];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        return dp[n - 1];
    }

    @Override
    public int RoundHouses(int[] money) {
        int n = money.length;
        if (n == 0) return 0;
        if (n == 1) return money[0];
        // Exclude first house and calculate
        int excludeFirst = RowHouses(Arrays.copyOfRange(money, 1, n));
        // Exclude last house and calculate
        int excludeLast = RowHouses(Arrays.copyOfRange(money, 0, n - 1));
        return Math.max(excludeFirst, excludeLast);
    }

    @Override
    public int SquareHouse(int[] grid) {        
        int a=0;
        int b=0;
        for(int i=0;i<grid.length;i++){
            if(i%2==0){
                a+=grid[i];
            }
            else{
                b+=grid[i];
            }
           

        }
        return Math.max(a,b);
           
        
        
    }
    @Override
    public int MultiHouseBuilding(int[][] money) {
        int odd = 0;
        int even = 0;

        for (int i = 0; i < money.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < money[i].length; j++) {
                    even += money[i][j];
                }
            } else {
                for (int j = 0; j < money[i].length; j++) {
                    odd += money[i][j];
                }
            }
        }
        return Math.max(odd, even);
    }
}
    
class Lab4 {
    public static void main(String[] args)
    {
   
        JAVAProfessionalRobber s = new JAVAProfessionalRobber();
        s.RobbingClass();
        // RowHouses Example
        int[] rowHouses = {2,4,5,6};
        System.out.println("Row Houses Maximum: " + s.RowHouses(rowHouses));
        
        // RoundHouses Example
        int[] roundHouses = {3,7,8,1};
        System.out.println("Round Houses Maximum: " + s.RoundHouses(roundHouses));
        
        // SquareHouse Example
        int[] squareHouses = {2,5,7,4};
        System.out.println("Square House Maximum: " + s.SquareHouse(squareHouses));
        
        // MultiHouseBuilding Example
        int[][] multiHouse = {
            {5,3,8,2},
            {10,12,7,6},
            {4,9,11,5},
            {8,6,3,7}
        };
        System.out.println("MultiHouse Building Maximum: " + s.MultiHouseBuilding(multiHouse));
        
        s.MachineLearning();
        

    }

}
