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
    /*
    Take as input an already-created Scanner,
    Reads in the first three lines of the file
    (title, label and source) and creates a BarChart.
     */
    public void processHeader(Scanner input) {
        if(!input.hasNext()) return;
        String title = input.nextLine();
        String label = input.nextLine();
        String source = input.nextLine();
        chart = new BarChart(title, label, source);

    }
    /*
    @Param String line the line containing data
    @Returns the name of the subject located at after the first comma
     */
    public String findName(String line){
        String[] strings = line.split(",");
        return strings[1];
    }
    /*
    @Param String line the line containing data
    Converts the string value into an integer value
    @Returns the integer value of the subject located at after the third comma
     */
    public int findValue(String line){
        String[] strings = line.split(",");
        return Integer.parseInt(strings[3]);
    }
    /*
@Param String line the line containing data
@Returns the string indicating the label of the subject located at after the fourth comma
 */
    public String findLabel(String line){
        String[] strings = line.split(",");
        return strings[4];
    }
    public int[] findNumBars() throws FileNotFoundException {
        File file = new File(fname);
        Scanner scanner = new Scanner(file);
        int[] numBars = new int[100];
        int count = 0;
        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
/*            if(scanner.nextInt() >= 0 && scanner.nextInt() < 1000){
                int temp = scanner.nextInt();
                numBars[count] = temp;
                count++;
            }*/
        }
        return numBars;
    }

/*    public Bar[] getNextBars(Scanner input) {


    }*/

    public static void main(String[] args) {
        BarChartRacer br = new BarChartRacer();
        br.drawChart();
    }


}

