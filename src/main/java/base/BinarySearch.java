package base;

/**
 * 二分查找
 * @author ：xz
 * @date ：Created by 2021/2/17 22:36
 * @description：
 * @modified By：
 * @version:
 */

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums ={1,3,4,6,7,8};
        int index = new BinarySearch().binarySearch(nums,0,nums.length-1,2);
        System.out.println(index);
    }

    int binarySearch(int[] nums, int start, int end, int target){
        if(nums==null|| nums.length<1 || start<0||start>=end){
            return -1;
        }

        while (start<=end){

            int mid = start+(end-start)>>>2;
            if(target==nums[mid]){
                return mid;
            }else if(target<nums[mid]){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return -1;
    }

}
