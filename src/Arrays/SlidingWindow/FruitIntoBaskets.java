import java.util.*;

class Main {

    /**
* Problem: Fruit Into Baskets
*
* Pattern:
* • Sliding Window (Variable Size)
*
* Logic:
* • We are allowed to collect fruits from at most
* two different fruit types.
*
* • Maintain a window [left, right].
* • Use a HashMap to store:
* * Fruit type → Frequency inside the window.
*
* • Expand the window by moving right.
* • Add the current fruit to the map.
*
* • If the number of distinct fruit types exceeds 2:
* * Shrink the window from the left.
* * Decrease the frequency of fruits[left].
* * Remove the fruit type when its frequency
* ```
  becomes 0.
  ```
*
* • The valid window always contains at most
* two distinct fruit types.
*
* • Update the maximum window size.
*
* Example:
* Input:
* ```
  [1,2,1]
  ```
*
* Window:
* ```
  [1,2,1]
  ```
*
* Distinct Fruits:
* ```
  {1,2}
  ```
*
* Output:
* ```
  3
  ```
*
* Example:
* Input:
* ```
  [1,2,3,2,2]
  ```
*
* Longest Valid Window:
* ```
  [2,3,2,2]
  ```
*
* Output:
* ```
  4
  ```
*
* Complexity:
* • Time Complexity  : O(N)
* * Each element enters and leaves the window
* ```
  at most once.
  ```
*
* • Space Complexity : O(1)
* * HashMap stores at most 3 fruit types.
*
* Key Learning:
* • Variable Size Sliding Window.
* • HashMap helps track frequencies inside
* the current window.
* • Common pattern:
* ```
   "Longest subarray with at most K distinct elements".
  ```

*/
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] fruits=new int[n];

        for(int i=0;i<n;i++) {
            fruits[i]=sc.nextInt();
        }

        int left=0;
        int ans=0;

        HashMap<Integer, Integer> map=new HashMap<>();

        for(int right=0;right<n;right++) {

            map.put(fruits[right],
                    map.getOrDefault(fruits[right],0)+1);

            while(map.size()>2) {

                map.put(fruits[left],
                        map.get(fruits[left])-1);

                if(map.get(fruits[left])==0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        System.out.print(ans);
    }
}