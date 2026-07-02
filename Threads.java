public class Threads implements Runnable {
    private Thread t;
    private String threadName;

    Threads(String name) {
        this.threadName = name;
        System.out.println("Creating" + threadName);

    }
    
    public void run() {
        System.out.println("Running" + threadName);
        try {
             for(int i = 4; i>0; i--) {
                System.out.println("Thread:" + threadName + "," + i);

                Thread.sleep(50);
             }
        } catch (InterruptedException e) {
            System.out.println("Thread" + threadName + "interrupted.");
        }
        System.out.println("Thread" + threadName + "exiting.");
    }

    public void start () {
        System.out.println("Starting" + threadName);
        if ( t == null) {
            t = new Thread (this, threadName);
            t.start();
        }
    }
}

class TrestThread {
    public static void main(String args[]) {
        Threads T1 = new Threads("Thread-1");
        T1.start();
        
        Threads T2 = new Threads("Thread-2");
        T2.start();

    }
}
