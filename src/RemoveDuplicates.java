/**
 * @author FJianC
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2};
        System.out.println(new RemoveDuplicates().removeDuplicates2(nums));
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        } else {
            int temp = nums[0];
            int len = 1;
            for (int i = 1; i < nums.length; i++) {
                if (temp == nums[i]) {
                    continue;
                } else {
                    temp = nums[i];
                    nums[len] = nums[i];
                    len++;
                }
            }
            return len;
        }
    }

    public int removeDuplicates2(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int noRepeat = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != nums[noRepeat]){
                noRepeat ++;
                nums[noRepeat] = nums[i];
            }
        }
        return noRepeat + 1;
    }

    public int removeDuplicates10(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = count + 1;
            while (nums[i] == nums[j]) {
                j++;
                if (j >= nums.length) {
                    return i + 1;
                }
            }
            count = j;
            nums[i + 1] = nums[count];
            if (count == nums.length - 1) {
                return i + 2;
            }
        }
        return count;
    }
}
