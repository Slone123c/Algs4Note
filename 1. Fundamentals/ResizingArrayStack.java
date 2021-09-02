import java.util.Iterator;
public class ResizingArrayStack<Item> implements Iterable<Item>
{
    private Item[] a = (Item[]) new Object[1]; //栈元素
    private int N = 0;
    public boolean isEmpty(){ return N == 0; }
    public int Size(){ return N; }
    private void resize(int max)
    {//将栈移动到新大小的数组内
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N ; i ++)
            temp[i] = a[i];
        a = temp;
    }
    public void push(Item item)
    {//添加元素到栈顶
        if(N == a.length) resize(a.length * 2);//栈满时增加一半大小
        a[N++] = item;
    }
    public Item pop()
    {//从栈顶删除元素
        Item item = a[--N];
        a[N] = null;//避免对象游离
        if(N > 0 && N == a.length/4) resize(a.length/2);//在达到四分之一长度时，缩小一半大小
        return item;
    }
    public Iterator<Item> iterator()
    {   return new ReserveArrayIterator();    }
    private class ReserveArrayIterator implements Iterator<Item>
    {//后进先出的迭代
        private int i = N;
        public boolean hasNext(){   return i > 0; }
        public Item next(){     return a[--i];  }
        public void remove(){       }
    }
}