/**
 * @author FJianC
 */
/**
 * 11. 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * */
public class MaxArea {

    public static void main(String[] args) {
        String line = "[1,8,6,2,5,4,8,3,7]";
        line = line.substring(1, line.length() - 1);
        String[] str = line.split(",");
        int[] height = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            height[i] = Integer.parseInt(str[i]);
        }
        System.out.println(new MaxArea().maxArea10(height));
    }

    public int maxArea1(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxarea;
    }

    public int maxArea10(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = 1; j < height.length; j++) {
                int temp;
                if (height[i] >= height[j]) {
                    temp = height[j] * (j - i);
                } else {
                    temp = height[i] * (j - i);
                }
                max = temp > max ? temp : max;
            }
        }
        return max;
    }

}
