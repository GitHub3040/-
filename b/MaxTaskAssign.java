import java.util.Arrays;

public class MaxTaskAssign {
    private static int[] task;
    private static int[] work;
    private static int MAXN=50001;
    private static int[] queue=new int[MAXN];
    public int maxTaskAssign(int[] tasks,int[] worker,int pills,int strength){
        task=tasks;
        work=worker;
        int n=tasks.length;
        int m=worker.length;
        Arrays.sort(task);
        Arrays.sort(work);
        int r=Math.min(m,n),l=0;
        while (l<=r){
            int mid=(l+r)/2;
            if (check(mid,0,mid-1,m-mid,m-1,pills,strength)){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return l-1;
    }
    public static boolean check(int mid,int tl,int tr,int wl,int wr,int pills,int strength){
        int r=0,l=0;
        int cnt=0;
        for (int i = wl,j=tl; i <= wr; i++) {
            while (j<=tr && task[j]<=work[i]){
                queue[r++]=task[j++];
            }
            if (r>l && work[i]>=queue[l]){
                l++;
            }else {
                while (j<=tr && task[j]<=work[i]+strength){
                    queue[r++]=task[j++];
                }
                if (r>l){
                    cnt++;
                    r--;
                }else{
                    return false;
                }
            }
        }
        return cnt<=pills;
    }
}
