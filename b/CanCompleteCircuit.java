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
    public int canCompleteCircuit1(int[] gas, int[] cost){
        int n=gas.length;
        for (int l=0,r=0,sum; l<n ; l=r+1,r=l) {
            sum=0;
            while (sum+gas[r%n]-cost[r%n]>=0){
                if (r-l+1==n){
                    return l;
                }
                sum+=gas[r%n]-cost[r%n];
                r++;
            }
        }
        return -1;
    }
}
