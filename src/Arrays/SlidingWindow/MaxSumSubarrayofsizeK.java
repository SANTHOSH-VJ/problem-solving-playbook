import java.util.*;

class Main {
    
    /**
* Problem: Maximum Sum Subarray of Size K
*
* Pattern:
* • Sliding Window (Fixed Size)
*
* Logic:
* • Compute the sum of the first window of size k.
* • Store it as the current maximum sum.
*
* • Slide the window one element at a time:
* * Add the new element entering the window.
* * Remove the element leaving the window.
* * Update the maximum sum if needed.
*
* • This avoids recomputing the sum of each
* subarray from scratch.
*
* Example:
* Input:
* ```
  arr = [2, 1, 5, 1, 3, 2]
  ```
* ```
  k = 3
  ```
*
* Windows:
* ```
  [2,1,5] → 8
  ```
* ```
  [1,5,1] → 7
  ```
* ```
  [5,1,3] → 9
  ```
* ```
  [1,3,2] → 6
  ```
*
* Maximum Sum:
* ```
  9
  ```
*
* Complexity:
* • Time Complexity  : O(N)
* * Each element is added and removed at most once.
*
* • Space Complexity : O(1)
* * Only a few variables are used.
*
* Key Learning:
* • Sliding Window eliminates redundant calculations.
* • Fixed-size window problems often improve from
* O(N × K) to O(N).
* • Useful for subarray sum and average problems.
  */

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N=sc.nextInt();
        int arr[]=new int[N];

        for(int i=0;i<N;i++) {
            arr[i]=sc.nextInt();
        }

        int k=sc.nextInt();

        int ws=0;

        // First window sum
        for(int i=0;i<k;i++) {
            ws+=arr[i];
        }
        int max=ws;

        // Sliding window
        for(int j=k;j<N;j++) {
            ws+=arr[j];
            ws-=arr[j-k];

            max=Math.max(max, ws);
        }
        System.out.print(max);
    }
}