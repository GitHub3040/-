import java.util.HashMap;

public class BalancedString {
    public static int balancedString(String s) {
        int n=s.length();
        int m=n/4,left=0,ans=n,size=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int num:map.values()){
            if (num>m){
                size++;
            }
        }
        if (size==0){
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            int value=map.get(c)-1;
            if (value==m){
                size--;
            }
            map.put(c,value);
            while (size==0){
                ans=Math.min(ans,i-left+1);
                char d=s.charAt(left++);
                if (map.get(d)==m){
                    size++;
                }
                map.put(d,map.get(d)+1);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(balancedString("QWER"));
    }
}
