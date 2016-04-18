import java.util.*;

public class Main {
    public static void main(String[] args) {
        int bufferSize = 20;
        int producersNum = 5;
        int consumersNum = 7;

        List<Process> processes = new ArrayList<>();
        Buffer buffer = new Buffer(bufferSize);
        BufferScheduler scheduler = new BufferScheduler();
        Random r = new Random();
        for (int i = 1; i <= producersNum; i++)
            processes.add(new Producer(buffer, i, scheduler));
        for (int i = 1; i <= consumersNum; i++)
            processes.add(new Consumer(buffer, i, scheduler));
        for (Process process : processes) {
            Thread t = new Thread(process);
            t.start();
        }
    }
}