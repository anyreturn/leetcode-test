//Given a string s, find the longest palindromic substring in s. You may assume 
//that the maximum length of s is 1000. 
//
// Example 1: 
//
// 
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: "cbbd"
//Output: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2487 👎 0


package leetcode.editor.cn;

/**
 * LongestPalindromicSubstring
 */    
public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
      }
      
/**
 * 
 */
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty()){
            return "";
        }

        int len = s.length();
        String inverter = new StringBuffer(s).reverse().toString();

        int maxLen=0;
        int maxEnd=0;
        int[][] arr = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(s.charAt(i) == inverter.charAt(j)){
                    if(i==0||j==0){
                        arr[i][j]=1;
                    }else {
                        arr[i][j]= arr[i-1][j-1]+1;
                    }
                }

                if(arr[i][j] > maxLen){
                    int oldIndex = len-j-1;
                    if(oldIndex + arr[i][j] -1 == i) {
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd-maxLen+1,maxEnd+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  
}