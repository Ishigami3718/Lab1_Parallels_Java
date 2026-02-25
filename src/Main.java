//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    Controller controller = new Controller();
    Random rnd = new Random();
    for(int i=1;i<n;i++){
        (new Progression(i,rnd.nextDouble(2,20),controller)).start();
    }
    controller.start();
}
