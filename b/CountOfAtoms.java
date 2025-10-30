
import java.util.TreeMap;

public class CountOfAtoms {
    private static int where;
    public String countOfAtoms(String formule){
        where=0;
        TreeMap<String,Integer> tmp=f(0,formule.toCharArray());
        StringBuilder ans=new StringBuilder();
        for (String key:tmp.keySet()){
            ans.append(key);
            int cnt=tmp.get(key);
            if (cnt>1){
                ans.append(cnt);
            }
        }
        return ans.toString();
    }
    public TreeMap<String,Integer> f(int i, char[] form){
        int cur=0;
        StringBuilder sb=new StringBuilder();
        TreeMap<String,Integer> map=new TreeMap<>();
        TreeMap<String,Integer> pre=new TreeMap<>();
        while (i<form.length&&form[i]!=')'){
            if ((form[i]<='Z'&&form[i]>='A') || form[i]=='('){
                fill(sb,pre,map,cur);
                cur=0;
                sb.setLength(0);
                pre=null;
                if (form[i] >= 'A' && form[i] <= 'Z') {
                    sb.append(form[i++]);
                }else {
                    pre=f(i+1,form);
                    i=where+1;
                }
            } else if (form[i]<='z'&&form[i]>='a'){
                sb.append(form[i++]);
            }else {
                cur=cur*10+form[i++]-'0';
            }
        }
        fill(sb,pre,map,cur);
        where=i;
        return map;
    }
    public void fill(StringBuilder sb, TreeMap<String,Integer> pre,TreeMap<String,Integer> map,int cnt){
        if (!sb.isEmpty()|| !pre.isEmpty()){
            cnt= cnt==0 ? 1 : cnt;
            if (!sb.isEmpty()){
                String key = sb.toString();
                map.put(key, map.getOrDefault(key, 0) + cnt);
            }else {
                for (String key:pre.keySet()){
                    map.put(key,map.getOrDefault(key,0)+pre.get(key)*cnt);
                }
            }
        }
    }
}
