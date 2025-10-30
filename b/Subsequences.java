import java.util.HashMap;
import java.util.HashSet;

public class Subsequences {
    public String[] generatePermutation (String s) {
        char[] arr=s.toCharArray();
        HashSet<String> map=new HashSet<>();
        f(arr,0,new StringBuilder(),map);
        String[] ans=new String[map.size()];
        int i=0;
        for(String C:map){
            ans[i++]=C;
        }
        return ans;
    }
    public void f(char[] arr,int i,StringBuilder sb,HashSet<String> map){
        if (i==arr.length){
            map.add(sb.toString());
        }
        sb.append(arr[i]);
        f(arr,i+1,sb,map);
        sb.deleteCharAt(sb.length()-1);
        f(arr,i+1,sb,map);
    }
    private static char[] help;
    public String[] generatePermutation1 (String s) {
        char[] arr=s.toCharArray();
        HashSet<String> map=new HashSet<>();
        help=new char[arr.length] ;
        f1(arr,0,0,map);
        String[] ans=new String[map.size()];
        int i=0;
        for(String C:map){
            ans[i++]=C;
        }
        return ans;
    }
    public void f1(char[] arr,int i,int size,HashSet<String> map){
        if (i==arr.length){
            map.add(String.valueOf(help, 0, size));
            return;
        }
        help[size]=arr[i];
        f1(arr,i+1,size+1,map);
        f1(arr,i+1,size,map);
    }
}
