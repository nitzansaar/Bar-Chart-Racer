import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BarChartRacerTest {

    BarChartRacer barChartRacer;
    Scanner input;
    File file;
    String line = "1982-01-14,101 Dalmations,USA,51000000,Buena Vista";

    @BeforeEach
    void setup() throws FileNotFoundException {
        file = new File("movies.txt");
        input = new Scanner(file);
        barChartRacer = new BarChartRacer("brands.txt");
    }

    @Test
    void processHeader() {
        barChartRacer.processHeader(input);
        assertTrue(barChartRacer.chart.getTitle().equals
                ("The highest-grossing movies in the U.S. from 1982 to 2019"));
        assertTrue(barChartRacer.chart.getxAxisLabel().equals
                ("Gross revenue (unadjusted $)"));
        assertTrue(barChartRacer.chart.getDataSource().equals
                ("Source: Box Office Mojo"));
        assertFalse(barChartRacer.chart.getDataSource().equals
                ("This is a test"));
    }

    @Test
    void findName() {
        String name = barChartRacer.parseName(line);
        assertTrue(name.equals("101 Dalmations"));
        assertTrue(!name.equals("False"));
    }

    @Test
    void findValue() {
        int val = barChartRacer.parseValue(line);
        assertTrue(val == 51000000);
        assertFalse(val == 12345);
    }

    @Test
    void findLabel() {
        String label = barChartRacer.parseLabel(line);
        assertTrue(label.equals("Buena Vista"));
        assertTrue(!label.equals("This is a test"));
    }

    @Test
    void getNum() {
        barChartRacer.getNumBars(input);
    }

    @Test
    void getNextBars() {
        barChartRacer.processHeader(input);
        Bar[] bar = barChartRacer.getNextBars(input);
        for(int i = 0; i < bar.length; i++){
            System.out.println(bar[i].name + " " + bar[i].value + " " + bar[i].label);
        }
        Bar[] bars = barChartRacer.getNextBars(input);
        for(int i = 0; i < bars.length; i++){
            System.out.println(bars[i].name + " " + bars[i].value + " " + bars[i].label);
        }
        Bar[] moreBars = barChartRacer.getNextBars(input);
        for(int i = 0; i < bars.length; i++){
            System.out.println(moreBars[i].name + " " + moreBars[i].value + " " + moreBars[i].label);
        }

    }

    @Test
    void drawChart() throws FileNotFoundException {
        barChartRacer.drawChart(10, 45);
    }
}