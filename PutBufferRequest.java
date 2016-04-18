/**
 * Created by mborzecki on 12.04.16.
 */
public class PutBufferRequest extends ObjectBufferRequest {
    private Buffer buffer;

    public PutBufferRequest(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public boolean guard() {
        return !this.buffer.isFull();
    }

    @Override
    public void call() {
        this.buffer.put();
        this.getResult().setResult(true);
        System.out.println("Put successful.");
    }
}
