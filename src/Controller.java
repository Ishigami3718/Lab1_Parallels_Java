import java.lang.reflect.Array;
import java.util.*;

class Tuple{
    public int Item1;
    public int Item2;
    public Tuple(int item1,int item2){
        Item1 = item1;
        Item2 = item2;
    }
    public int getItem1(){
        return Item2;
    }
}

public class Controller extends Thread {
    private volatile boolean[] canStop;
    public boolean getCanStop(int indx){return canStop[indx];}
    public Controller(int n)
    {
        canStop = new boolean[n];
        delays_local = new Tuple[n];
        for(int i=0;i<n;i++) delays_local[i] = new Tuple(i,delays[rnd.nextInt(0,6)]);
    }
    private int[] delays = {3000,5000,7000,10000,12000,15000};
    private Tuple[] delays_local;
    Random rnd = new Random();
    @Override
    public void run(){
        Arrays.sort(delays_local, Comparator.comparingInt(Tuple::getItem1));
        try {
            sleep(delays_local[0].Item2);
            canStop[delays_local[0].Item1]=true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i=1;i< canStop.length;i++)
            {
                try {
                    sleep(delays_local[i].Item2-delays_local[i-1].Item2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                canStop[delays_local[i].Item1]=true;

            }
    }

}
