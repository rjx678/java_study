import java.io.IOException;
import java.util.concurrent.*;

public class CDownloader implements Callable<Boolean> {
    private String url;
    private String name;
    public CDownloader(String url,String name){
        this.url= url;
        this.name=name;
    }
    @Override
    public Boolean call() throws Exception {
        webDownloader wd = new webDownloader();
        try {
            wd.download(url,name);
            System.out.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CDownloader cd1= new CDownloader("","");
        CDownloader cd2= new CDownloader("","");
        CDownloader cd3= new CDownloader("","");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> result1= ser.submit(cd1);
        Future<Boolean> result2= ser.submit(cd2);
        Future<Boolean> result3= ser.submit(cd3);
        //获取结果
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();
        //关闭服务
        ser.shutdown();
    }
}

