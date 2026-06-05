import java.util.*;

class Main {

    /**
     * Problem: Subarray Product Less Than K
     *
     * Pattern:
     * • Sliding Window (Variable Size)
     *
     * Logic:
     * • Maintain a window [left, right].
     * • Keep track of the product of all elements
     *   inside the current window.
     *
     * • Expand the window by moving right.
     * • Multiply the new element into the product.
     *
     * • If the product becomes greater than or
     *   equal to k:
     *   - Shrink the window from the left.
     *   - Divide the product by nums[left].
     *
     * • Once the window becomes valid:
     *   - Every subarray ending at right and
     *     starting between left and right is valid.
     *
     * • Number of such subarrays:
     *
     *      right - left + 1
     *
     * • Add this count to the answer.
     *
     * Example:
     *   Input:
     *     nums = [10, 5, 2, 6]
     *     k = 100
     *
     *   Valid Subarrays:
     *     [10], [5], [2], [6]
     *     [10,5], [5,2], [2,6]
     *     [5,2,6]
     *
     *   Output:
     *     8
     *
     * Complexity:
     * • Time Complexity  : O(N)
     *   - Each element enters and leaves
     *     the window at most once.
     *
     * • Space Complexity : O(1)
     *
     * Key Learning:
     * • Variable Size Sliding Window.
     * • Count all valid subarrays ending at
     *   each index using:
     *
     *      right - left + 1
     */
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[] nums=new int[n];

        for(int i=0;i<n;i++) {
            nums[i]=sc.nextInt();
        }

        int k=sc.nextInt();

        if(k<=1) {
            System.out.print(0);
            return;
        }

        int left=0;
        int count=0;
        int product=1;

        for(int right=0;right<n;right++) {

            product*=nums[right];

            while(product>=k) {
                product/=nums[left];
                left++;
            }
            count+=right-left+1;
        }
        System.out.print(count);
    }
}