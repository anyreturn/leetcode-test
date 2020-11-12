//Given a string, find the length of the longest substring without repeating cha
//racters. 
//
// 
// Example 1: 
//
// 
//Input: "abcabcbb"
//Output: 3 
//Explanation: The answer is "abc", with the length of 3. 
// 
//
// 
// Example 2: 
//
// 
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// 
// Example 3: 
//
// 
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence
// and not a substring.
// 
// 
// 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4011 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * LongestSubstringWithoutRepeatingCharacters
 */    
public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String ss = "pwwkew";
        int ll = solution.lengthOfLongestSubstring(ss);
        System.out.println(ll);

      }
      
/**
 * 
 */
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 任意字符串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        //int n = s.length(), ans = 0;
        //Map<Character, Integer> map = new HashMap<>();
        //for (int end = 0, start = 0; end < n; end++) {
        //    char alpha = s.charAt(end);
        //    if (map.containsKey(alpha)) {
        //        start = Math.max(map.get(alpha), start);
        //    }
        //    ans = Math.max(ans, end - start + 1);
        //    map.put(s.charAt(end), end + 1);
        //}
        //return ans;

        int n=s.length(), ans=0;
        Map<Character, Integer> map = new HashMap<>(16);
        for(int start=0,end=0;end <n;end++){
            Character character = s.charAt(end);
            if(map.containsKey(character)){
                start = Math.max(map.get(character),start);
            }
            ans = Math.max(ans,end-start+1);
            map.put(s.charAt(end),end+1);
        }
        return ans;
    }

    /**
     * 假设字符串中只包含从’a’到’z’的字符
     * @param s
     * @return
     */
    //public Integer lengthOfLongestSubstring(String s){
    //
    //    if(s==null || "".equals(s)){
    //        return null;
    //    }
    //    if("".equals(s)){
    //        return null;
    //    }
    //
    //    int[] chart = new int[27];
    //    for(int i=0;i<chart.length;i++){
    //        chart[i] = -1;
    //    }
    //    int currentLength = 0;
    //    int maxLength = -1;
    //    for(int j=0;j<s.length();j++){
    //        int preIndex = chart[s.charAt(j)-'a'];
    //        if(preIndex<0 || j-preIndex>currentLength){
    //            ++currentLength;
    //        }else {
    //            //if(currentLength>maxLength){
    //            //    maxLength=currentLength;
    //            //}
    //            currentLength = j-preIndex;
    //        }
    //        if(currentLength>maxLength){
    //            maxLength=currentLength;
    //        }
    //        chart[s.charAt(j)-'a'] = j;
    //    }
    //    return maxLength;
    //}
}
//leetcode submit region end(Prohibit modification and deletion)
  
}