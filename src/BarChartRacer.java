import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BarChartRacer {
    protected BarChart chart;
    protected String fname;

    /**
     * get the chart headings
     * for each chunk,
     */

    public BarChartRacer() {
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
    }
    public BarChartRacer(String fname) {
        this.fname = fname;
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
    }



    public void drawChart() {

    }

    public void processHeader(Scanner input) {


    }


    public Bar[] getNextBars(Scanner input) {

    }

    public static void main(String[] args) {
        BarChartRacer br = new BarChartRacer();
        br.drawChart();
    }


}
