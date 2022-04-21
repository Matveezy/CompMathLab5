package equation;

import entity.Function;
import entity.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EquationStorage {
    private static Map<Integer, Equation> equations;

    private EquationStorage() {
    }


    static {
        equations = new HashMap<>();
        equations.put(1, new Equation(
                "y' = y * (x^2 + 1)",
                (x, y) -> (y * (Math.pow(x, 2) + 1)),
                (x) -> (Math.exp(((Math.pow(x, 3)) / 3) + x))
        ));
        equations.put(2, new Equation(
                "y' = 3x^2 * y + x^2 * e^(x^3)",
                (x, y) -> (3 * Math.pow(x, 2) * y + Math.pow(x, 2) * Math.exp(Math.pow(x, 3))),
                (x) -> ((Math.pow(x, 3) * Math.exp(Math.pow(x, 3))) / 3)
        ));
        equations.put(3, new Equation(
                "y' = x^2 - 2*y",
                (x, y) -> (Math.pow(x, 2) - 2 * y),
                (x) -> (0.75 * Math.exp(-2 * x) + 0.5 * Math.pow(x, 2) - 0.5 * x + 0.25)
        ));
    }

    public static Map<Integer, Equation> getEquations() {
        return equations;
    }

    public static Equation getEquation(int choose) {
        if (choose <= 1 || choose > equations.size()) {
            choose = 1;
        }
        return equations.get(choose);
    }

}
