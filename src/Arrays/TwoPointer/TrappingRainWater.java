/**
* Problem: Trapping Rain Water
*
* Pattern:
* • Brute Force
*
* Logic:
* • For every index i:
* * Find the maximum height on the left side.
* * Find the maximum height on the right side.
*
* • The water trapped at index i is:
*
* ```
   min(leftMax, rightMax) - height[i]
  ```
*
* • Add the trapped water at each index to get
* the total amount of trapped rain water.
*
* Example:
* Input:
* ```
  [0,1,0,2,1,0,1,3,2,1,2,1]
  ```
*
* At index 5:
* ```
  height[5] = 0
  ```
* ```
  leftMax   = 2
  ```
* ```
  rightMax  = 3
  ```
*
* ```
  trappedWater
  ```
* ```
    = min(2,3) - 0
  ```
* ```
    = 2
  ```
*
* Total Water Trapped:
* ```
  6
  ```
*
* Complexity:
* • Time Complexity  : O(N²)
* * For each index, we scan both left and right
* ```
  sides to find the maximum heights.
  ```
*
* • Space Complexity : O(1)
* * No extra data structures are used.
*
* Key Learning:
* • Water trapped at any position depends on the
* shorter boundary between the tallest bars on
* its left and right.
* • This brute-force approach is simple to understand
* but inefficient for large inputs.
* • Serves as a foundation for optimized solutions
* using Prefix/Suffix arrays or Two Pointers.
  */

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] height = new int[N];

        for(int i = 0; i < N; i++) {
            height[i] = sc.nextInt();
        }

        int totalWater = 0;

        for(int i = 0; i < N; i++) {

            int leftMax = 0;
            int rightMax = 0;

            for(int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for(int j = i; j < N; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            totalWater += Math.min(leftMax, rightMax) - height[i];
        }
        System.out.println(totalWater);
    }
}

/**
 * Problem: Trapping Rain Water
 *
 * Pattern:
 * • Two Pointers
 *
 * Logic:
 * • Maintain two pointers:
 *   - left at the beginning
 *   - right at the end
 *
 * • Keep track of:
 *   - leftMax  = maximum height seen from the left
 *   - rightMax = maximum height seen from the right
 *
 * • If leftMax < rightMax:
 *   - Water trapped at the left position depends only
 *     on leftMax.
 *   - Move left pointer forward.
 *
 * • Otherwise:
 *   - Water trapped at the right position depends only
 *     on rightMax.
 *   - Move right pointer backward.
 *
 * • Add trapped water at each step.
 *
 * Example:
 *   Input:
 *     [0,1,0,2,1,0,1,3,2,1,2,1]
 *
 *   Output:
 *     6
 *
 * Complexity:
 * • Time Complexity  : O(N)
 * • Space Complexity : O(1)
 *
 * Key Learning:
 * • Instead of finding left and right maxima for every
 *   index separately, maintain them dynamically.
 * • Reduces the brute-force O(N²) solution to O(N).
 * • One of the most important Two Pointer problems.
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] height = new int[n];

        for(int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int water = 0;

        while(left < right) {
            if(leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            } 
            else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }
        System.out.println(water);
    }
}

