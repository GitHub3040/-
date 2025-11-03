public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0,l=0,n=gas.length,start=0;
        for (int i = 0; i <2*n ; i++) {
            sum+=gas[i%n]-cost[i%n];
            if (sum<0){
                sum=0;
                start=i+1;
            }
        }
        return start>=n ? -1 : n;
    }
}
