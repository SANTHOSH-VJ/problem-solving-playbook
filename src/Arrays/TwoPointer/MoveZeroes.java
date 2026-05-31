import java.util.*;

class Main {

    /**

* Problem: Move Zeroes
*
* Pattern:
* • Two Pointers
*
* Logic:
* • Maintain a pointer 'l' that indicates the position
* where the next non-zero element should be placed.
*
* • Traverse the array using pointer 'r'.
*
* • Whenever a non-zero element is found:
* * Swap arr[l] and arr[r].
* * Increment l.
*
* • This ensures:
* * All non-zero elements remain in their relative order.
* * All zeroes are moved to the end.
*
* Example:
* Input:
* ```
  [0, 1, 0, 3, 12]
  ```
*
* Execution:
* ```
  r=1 → swap(0,1)
  ```
* ```
  [1,0,0,3,12]
  ```
*
* ```
  r=3 → swap(1,3)
  ```
* ```
  [1,3,0,0,12]
  ```
*
* ```
  r=4 → swap(2,4)
  ```
* ```
  [1,3,12,0,0]
  ```
*
* Output:
* ```
  [1,3,12,0,0]
  ```
*
* Complexity:
* • Time Complexity  : O(N)
* * Single traversal of the array.
*
* • Space Complexity : O(1)
* * In-place modification.
*
* Key Learning:
* • Two Pointer technique helps perform stable
* in-place rearrangement.
* • Preserves the relative order of non-zero elements.
* • More efficient than repeatedly shifting elements.
  */

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int arr[]=new int[N];

        for(int i=0;i<N;i++) {
            arr[i]=sc.nextInt();
        }
        int l=0;

        for(int r=0;r<N;r++) {
            if(arr[r]!=0) {
                int temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                l++;
            }
        }
        for(int i=0;i<N;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}