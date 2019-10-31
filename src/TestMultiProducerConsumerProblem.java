import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

class NumbersProducer implements Runnable {

    private BlockingQueue<Integer> numbersQueue;
    private final int poisonPill;
    private final int poisonPillProducer;

    public NumbersProducer(BlockingQueue<Integer> numbersQueue, int poisonPill, int poisonPillProducer) {
        this.numbersQueue = numbersQueue;
        this.poisonPill = poisonPill;
        this.poisonPillProducer = poisonPillProducer;
    }

    @Override
    public void run() {
        try {
            generateNumbers();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void generateNumbers() throws InterruptedException {
        for(int i=0;i<100;i++) {
            numbersQueue.put(ThreadLocalRandom.current().nextInt(100));
        }
        for(int j=0;j<poisonPillProducer;j++) {
            numbersQueue.put(poisonPill);
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;
    private final int poisonPill;

    public Consumer(BlockingQueue<Integer> queue, int poisonPill) {
        this.queue = queue;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer num = queue.take();
                if (num.equals(poisonPill)) {
                    return;
                }
                System.out.println(Thread.currentThread().getName() + " result: " + num);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class TestMultiProducerConsumerProblem {
}
