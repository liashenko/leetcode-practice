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
        int fleets = 1;
        double prevTime = (double)(target - position[cars[0]]) / speed[cars[0]];
        for (int i = 1; i < cars.length; i++) {
            double time = (double)(target - position[cars[i]]) / speed[cars[i]];
            if (Double.compare(time, prevTime) > 0) {
                fleets++;
                prevTime = time;
            }
        }
        return fleets;
    }
}
