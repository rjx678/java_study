public class Racer implements Runnable{
    private static String winner;
    @Override
    public void run() {
        for(int steps=1;steps<=100;steps++){
            if(Thread.currentThread().getName().equals("rabbit")&& steps%10==0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"-->"+steps);
            boolean flag= GameOver(steps);
            if(flag){
                break;
            }
        }
    }
    public boolean GameOver(int steps){
        if(winner!=null){
            return true;
        }else{
            if(steps==100){
            winner = Thread.currentThread().getName();
            System.out.println("Winner-->"+winner);
            return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer,"rabbit").start();
        new Thread(racer,"wugui").start();
    }

}
