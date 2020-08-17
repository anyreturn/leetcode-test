//Given n non-negative integers a1, a2, ..., an , where each represents a point 
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
// line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis for
//ms a container, such that the container contains the most water. 
//
// Note: You may not slant the container and n is at least 2. 
//
// 
//
// 
//
// The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In thi
//s case, the max area of water (blue section) the container can contain is 49. 
//
// 
//
// Example: 
//
// 
//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49 Related Topics 数组 双指针 
// 👍 1752 👎 0


package leetcode.editor.cn;

/**
 * ContainerWithMostWater
 */    
public class ContainerWithMostWater{
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
      }
      
/**
 * 
 */
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {

        int len = height.length;

        int start = 0;
        int end = len-1;
        int maxArea=0;

        while(start<end){
            int area = Math.min(height[start],height[end])*(end-start);
            maxArea = Math.max(area, maxArea);
            if(height[start]<height[end]){
                start++;
            }else {
                end--;
            }
        }

        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  
}