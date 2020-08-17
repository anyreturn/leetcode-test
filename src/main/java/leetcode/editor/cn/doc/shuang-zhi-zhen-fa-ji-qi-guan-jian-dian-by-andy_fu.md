### 双指针法

- 双指针法，左指针为数组头索引位置，不断向内增加，右指针为数组尾索引位置，不断向内递减
- 第一步，先计算出当前的面积，再与存储的最大面积比较，进而存储两者的最大值
- 第二步，根据双指针夹逼原则，双指针的宽度此时最大，为了能够获取更大的面积，故最小高度的一段指针向内收缩，这是关键

### 关键点

- 对于该方法而言，关键点在于什么时候往内收缩，可以获取最大面积，并且不会遗漏各个情况
- 对于该题，j-i宽度实际上已是最大宽度，那么，最小高度的指针向内收缩，有可能获取更高的高度，故可以获得更大的面积

### 代码

```java
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            maxArea = Math.max((j - i) * (height[i] < height[j] ? height[i++] : height[j--]), maxArea);
        }
        return maxArea;
    }
}
```