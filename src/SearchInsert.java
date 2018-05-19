/**
 * @author FJianC
 * */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 2;
        System.out.println(new SearchInsert().searchInsert10(nums, target));
    }

    public int searchInsert1(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if(nums[0] >= target){
            return 0;
        }
        for(int i = 1; i<len; i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return len;
    }


    public int searchInsert10(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return target > nums[mid] ? ++mid : mid;
    }
}
