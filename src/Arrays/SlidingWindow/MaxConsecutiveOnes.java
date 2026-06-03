import java.util.*;

public class Main {

    /**
     * Problem: Max Consecutive Ones
     *
     * Pattern:
     * • Array Traversal / Counting
     *
     * Logic:
     * • Traverse the array and maintain a count of
     *   consecutive 1s.
     * • If the current element is 1:
     *   - Increment count.
     *   - Update the maximum count.
     * • If the current element is 0:
     *   - Reset count to 0.
     *
     * Example:
     *   Input:
     *     [1,1,0,1,1,1]
     *
     *   Output:
     *     3
     *
     * Complexity:
     * • Time Complexity  : O(N)
     * • Space Complexity : O(1)
     *
     * Key Learning:
     * • Track the current streak while traversing.
     * • Reset when the sequence breaks.
     */

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] nums=new int[n];

        for(int i=0;i<n;i++) {
            nums[i]=sc.nextInt();
        }

        int max=0;
        int count=0;

        for(int i=0;i<n;i++) {

            if(nums[i]==1) {
                count++;
                max=Math.max(max, count);
            }
            else {
                count = 0;
            }
        }
        System.out.println(max);
    }
}