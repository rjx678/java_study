public class getBestGoldMiningV3 {
    public static int getBestReward(int w,int n,int[] p,int[] g){
        int[] result=new int[w+1];
        for(int i=1;i<=n;i++){
            for(int j=w;j>=1;j--){
                if(j>=p[i-1]){
                    result[j]=Math.max(result[j],result[j-p[i-1]]+g[i-1]);
                }
            }
        }
        for(int j=1;j<=w;j++)
            System.out.print(result[j]+"\t");
        System.out.println();
        return result[w];
    }
    public static void main(String[] args) {
        int[] p={5,5,3,4,3};
        int[] g={400,500,200,300,350};
        int w=10;
        int n=5;
        System.out.println(getBestReward(w,n,p,g));
    }
}
