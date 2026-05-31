import java.util.*;

class Main {
    
/**
* Problem: Container With Most Water
*
* Pattern:
* • Two Pointers
*
* Logic:
* • Two vertical lines form a container.
* • The amount of water stored is:
*
* ```
   Area = min(height[left], height[right]) × (right - left)
  ```
*
* • Start with:
* * left at the beginning
* * right at the end
*
* • Calculate the area formed by the two pointers.
* • Update the maximum area found so far.
*
* • Move the pointer with the smaller height:
* * A taller line may increase the minimum height.
* * Moving the taller line cannot improve the area because
* ```
  the width decreases while the limiting height remains.
  ```
*
* Example:
* Input:
* ```
  [1,8,6,2,5,4,8,3,7]
  ```
*
* Execution:
* ```
  left = 0, right = 8
  ```
* ```
  Area = min(1,7) × 8 = 8
  ```
*
* ```
  Move left
  ```
*
* ```
  left = 1, right = 8
  ```
* ```
  Area = min(8,7) × 7 = 49
  ```
*
* ```
  Maximum Area = 49
  ```
*
* Output:
* ```
  49
  ```
*
* Complexity:
* • Time Complexity  : O(N)
* * Each pointer moves at most N times.
*
* • Space Complexity : O(1)
* * No extra space is used.
*
* Key Learning:
* • Brute Force takes O(N²).
* • Two Pointers reduce the complexity to O(N).
* • Always move the pointer corresponding to the
* smaller height to maximize the chance of finding
* a larger area.
  */

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int height[]=new int[N];

        for(int i=0;i<N;i++) {
            height[i]=sc.nextInt();
        }

        int maxArea=0;
        int l=0;
        int r=N-1;

        while(l<r) {
            int h=Math.min(height[l], height[r]);
            int w=r-l;
            int area=h*w;
            maxArea=Math.max(maxArea, area);

            if(height[l]<=height[r])
                l++;
            else
                r--;
        }
        System.out.print(maxArea);
    }
}