//There are two sorted arrays nums1 and nums2 of size m and n respectively. 
//
// Find the median of the two sorted arrays. The overall run time complexity sho
//uld be O(log (m+n)). 
//
// You may assume nums1 and nums2 cannot be both empty. 
//
// Example 1: 
//
// 
//nums1 = [1, 3]
//nums2 = [2]
//
//The median is 2.0
// 
//
// Example 2: 
//
// 
//nums1 = [1, 2]
//nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 2939 👎 0


package leetcode.editor.cn;

/**
 * MedianOfTwoSortedArrays
 */    
public class MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] n1 = {1,2};
        int[] n2 = {3,4};

        solution.findMedianSortedArrays(n1,n2);

      }
      
/**
 * 
 */
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int nums1Length = nums1.length;
        int nums2Length = nums2.length;

        if(nums1Length == 0){
            return findMedian(nums2);
        }

        if(nums2Length == 0){
            return findMedian(nums1);
        }

        int[] nums = new int[nums1Length+nums2Length];
        int i=0,i1=0,i2=0;

        while (i1<nums1Length && i2<nums2Length){
            if(nums1[i1]<=nums2[i2]){
                nums[i++]=nums1[i1++];
            }else {
                nums[i++]=nums2[i2++];
            }
        }
        while (i1 < nums1Length){
            nums[i++]=nums1[i1++];
        }
        while (i2 < nums2Length){
            nums[i++]=nums2[i2++];
        }
        double num = findMedian(nums);
        System.out.println(num);

        return num;
    }

    public double findMedian(int[] array){

        int length = array.length;
        if(length==0){
            return 0d;
        }
        if(length % 2 == 0){
            return (array[length/2] + array[length/2-1])/2.0;
        }else {
            return array[length/2];
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
  
}