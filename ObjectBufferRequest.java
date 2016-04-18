public abstract class ObjectBufferRequest implements BufferRequest<Object> {
    private FutureResult<Object> result = new FutureResult<>();

    public abstract boolean guard();

    public abstract void call();

    @Override
    public FutureResult<Object> getResult() {
        return this.result;
    }
}
