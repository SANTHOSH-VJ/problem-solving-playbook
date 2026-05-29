import java.util.*;

class Main {

    /**
     * Problem: 3Sum
     *
     * Pattern:
     * • Sorting + Two Pointers
     *
     * Logic:
     * • Sort the array.
     * • Fix one element at index i.
     * • Use two pointers:
     *   - left = i + 1
     *   - right = n - 1
     *
     * • Check the sum:
     *   nums[i] + nums[left] + nums[right]
     *
     * • If sum == 0:
     *   - Store the triplet.
     *   - Skip duplicate elements.
     *
     * • If sum < 0:
     *   - Move left forward.
     *
     * • If sum > 0:
     *   - Move right backward.
     *
     * Example:
     * Input:
     *   6
     *   -1 0 1 2 -1 -4
     *
     * Sorted Array:
     *   [-4, -1, -1, 0, 1, 2]
     *
     * Output:
     *   [-1, -1, 2]
     *   [-1, 0, 1]
     *
     * Complexity:
     * • Time Complexity  : O(N²)
     * • Space Complexity : O(1)
     *   (excluding output list)
     *
     * Key Learning:
     * • Sorting enables efficient searching.
     * • Two Pointers reduce complexity from O(N³) to O(N²).
     * • Duplicate handling avoids repeated triplets.
     */
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int nums[]=new int[n];

        for(int i=0;i<n;i++) {
            nums[i]=sc.nextInt();
        }

        List<List<Integer>> res=new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<n-2;i++) {

            if(i>0 && nums[i]==nums[i-1])
                continue;

            int left=i+1, right=n-1;

            while(left<right) {

                int sum=nums[i] + nums[left] + nums[right];

                if(sum == 0) {

                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left<right && nums[left] == nums[left + 1])
                        left++;

                    while(left<right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                }
                else if(sum<0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        System.out.println(res);
    }
}
