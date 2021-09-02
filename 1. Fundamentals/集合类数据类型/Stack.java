public class Stack<Item> {
    private Node first;  //栈顶
    private int N;  //元素数量
    private class Node
    {
        Item item;
        Node next;
    }    
    public boolean isEmpty(){   return first == null;   } // 或 N == 0
    public int size(){  return N;   }
    public void push(Item item)
    {//(向栈顶)添加元素
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop()
    {//（从栈顶）删除元素
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
}
