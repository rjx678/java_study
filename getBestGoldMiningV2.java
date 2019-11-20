public class getBestGoldMiningV2 {
    public  static int getBestReward(int w,int n,int[] p,int[] g){
        int[][] result=new int[g.length+1][w+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(j<p[i-1]){
                    result[i][j]=result[i-1][j];
                }else{
                    result[i][j]=Math.max(result[i-1][j],result[i-1][j-p[i-1]]+g[i-1]);
                }
            }
        }
        for(int i=1;i<=n;i++) {
            for (int j = 1; j <= w; j++) {
                System.out.print(result[i][j]+"\t");
            }
            System.out.println();
        }
    return result[n][w];
    }

    public static void main(String[] args) {
        int[] p={5,5,3,4,3};
        int[] g={400,500,200,300,350};
        int w=10;
        int n=5;
        System.out.println(getBestReward(w,n,p,g));
    }
}
