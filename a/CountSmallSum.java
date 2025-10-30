import java.io.*;

public class CountSmallSum {
    private static int MAX=100001;
    private static int [] arr=new int[MAX];
    private static int [] temp=new int[MAX];
    public static void main(String[] agrs) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out =new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            int n=(int) in.nval;
            in.nextToken();
            for (int i = 0; i < n; i++) {
                arr[i]=(int) in.nval;
                in.nextToken();
            }
            long ans=countSum(0,n-1);
            out.println(ans);
        }
        out.flush();
        out.close();
    }
    public static long countSum(int l,int r){
        if (l>=r) return 0;
        int mid=(l+r)/2;
        return countSum(l,mid)+countSum(mid+1,r)+merge(l,mid,r);
    }
    public static long merge(int l,int mid,int r){
        long sum=0,ans=0;
        for(int i=l,j=mid+1;j<=r;j++){
            while(i<=mid && arr[i]<=arr[j]){
                sum+=arr[i++];
            }
            ans+=sum;
        }
        int i=l,k=l,j=mid+1;
        while (i<=mid&&j<=r){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=r){
            temp[k++]=arr[j++];
        }
        for(int p=l;p<=r;p++){
            arr[p]=temp[p];
        }
        return ans;
    }
}
