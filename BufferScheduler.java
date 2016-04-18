import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BufferScheduler {
    private BlockingQueue<BufferRequest> queue = new LinkedBlockingQueue<>();

    public BufferScheduler() {
        this.dispatch();
    }

    public void enqueue(BufferRequest request) {
        try {
            this.queue.put(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dispatch() {
        Thread dispatcher = new Dispatcher();
        dispatcher.start();
    }

    private class Dispatcher extends Thread {
        public void run() {
            BufferRequest request;
            try {
                while (true) {
                    request = queue.take();
                    if (!request.guard()) {
                        queue.put(request);
                    }
                    else {
                        request.call();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
