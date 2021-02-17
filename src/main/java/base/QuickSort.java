package base;

import com.alibaba.fastjson.JSON;

/**
 * 快速排序
 * @author ：xz
 * @date ：Created by 2021/2/17 20:30
 * @description：
 * @modified By：
 * @version:
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {2,3,5,1,2,4,5,6,7,1,7,9,0};
        new QuickSort().quickSort(nums,0,nums.length-1);
        System.out.println(JSON.toJSONString(nums));

    }

    /**
     * 快速排序
     * @param numbers
     * @param start
     * @param end
     */
    void quickSort(int[] numbers, int start, int end){

        if(numbers==null||start>end||numbers.length<1){
            return;
        }

        int index = partition2(numbers, start,end);

        quickSort(numbers, start, index - 1);
        quickSort(numbers, index + 1, end);

    }

    /**
     * 一趟排序
     * @param nums
     * @param start
     * @param end
     * @return
     */
    int partition(int[] nums, int start, int end){

        //取基准值
        int temp = nums[start];
        while (start<end){
            while (nums[end]>=temp && end>start){
                end--;
            }
            if(end>start) {
                nums[start++] = nums[end];
            }

            while (nums[start]<=temp && end>start){
                start++;
            }

            if(start<end){
                nums[end--]=nums[start];
            }
        }
        nums[start]=temp;
        return start;
    }

    /**
     * 一趟排序 第二种实现
     * @param nums
     * @param start
     * @param end
     * @return
     */
    int partition2(int[] nums, int start, int end){
        if(nums==null||nums.length<1||start<0||end<start){
            return start;
        }

        int small = start-1;
        for(int index = start;index<end;index++){
            //取最后一个元素为基准值
            if(nums[index]<nums[end]){
                small++;
                if(small!=index){
                    swap(nums,index,small);
                }
            }
        }
        small++;
        swap(nums,end,small);

        return small;
    }

    void swap(int[] nums,int index1, int index2){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }
}
