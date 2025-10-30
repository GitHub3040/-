public class TotalNQueens {
    private static int mask;
    public int totalNQueens2(int n){
        if (n<1){
            return 0;
        }
        return f2(0,new int[n],n);
    }

    public int f2(int i,int[] path,int n){
        if (i==n){
            return 1;
        }
        int ans=0;
        for (int j = 0; j < n; j++) {
            if(check(path,i,j)){
                path[i]=j;
                ans+=f2(i+1,path,n);
            }
        }
        return ans;
    }
    public boolean check(int[] path,int i,int j){
        for (int k = 0; k < i; k++) {
            if (j==path[k]||Math.abs(i-k)==Math.abs(j-path[k])){
                return false;
            }
        }
        return true;
    }
    public int totalNQueens(int n){
        mask=(1<<n)-1;
        return f(0,0,0);
    }
    public int f(int col,int left,int right){
        if (col==mask){
            return 1;
        }
        int pos=~(col|left|right);
        pos&=mask;
        int ans=0;
        while (pos!=0){
            int x=pos&-pos;
            ans+=f(col|x,(left|x)<<1,(right|x)>>>1);
            pos-=x;
        }
        return ans;
    }
}