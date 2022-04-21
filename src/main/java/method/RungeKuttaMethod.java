package method;

import equation.Equation;
import userio.UserIO;

public class RungeKuttaMethod {

    public static void rungeKuttaMethodRunner() {
        UserIO.showEquations();
        int chose = UserIO.getEquationChoose();
        double[] borders = UserIO.getBorders();
        double step = UserIO.getStep();
        double y = UserIO.getY(borders);
    }

    private static void rungeKuttaMethod(Equation equation, double[] borders, double step, double y) {

    }

    private static double getK1(Equation equation, double step, double x, double y) {
        return equation.getFunction().apply(x, y) * step;
    }

    private static double getK2(Equation equation, double step, double x, double y, double k1) {
        return equation.getFunction().apply(x + step * 0.5, y + k1 * 0.5) * step;
    }

    private static double getK3(Equation equation, double step, double x, double y, double k2) {
        return equation.getFunction().apply(x + step * 0.5, y + k2 * 0.5) * step;
    }

    private static double getK4(Equation equation, double step, double x, double y, double k3) {
        return equation.getFunction().apply(x + step , y + k3) * step;
    }
}
