package userio;

import approximation.Approximation;
import approximation.ApproximationStorage;
import entity.Pair;
import equation.Equation;
import equation.EquationStorage;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserIO {

    private static Scanner scanner = new Scanner(System.in);

    public static void introduction() {
        System.out.println("Чухно Матвей. Метод Рунге-Кутта 4 порядка");
    }

    public static void showEquations() {
        Map<Integer, Equation> equations = EquationStorage.getEquations();
        for (Map.Entry<Integer, Equation> eq : equations.entrySet()) {
            System.out.println(eq.getKey() + ": " + eq.getValue().getDescription());
        }
    }

    public static int getEquationChoose() {
        System.out.println("Выберите номер уравнения");
        return scanner.nextInt();
    }

    public static double[] getBorders() {
        double[] borders = new double[2];
        System.out.println("Введите начало и конец отрезка:");
        borders[0] = scanner.nextDouble();
        borders[1] = scanner.nextDouble();
        return borders;
    }

    public static double getStep() {
        System.out.println("Введите размер шага:");
        return scanner.nextDouble();
    }

    public static double getY(double[] borders) {
        System.out.println("Введите координату y начальной точки с x = " + borders[0]);
        return scanner.nextDouble();
    }

    public static void showResultTable(Equation equation) {
        List<Pair> points = equation.getPoints();
        showStringColorful("x:        y:    ");
        System.out.println();
        points.stream()
                .forEach((point) -> showDigitResultColorful(point.getX(), point.getY()));
    }

    public static int getApproximationChoose() {
        System.out.println("Выберите , какой функцией хотите аппроксимировать:");
        printAllTypesOfApproximations();
        return scanner.nextInt();
    }

    public static void printAllTypesOfApproximations() {
        for (Map.Entry<Integer, Approximation> entry : ApproximationStorage.getApproximations().entrySet()) {
            System.out.println(entry.getKey() + "." + entry.getValue().typeOfApproximation());
        }
    }

    public static void showDigitResultColorful(double x, double y) {
        System.out.printf("\u001B[36m" + "%.4f    " + "\u001B[0m", x);
        System.out.printf("\u001B[36m" + "%.4f\n" + "\u001B[0m", y);
    }

    public static void showStringColorful(String str) {
        System.out.printf("\u001B[36m");
        System.out.printf(str);
        System.out.printf("\u001B[36m" + "\u001B[0m");
    }
}
