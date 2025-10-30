import java.io.*;

public class HeapSort {
    private static int MAX=100001;
    private static int[] arr=new int[MAX];
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(bf);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            n=(int)in.nval;
            in.nextToken();
            for (int i = 0; i < n; i++) {
                arr[i] = (int) in.nval;
                in.nextToken();
            }
        }
        heapSort();
        for (int i = 0; i < n - 1; i++) {
            out.print(arr[i] + " ");
        }
        out.println(arr[n - 1]);
        out.flush();
        out.close();
        bf.close();

    }
    public  static void swap(int i ,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void heapInsert(int i){
        while (arr[i]>arr[(i-1)/2]){
            swap(i,(i-1)/2);
            i=(i-1)/2;
        }
    }
    public static void  heapify(int i,int size){
        int l=i*2+1;
        while (l<size){
            int best=l+1<size&&arr[l+1]>arr[l] ? l+1 : l;
            best=arr[best]>arr[i] ? best : i;
            if (best==i){
                break;
            }
            swap(best,i);
            i=best;
            l=i*2+1;
        }
    }
    public static  void heapSort(){
        for (int i = n-1; i >=0; i--) {
            heapify(i,n);
        }
        int size=n;
        while (size>0){
            swap(0,--size);
            heapify(0,size);
        }
    }
}
