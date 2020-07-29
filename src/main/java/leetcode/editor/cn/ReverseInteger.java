//Given a 32-bit signed integer, reverse digits of an integer. 
//
// Example 1: 
//
// 
//Input: 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: 120
//Output: 21
// 
//
// Note: 
//Assume we are dealing with an environment which could only store integers with
//in the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pro
//blem, assume that your function returns 0 when the reversed integer overflows. 
// Related Topics 数学 
// 👍 2065 👎 0


package leetcode.editor.cn;

/**
 * ReverseInteger
 */    
public class ReverseInteger{
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
      }
      
/**
 * 
 */
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {

        int max = 2147483647;
        int min = -2147483648;

        int ans = 0;
        int pop = 0;
        while (x!=0){
            pop = x%10;
            x = x/10;
            if(ans>214748364 || (ans == 214748364 && pop > 7)){
                return 0;
            }else if(ans < -214748364 || (ans == -214748364 && pop < -8)){
                return 0;
            }
            ans = ans * 10 +pop;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  
}