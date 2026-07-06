class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // not optimal: merge nums1 and nums2
        // n+m, space -O(N)
        // optimizations:
        // find partition
        // left part should contain half elements
        // right part should contain another half
        // make a cut in a smaller array, take half-cut the other array
        // now check if the partition is correct:
        // check that all left <= right, if yes we found it
        // else:
        // continue cutting, low = mid+1
        int[] smaller = nums1.length <= nums2.length ? nums1 : nums2;
        int[] larger = nums1.length <= nums2.length ? nums2 : nums1;
        // take 0 elements from smaller or smaller.length
        int l = 0, r = smaller.length;
        int totalLeft = (nums1.length+nums2.length+1)/2; // left would contain median in case of odd
        while (l <= r) {
            int cut1 = l + (r-l)/2; // take cut1 from the smaller
            int cut2 = totalLeft - cut1; // take cut from the larger
            // now left partition is cut1+cut2 elements
            // let's check it
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : smaller[cut1-1];
            int right1 = cut1 == smaller.length ? Integer.MAX_VALUE : smaller[cut1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : larger[cut2-1];
            int right2 = cut2 == larger.length ? Integer.MAX_VALUE : larger[cut2];
            // 1 2 3 4
            // 5 6 7 8 9
            if (left1 <= right2 && left2 <= right1) {
                return (nums1.length+nums2.length)%2==1 ? 
                    Math.max(left1, left2) : (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left2 > right1) {
                l = cut1+1;
            } else {
                r = cut1-1;
            }
        }
        return 0.0;
    }
}
