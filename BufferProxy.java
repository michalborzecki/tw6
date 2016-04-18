public class BufferProxy {
    private Buffer buffer;
    private BufferScheduler scheduler;

    public BufferProxy(Buffer buffer, BufferScheduler scheduler) {
        this.buffer = buffer;
        this.scheduler = scheduler;
    }

    public FutureResult<Object> get() {
        BufferRequest<Object> request = new GetBufferRequest(this.buffer);
        this.scheduler.enqueue(request);
        return request.getResult();
    }

    public FutureResult<Object> put() {
        BufferRequest<Object> request = new PutBufferRequest(this.buffer);
        this.scheduler.enqueue(request);
        return request.getResult();
    }
}
