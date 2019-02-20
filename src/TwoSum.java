import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例：
 *  给定nums = [2, 7, 11, 15], target = 9
 *
 *  因为nums[0] + nums[1] = 2 + 7 = 9
 *  所以返回[0, 1]
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val) && map.get(val) != i) {
                return new int[] {i, map.get(val)};
            }
        }
        throw new IllegalArgumentException("No two Solution");
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] res = new TwoSum().twoSum(nums, target);
        for (int i: res) {
            System.out.println(i);
        }
    }
}
