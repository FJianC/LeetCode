import java.util.Arrays;

/**
 * @author FJianC
 */
/**
 * 4. 两个排序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 你可以假设 nums1 和 nums2 均不为空。
 * */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};

        double ret = findMedianSortedArrays1(nums1, nums2);
        System.out.print(ret);

    }

    private static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int size = len1 + len2;
        if (size % 2 == 1) {
            return findKth(nums1, 0, len1, nums2, 0, len2, size / 2 + 1);
        } else {
            final double r1 = findKth(nums1, 0, len1, nums2, 0, len2, size / 2);
            final double r2 = findKth(nums1, 0, len1, nums2, 0, len2, size / 2 + 1);
            return (r1 + r2) / 2;
        }
    }
    private static double findKth(int[] nums1, int start1, int len1,
                          int[] nums2, int start2, int len2,
                          int k) {
        //短的数组放前面
        if (len1 - start1 > len2 - start2) {
            return findKth(nums2, start2, len2, nums1, start1, len1, k);
        }
        if (len1 - start1 == 0) {
            return nums2[k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int p1 = start1 + Math.min(len1 - start1, k / 2);
        int p2 = start2 + k - p1 + start1;
        if (nums1[p1 - 1] < nums2[p2 - 1]) {
            return findKth(nums1, p1, len1, nums2, start2, len2, k - p1 + start1);
        } else if (nums1[p1 - 1] > nums2[p2 - 1]) {
            return findKth(nums1, start1, len1, nums2, p2, len2, k - p2 + start2);
        } else {
            return nums1[p1 - 1];
        }
    }

    private static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int [] merge=new int[nums1.length+nums2.length];
        int indexA=0;
        int indexB=0;
        for(int i=0;i<merge.length;i++){
            if(indexA>=nums1.length){
                merge[i]=nums2[indexB++];
            }else if(indexB>=nums2.length){
                merge[i]=nums1[indexA++];
            }else if(nums1[indexA]>nums2[indexB]){
                merge[i]=nums2[indexB++];
            }else{
                merge[i]=nums1[indexA++];
            }
        }
        if(merge.length%2==0){
            int centre=merge.length/2;
            return (merge[centre]+merge[centre-1])/2.0;

        }else{
            return  merge[merge.length/2];
        }
    }

    private static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        nums1 = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, nums1, length1, nums2.length);
        Arrays.sort(nums1);

        return nums1.length % 2 == 0 ? (double) (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2
                : nums1[nums1.length / 2  ];
    }

    private static double findMedianSortedArrays10(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        int len = nums1.length + nums2.length;
        int mid = len / 2;
        int[] mids = new int[mid + 1];
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (count > mid) {
                break;
            }
            if (nums1[i] < nums2[j]) {
                mids[count++] = nums1[i++];
            } else {
                mids[count++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            if (count > mid) {
                break;
            }
            mids[count++] = nums1[i++];

        }
        while (j < nums2.length) {
            if (count > mid) {
                break;
            }
            mids[count++] = nums2[j++];
        }
        if (len % 2 != 0) {
            return mids[mid];
        }
        return (mids[mid] + mids[mid - 1]) / 2.0;
    }

}
