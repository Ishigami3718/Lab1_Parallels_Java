public class Controller extends Thread {
    private volatile boolean canStop;
    public boolean getCanStop(){return canStop;}
    public Controller(){canStop = false;}
    @Override
    public void run(){
        try {
            sleep(5000);
            canStop = true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
