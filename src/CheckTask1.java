// Задание 1:
// Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
// Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).

public class CheckTask1 {
    public static void main(String[] args) {
        RunAndJump man = new Human();       //создаем человека
        RunAndJump cat = new Cat();         //создаем кота
        RunAndJump robot = new Robot();     //создаем робота

        //Проверка работы
        man.run();
        man.jump();
        cat.run();
        cat.jump();
        robot.run();
        robot.jump();
    }
}
