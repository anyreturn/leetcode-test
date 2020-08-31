//Roman numerals are represented by seven different symbols: I, V, X, L, C, D an
//d M. 
//
// 
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// For example, two is written as II in Roman numeral, just two one's added toge
//ther. Twelve is written as, XII, which is simply X + II. The number twenty seven
// is written as XXVII, which is XX + V + II. 
//
// Roman numerals are usually written largest to smallest from left to right. Ho
//wever, the numeral for four is not IIII. Instead, the number four is written as 
//IV. Because the one is before the five we subtract it making four. The same prin
//ciple applies to the number nine, which is written as IX. There are six instance
//s where subtraction is used: 
//
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900. 
// 
//
// Given an integer, convert it to a roman numeral. Input is guaranteed to be wi
//thin the range from 1 to 3999. 
//
// Example 1: 
//
// 
//Input: 3
//Output: "III" 
//
// Example 2: 
//
// 
//Input: 4
//Output: "IV" 
//
// Example 3: 
//
// 
//Input: 9
//Output: "IX" 
//
// Example 4: 
//
// 
//Input: 58
//Output: "LVIII"
//Explanation: L = 50, V = 5, III = 3.
// 
//
// Example 5: 
//
// 
//Input: 1994
//Output: "MCMXCIV"
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4. 
// Related Topics 数学 字符串 
// 👍 390 👎 0


package leetcode.editor.cn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * IntegerToRoman
 */    
public class IntegerToRoman{
    public static void main(String[] args) {
        Solution solution = new IntegerToRoman().new Solution();
        String ss = solution.intToRoman(3);
        System.out.println(ss);
      }
      
/**
 * 
 */
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String intToRoman(int num) {

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(16);

        linkedHashMap.put(1000,"M");
        linkedHashMap.put(900,"CM");
        linkedHashMap.put(500,"D");
        linkedHashMap.put(400,"CD");
        linkedHashMap.put(100,"C");
        linkedHashMap.put(90,"XC");
        linkedHashMap.put(50,"L");
        linkedHashMap.put(40,"XL");
        linkedHashMap.put(10,"X");
        linkedHashMap.put(9,"IX");
        linkedHashMap.put(5,"V");
        linkedHashMap.put(4,"IV");
        linkedHashMap.put(1,"I");

        StringBuilder nums = new StringBuilder();


        for(Map.Entry<Integer, String> entry : linkedHashMap.entrySet()){
            Integer count = 0;
            while (num >= entry.getKey()){
                count++;
                num = num - entry.getKey();
            }
            while (count>0){
                nums.append(entry.getValue());
                count--;
            }
        }

        return nums.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  
}