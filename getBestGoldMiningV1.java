public class getBestGoldMiningV1 {
    /**
     * 递归实现动态规划
     */
    public static int getBestReward(int w,int n,int[] p,int g[]){
        if(w==0||n==0)
            return 0;
        if(w<p[n-1])//p[n-1] 最后一个矿所需要的工人数量
            return getBestReward(w,n-1,p,g);
        return Math.max(getBestReward(w,n-1,p,g),getBestReward(w-p[n-1],n-1,p,g)+g[n-1]);
    }

    public static void main(String[] args) {
        int[] p={5,5,3,4,3};
        int[] g={400,500,200,300,350};
        int w=10;
        int n=5;
        System.out.println(getBestReward(w,n,p,g));
    }
}
