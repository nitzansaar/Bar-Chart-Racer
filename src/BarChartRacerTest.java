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
        barChartRacer = new BarChartRacer("movies.txt");
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
        String name = barChartRacer.findName(line);
        assertTrue(name.equals("101 Dalmations"));
        assertTrue(!name.equals("False"));
    }

    @Test
    void findValue() {
        int val = barChartRacer.findValue(line);
        assertTrue(val == 51000000);
        assertFalse(val == 12345);
    }

    @Test
    void findLabel() {
        String label = barChartRacer.findLabel(line);
        assertTrue(label.equals("Buena Vista"));
        assertTrue(!label.equals("This is a test"));
    }

    @Test
    void findNumBars() throws IOException {
        int[] numBars = barChartRacer.findNumBars();
        System.out.println(numBars[0]);
    }

    @Test
    void findFileLength() throws IOException {
        int fileLength = barChartRacer.findFileLength();
        System.out.println(fileLength);
    }
}