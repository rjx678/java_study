public class MyArray {
    private int[] array;
    private int size;//数组实际元素的数量

    public MyArray(int capacity){
        this.array = new int[capacity];
        size=0;
    }

    public void insert(int element,int index) throws Exception{
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        //数组扩容
        if(size>=array.length){
            resize();
        }
        //中间插入（假设数组长度是足够的），从右往左循环，将元素向右移动一位
        for (int i= size-1 ;i>=index;i--){
            array[i+1] =array[i];
        }
        array[index] = element;
        size++;
    }
    public void output(){
        for(int i=0;i<size;i++){
            System.out.println(array[i]);
        }
    }
    public int delete(int index) throws Exception{
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        int delElement = array[index];
        //从左向右循环，将元素左移一位
        for (int i= index ;i<size-1;i++){
            array[i] =array[i+1];
        }
        size--;
        return delElement;
    }

    public void resize(){
        int[] newArray= new int[2*array.length];
        System.arraycopy(array,0,newArray,0,array.length);
        array = newArray;
    }

    public static void main(String[] args) throws Exception{
        MyArray myArray = new MyArray(4);
        myArray.insert(3,0);
        myArray.insert(7,1);
        myArray.insert(9,2);
        myArray.insert(5,3);
        myArray.insert(6,1);
        myArray.output();
        System.out.println("############");
        myArray.delete(2);
        myArray.output();
    }
}
