class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (sum(gas) < sum(cost)) {
            return -1;
        }
        int result = 0;
        int sum = 0;

        for (int i = 0; i < gas.length - 1; i++) {
            sum = sum + gas[i] - cost[i];

            if (sum < 0) {
                sum = 0;
                result = i + 1;
            }
        }
        return result;
    }

    public int sum(int[] array) {
        int res = 0;
        for (int num : array) {
            res += num;
        }
        return res;
    }
}