package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

/**
 * 快速排序
 * @author ：xinze
 * @date ：Created by 2020/11/2 14:11
 * @description：
 * @modified By：
 * @version:
 */

public class QuickSort {

    public static void main(String[] args) throws Exception{

        int[] data = {1,2,5,3,7,4,9,0,6,19,14,2,5,4};
        int length = data.length;

        new QuickSort().QuickSort(data,0,length-1);
        System.out.println("data="+ JSON.toJSONString(data));
    }

    /**
     * 快排-单趟排序
     * 返回基数值位置
     */
    int partition(int[] data, int low, int high) throws Exception{
        if(data == null || low<0 || high>data.length){
            throw new Exception("invalid input");
        }
        //随机选取基数值
        int index = (int)(Math.random()*(high-low))+low;
        swap(data, index, high);

        //small指向最新小于基数值的位置
        int small = low-1;
        for(int i =low; i<high;i++){
            if(data[i]<data[high]){
                small++;
                if(small!=i){
                    swap(data,small, i);
                }
            }
        }

        small++;
        swap(data,small,high);
        return small;
    }

    /**
     * 快速排序
     * @param data
     * @param start
     * @param end
     * @throws Exception
     */
    void QuickSort(int[] data, int start, int end) throws Exception{
        if(data == null||start<0||end>data.length){
            return;
        }
        int index = partition(data,start,end);
        if(index>start){
            QuickSort(data, start, index-1);
        }
        if(index<end){
            QuickSort(data,index+1,end);
        }
    }

    void swap(int[] data, int index1, int index2){
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}
