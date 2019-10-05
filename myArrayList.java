
public class myArrayList<E> {
    private int size;//数组实际的元素
    private Object[] elementData;//核心数组,存储内容

    private static final int DEFAULT_CAPACITY = 10;
    public myArrayList(){
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public myArrayList(int capacity){
        if(capacity<0){
            throw new RuntimeException("索引异常");
        }else if(capacity==0){
            elementData=new Object[DEFAULT_CAPACITY];
        }else{
        elementData = new Object[capacity];
        }
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void add(E element){
        if(size==elementData.length){//扩容
            Object[] newArray = new Object[elementData.length<<1];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData=newArray;
        }
        elementData[size++] = element;
    }
    public void checkRange(int index){
        if(index>size-1||index<0){
            throw  new RuntimeException("数组越界");
        }
    }
    public E get(int index){
        checkRange(index);
        return (E) elementData[index];
    }
    public void set(int index,E element){
        checkRange(index);
        elementData[index]=element;
    }
    public void remove(int index){
        int numMoved = size-index-1;
        if(numMoved>0){
        System.arraycopy(elementData,index+1,elementData,index,numMoved);}

        //合并
        // elementData[size-1]=null;
        //        size--;
        elementData[--size]=null;
    }
    public void remove(E element){
        //element 将它和所有元素挨个比较，获得第一个比较为true的，返回。
        for(int i=0;i<size;i++){
            if(element.equals(get(i))){
                remove(i);
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<size;i++){
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        myArrayList s1= new myArrayList(20);

        for(int i=0;i<40;i++){
            s1.add("aa"+i);
        }
        System.out.println(s1);
        s1.set(1,"gao");
        System.out.println(s1);
        System.out.println(s1.get(1));
        s1.remove(3);
        System.out.println(s1);
        s1.remove("gao");
        System.out.println(s1);
        System.out.println(s1.size);
        System.out.println(s1.isEmpty());
    }
}
