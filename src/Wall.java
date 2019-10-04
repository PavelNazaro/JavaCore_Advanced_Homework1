public class Wall implements Mission{
    private final String title;
    private final int height;

    public Wall(String title, int height) {
        this.title = title;
        this.height = height;
    }

    @Override
    public boolean doRun(RunAndJump runAndJump) {
        return false;
    }

    @Override
    public boolean doJump(RunAndJump runAndJump){
        return runAndJump.getJump() >= height;
    }

    @Override
    public boolean isTrack(){
        return false;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
