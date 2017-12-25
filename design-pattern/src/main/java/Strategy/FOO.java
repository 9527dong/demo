package Strategy;

class FOO extends StrategySolution {
    private int state = 1;
    @Override
    protected void start() {
        System.out.print("Start  ");
    }
    @Override
    protected void stop() {
        System.out.println("Stop");
    }
    @Override
    protected boolean nextTry() {
        System.out.print("NextTry-" + state++ + "  ");
        return true;
    }
    @Override
    protected boolean isSolution() {
        System.out.print("IsSolution-" + (state == 3) + "  ");
        return (state == 3);
    }
}