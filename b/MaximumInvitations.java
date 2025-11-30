import java.util.ArrayList;

public class MaximumInvitations {
    public int maximumInvitations(int[] favorite){
        int n=favorite.length;
        int[] deep=new int[n];
        int [] indegree=new int[n];
        for (int k : favorite) {
            indegree[k]++;
        }
        int [] queue=new int[n];
        int l=0,r=0;
        for (int i = 0; i < n; i++) {
            if (indegree[i]==0){
                queue[r++]=i;
            }
        }
        while (r>l){
            int cur=queue[l++];
            int v=favorite[cur];
            deep[v]=Math.max(deep[v],deep[cur]+1);
            if (--indegree[v]==0){
                queue[r++]=v;
            }
        }
        int big=0;
        int sumOfSmall=0;
        for (int i = 0; i < n; i++) {
            if (indegree[i]>0){
                int cnt=1,j=i;
                indegree[i]=0;
                while (i!=favorite[j]){
                    cnt++;
                    j=favorite[j];
                    indegree[j]=0;
                }
                if (cnt==2){
                    sumOfSmall+=deep[i]+deep[favorite[i]]+2;
                }else {
                    big=Math.max(big,cnt);
                }
            }
        }
        return Math.max(sumOfSmall,big);
    }
}
