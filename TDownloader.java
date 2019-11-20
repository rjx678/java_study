import java.io.IOException;

public class TDownloader extends Thread {
    private String url;
    private String name;
    public TDownloader(String url,String name){
        this.url= url;
        this.name=name;
    }
    @Override
    public void run() {
        webDownloader wd = new webDownloader();
        try {
            wd.download(url,name);
            System.out.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TDownloader td1= new TDownloader("","");
        TDownloader td2= new TDownloader("","");
        TDownloader td3= new TDownloader("","");
        td1.start();
        td2.start();
        td3.start();
    }
}
