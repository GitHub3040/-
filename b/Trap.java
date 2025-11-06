public class Trap {
    public int trap(int [] h){
        int n=h.length;
        int l=1,r=n-2,ans=0,lmax=h[0],rmax=h[n-1];
        while (l<=r){
            if (lmax>=rmax){
                ans+=Math.max(0,rmax-h[r]);
                rmax=Math.max(h[r--],rmax);
            }else {
                ans+=Math.max(0,lmax-h[l]);
                lmax=Math.max(h[l++],lmax);
            }
        }
        return ans;
    }
}
