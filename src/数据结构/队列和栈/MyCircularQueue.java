package 数据结构.队列和栈;

class MyCircularQueue {

    private int[] element;
    private int head = -1;
    private int tail = -1;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        element = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (isEmpty()) {//队列为空
            head = 0;
        }
        //如果队列满返回false
        tail = (tail + 1) % element.length;
        element[tail] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) return false;
        if (head == tail) {//只有一个元素
            head = tail = -1;
        } else {
            head = (head + 1) % element.length;
        }
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) return -1;
        return element[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) return -1;
        return element[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return head == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (tail + 1) % element.length == head;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(6);
        queue.enQueue(6);
        queue.Rear();
        queue.Rear();
        queue.deQueue();
        queue.enQueue(5);
        queue.Rear();
        queue.deQueue();
        queue.Front();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */