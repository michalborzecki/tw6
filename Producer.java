public class Producer extends Process {
    public Producer(Buffer buffer, int id, BufferScheduler scheduler) {
        this.proxy = new BufferProxy(buffer, scheduler);
        this.id = id;
    }

    @Override
    protected FutureResult<Object> doAction() {
        return this.proxy.put();
    }

    @Override
    protected String getProcessName() {
        return "Producer #" + this.id;
    }
}