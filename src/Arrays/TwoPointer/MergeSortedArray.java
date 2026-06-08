import java.util.*;

class Main {

    /**
 * Problem: Merge Sorted Array
 *
 * Pattern:
 * • Two Pointers
 *
 * Logic:
 * • nums1 has enough extra space to hold all
 *   elements from nums2.
 *
 * • Start filling from the end of nums1.
 *
 * • Use three pointers:
 *   - i = last valid element in nums1
 *   - j = last element in nums2
 *   - k = last position in nums1
 *
 * • Compare nums1[i] and nums2[j]:
 *   - Place the larger element at nums1[k].
 *   - Move the corresponding pointer.
 *
 * • If nums2 still has remaining elements,
 *   copy them into nums1.
 *
 * Example:
 *   Input:
 *     nums1 = [1,2,3,0,0,0]
 *     m = 3
 *     nums2 = [2,5,6]
 *     n = 3
 *
 *   Output:
 *     [1,2,2,3,5,6]
 *
 * Complexity:
 * • Time Complexity  : O(m + n)
 * • Space Complexity : O(1)
 *
 * Key Learning:
 * • Merge from the back to avoid overwriting
 *   elements in nums1.
 * • Classic Two Pointer technique.
 */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m=sc.nextInt();
        int n=sc.nextInt();

        intnums1[]=new int[m + n];
        intnums2[]=new int[n];

        for(int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++) {
            nums2[i]=sc.nextInt();
        }

        int i=m-1;
        int j=n-1;
        int k= m+n-1;

        while(i>=0 && j>=0) {

            if(nums1[i]>nums2[j]) {
                nums1[k--]=nums1[i--];
            } else {
                nums1[k--]=nums2[j--];
            }
        }
        while(j>=0) {
            nums1[k--]=nums2[j--];
        }
        for(int x : nums1) {
            System.out.print(x + " ");
        }
    }
}