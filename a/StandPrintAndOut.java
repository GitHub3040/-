import java.io.*;

public class StandPrintAndOut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        while (st.nextToken()!=StreamTokenizer.TT_EOF){
            int n=(int) st.nval;
            st.nextToken();
            for (int i = 0; i <n ; i++) {
                pw.println(st.nval);
                st.nextToken();
            }
        }
        pw.flush();
        pw.close();
    }
}