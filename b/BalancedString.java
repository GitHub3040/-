import java.util.HashMap;

public class BalancedString {
    public static int balancedString1(String s){
        int n=s.length();
        int [] map=new int[n];
        int[] cnt=new int[4];
        for (int i = 0; i < n; i++) {
            char c=s.charAt(i);
            map[i]=c=='W' ? 1 : c=='E' ? 2 : c=='R' ? 3 : 0;
            cnt[map[i]]++;
        }
        int debt=0;
        for (int i = 0; i < 4; i++) {
            if (cnt[i]< n/4){
                cnt[i]=0;
            }else {
                cnt[i] = n / 4 - cnt[i];
                debt -= cnt[i];
            }
        }
        if (debt == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int l = 0,r=0; r < n; r++) {
            if (cnt[map[r]]++<0){
                debt--;
            }
            if (debt==0){
                while (cnt[map[l]]>0){
                    cnt[map[l++]]--;
                }
                ans = Math.min(ans, r - l + 1);
            }
        }
        return ans;
    }
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
