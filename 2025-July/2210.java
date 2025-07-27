import java.util.*;

class Solution {
    public int countHillValley(int[] nums) {
        int ans = 0;
        int fin = nums.length;
        int state[] = new int[fin]; //0은 일반, 1은 hill, 2는 valley

        for (int i = 1; i < fin - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i - 1];
            }

            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                state[i] = 1;
                if (state[i] != state[i - 1]) {
                    ans++;
                }
            }

            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                state[i] = 2;
                if (state[i] != state[i - 1]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}