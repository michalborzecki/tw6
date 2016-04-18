public class GetBufferRequest extends ObjectBufferRequest {
    private Buffer buffer;

    public GetBufferRequest(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public boolean guard() {
        return !this.buffer.isEmpty();
    }

    @Override
    public void call() {
        this.getResult().setResult(this.buffer.get());
        System.out.println("Get successful.");
    }
}
