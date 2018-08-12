import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FJianC
 */
/**
 * 1. 两数之和
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 *      给定 nums = [2, 7, 11, 15], target = 9
 *      因为 nums[0] + nums[1] = 2 + 7 = 9
 *      所以返回 [0, 1]
 * */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result;
        result = twoSum1(nums, target);
        System.out.println("[ "+ result[0] + " , " + result[1] + " ]");
        result = twoSum2(nums, target);
        System.out.println("[ "+ result[0] + " , " + result[1] + " ]");
        result = twoSum3(nums, target);
        System.out.println("[ "+ result[0] + " , " + result[1] + " ]");
        result = twoSum4(nums, target);
        System.out.println("[ "+ result[0] + " , " + result[1] + " ]");
        result = twoSum5(nums, target);
        System.out.println("[ "+ result[0] + " , " + result[1] + " ]");
    }
    /**
     * 这个算法很骚。。 O(n)
     * */
    private static int[] twoSum1(int[] nums, int target) {
        /**
         * 获取数组中的最大值numMax和最小值numMin
         * */
        int numMin = Integer.MAX_VALUE;
        int numMax = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < numMin) {
                numMin = num;
            }
            if (num > numMax) {
                numMax = num;
            }
        }
        /**
         * 获取能存在解的范围 [x, y] ，x = targetMin ，y = targetMax
         * target = numMin + x ，当 x <= numMax 时，才可能存在解
         *                       若 x > numMax ，则 numMax 作为最大值才可能存在解
         * target = numMax + y ，当 y >= numMin 时，才可能存在解
         *                       若 y < numMax ，则 numMin 作为最小值才可能存在解
         * */
        int max = target - numMin;
        int min = target - numMax;
        int targetMax = max > numMax ? numMax : max;
        int targetMin = min < numMin ? numMin : min;
        /**
         * numIndices[] 用于记录数组中在 [x, y] 范围内的元素的位置，初始为 -1
         *              初始化 numIndices[0, targetMax - targetMin] = -1
         *              numIndices[0] 即 targetMin 这个数在数组中的位置
         *              numIndices[1] 即 targetMin + 1 这个数在数组中的位置
         *              。。。。
         *              numIndices[num[i] - targetMin] 即 num[i] 这个数在数组中的位置
         *              。。。。
         *              numIndices[targetMax - targetMin] 即 targetMax 这个数在数组中的位置
         * 设 num[i] 为当前元素 ，target = num[i] + x
         * 若 numIndices[x] != -1 ，则说明 x 是数组中的一个元素
         *                          这个数是在数组的第 numIndices[x] 个元素
         * 若 numIndices[x] == -1 ，则说明 x 不是数组中的一个元素
         *                          将 num[i] 记录在 numIndices[] 中
         *                          numIndices[num[i]] = i
         * 判断下一个数 num[i + 1] ，target = num[i + 1] + x  。。。。
         * */
        int[] numIndices = new int[targetMax - targetMin + 1];
        for (int i = 0; i <= numIndices.length - 1; i++) {
            numIndices[i] = -1;
        }
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] >= targetMin && nums[i] <= targetMax) {
                int offset = -targetMin;
                if (numIndices[(target - nums[i]) + offset] != -1) {
                    return new int[] { numIndices[(target - nums[i]) + offset], i };
                } else {
                    numIndices[nums[i] + offset] = i;
                }
            }
        }
        return new int[] { 0, 0 };
    }
    /**
     * Arrays.sort()，底层是快排，O(nlogn)
     * */
    private static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        int[] sortedArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedArray);
        int start = 0, end = sortedArray.length - 1;
        while (start < end) {
            while (sortedArray[start] + sortedArray[end] > target) {
                end--;
            }
            if (sortedArray[start] + sortedArray[end] == target) {
                break;
            }
            while (sortedArray[start] + sortedArray[end] < target) {
                start++;
            }
            if (sortedArray[start] + sortedArray[end] == target) {
                break;
            }
        }
        int flag = 0;
        int a = sortedArray[start], b = sortedArray[end];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a || nums[i] == b) {
                result[flag++] = i;
            }
        }
        return result;
    }
    /**
     * 快排，O(nlogn)
     * */
    private static int[] twoSum3(int[] nums, int target) {
        int length = nums.length;
        if (length < 20) {
            for (int i = length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] + nums[i] == target) {
                        return new int[]{j, i};
                    }
                }
            }
        }
        else{
            int[] sortIndex = new int[length];
            for (int i = 0; i < length; i++) {
                sortIndex[i] = i;
            }
            mergeSort(nums, sortIndex, 0, length - 1);
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int flag = nums[sortIndex[left]] + nums[sortIndex[right]] - target;
                if(flag == 0){
                    break;
                }
                if(flag > 0){
                    right--;
                }
                else{
                    left++;
                }
            }

            return new int[]{sortIndex[left], sortIndex[right]};
        }
        return new int[]{};
    }
    private static void mergeSort(int[] nums, int[] index, int begin, int end){
        if(begin < end){
            int mid = (begin + end) / 2;
            mergeSort(nums, index, begin, mid);
            mergeSort(nums, index, mid + 1, end);
            int i = begin,j = mid + 1,k = 0;
            int[] mergeIndex = new int[end - begin + 1];
            while (i <= mid && j <= end) {
                int left = nums[index[i]];
                int right = nums[index[j]];
                if(left < right){
                    mergeIndex[k] = index[i];
                    i++;
                }
                else{
                    mergeIndex[k] = index[j];
                    j++;
                }
                k++;
            }
            if (i > mid) {
                System.arraycopy(index, j, mergeIndex, k, end - j + 1);
            }
            if (j > end) {
                System.arraycopy(index, i, mergeIndex, k, mid - i + 1);
            }
            System.arraycopy(mergeIndex, 0, index, begin, end - begin + 1);
        }
    }
    /**
     * HashMap，利用哈希算法，O(n)
     * */
    private static int[] twoSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer res = map.get(target - nums[i]);
            if (res != null) {
                return new int[]{res, i};
            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
    /**
     * 蛮力法 O(n2)
     * */
    private static int[] twoSum5(int[] nums, int target) {
        if (nums.length == 0 || nums.length == 1) {
            return  new int[]{-1};
        }
        int i, j;
        for (i = 0;i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
