class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // p  id s t
        // 0: 2, 1 10
        // 1: 1, 2  4 
        // 4: 0, 2  3 6 8 10
        // 5:    1  5 6 7 8 9 10
        // 7: 3, 1  3 8 9 10
        // 8 1 
        // 6 1+
        // time=(target - position)/speed
        // if car ahead has time greater or equal
        Integer[] cars = new Integer[position.length];
        for (int i = 0; i < position.length; ++i) {
            cars[i] = i;
        }
        Arrays.sort(cars, (a, b) -> {
            return position[b] - position[a];
        });
        Stack<Double> st = new Stack<>();
        for (int c : cars) {
            double time = (double)(target - position[c]) / speed[c];
            if (st.isEmpty() || Double.compare(time, st.peek()) > 0) {
                st.push(time);
            }
        }
        return st.size();
    }
}
