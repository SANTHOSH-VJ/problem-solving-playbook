/**

* Problem: Two Sum in a Sorted Array
*
* Pattern:
* • Two Pointers
*
* Logic:
* • Since the array is sorted, initialize two pointers:
* * left at the beginning of the array.
* * right at the end of the array.
*
* • Calculate the sum of elements at left and right.
*
* • If sum equals target:
* * Return the indices of left and right.
*
* • If sum is smaller than target:
* * Move left pointer forward to increase the sum.
*
* • If sum is greater than target:
* * Move right pointer backward to decrease the sum.
*
* Example:
* Input:
* ```
  arr = [1, 2, 4, 7, 11, 15]
  ```
* ```
  target = 15
  ```
*
* Execution:
* ```
  1 + 15 = 16 > 15  → right--
  ```
* ```
  1 + 11 = 12 < 15  → left++
  ```
* ```
  2 + 11 = 13 < 15  → left++
  ```
* ```
  4 + 11 = 15       → Found
  ```
*
* Output:
* ```
  2 4
  ```
*
* Complexity:
* • Time Complexity  : O(N)
* * Each pointer moves at most N times.
*
* • Space Complexity : O(1)
* * No extra data structures are used.
*
* Key Learning:
* • Two Pointer technique efficiently solves pair-sum problems
* on sorted arrays.
* • Avoids the O(N²) brute-force approach.
* • Useful for many array-based interview problems.
  */

import java.util.*;

class Main {

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int arr[]=new int[N];
        for (int i=0;i<N;i++) {
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();

        int left=0,right=N-1;
        while(left<right) {
            int sum=arr[left]+arr[right];
            if(sum==target) {
                System.out.println(left+" "+right);
                return;
            } else if(sum<target) {
                left++;
            } else {
                right--;
            }
        }
    }
}

