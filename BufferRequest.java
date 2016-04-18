public interface BufferRequest<T> {
    boolean guard();
    void call();
    FutureResult<T> getResult();
}
