// bruteforce: Compare every buy day with every sell day to find max profit, O(N^2) time
// solution: Track the minimum price seen so far and calculate maximum profit dynamically, O(N) time / O(1) space
class Solution {
    public int maxProfit(int[] prices) {
        int p = 0;
        int min = 102;
        for (int i = 0; i < prices.length;++i) {
            min = Math.min(min, prices[i]);
            p = Math.max(p, prices[i]-min);
        }
        return p;
    }
}
