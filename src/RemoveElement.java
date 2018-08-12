/**
 * @author FJianC
 */
/**
 * 27. 移除元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1:
 *      给定 nums = [3,2,2,3], val = 3,
 *      函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *      你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *      给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *      函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *      注意这五个元素可为任意顺序。
 *      你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 *      为什么返回数值是整数，但输出的答案是数组呢?
 *      请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *      你可以想象内部操作如下:
 *          // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 *          int len = removeElement(nums, val);
 *          // 在函数里修改输入数组对于调用者是可见的。
 *          // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 *          for (int i = 0; i < len; i++) {
 *              print(nums[i]);
 *          }
 * */
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
