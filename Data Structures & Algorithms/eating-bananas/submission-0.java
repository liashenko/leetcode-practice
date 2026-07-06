// bruteforce: Try each speed from 1 to max(piles), compute hours needed, O(max(piles) * N) time
// solution: Binary search the minimum eating speed, check feasibility by computing total hours, O(N log M) time / O(1) space
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 1 2 ... max(piles)
        // binary search
        int maxPiles = 0;
        for (int p : piles) {
            maxPiles = Math.max(p, maxPiles);
        }
        // lower bound finds >=
        // upper bound finds >
        // to find <= get upper bound - 1
        // to find the minimum, we need to find upper bound of h
        int minHours = 1, maxHours = maxPiles+1;
        while (minHours < maxHours) {
            int mid = minHours + (maxHours-minHours)/2;
            int hoursNeeded = 0;
            for (int p : piles) {
                hoursNeeded+=Math.ceil((double)p/mid);
            }
            System.out.println(mid + " " + hoursNeeded);
            // 1 2 3 4
            // 10 6 5 4
            if (hoursNeeded > h) {
                minHours = mid + 1;
            } else {
                maxHours = mid;
            }
        }
        return minHours;
    }
}
