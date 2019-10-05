public class simpleArrayInsert_delete {
    public static void main(String[] args) {
        String s1[]={"aa","bb","cc","dd"};
        s1=insertElment(s1,2,"xx");
        for(String temp:s1){
            System.out.println(temp);
        }
        System.out.println("############");
        s1=deleteElment(s1,3);
        for(String temp:s1){
            System.out.println(temp);
        }
    }

    /**
     * 返回已经插入后的数组
     * @param str
     * @param index
     * @param elment
     * @return
     */
    public  static String[] insertElment(String str[],int index,String elment){
        String s2[]=new String[str.length+1];
        System.arraycopy(str,0,s2,0,index);
        s2[index]=elment;
        System.arraycopy(str,index,s2,index+1,str.length-index);
        return s2;
    }
    public  static String[] deleteElment(String str[],int index){
        System.arraycopy(str,index+1,str,index,str.length-index-1);
        str[str.length-1]=null;
        return str;
    }

}
