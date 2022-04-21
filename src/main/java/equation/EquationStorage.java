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
                Collections.emptyList(),
                (x, y) -> (y * (Math.pow(x, 2) + 1))
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
