package org.htw.prog2.aufgabe0;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.SwingWrapper;

import java.util.LinkedList;

public class MyProject {

    /**
     * Calculate root X of a value S according to babylonian algorithm, starting with
     * an initial estimate X(0):
     * <ol>
     *     <li>Estimate the error e(n): e(n)=(S-X(n-1)²)/(2*X(n-1))</li>
     *     <li>Calculate X(n): X(n)=X(n-1)+e(n)</li>
     * </ol>
     * Continue until the estimated error reaches the desired maximum error
     * @param value The value to calculate the root of
     * @param initial The initial value to start the calculation with
     * @param maxerror The maximum allowed error
     * @return An array containing the values of all iterations. The last value in the array is the final estimate.
     */
    public static double[] calculateBabylonianRoot(double value, double initial, double maxerror) {
        maxerror = Math.abs(maxerror);
        
        if (value < 0) {
           return new double[]{0};
        }

        if (value == 0) {
            return new double[]{0};
        }

        if (initial == 0) {
            initial = 1;
        }

        LinkedList<Double> results = new LinkedList<>();
        results.add(initial);

        double currentV = initial;

        int maxIterations = 1000;
        int count = 0;
        
        while(count < maxIterations){
            double error = (value - currentV * currentV) / (2 * currentV);
            

            if (Math.abs(error) <= maxerror)
                break;
            
            currentV = currentV + error;
            results.add(currentV);  
            count++;
        }

        double[] arrayV = new double[results.size()];
        for (int i = 0; i < results.size(); i++){
            arrayV[i] = results.get(i);

    }
            return arrayV;

}

    public static void plotData(double[] values) {
        XYChart chart = new XYChart(500, 500);
        chart.addSeries("Data", values);
        new SwingWrapper(chart).displayChart();
    }

    public static void main(String[] args) {
        plotData(calculateBabylonianRoot(74821, 5, 1));
    }
}
