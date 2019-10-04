// Задание 3:
// Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
// Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

public class CheckTask3 {
    public static void main(String[] args) {

        //Массив участников
        RunAndJump[] members = new RunAndJump[6];
        members[0] = new Human("Петр", 100, 2);
        members[1] = new Human("Илья", 120, 1);
        members[2] = new Cat("Васька", 50, 3);
        members[3] = new Cat("Гарфилд", 150, 4);
        members[4] = new Robot("Робот1", 50, 1);
        members[5] = new Robot("Робот2", 5, 2);

        //Массив препятствий
        Mission[] missions = new Mission[4];
        missions[0] = new RunningTrack("Дорожка 1", 45);
        missions[1] = new RunningTrack("Дорожка 2", 120);
        missions[2] = new Wall("Стена 1", 1);
        missions[3] = new Wall("Стена 2", 3);

        for (int i = 0; i < members.length; i++) {
            int countDo = 0;                    //Счетчик выполненных испытаний
            System.out.println("Участник: " + members[i].getName());
            for (int j = 0; j < missions.length; j++) {
                //Если беговая дорожка
                if (missions[j].isTrack()){
                    if(missions[j].doRun(members[i])){
                        System.out.println(missions[j].getTitle() + ": успешно пробежал");
                        countDo++;
                    }
                    else {
                        System.out.println(missions[j].getTitle() + ": НЕ смог пробежать");
                        break;
                    }
                }
                //Тогда стена
                else {
                    if (missions[j].doJump(members[i])){
                        System.out.println(missions[j].getTitle() + ": успешно перепрыгнул");
                        countDo++;
                    }
                    else {
                        System.out.println(missions[j].getTitle() + ": НЕ смог перепрыгнуть");
                        break;
                    }
                }
            }
            if (countDo == 4) System.out.println(members[i].getName() + " выполнил все испытания!");
            else System.out.println("Для " + members[i].getName() + " пряпятствия закончились!");
            System.out.println(); //пустая строка для консоли
        }
    }
}
