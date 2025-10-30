import java.io.*;

public class Quicksort {
    static int Max=100000;
    static int [] arr=new int[Max];
    public static void main(String [] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            int n=(int)in.nval;
            in.nextToken();
            for (int i = 0; i < n; i++) {
                arr[i]=(int) in.nval;
                in.nextToken();
            }
            quickSort(0,n-1);
            for (int i = 0; i < n - 1; i++) {
                out.print(arr[i] + " ");
            }
            out.println(arr[n-1]);
        }
        out.flush();
        out.close();
    }
    public static void quickSort(int left,int right) {
        if(left>=right) return ;
        int len=right-left+1;
        int plot=arr[left+(int)(Math.random()*len)];
        int i=left,j=right,k=left;
        while (k<=j){
            if(arr[k]==plot){
                k++;
            }
            else {
                if (arr[k] < plot) {
                    int emt = arr[i];
                    arr[i] = arr[k];
                    arr[k] = emt;
                    i++;
                    k++;
                }
                else{
                    int emt = arr[k];
                    arr[k] = arr[j];
                    arr[j] = emt;
                    j--;
                }
            }
        }
        quickSort(left,i-1);
        quickSort(j+1,right);
    }

}
