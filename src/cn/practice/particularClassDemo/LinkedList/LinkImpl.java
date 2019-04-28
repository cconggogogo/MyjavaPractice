package cn.practice.particularClassDemo.LinkedList;

public class LinkImpl implements Link {

    private Node first;
    private Node last;
    private int size;

    //--------------------------
    private class Node{
        private Node prev;
        private Object data;
        private Node next;

        public Node(Node prev,Object data,Node next){
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
//--------------------------

    @Override
    public void add(Object obj) {
        Node lastNode = last;
        Node newNode = new Node(lastNode, obj, null);
        last = newNode;

        if(first == null) {
            first = newNode;
        }else {
            lastNode.next = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(int index) {
        // TODO Auto-generated method stub
        if(index < 0 || index >= size) {
            return false;
        }
        else if(index == 0) {
            if(size == 1) {
                Node node = first;
                node = null;
                first = null;
                last = null;
                size--;
            }
            else {
                Node node = node(index);
                first = node.next;
                node.next.prev = null;
                node = null;
                size--;
            }
        }else if(index == size - 1) {
            Node node = node(index);
            last = node.prev;
            node.prev.next = null;
            node = null;
            size--;
        }else {
            Node node = node(index);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node = null;
            size--;
        }
        return true;
    }

    @Override
    public boolean set(int index, Object obj) {
        if(index < 0 || index >= size) {
            return false;
        }

        Node node = node(index);
        node.data = obj;

        return true;
    }

    private Node node(int index) {
        // >>除以2整除
        if(index < (size >> 1)) {
            Node temp = first;
            for(int i = 0;i < index;i++) {
                temp = temp.next;
            }
            return temp;
        }else {
            Node temp = last;
            for(int i = size - 1;i > index;i--) {
                temp = temp.prev;
            }
            return temp;
        }
    }

    @Override
    public Object get(int index) {
        // TODO Auto-generated method stub
        if(index < 0 || index >= size) {
            return null;
        }
        Object[] arr = toArray();
        return arr[index - 1];
    }

    @Override
    public void printLink() {
        Object[] arr = toArray();
        for(int i = 0;i < size;i++) {
            System.out.println(arr[i]);
        }
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for(Node node = first;node != null;node = node.next) {
            arr[i++] = node.data;
        }
        return arr;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        Node rubbish;
        for(Node node = first;node != null;node = rubbish) {
            node.prev = null;
            node.data = 0;
            rubbish = node.next;
            node.next = null;
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int contains(Object obj) {
        int index = 0;
        for(Node node = first;node != null;node = node.next) {
            if(node.data == obj) {
                return index + 1;
            }
            index++;
        }
        return -1;
    }

}
