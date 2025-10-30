import java.io.*;
import java.util.HashMap;

public class SetAll {
    public static HashMap<Integer, int[]> map = new HashMap<>();
    public static int curTime,setAllTime,setAllValue;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int n=(int)in.nval;
        in.nextToken();
        map.clear();
        setAllValue=0;
        setAllTime=-1;
        for (int i = 0; i < n; i++) {
            int op=(int) in.nval;
            in.nextToken();
            if (op==1){
                int key=(int)in.nval;
                in.nextToken();
                int value=(int) in.nval;
                in.nextToken();
                setValue(key,value);
            } else if (op==2) {
                int k=(int) in.nval;
                in.nextToken();
                int val=get(k);
                out.println(val);
            } else{
                int c=(int) in.nval;
                in.nextToken();
                setAll(c);
            }
        }
        out.flush();
        out.close();
        br.close();;
    }
    public static void setValue(int key,int value){
        if (map.containsKey(key)){
            int [] val=map.get(key);
            val[0]=value;
            val[1]=curTime++;
        }else {
            map.put(key,new int []{value,curTime++});
        }
    }
    public static void setAll(int v){
        setAllValue=v;
        setAllTime=curTime++;
    }
    public static int get(int k){
        if(!map.containsKey(k)){
            return -1;
        }
        int[] val=map.get(k);
        if (val[1]>setAllTime){
            return val[0];
        }else {
            return setAllValue;
        }
    }
}
