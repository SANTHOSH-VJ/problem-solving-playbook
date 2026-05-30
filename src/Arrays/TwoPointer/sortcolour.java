import java.util.*;

class Main {

    /**
     * Problem: Sort Colors
     *
     * Pattern:
     * • Three Pointers (Dutch National Flag Algorithm)
     *
     * Logic:
     * • The array contains only 0s, 1s, and 2s.
     * • Maintain three pointers:
     *   - low  : next position for 0
     *   - mid  : current element being processed
     *   - high : next position for 2
     *
     * • Traverse the array while mid <= high:
     *
     *   Case 1: nums[mid] == 0
     *   - Swap nums[mid] with nums[low].
     *   - Increment low and mid.
     *
     *   Case 2: nums[mid] == 1
     *   - Move mid forward.
     *
     *   Case 3: nums[mid] == 2
     *   - Swap nums[mid] with nums[high].
     *   - Decrement high.
     *   - Do not increment mid because the swapped
     *     element must still be processed.
     *
     * Example:
     *   Input:
     *     [2, 0, 2, 1, 1, 0]
     *
     *   Output:
     *     [0, 0, 1, 1, 2, 2]
     *
     * Complexity:
     * • Time Complexity  : O(N)
     * • Space Complexity : O(1)
     *
     * Key Learning:
     * • Dutch National Flag Algorithm sorts an array
     *   containing only 0s, 1s, and 2s in a single pass.
     * • In-place sorting without extra space.
     */

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int nums[]=new int[n];

        for(int i=0;i<n;i++) {
            nums[i]=sc.nextInt();
        }

        int low=0;
        int mid=0;
        int high=n-1;

        while(mid<=high) {

            if(nums[mid]==0) {
                nums[mid]=nums[low];
                nums[low]=0;

                low++;
                mid++;
            }
            else if(nums[mid] == 1) {
                mid++;
            }
            else {
                nums[mid]=nums[high];
                nums[high]=2;
                high--;
            }
        }
        for(int i=0;i<n;i++)
        System.out.print(nums[i]+" ");

    }
}
```
