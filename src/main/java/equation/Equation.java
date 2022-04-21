package equation;

import entity.Function;
import entity.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Equation {

    private final String description;
    private final List<Pair> points;
    private final BiFunction<Double, Double, Double> function;

    public Equation(String description, BiFunction<Double, Double, Double> function) {
        this.description = description;
        this.points = new ArrayList();
        this.function = function;
    }

    public double[] getArrayX() {
        return getPoints().stream()
                .mapToDouble(Pair::getX)
                .toArray();
    }

    public double[] getArrayY() {
        return getPoints().stream()
                .mapToDouble(Pair::getY)
                .toArray();
    }

    public String getDescription() {
        return description;
    }

    public List<Pair> getPoints() {
        return points;
    }

    public BiFunction<Double, Double, Double> getFunction() {
        return function;
    }
}
