public class SumSubarrayMins {
    private static int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] stack = new int[n];
        int r = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            while (r > 0 && arr[i] <= arr[stack[r - 1]]) {
                int c = stack[--r];
                int left = r == 0 ? -1 : stack[r - 1];
                sum = (sum + (long) (c - left) * (i - c) * arr[c]) % MOD;
            }
            stack[r++] = i;
        }
        while (r > 0) {
            int c = stack[--r];
            int left= r==0 ? -1 : stack[r-1];
            sum=(sum+(long) (c-left)*(n-c)*arr[c])%MOD;
        }
        return (int) sum;
    }
}
