package Strategy;

class BAR extends StrategySearch {
    private int state = 1;
    @Override
    protected void preProcess()  {
        System.out.print("PreProcess  ");
    }
    @Override
    protected void postProcess() {
        System.out.print("PostProcess  ");
    }
    @Override
    protected boolean search() {
        System.out.print("Search-" + state++ + "  ");
        return state == 3 ? true : false;
    }
}