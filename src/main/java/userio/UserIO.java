package userio;

import approximation.Approximation;
import approximation.ApproximationStorage;
import entity.Function;
import entity.FunctionStorage;
import entity.Pair;
import equation.Equation;
import equation.EquationStorage;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserIO {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Approximation> approximations;

    public static void introduction() {
        System.out.println("Чухно Матвей. Метод Рунге-Кутта 4 порядка");
    }

    public static void showFunctions() {
        Map<Integer, Function> functions = FunctionStorage.getFunctions();
        for (int i = 1; i <= functions.size(); i++) {
            System.out.println("Таблица значений " + i);
            showTable(functions.get(i));
        }
    }

    public static void showEquations() {
        Map<Integer, Equation> equations = EquationStorage.getEquations();
        for (Map.Entry<Integer, Equation> eq : equations.entrySet()) {
            System.out.println(eq.getKey() + ": " + eq.getValue().getDescription());
        }
    }


    private static void showTable(Function function) {
        System.out.print("x:| ");
        List<Pair> points = function.getPoints();
        for (int i = 0; i < points.size(); i++) {
            System.out.print(points.get(i).getX() + " ");
        }
        System.out.println("|");
        System.out.print("y:| ");
        for (int i = 0; i < points.size(); i++) {
            System.out.print(points.get(i).getY() + " ");
        }
        System.out.println("|");
    }

    public static int getEquationChoose() {
        System.out.println("Выберите номер уравнения");
        return scanner.nextInt();
    }

    public static int getFunctionChoose() {
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
        System.out.println("Выберите номер аппроксимиции");
        printAllTypesOfApproximations();
        return scanner.nextInt();
    }

    public static void printAllTypesOfApproximations() {
        for (Map.Entry<Integer, Approximation> entry : ApproximationStorage.getApproximations().entrySet()) {
            System.out.println(entry.getKey() + "." + entry.getValue().typeOfApproximation());
        }
    }

    public static void printParams(double[] params) {
        for (int i = 0; i < params.length; i++) {
            System.out.printf("\u001B[36m" + "a[" + i + "]= " + "%.6f\n" + "\u001B[0m", params[i]);
        }
        System.out.println();
    }

    public static void printDeviation(double deviation) {
        System.out.printf("\u001B[36m" + "Мера отклонения: " + "%.6f\n" + "\u001B[0m", deviation);
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
