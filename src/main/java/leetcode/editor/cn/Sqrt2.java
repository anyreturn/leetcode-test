package leetcode.editor.cn;

/**
 * @author ：xinze
 * @date ：Created by 2020/11/2 16:17
 * @description：
 * @modified By：
 * @version:
 */

public class Sqrt2 {

    public static void main(String[] args) {

        double num = 2;
       double sqrtNum = new Sqrt2().sqrt(num);

       System.out.println("num="+num+"\nsqrtNum="+sqrtNum);
    }

    /**
     * 开根号
     * @param num
     * @return
     */
    double sqrt(double num){

        double threshold = 0.0000000001;

        double low = 0;
        double height = num;

        double mid = low + (height-low)/2;

        while (height-low>threshold){
            double temp = mid*mid;
            if(temp<num){
                low=mid;
            }else if (temp>num){
                height=mid;
            }
            mid = low + (height-low)/2;
        }
        return mid;

    }
}
