package equation;

import entity.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Equation {

    private final String description;
    private final List<Pair> points;
    private final List<Pair> analyticPoints;
    private final BiFunction<Double, Double, Double> function;
    private java.util.function.Function<Double, Double> analyticSolve;

    public Equation(String description, BiFunction<Double, Double, Double> function, java.util.function.Function<Double, Double> analyticSolve) {
        this.description = description;
        this.points = new ArrayList();
        this.analyticPoints = new ArrayList();
        this.function = function;
        this.analyticSolve = analyticSolve;
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

    public List<Pair> getAnalyticPoints() {
        return analyticPoints;
    }

    public Function<Double, Double> getAnalyticSolve() {
        return analyticSolve;
    }


}
