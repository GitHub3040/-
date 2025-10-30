public class DecodeString {
    private static int where;
    public String decodeString(String s){
        where=0;
        char[] chars=s.toCharArray();
        return f(1,chars,0);
    }
    public String f(int k,char[] chars,int i){
        int cur=0;
        StringBuilder sb=new StringBuilder();
        while (i<chars.length&&chars[i]!=']'){
            if (chars[i]<='9'&&chars[i]>='0'){
                cur=cur*10+chars[i]-'0';
            }else if (chars[i]!='['){
                sb.append(chars[i]);
            }else {
                String s=f(cur,chars,i+1);
                for (int j = 0; j < cur; j++) {
                    sb.append(s);
                }
                cur=0;
                i=where+1;
            }
        }
        where=i;
        return sb.toString();
    }
}
