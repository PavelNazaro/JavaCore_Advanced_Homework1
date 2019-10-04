// Задание 2:
// Создайте два класса: беговая дорожка и стена, при прохождении через которые,
// участники должны выполнять соответствующие действия (бежать или прыгать),
// результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
// У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.

public class CheckTask2{

    public static void main(String[] args) {
        RunAndJump man = new Human("Иван", 100, 2);     //создаем человека по имени Иван
        RunAndJump cat = new Cat("Барсик", 50, 3);     //создаем кота по имени Барсик
        RunAndJump robot = new Robot("Робокоп", 10, 1);//создаем робота по имени Робокоп

        RunningTrack track1 = new RunningTrack("Track1", 45);   //создаем дорожку, длиной 45м

        if(track1.doRun(man)) System.out.println(man.getName() + " смог пробежать");
        else System.out.println(man.getName() + " НЕ смог пробежать");
        if(track1.doRun(cat)) System.out.println(cat.getName() + " смог пробежать");
        else System.out.println(cat.getName() + " НЕ смог пробежать");
        if(track1.doRun(robot)) System.out.println(robot.getName() + " смог пробежать");
        else System.out.println(robot.getName() + " НЕ смог пробежать");

        System.out.println();       //Пустая строка для консоли
        Wall wall1 = new Wall("Wall1", 3);      //Создаем стену, высотой 3м

        if(wall1.doJump(man)) System.out.println(man.getName() + " смог перепрыгнуть");
        else System.out.println(man.getName() + " НЕ смог перепрыгнуть");
        if(wall1.doJump(cat)) System.out.println(cat.getName() + " смог перепрыгнуть");
        else System.out.println(cat.getName() + " НЕ смог перепрыгнуть");
        if(wall1.doJump(robot)) System.out.println(robot.getName() + " смог перепрыгнуть");
        else System.out.println(robot.getName() + " НЕ смог перепрыгнуть");
    }
}
