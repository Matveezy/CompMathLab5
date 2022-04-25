package method;

import approximation.*;
import entity.*;
import ui.Drawer;


public class LeastSquaresMethod {

    public static void approximationRunner(Function rungeKutta, Function analyticSolve, Approximation approximation) {
        Function rungeKuttaApproximation = approximation.approximation(rungeKutta, approximation);
        Function analyticSolveApproximation = approximation.approximation(analyticSolve, approximation);
        Drawer.draw(rungeKuttaApproximation, analyticSolveApproximation);
    }

}
