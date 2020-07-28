//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number o
//f rows like this: (you may want to display this pattern in a fixed font for bett
//er legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a numbe
//r of rows: 
//
// 
//string convert(string s, int numRows); 
//
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//
//P     I    N
//A   L S  I G
//Y A   H R
//P     I 
// Related Topics 字符串 
// 👍 761 👎 0


package leetcode.editor.cn;

/**
 * ZigzagConversion
 */    
public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        solution.convert("PAYPALISHIRING",3);
    }

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {

            if ( numRows == 1 ) {
                return s;
            }

            int len = Math.min(s.length(), numRows);

            StringBuilder[] stringBuilders = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                stringBuilders[i] = new StringBuilder();
            }
            StringBuilder stringBuilder = new StringBuilder(s.length());

            int lc = 0;
            boolean down = false;

            for (int i = 0; i < s.length(); i++) {
                stringBuilders[lc].append(s.charAt(i));
                if (lc == numRows - 1 || lc == 0) {
                    down = !down;
                }
                lc += down ? 1 : -1;
            }

            for (int i = 0; i < numRows; i++) {
                stringBuilder.append(stringBuilders[i]);
            }
            return stringBuilder.toString();

            //for (int i = 0; i < numRows; i++) {
            //    for (int j = i; j < len; ) {
            //        stringBuilder.append(s.charAt(j));
            //        j = j+(numRows-1-i)*2;
            //    }

            //char[][] arr = new char[numRows][len];
            //
            //int k=0;
            //for(int j =0;j<len;j++){
            //    for(int i =0;i<numRows;i++){
            //        if(i%2 == 0){
            //            arr[0][j] = '*';
            //            arr[1][j] = s.charAt(k++);
            //            arr[2][j] = '*';
            //            break;
            //        }else {
            //            arr[i][j] = s.charAt(k++);
            //        }
            //}
            //}
            //    return stringBuilder.toString();
        }
    }
        //leetcode submit region end(Prohibit modification and deletion)

}