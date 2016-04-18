public class Buffer {
    private int actual_size = 0;
    private int max_size;

    public Buffer(int max_size) {
        this.max_size = max_size;
    }

    public boolean get() {
        if (!this.isEmpty()) {
            this.actual_size--;
            return true;
        }
        return false;
    }

    public void put() {
        if (!this.isFull()) {
            this.actual_size++;
        }
    }

    public boolean isEmpty() {
        return this.actual_size == 0;
    }

    public boolean isFull() {
        return this.actual_size == max_size;
    }
}
