public interface Mission {
    boolean doRun(RunAndJump runAndJump);
    boolean doJump(RunAndJump runAndJump);
    boolean isTrack();
    String getTitle();
}
