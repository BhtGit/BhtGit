### 解题思路
本题属于使用动态规划方法解决的一道题，回文序列的意思应该不用去解释了。做动态规划的题目，首先要去定义dp数组的含义。这里我们定义一个二维数组dp

*dp[i][j]***表示字符串**![s\[i\cdotsj\] ](./p__s_icdots_j__.png) **的最长回文子序列的长度。**

看下面的例子：

![516_1.png](https://pic.leetcode-cn.com/065b6533d1a68e10a9667408a121c38b565157a350dd405c2bd3f3322810bd57-516_1.png)


假设我们现在知道了*dp[i+1][j-1]*，我们如何计算*dp[i][j]*呢？我们只需要观察是*s[i]* 等不等于*s[j]*

- 当*s[i] = s[j]*，那么就说明在原先的基础上又增加了回文子序列的长度，*dp[i][j] = dp[i+1][j-1] + 2*。
- 当![s\[i\]\nes\[j\] ](./p__s_i__ne_s_j__.png) ，那么那么说明*s[i]、s[j]*至少有一个不在回文子序列中。那就变成了下图所示：

![516_2.png](https://pic.leetcode-cn.com/cd33cfe11201c4f8c59b02a9644eff27b1f9dbe202890fc7b6f33103132e8771-516_2.png)


表明这时的*dp[i][j]*只需取两者之间的最大值即可。即*dp[i][j] = max(dp[i][j-1],dp[i+1][j])*。

由于我们的一个字符就能构成一个回文子序列，且长度为1，故dp\[i][j] = 1，此时i一直是小于j的，不存在i大于j的情况。故我们的dp表为：

![516_3.png](https://pic.leetcode-cn.com/f4c7b23593b01348114b37781d280117273f1ba4356253f6cfcc1b1254df6cec-516_3.png)


由于这种初试值的方式，决定了我们遍历的顺序，我们需要需要从下向上的遍历，如图所示

![516_4.png](https://pic.leetcode-cn.com/9fab54973a3b53d864831a8abac9f3eac1d6bf47f5e4b618e081fab552ad1efd-516_4.png)


这样我们就可以走完整个过程了 。

![516_5.GIF](https://pic.leetcode-cn.com/65ddfb82b07e9d66fad03d34fd5ceb74523e9d93bfea6debe5148b9ed181fcd0-516_5.GIF)


### 代码

```java
class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s == null){
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        int n = s.length();
        for(int i = 0; i<n; i++){
            dp[i][i] = 1;
        }
        //从下往上遍历
        for(int i = n-1; i>=0; i--){
            for(int j = i+1; j<n; j++){
                //那么就说明在原先的基础上又增加了回文子序列的长度
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                //表明这时dp[i][j]只需取两者之间的最大值即可
                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];

    }
}
```