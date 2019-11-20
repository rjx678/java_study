
public class bigNumSum {
    public static String bigNumberSum(String bigNumA,String bigNumB){
        int maxnum=bigNumA.length()>bigNumB.length()?bigNumA.length():bigNumB.length();
        int[] a1=new int[maxnum+1];
        for(int i=0;i<bigNumA.length();i++){
            a1[i]=bigNumA.charAt(bigNumA.length()-1-i)-'0';
        }

        int[] b1=new int[maxnum+1];
        for(int i=0;i<bigNumB.length();i++){
            b1[i]=bigNumB.charAt(bigNumB.length()-1-i)-'0';
        }
        int[] result =new int[maxnum+1];
        for(int i=0;i<result.length;i++){
            int temp=result[i];
            temp+=a1[i];
            temp+=b1[i];
            if(temp>=10){
                temp=temp-10;
                result[i+1]=1;
            }
            result[i]=temp;
        }
        StringBuilder sb =new StringBuilder();
        boolean flag = false;//最高有效位是否找到的标志
        for(int i=result.length-1;i>=0;i--){
            if(!flag){
                if(result[i]==0)
                    continue;
                flag=true;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String bigNumA="426709752318";
        String bigNumB="95481253129";
        System.out.println(bigNumberSum(bigNumA,bigNumB));
    }
}
