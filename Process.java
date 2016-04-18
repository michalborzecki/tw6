import java.util.Random;

abstract class Process implements Runnable {
    protected BufferProxy proxy;
    protected int id;

    public int getId() {
        return this.id;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            try {
                Thread.sleep(Math.abs(r.nextInt()) % 3000);
                FutureResult<Object> result = this.doAction();
                result.getResult();
                System.out.println("Process \"" + this.getProcessName() + "\" has used buffer.");
                Thread.sleep(Math.abs(r.nextInt()) % 3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract FutureResult<Object> doAction();

    protected abstract String getProcessName();
}
