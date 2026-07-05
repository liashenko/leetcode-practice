# LeetCode Practice

A collection of Leetcode problem solutions implemented in Java.

---

## Core Algorithmic Patterns

### 1. Two Pointers (Converging / Inward Pointers)
* **What it is**: A technique where two pointers starting at different indices (typically the beginning and end of a sorted sequence) move towards each other based on comparison rules.
* **How to use**: 
  - Place `left` at the start and `right` at the end of the array.
  - Evaluate the target condition (e.g., `sum = nums[left] + nums[right]`).
  - If the sum is too small, advance `left++`. If the sum is too large, decrement `right--`.
* **When to use**: 
  - Searching for pairs in a **sorted** array (e.g., Two Sum II, Three Sum).
  - Maximizing boundaries or trapping areas (e.g., Container With Most Water, Trapping Rain Water).

### 2. Sliding Window
* **What it is**: A technique that uses two pointers (`left` and `right`) to define a subsegment of an array or string, adjusting its boundaries dynamically or using a fixed size.
* **How to use**:
  - Initialize `left = 0` and expand `right` to grow the window.
  - Update your state (e.g., frequency maps, sums) with the incoming element.
  - Shrink the window by advancing `left` whenever a constraint is violated, updating the state accordingly.
  - Record the maximum, minimum, or valid state during each step.
* **When to use**:
  - Problems involving contiguous subarrays or substrings.
  - Optimizing lengths (e.g., longest substring without duplicate characters, minimum window containing target characters).

### 3. Prefix & Suffix Precomputation (Prefix Sum)
* **What it is**: Precomputing running totals, products, or min/max bounds from both directions (left-to-right and right-to-left) into auxiliary arrays.
* **How to use**:
  - Create a `prefix` array: loop left-to-right, calculating `prefix[i] = prefix[i-1] * nums[i]`.
  - Create a `suffix` array: loop right-to-left, calculating `suffix[i] = suffix[i+1] * nums[i]`.
  - Resolve the query for index `i` by combining `prefix[i-1]` and `suffix[i+1]` in $O(1)$ time.
* **When to use**:
  - Excludable range queries (e.g., Product of Array Except Self).
  - Precomputing boundary limits (e.g., Trapping Rain Water standard solution).

### 4. Monotonic Stack & Deque
* **What it is**: A stack or double-ended queue (deque) that maintains its elements in a strictly increasing or decreasing order.
* **How to use**:
  - Iterate through the array.
  - Before pushing the current element (or its index), pop all elements from the stack/deque that violate the monotonic property (e.g., elements smaller than the current one for a decreasing stack).
  - For sliding windows (deque), also pop from the front if the index falls outside the window boundaries (`left` pointer).
* **When to use**:
  - Finding the *next greater* or *next smaller* element in $O(N)$ time.
  - Tracking the maximum or minimum element in a dynamic/sliding window range.

### 5. Bitmasking (Bit Manipulation)
* **What it is**: Utilizing the individual bits of a primitive integer (like `int` or `long`) as a compact, high-performance boolean array or set.
* **How to use**:
  - Map elements to a bit index (e.g., character `c - 'a'` or number `val - 1`).
  - **Set bit**: `mask |= (1 << bitIndex)`
  - **Check bit**: `(mask & (1 << bitIndex)) > 0`
  - **Clear bit**: `mask &= ~(1 << bitIndex)`
* **When to use**:
  - When $O(1)$ auxiliary space is strictly required, replacing bulky collections like `HashSet`.
  - State tracking in finite sets (e.g., Valid Sudoku grid checks, grid-based pathfinding, subset selection).

### 6. Bucket Sort (Frequency-to-Index Mapping)
* **What it is**: A sorting optimization where you map frequency metrics to array indices. Since the maximum frequency of any element in an array of size $N$ is bounded by $N$, you can sort by frequency in $O(N)$ time.
* **How to use**:
  - Build a frequency map of items.
  - Create an array of lists `List[] buckets = new List[nums.length + 1]`.
  - Place each element into the list at `buckets[frequency]`.
  - Iterate from the back of the buckets array to gather the most frequent elements first.
* **When to use**:
  - Top K Frequent Elements or any problem requiring element retrieval ordered by frequency in $O(N)$ time.

