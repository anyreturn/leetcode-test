package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

/**
 * 归并排序
 * @author ：xinze
 * @date ：Created by 2020/11/2 11:52
 * @description：
 * @modified By：
 * @version:
 */

public class MergeSort {
    public static void main(String[] args) {

        int[] data = {1,2,5,3,7,4,9,0,6,19,14,2,5,4};
        int length = data.length;
        int[] data2 = new int[length];
         MergeSort mergeSort = new MergeSort();
         mergeSort.mergeSort(data,data2,0,data.length-1);
        System.out.println("data="+ JSON.toJSONString(data));
        System.out.println("data2="+ JSON.toJSONString(data2));

        //Random random = new Random(1);
        //random.nextInt(100);
        //random.nextInt();
        ////Math.random()*(length-low)+length;
    }

    //归并排序 不改变原数组，基于辅助数组排序
    void merge(int[] data, int low,int mid, int hight){
        if(data == null){
            return;
        }
        int[]data2 = new int[hight-low+1];

        int i,j,k;
        for(i=low, j=mid+1,k=0; i<=mid&&j<=hight; k++){
            if(data[i]<data[j]){
                data2[k]=data[i++];
            }else {
                data2[k]=data[j++];
            }
        }
        while (i<=mid){
            data2[k++]=data[i++];
        }
        while (j<=hight){
            data2[k++]=data[j++];
        }
        for (int l = 0; l < data2.length; l++) {
            data[l+low] = data2[l];
        }
    }

    void mergeSort(int[] data, int[]data2, int low, int high){
        if(data == null){
            return;
        }
        //int[]dataTemp = new int[data.length];
        if(low == high) {
            //将原数组值赋值给排序数组
            data2[low] = data[low];
        }
        else {
            int mid = low + ((high - low) >> 1);
            mergeSort(data, data2, low, mid);
            mergeSort(data, data2,mid + 1, high);
            merge(data2, low, mid, high);
        }
    }

    //归并排序 改变原数组
    //void merge(int[] data, int low,int mid, int hight){
    //    if(data == null){
    //        return;
    //    }
    //    int[]data2 = new int[hight-low+1];
    //
    //    int i,j,k;
    //    for(i=low, j=mid+1,k=0; i<=mid&&j<=hight; k++){
    //        if(data[i]<data[j]){
    //            data2[k]=data[i++];
    //        }else {
    //            data2[k]=data[j++];
    //        }
    //    }
    //    while (i<=mid){
    //        data2[k++]=data[i++];
    //    }
    //    while (j<=hight){
    //        data2[k++]=data[j++];
    //    }
    //    for (int l = 0; l < data2.length; l++) {
    //        data[l+low] = data2[l];
    //    }
    //}

    //void mergeSort(int[] data, int low, int high){
    //    if(data == null){
    //        return;
    //    }
    //
    //    if(low<high) {
    //        int mid = low + ((high - low) >> 1);
    //        mergeSort(data, low, mid);
    //        mergeSort(data, mid + 1, high);
    //        merge(data, low, mid, high);
    //    }
    //}
}
