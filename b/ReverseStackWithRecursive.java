import java.util.Stack;
import java.util.UUID;

public class ReverseStackWithRecursive {
    public static void reverse(Stack<Integer> stack){
        if (stack.empty()){
            return ;
        }
        int num=deep(stack);
        reverse(stack);
        stack.push(num);
    }
    public static int deep(Stack<Integer> stack){
        int ans=stack.pop();
        if (stack.empty()){
            return ans;
        }else {
            int last=deep(stack);
            stack.push(ans);
            return last;
        }
    }
    public static void main(String [] args){
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < 5; i++) {
            st.push(i);
        }
        reverse(st);
        for (int i = 0; i < 5; i++) {
            System.out.println(st.pop());
        };
    }
}
