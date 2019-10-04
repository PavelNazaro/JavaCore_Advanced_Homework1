public class Cat implements RunAndJump{
    private final String name;
    private final int run;
    private final int jump;

    public Cat(String name, int run, int jump) {  //Для 2го и 3го задания
        this.name = name;
        this.run = run;
        this.jump = jump;
    }

    public Cat() {        //Для первого задания
        this.name = null;
        this.run = 0;
        this.jump = 0;
    }

    @Override
    public int getRun() {
        return run;
    }

    @Override
    public int getJump() {
        return jump;
    }

    @Override
    public String getName() {
        return name;
    }

    //Для первого задания
    @Override
    public void run() {
        System.out.println("Кот умеет бегать");
    }

    //Для первого задания
    @Override
    public void jump() {
        System.out.println("Кот умеет прыгать");
    }
}
