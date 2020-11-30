package backup;

public class ExampleThread extends Thread{


    public ExampleThread(){
        start();
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            System.out.println("Test"+ i + Thread.currentThread().getName()) ;
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
