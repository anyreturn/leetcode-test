//Given an input string (s) and a pattern (p), implement regular expression matc
//hing with support for '.' and '*'. 
//
// 
//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
// 
//
// The matching should cover the entire input string (not partial). 
//
// Note: 
//
// 
// s could be empty and contains only lowercase letters a-z. 
// p could be empty and contains only lowercase letters a-z, and characters like
// . or *. 
// 
//
// Example 1: 
//
// 
//Input:
//s = "aa"
//p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input:
//s = "aa"
//p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input:
//s = "ab"
//p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// Example 4: 
//
// 
//Input:
//s = "aab"
//p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, i
//t matches "aab".
// 
//
// Example 5: 
//
// 
//Input:
//s = "mississippi"
//p = "mis*is*p*."
//Output: false
// 
// Related Topics 字符串 动态规划 回溯算法 
// 👍 1449 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * RegularExpressionMatching
 */    
public class RegularExpressionMatching{
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
      }
      
/**
 * 
 */
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        //状态机解决方案
        int index = 0 ;
        Set<Integer> nextState = new HashSet<Integer>();
        nextMatch(p,0,nextState);

        while(!nextState.isEmpty()){

            Set<Integer> nowState = nextState;
            nextState = new HashSet();

            for (Integer state : nowState ){
                if(state >= p.length() && index >= s.length()){
                    return true;
                }
                if(state >= p.length()){
                    continue;
                }
                if(index < s.length()){
                    if(p.charAt(state) == '.' || p.charAt(state) == s.charAt(index)){
                        if(state+1 < p.length() && p.charAt(state+1) == '*'){
                            nextMatch(p, state, nextState);
                        }else {
                            nextMatch(p,state+1,nextState);
                        }
                    }
                }
            }
            index++;
        }
        return false;
    }

    void nextMatch(String p, int state, Set nextState){
        nextState.add(state);
        if(state+1<p.length() && p.charAt(state+1) == '*'){
            nextMatch(p,state+2,nextState);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  
}