package ui;

import entity.Function;
import entity.Pair;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;
import org.knowm.xchart.style.theme.GGPlot2Theme;

import java.awt.*;

public class Drawer {

    public static void draw(Function rungeKutta, Function analyticSolve) {
        double[] xRungeData = rungeKutta.getArrayX();
        double[] yRungeData = rungeKutta.getArrayY();

        double[] xAnalyticData = analyticSolve.getArrayX();
        double[] yAnalyticData = analyticSolve.getArrayY();


        XYChart chart = new XYChartBuilder()
                .width(1200)
                .height(1000)
                .title("Runge-Kutta Method")
                .xAxisTitle("X")
                .yAxisTitle("Y")
                .build();
        XYSeries functionDraw = chart.addSeries("Initial State", new double[]{rungeKutta.getPoints().get(0).getX()}, new double[]{rungeKutta.getPoints().get(0).getY()});
        functionDraw.setLineStyle(SeriesLines.NONE);

        XYSeries firstApproximationDraw = chart.addSeries("Runge Kutta Method", xRungeData, yRungeData);
        firstApproximationDraw.setMarker(SeriesMarkers.NONE);
        firstApproximationDraw.setLineStyle(SeriesLines.SOLID);
        firstApproximationDraw.setLineColor(Color.BLUE);

        XYSeries secondApproximationDraw = chart.addSeries("Analytic Solve", xAnalyticData, yAnalyticData);
        secondApproximationDraw.setMarker(SeriesMarkers.NONE);
        secondApproximationDraw.setLineStyle(SeriesLines.DOT_DOT);
        secondApproximationDraw.setLineColor(Color.pink);

        chart.getStyler().setTheme(new GGPlot2Theme());
        chart.getStyler().setZoomEnabled(true);
        chart.getStyler().setZoomResetByDoubleClick(false);
        chart.getStyler().setZoomResetByButton(true);
        chart.getStyler().setZoomSelectionColor(new Color(0,0 , 192, 128));
        chart.getStyler().setCursorEnabled(true);
        new SwingWrapper(chart).displayChart();
    }
}
