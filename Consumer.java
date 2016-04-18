public class Consumer extends Process {
    public Consumer(Buffer buffer, int id, BufferScheduler scheduler) {
        this.proxy = new BufferProxy(buffer, scheduler);
        this.id = id;
    }

    @Override
    protected FutureResult<Object> doAction() {
        return this.proxy.get();
    }

    @Override
    protected String getProcessName() {
        return "Consumer #" + this.id;
    }
}