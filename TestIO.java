import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

public class TestIO {
    public static void main(String[] args) throws IOException {
        long len = FileUtils.sizeOf(new File("C:\\Users\\daigang\\IdeaProjects\\untitled\\test\\testRw.java"));//文件大小
//        System.out.println(len);
        len = FileUtils.sizeOf(new File("C:\\Users\\daigang\\IdeaProjects\\untitled"));//目录大小
//        System.out.println(len);
        //子孙级
        Collection<File>  files=FileUtils.listFiles(new File("C:/Users/daigang/IdeaProjects/untitled/test"), EmptyFileFilter.NOT_EMPTY,null);

//        for(File f :files){
//            System.out.println(f.getAbsolutePath());
//        }
//        System.out.println("#################################################");
        Collection<File>  files1=FileUtils.listFiles(new File("C:/Users/daigang/IdeaProjects/untitled"),
                FileFilterUtils.or(new SuffixFileFilter("java"), new SuffixFileFilter("class")),DirectoryFileFilter.INSTANCE);

//        for(File f :files1){
//            System.out.println(f.getAbsolutePath());
//        }
        //读取文件
        String msg =FileUtils.readFileToString(new File("C:/Users/daigang/IdeaProjects/untitled/test/a.txt"),"UTF-8");
        System.out.println(msg);
        System.out.println("#################################################");
        byte[] datas = FileUtils.readFileToByteArray(new File("C:/Users/daigang/IdeaProjects/untitled/test/a.txt"));
        System.out.println(datas.length);
        //逐行读取
        List<String> msgs = FileUtils.readLines(new File("C:/Users/daigang/IdeaProjects/untitled/test/a.txt"),"UTF-8");
        for(String i:msgs){
            System.out.println(i);
        }
        LineIterator it = FileUtils.lineIterator(new File("C:/Users/daigang/IdeaProjects/untitled/test/a.txt"),"UTF-8");
        while(it.hasNext()){
            System.out.println(it.nextLine());
        }
        //写出文件
        FileUtils.write(new File("b.txt"),"科技时代刚好是\r\n","UTF-8",true);
        FileUtils.writeStringToFile(new File("b.txt"),"科技时代刚好是\r\n","UTF-8",true);
        FileUtils.writeByteArrayToFile(new File("b.txt"),"收到个地方地方\r\n".getBytes("UTF-8"),true);
        //写出列表
        List<String> list = new ArrayList<String>();
        list.add("的风格的");
        list.add("的风fgdf");
        list.add("的风的风格的");
        FileUtils.writeLines(new File("b.txt"),list,".",true);
        //拷贝 复制文件
        FileUtils.copyFile(new File("C:/Users/daigang/IdeaProjects/untitled/test/a.txt"),new File("C:/Users/daigang/IdeaProjects/untitled/test/b.txt"));
        //FileUtils.copyURLToFile();
        //String datas=IOUtils.toString(new URL("http://www.baidu.com"),"UTF-8");

    }
}
