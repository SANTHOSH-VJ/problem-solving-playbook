import java.util.*;

class Main {

    /**
* Problem: Minimum Size Subarray Sum
*
* Pattern:
* • Sliding Window (Variable Size)
*
* Logic:
* • Maintain a window [left, right].
* • Keep track of the sum of elements inside
* the current window.
*
* • Expand the window by moving right and
* adding nums[right] to the sum.
*
* • Whenever the window sum becomes greater than
* or equal to the target:
* * Update the minimum window length.
* * Shrink the window from the left to find
* ```
  a smaller valid subarray.
  ```
*
* • Continue until all elements are processed.
*
* Example:
* Input:
* ```
  target = 7
  ```
* ```
  nums = [2,3,1,2,4,3]
  ```
*
* Valid Subarrays:
* ```
  [2,3,1,2] → length = 4
  ```
* ```
  [3,1,2,4] → length = 4
  ```
* ```
  [4,3]     → length = 2
  ```
*
* Minimum Length:
* ```
  2
  ```
*
* Complexity:
* • Time Complexity  : O(N)
* * Each element enters and leaves the window
* ```
  at most once.
  ```
*
* • Space Complexity : O(1)
*
* Key Learning:
* • Variable Size Sliding Window.
* • Expand to satisfy the condition.
* • Shrink to optimize the answer.
* • Common pattern for minimum/maximum length
* subarray problems.
  */

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int target=sc.nextInt();

        int n=sc.nextInt();

        int nums[]=new int[n];

        for(int i=0;i<n;i++) {
            nums[i]=sc.nextInt();
        }

        int sum=0;
        int left=0;
        int minLength=Integer.MAX_VALUE;

        for(int right=0;right<n;right++) {

            sum+=nums[right];

            while(sum>=target) {

                minLength=Math.min(minLength,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        System.out.println(minLength==Integer.MAX_VALUE ? 0 : minLength);
    }
}