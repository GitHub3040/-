import java.io.*;

public class MergeSort {
    static int Max=100000;
    static int [] arr=new int[Max];
    static int[] temp=new int[Max];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        while (st.nextToken()!=StreamTokenizer.TT_EOF) {
            int n = (int) st.nval;
            st.nextToken();
            for (int i = 0; i < n; i++) {
                arr[i] = (int) st.nval;
                st.nextToken();
            }
//            mergeSort1(0,n-1);
            mergeSort2(n);
            for (int i = 0; i < n; i++) {
                pw.print(arr[i]+" ");
            }
        }
        pw.flush();
        pw.close();
    }
    private static void mergeSort1(int left, int right) {
        if(left>=right) return;
        int mid=(left+right)/2;
        mergeSort1(left,mid);
        mergeSort1(mid+1,right);
        merge(left,mid,right);
    }
    private static void merge(int left,int mid,int right) {
        int i=left,j=mid+1,k=left;
        while(i<=mid&&j<=right){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=right){
            temp[k++]=arr[j++];
        }
        for(int p=left;p<=right;p++){
            arr[p]=temp[p];
        }
    }
//    非递归写法
    private static void mergeSort2(int n){
        for(int left,m,right,step=1;step<n;step*=2){
            left=0;
            while(left<n){
                m=left+step-1;
                if(m+1>=n){
                    break;
                }
                right = Math.min(left + (step << 1) - 1, n - 1);
                merge(left,m,right);
                left=right+1;
            }
        }
    }
}