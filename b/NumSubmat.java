public class NumSubmat {
    public int numSubmat(int[][] mat){
        int m=mat.length;
        int n=mat[0].length;
        int [] arr=new int[n];
        int [] stack=new int[n];
        int ans=0,r;
        for (int i = 0; i < m; i++) {
            r=0;
            for (int j = 0; j < n; j++) {
                arr[j]= mat[i][j]==0 ? 0 : arr[j]+1;
            }
            for (int j = 0; j < n; j++) {
                while (r>0 && arr[j]<=arr[stack[r-1]]){
                    int cur=stack[--r];
                    if (arr[cur]>arr[j]){
                        int left= r==0 ? -1 : stack[r-1];
                        int len=j-left-1;
                        int bottom=Math.max((left==-1 ? 0 : arr[left]),arr[j]);
                        ans+=(arr[cur]-bottom)*len*(len+1)/2;
                    }
                }
                stack[r++]=j;
            }
            while (r>0){
                int cur=stack[--r];
                int left= r==0 ? -1 : stack[r-1];
                int len=n-left-1;
                int bottom=left == -1 ? 0 : arr[left];
                ans+=(arr[cur]-bottom)*len*(len+1)/2;
            }
        }
        return ans;
    }
}
