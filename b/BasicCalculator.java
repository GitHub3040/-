import java.util.ArrayList;
import java.util.Stack;

public class BasicCalculator {
    private static int where;
    public static int solve(String s){
        where=0;
        return f(s.toCharArray());
    }
    public static int f(char[] s){
        int cur=0;
        ArrayList<Integer> num=new ArrayList<>();
        ArrayList<Character> ops=new ArrayList<>();
        while (where<s.length&&s[where]!=')'){
            if (s[where]<='9'&&s[where]>='0'){
                cur=cur*10+s[where++]-'0';
            }else if (s[where]!='('){
                push(cur,num,s[where++],ops);
                cur=0;
            }else {
                where++;
                cur=f(s);
            }
        }
        where++;
        push(cur,num,'+',ops);
        return count(num,ops);
    }

    private static int count(ArrayList<Integer> num, ArrayList<Character> ops) {
        int n = num.size();
        int ans = num.get(0);
        for (int i = 1; i < n; i++) {
            ans += ops.get(i - 1) == '+' ? num.get(i) : -num.get(i);
        }
        return ans;

    }

    private static void push(int cur, ArrayList<Integer> num, char c, ArrayList<Character> ops) {
        int n = num.size();
        if (n == 0 || ops.get(n - 1) == '+' || ops.get(n - 1) == '-') {
            num.add(cur);
            ops.add(c);
        }else {
            int x=num.get(n-1);
            int op=ops.get(n-1);
            if (op=='*'){
                num.set(n-1,x*cur);
            }else {
                num.set(n-1,x/cur);
            }
            ops.set(n-1,c);
        }
    }
}
