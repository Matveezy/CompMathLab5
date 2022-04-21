import method.LeastSquaresMethod;
import method.RungeKuttaMethod;
import userio.UserIO;

public class Main {
    public static void main(String[] args) {
        UserIO.introduction();
        RungeKuttaMethod.rungeKuttaMethodRunner();
//        LeastSquaresMethod.leastSquaresMethodRunner();
    }
}
