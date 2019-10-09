package Lesson1;

public class RunningTrack implements Mission{

    private final String title;
    private final int length;

    public RunningTrack(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public boolean doRun(RunAndJump runAndJump){
        return runAndJump.getRun() >= length;
    }

    @Override
    public boolean doJump(RunAndJump runAndJump) {
        return false;
    }

    @Override
    public boolean isTrack(){
        return true;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
