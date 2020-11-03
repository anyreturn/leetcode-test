package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

/**
 * 从有n个元素的乱序数组中找出第k大的元素
 * https://blog.csdn.net/orangefly0214/article/details/86527462
 * @author ：xinze
 * @date ：Created by 2020/11/2 18:44
 * @description：
 * @modified By：
 * @version:
 */

public class FindKthLargest {
    public static void main(String[] args)throws Exception {
        int[] data = {1,2,3,2,8,5};
        int k =4;
        int result = new FindKthLargest().findKthLargest(data,k);
        System.out.println("data="+ JSON.toJSONString(data)
            +"\nresult="+result);

    }

    /**
     *
     * 从有n个元素的乱序数组中找出第k大的元素
     * https://blog.csdn.net/orangefly0214/article/details/86527462
     * @param data
     * @param k
     * @return
     * @throws Exception
     */
    int findKthLargest(int[] data, int k)throws Exception{
        if(data==null||k<0||k>data.length){
            throw new Exception("invalid input");
        }
        int index = kthLargest(data,k,0,data.length-1);
        return data[index];
    }

    int kthLargest(int[] data, int k, int start, int end)throws Exception{
        if(data==null||start<0||end>data.length){
            throw new Exception("invalid input");
        }
        int index = (int)(Math.random()*(end-start))+start;
        swap(data,index,end);
        int big = start-1;

        for(int i=start;i<end;i++){
            if(data[i]>data[end]){
                big++;
                if(i!=big){
                    swap(data,big,i);
                }
            }
        }
        big++;
        swap(data,big,end);
        if(big==k-1){
            return big;
        }else if(big>k-1){
            return kthLargest(data,k,start,big-1);
        }else{
            return kthLargest(data,k,big+1,end);
        }

    }

    void swap(int[]data, int src,int dest){
        int temp = data[src];
        data[src] = data[dest];
        data[dest] = temp;
    }
}
