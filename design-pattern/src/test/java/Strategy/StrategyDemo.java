package Strategy;

public class StrategyDemo {
    // client code here
    private static void execute(Strategy strategy) {
        strategy.solve();
    }

    public static void main( String[] args ) {
        Strategy[] algorithms = {new FOO(), new BAR()};
        for (Strategy algorithm : algorithms) {
            execute(algorithm);
        }
    }
}
/**
 Start  NextTry-1  IsSolution-false  NextTry-2  IsSolution-true  Stop
 PreProcess  Search-1  PostProcess  PreProcess  Search-2
 **/