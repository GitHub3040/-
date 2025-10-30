public class Hannota {
    public static void hannota(int n){
        if (n>0){
            f(n,"左","右","中");
        }
    }
    public static void f(int i,String from,String to,String other){
        if (i==1){
            System.out.println(i+"从"+from+"到"+to);
        }else {
            f(i-1,from,other,to);
            System.out.println(i+"从"+from+"到"+to);
            f(i-1,other,to,from);
        }
    }
    public static void main(String[] args){
        hannota(3);
    }
}
