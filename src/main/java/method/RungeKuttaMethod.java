package method;

import entity.Pair;
import equation.Equation;
import equation.EquationStorage;
import userio.UserIO;

import javax.swing.*;
import java.util.List;

public class RungeKuttaMethod {

    public static void rungeKuttaMethodRunner() {
        UserIO.showEquations();
        int chose = UserIO.getEquationChoose();
        double[] borders = UserIO.getBorders();
        double step = UserIO.getStep();
        double y = UserIO.getY(borders);
        rungeKuttaMethod(EquationStorage.getEquation(chose), borders, step, y);
    }

    private static void rungeKuttaMethod(Equation equation, double[] borders, double step, double y) {
        List<Pair> points = equation.getPoints();
        points.add(new Pair(borders[0], y));
        for (double i = borders[0]; i < borders[1] - step; i += step) {
            double k1 = getK1(equation, step, i, y);
            double k2 = getK2(equation, step, i, y, k1);
            double k3 = getK3(equation, step, i, y, k2);
            double k4 = getK4(equation, step, i, y, k3);
            double dy = getDy(k1, k2, k3, k4);
            y += dy;
            points.add(new Pair(i + step, y));
        }
        UserIO.showResultTable(equation);
        addAnalyticPoints(equation, borders, step);
    }

    public static double getDy(double k1, double k2, double k3, double k4) {
        return (k1 + 2 * k2 + 2 * k3 + k4) / 6;
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
        return equation.getFunction().apply(x + step, y + k3) * step;
    }

    private static void addAnalyticPoints(Equation equation, double[] borders, double step) {
        List<Pair> points = equation.getAnalyticPoints();
        for (double i = borders[0]; i < borders[1]; i += step) {
            points.add(new Pair(i, equation.getAnalyticSolve().apply(i)));
        }
    }
}
