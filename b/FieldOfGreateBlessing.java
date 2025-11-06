import java.util.Arrays;

public class FieldOfGreateBlessing{
    public int fieldOfGreatestBlessing(int[][] forceField) {
        int n=forceField.length;
        long[] xs=new long[n*2];
        long[] ys=new long[n*2];
        for (int i=0;i<n;i++){
            xs[i*2]=forceField[i][0]*2-forceField[i][2];
            xs[i*2+1]=forceField[i][0]*2+forceField[i][2];
            ys[i*2]=forceField[i][1]*2-forceField[i][2];
            ys[i*2+1]=forceField[i][1]*2+forceField[i][2];
        }
        int sizex=sort(xs);
        int sizey=sort(ys);
        int[][] diff=new int[sizex+2][sizey+2];
        for (int i = 0,a,b,c,d; i < n; i++) {
            long x=forceField[i][0],y=forceField[i][1],r=forceField[i][2];
            a=rank((x<<1)-r,0,sizex-1,xs);
            b=rank((y<<1)-r,0,sizey-1,ys);
            c=rank((x<<1)+r,0,sizex-1,xs);
            d=rank((y<<1)+r,0,sizey-1,ys);
            add(diff,a,b,c,d);
        }
        int ans=0;
        for (int i = 1; i <= sizex; i++) {
            for (int j = 1; j <= sizey; j++) {
                diff[i][j]+=diff[i-1][j]+diff[i][j-1]-diff[i-1][j-1];
                ans=Math.max(ans,diff[i][j]);
            }
        }
        return ans;
    }
    public static void add(int [][] diff,int a,int b,int c,int d){
        diff[a][b]++;
        diff[a][d+1]--;
        diff[c+1][b]--;
        diff[c+1][d+1]++;
    }
    public static int sort(long [] nums){
        Arrays.sort(nums);
        int size=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[i-1]){
                nums[size++]=nums[i];
            }
        }
        return size;
    }
    public static int rank(long x,int l,int r,long [] nums){
        while (l<=r){
            int mid=l+(r-l)/2;
            if (nums[mid]<=x){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return l;
    }
}
