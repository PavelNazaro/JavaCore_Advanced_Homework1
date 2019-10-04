public enum Member {

    PETR ("Петр", 100, 2),
    ILYA ("Илья", 120, 1),
    BASYA ("Васька", 50, 3),
    GARFILD ("Гарфилд", 15, 4),
    ROBOT1 ("Робот1", 10, 1),
    ROBOT2 ("Робот2", 5, 2);

    private String russianName;
    private int run;
    private int jump;

    Member(String russianName, int run, int jump) {
        this.russianName = russianName;
        this.run = run;
        this.jump = jump;
    }

    public String getRussianName(){
        return russianName;
    }

    public int getRun(){
        return run;
    }

    public int getJump(){
        return jump;
    }
}
