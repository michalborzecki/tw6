import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FutureResult<T> {
    private T result = null;
    private final Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public T getResult() {
        lock.lock();
        try {
            while (this.result == null) {
                this.condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return this.result;
    }

    public boolean hasResult() {
        return result != null;
    }

    public void setResult(T res) {
        lock.lock();
        this.result = res;
        this.condition.signalAll();
        lock.unlock();
    }
}
