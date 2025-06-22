package leetcode_622;

class MyCircularQueue {
    private int[] queue;
    private int start;
    private int end;
    private int size;

    public MyCircularQueue(int k) {
        queue = new int[k];
        start = 0;
        end = 0;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        queue[end] = value;
        end = (end + 1) % queue.length;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        start = (start + 1) % queue.length;
        size--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[start];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int idx = end - 1;
        if (idx == -1)
            idx = queue.length - 1;
        return queue[idx];
    }
    
    public boolean isEmpty() {
        return start == end && size == 0;
    }
    
    public boolean isFull() {
        return start == end && size == queue.length;
    }
}
