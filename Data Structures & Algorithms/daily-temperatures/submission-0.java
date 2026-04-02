class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] result = new int[temps.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<temps.length;i++){
            while(!stack.isEmpty() && temps[stack.peek()]<temps[i]){
                int topIndex = stack.pop();
                int diff = i-topIndex;
                result[topIndex] = diff;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int topIndex = stack.pop();
            result[topIndex]=0;
        }

        return result;
    }
}
