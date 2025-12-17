public class ShortestPathAllKeys {
    public int shortestPathAllKeys(String[] grid){
        int m=grid.length;
        int n=grid[0].length();
        int startRow=0,startCol=0;
        int target = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startRow = i;
                    startCol = j;
                } else if (c >= 'a' && c <= 'f') {
                    target |= (1 << (c - 'a'));
                }
            }
        }
        boolean [][][] visit=new boolean[m][n][1<<6];
        int [][] queue=new int[m*n*(1<<6)][3];
        int [] move=new int[]{-1,0,1,0,-1};
        int l=0,r=0;
        int ans=0;
        queue[r][0]=startRow;
        queue[r][1]=startCol;
        queue[r++][2]=0;
        visit[startRow][startCol][0]=true;
        while (r>l){
            int size=r-l;
            for (int i = 0; i < size; i++) {
                int [] cur=queue[l++];
                int x=cur[0],y=cur[1],k=cur[2];
                if (k==target){
                    return ans;
                }
                for (int j = 0; j < 4; j++) {
                    int dx=x+move[j],dy=y+move[j+1];
                    if (dx<0||dx>=m||dy<0||dy>=n){
                        continue;
                    }
                    char c = grid[dx].charAt(dy);
                    if (c == '#') continue;
                    int allKey=k;
                    if (c>='a' && c<='f'){
                        allKey=k|(1<<(c-'a'));
                    }
                    if (c>='A' && c<='F' && (k & (1 << (c - 'A'))) == 0){
                        continue;
                    }
                    if (!visit[dx][dy][allKey]){
                        queue[r][0]=dx;
                        queue[r][1]=dy;
                        queue[r++][2]=allKey;
                        visit[dx][dy][allKey]=true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
