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
