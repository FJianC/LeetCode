import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FJianC
 */
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
     * 这个算法很骚。。
     * */
    private static int[] twoSum1(int[] nums, int target) {
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
        int max = target - numMin;
        int min = target - numMax;
        int targetMax = max > numMax ? numMax : max;
        int targetMin = min < numMin ? numMin : min;
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
