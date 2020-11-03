package leetcode.editor.cn;

/**
 * 股票买卖
 * https://blog.csdn.net/weixin_34417183/article/details/91403483
 * @author ：xinze
 * @date ：Created by 2020/11/3 11:43
 * @description：
 * @modified By：
 * @version:
 */

public class MaxProfit {

    public static void main(String[] args) {
        int[] data = {7,1,5,3,6,4};
        int[] data2 = {7,6,4,3,1};

        int max = new MaxProfit().maxProfit(data2);
        System.out.println(max);

        int max2 = new MaxProfit().maxSumProfit(data);
        System.out.println(max2);

    }


    /**
     * https://blog.csdn.net/weixin_34417183/article/details/91403483
     * Leetcode 121. 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * 注意你不能在买入股票前卖出股票。
     * 股票买卖的最佳时间 单次购买
     * @param data
     * @return
     */
    int maxProfit(int[] data){

        if(data==null||data.length==0){
            return 0;
        }
        int length = data.length;

        int maxProfit=0;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i<data.length;i++){
            if(maxProfit<Integer.MAX_VALUE&&data[i]-minPrice>maxProfit){
                maxProfit=data[i]-minPrice;
            }
            if(data[i]<minPrice){
                minPrice=data[i];
            }
        }
        return maxProfit;
    }

    /**
     * 这次改成股票可以买卖多次, 但是你必须要在出售股票之前把持有的股票卖掉。
     * @param data
     * @return
     */
    int maxSumProfit(int[] data){
        if(data==null||data.length==0){
            return 0;
        }

        int maxSumProfit = 0;

        for (int i=0; i<data.length;i++){
            if(i!=0&&data[i]-data[i-1]>0){
                maxSumProfit+=data[i]-data[i-1];
            }
        }
        return maxSumProfit;
    }
}
