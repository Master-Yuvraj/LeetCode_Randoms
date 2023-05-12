#Approach-1 (Naive Recursion Approach)
  
  class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        return solve(questions,0,n-1);
    }
    public long solve(int arr[][],int i,int n){
       if(i>n)
           return 0;
        
        long solve = arr[i][0] + solve(arr,i+arr[i][1]+1,n);
        long skip = solve(arr,i+1,n);
        return Math.max(solve,skip);
    }
}


#Approach-2 (Optimal Solution Reduce The Redundant Task)

public long mostPoints(int[][] questions) {
        int n = questions.length;
        Map<Integer, Long> memo = new HashMap<>();
        return solve(questions, 0, n - 1, memo);
    }

    public long solve(int arr[][], int i, int n, Map<Integer, Long> memo) {
        if (i > n)
            return 0;

        if (memo.containsKey(i))
            return memo.get(i);

        long solve = arr[i][0] + solve(arr, i + arr[i][1] + 1, n, memo);
        long skip = solve(arr, i + 1, n, memo);
        long maxPoints = Math.max(solve, skip);
        memo.put(i, maxPoints);
        return maxPoints;
    }

// In this optimized version, a HashMap called memo is used to store previously calculated results. Before performing a calculation for a specific i value, the code checks if the result is already available in the memo map. If it is, the stored result is returned directly, avoiding unnecessary calculations.

// This memoization technique helps to reduce redundant recursive calls and improves the overall performance of the code.
