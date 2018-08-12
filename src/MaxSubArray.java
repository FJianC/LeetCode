/**
 * @author FJianC
 */
/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 *      输入: [-2,1,-3,4,-1,2,1,-5,4],
 *      输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *      如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = null;
        System.out.println(new MaxSubArray().maxSubArray10(nums));
    }


    public int maxSubArray10(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (max < temp) {
                    max = temp;
                }
            }
        }
        return max;
    }

    public int maxSubArray11(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        return maxSubSum(nums, 0, nums.length - 1);
    }
    public int maxSubSum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int maxleft = maxSubSum(nums, left, mid);
        int maxright = maxSubSum(nums, mid + 1, right);
        int maxmidleft = nums[mid];
        int max = 0;
        for (int i = mid; i >= left; i--) {
            max += nums[i];
            if (maxmidleft < max) {
                maxmidleft = max;
            }
        }
        int maxmidright = nums[mid + 1];
        max = 0;
        for (int i = mid + 1; i <= right; i++) {
            max += nums[i];
            if (maxmidright < max) {
                maxmidright = max;
            }
        }
        max = maxleft > maxright ? maxleft : maxright;
        if (max < maxmidleft + maxmidright) {
            max = maxmidleft + maxmidright;
        }
        return max;
    }

    public int maxSubArray12(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int max = nums[0];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (temp > 0) {
                temp += nums[i];
            } else {
                temp = nums[i];
            }
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }
}
