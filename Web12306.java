public class Web12306 implements Runnable{
    private int tickets=99;
    @Override
    public void run() {
        while (true){
            if(tickets<0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->当前票数还有"+tickets--);
        }
    }
    public static void main(String[] args) {
        //一份资源多个代理
        Web12306 w1 = new Web12306();
        new Thread(w1,"a").start();
        new Thread(w1,"b").start();
        new Thread(w1,"c").start();
    }
}


