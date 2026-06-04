import java.util.*;

class Main {

    /**
     * Problem: Max Consecutive Ones III
     *
     * Pattern:
     * • Sliding Window (Variable Size)
     *
     * Logic:
     * • We are allowed to flip at most k zeros.
     * • Maintain a window [left, right].
     *
     * • Expand the window by moving right.
     * • Count the number of zeros inside the window.
     *
     * • If zeroCount exceeds k:
     *   - Shrink the window from the left.
     *   - If the removed element is 0,
     *     decrement zeroCount.
     *
     * • The valid window always contains
     *   at most k zeros.
     *
     * • Track the maximum window length.
     *
     * Example:
     *   Input:
     *     nums = [1,1,1,0,0,0,1,1,1,1,0]
     *     k = 2
     *
     *   Output:
     *     6
     *
     * Explanation:
     *   Flip two zeros to get:
     *     [1,1,1,0,0,1,1,1,1,1,0]
     *
     *   Longest consecutive ones = 6
     *
     * Complexity:
     * • Time Complexity  : O(N)
     *   - Each element enters and leaves
     *     the window at most once.
     *
     * • Space Complexity : O(1)
     *
     * Key Learning:
     * • Classic Variable Size Sliding Window.
     * • Expand when valid.
     * • Shrink when the constraint is violated.
     * • Useful for longest subarray problems.
     */

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[] nums=new int[n];

        for(int i=0;i<n;i++) {
            nums[i]=sc.nextInt();
        }

        int k=sc.nextInt();

        int left=0;
        int zeroCount=0;
        int maxLen=0;

        for(int right=0;right<n;right++) {

            if(nums[right]==0) {
                zeroCount++;
            }

            while(zeroCount>k) {

                if(nums[left]==0) {
                    zeroCount--;
                }
                left++;
            }
            maxLen=Math.max(maxLen, right - left + 1);
        }
        System.out.print(maxLen);
    }
}
