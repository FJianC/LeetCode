/**
 * @author FJianC
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int val = 3;
        int len = new RemoveElement().removeElement1(nums, val);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int removeElement1(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        int length = nums.length;
        while(true){
            while(left <= nums.length - 1 && nums[left] != val){
                left++;
            }
            while(right >= 0 && nums[right] == val ){
                right--;
                length--;
            }
            if(left < right){
                nums[left++] = nums[right--];
                length --;
            }else{
                break;
            }
        }
        return length;
    }

    public int removeElement2(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int lastIndex = len - 1;
        for (int i = 0; i < lastIndex; i++) {
            if (nums[i] == val) {
                while (nums[lastIndex] == val && lastIndex > i) {
                    lastIndex--;
                }
                if (nums[lastIndex] == val) {
                    return i;
                } else {
                    nums[i] = nums[lastIndex];
                    lastIndex--;
                }
            }
        }
        return nums[lastIndex] == val ? lastIndex : (lastIndex + 1);
    }

    public int removeElement10(int[] nums, int val) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < nums.length - count; i++) {
            if (nums[i] == val) {
                count++;
                for (int j = i + 1; j < nums.length - count + 1; j++) {
                    nums[j - 1] = nums[j];
                    if (nums[j] == val) {
                        if (j != nums.length - count) {
                            flag = false;
                        } else {
                            count++;
                        }
                    }
                }
                if (flag) {
                    break;
                }
                nums[nums.length - count] = val;
                if (nums[i] == val) {
                    i--;
                }
            }
        }
        return nums.length - count;
    }
}
