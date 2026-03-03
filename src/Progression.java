public class Progression extends Thread {
    private double step;
    private int number;
    private Controller controller;

    public Progression(int number,double step, Controller controller){
        this.number = number;
        this.step = step;
        this.controller = controller;
    }


    @Override
    public void run(){
        double result =0;
        long count =0;
        while(!controller.getCanStop(number-1)){
            result+=step;
            count++;
        }
        System.out.printf("Thread with number %d and step %f executed with result %f and count of additions" +
                "%d%n",number,step,result,count);

    }
}
