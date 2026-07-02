public class Task implements Runnable {
    private String taskName;

    Task(String name) {
        this.taskName = name;
    }
    @Override
    public void run() {
        System.out.println(taskName + "Starting...");
        try {
            for( int i = 0; i<3; i++) {
                System.out.println(taskName + "Working(step" + (i+1) + ")");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(taskName + " was Interrupted.");
        }
        System.out.println(taskName + " Fininshed.");
    }
}


 class Threads1 {
    public static void manin (String args[]) {
        System.out.println("Main thread started.");

        Task task1 = new Task ("Task 1 ( Data Fetch)");
        Task task2 = new Task ("Task 2 ( UI Update)");

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        System.out.println("Main thread continues its work...");

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks finished. Main thread exiting.");
    }
}
