//Determine whether an integer is a palindrome. An integer is a palindrome when 
//it reads the same backward as forward. 
//
// Example 1: 
//
// 
//Input: 121
//Output: true
// 
//
// Example 2: 
//
// 
//Input: -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// Follow up: 
//
// Coud you solve it without converting the integer to a string? 
// Related Topics 数学 
// 👍 1177 👎 0


package leetcode.editor.cn;

/**
 * PalindromeNumber
 */    
public class PalindromeNumber{
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
      }
      
/**
 * 
 */
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {


        if(x<0){
            return false;
        }
        int help = 1;
        int temp = x;

        while (temp/10 > 0){
            help = help * 10;
            temp = temp/10;
        }

        while (x > 0){
            if(x/help != x%10){
                return false;
            }
            x=x%help/10;
            help= help/100;
        }
        //if(x==0||help<10){
        //    return true;
        //}
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  
}