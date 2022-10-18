import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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



    public void drawChart(int numBars, int numMS) throws FileNotFoundException {
        File file = new File(fname);
        Scanner scanner = new Scanner(file);
        processHeader(scanner);
        Bar[] bars;
        do{
            chart.reset();
            bars = getNextBars(scanner);
            int nBars = bars.length - 1 - numBars;
            if(nBars < 0){
                nBars = 0;
            }
            Arrays.sort(bars);
            for(int i = bars.length - 1; i > nBars; i--){
                chart.add(bars[i].name, bars[i].value, bars[i].label);
            }
            chart.setCaption(bars[0].getCategory());
            StdDraw.clear();
            this.chart.draw();
            StdDraw.show();
            StdDraw.pause(numMS);
        }while(scanner.hasNextLine());
    }
    public String getCategory(String line){
        String[] strings = line.split(",");
        return strings[0];
    }
    /*
    Take as input an already-created Scanner,
    Reads in the first three lines of the file
    (title, label and source) and creates a BarChart.
     */
    public void processHeader(Scanner input) {
        String title = input.nextLine();
        String label = input.nextLine();
        String source = input.nextLine();
        chart = new BarChart(title, label, source);

    }
    /*
    @Param String line the line containing data
    @Returns the name of the subject located at after the first comma
     */
    public String parseName(String line){
        String[] strings = line.split(",");
        return strings[1];
    }
    /*
    @Param String line the line containing data
    Converts the string value into an integer value
    @Returns the integer value of the subject located at after the third comma
     */
    public int parseValue(String line){
        String[] strings = line.split(",");
        int temp = Integer.parseInt(strings[3]);
        if(temp == 0){
            temp = 1;
        }
        return temp;
    }
    /*
@Param String line the line containing data
@Returns the string indicating the label of the subject located at after the fourth comma
 */
    public String parseLabel(String line){
        String[] strings = line.split(",");
        return strings[4];
    }
    /*
    @Param Scanner input
    @Param String category the category of data
    Creates a bar containing the name, value, category and label
    @Returns the bar
     */
    public Bar createBar(Scanner input){
        String line = input.nextLine();
        Bar bar = new Bar(parseName(line), parseValue(line), getCategory(line), parseLabel(line));
        return bar;
    }
    /*
    @Param Scanner input
    Takes a scanner as an argument, skips a blank line and then finds the integer after the line
    @Returns the integer value of how many bars
     */
    public int getNumBars(Scanner input) {
        input.nextLine();
        int num = Integer.parseInt(input.nextLine());
        if(num == 0){
            num = 1;
        }
        return num;
    }
/*
    public int findFileLength() throws IOException {
        File file = new File(fname);
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
        lineNumberReader.skip(Long.MAX_VALUE);
        int lines = lineNumberReader.getLineNumber();
        lineNumberReader.close();
        return lines;
    }
*/
/*
@Param Scanner input
gets the number of lines to read, then reads in
each line, parses it, create a Bar and adds it to the array.
@Returns an array of Bars
 */
   public Bar[] getNextBars(Scanner input) {
        int num = getNumBars(input);
        Bar[] bars = new Bar[num];
        for(int i = 0; i < bars.length; i++){
            Bar newbar = createBar(input);
            bars[i] = newbar;
        }
        return bars;

   }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName;
        int numBars;
        int numMS;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        fileName = sc.nextLine();
        System.out.print("Enter number of bars to display: ");
        numBars = sc.nextInt();
        System.out.print("Enter number of millisecond to pause on the command line: ");
        numMS = sc.nextInt();
        BarChartRacer br = new BarChartRacer(fileName);
        br.drawChart(numBars, numMS);
    }


}

