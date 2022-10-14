### Homework #4: Bar Chart Racer

#### Due: Friday, October 21 at start of class.

(This assignment is based on a similar one developed by Kevin Wayne at Princeton and presented at SIGCSE's Nifty Assignments Symposium. The Bar Chart code was written by him.)


This homework will be graded using specifications grading. There are a sequence of tasks to complete. Grades will be assigned as follows:

- To receive a C, you should complete tasks 1,2,3
- To receive a B, complete all the C-level tasks, plus tasks 4 and 5.
- To receive an A, complete the B-level tasks, plus task 6.


In this assignment you'll be writing a program to produce animated bar charts such as [this one](http://nifty.stanford.edu/2020/wayne-bar-chart-racer/cities-sound.mp4):

The repo includes two classes that handle all the drawing: BarChart and StdDraw. You do not need to alter these.

The repo also includes a collection of different datasets that you can use for your racer.

Task 1. To begin, we need to implement the Bar class. This will be the object that stores the
data we want to display. Bar contains the data's name, value, the category it belongs to, and the label that should go with the caption.
In order for us to sort the data, Bar needs to implement the Comparable interface. 

Complete the Bar class and use JUnit to create a BarTest class that tests compareTo and ensures that it works.
You will need to fill in the setters and getters and implement compareTo.

Task 2: The BarChart class and the StdDraw class will handle all of the drawing for you.
BarChart has a main() method that shows how to add items to a chart and produce a static image. The data in here is hardcoded - modify it to use some of the data from the movies.txt file.
(This will give you some familiarity with how the BarChart works.)

Task 3: We now need to implement the BarChartRacer class. To begin, implement processHeader. It should take as input an already-created 
Scanner, read in the first three lines of the file (title, label and source) and create a BarChart.

Task 4: Next, implement getNextBars. It should take as input an already-created Scanner and return an array of Bars
representing the next group of data. It will need to read in the first number to see how many lines follow, then read in 
each line, parse it, create a Bar and add it to the array.

(note: some files, such as infinity-war.txt, have initial values of 0, which will make BarChart crash. To solve this, set the value to max(value, 1)).

Task 5: Now you're ready to implement drawChart. It will need to:

- create a Scanner.
- process the headers.
- repeatedly:
  - call reset() on the chart to clear it.
  - Read in the next set of Bars.
  - call chart.setCaption() to show the current data group.
  - use Arrays.sort() to sort the Bars in order.
  - use the nbars variable to determine how many bars to add.
  - add the top n Bars to the chart in descending order.
    
  (note: sort() sorts the array in *ascending* order. How do you get the n largest elements? Don't reverse the whole thing!!)
  - call StdDraw.clear();
  - call this.chart.draw(); to render the chart. 
  - call StdDraw.show(); to make the window display. 
  - call StdDraw.pause(100); to wait 100 ms.
    (If you would like to add music, add StdAudio.loop("file.wav"); to the beginning of your program.)

Task 6: You're almost done! Now extend the main() so that the user can provide the 
name of a data file, the number of bars to display, and the number of ms to pause on the command line. Try it out with the different files that are included.


