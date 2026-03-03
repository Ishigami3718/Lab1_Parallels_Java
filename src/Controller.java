import java.util.Dictionary;
import java.util.Random;

public class Controller extends Thread {
    private volatile boolean[] canStop;
    public boolean getCanStop(int indx){return canStop[indx];}
    public Controller(int n){canStop = new boolean[n];}
    private int[] delays = {3000,5000,7000,10000,12000,15000};
    Random rnd = new Random();
    @Override
    public void run(){
            for(int i=0;i< canStop.length;i++)
            {
                int localI = i;
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            sleep(delays[rnd.nextInt(0,delays.length)]);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        canStop[localI] = true;
                    }
                };
                new Thread(r).start();
            }
    }

}
