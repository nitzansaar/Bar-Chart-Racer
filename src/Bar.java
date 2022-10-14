public class Bar implements Comparable<Bar> {
        protected String name;
        protected int value;
        protected String category;
        protected String label;

        // Creates a new bar. You do this.
        public Bar(String name, int value, String category, String label) {

        }

        // Returns the name of this bar. You do this.
        public String getName() {

        }

        // Returns the value of this bar.You do this.
        public int getValue() {

        }

        // Returns the category of this bar. You do this.
        public String getCategory() {

        }

        public String getLabel() {

        }

        // Compare two bars by value. You do this.
        // Bar A is less than Bar B if the value of A is less than the value of B.
        // compareTo should return -1 if this < otherBar, 1 if this > otherBar, and 0 otherwise.
        // If otherBar is null, you should throw a NullPointerException.
        // if otherBar.name is null, or otherBar.value < 0, or otherBar.category is null, then throw an IllegalArgumentException.

        public int compareTo(Bar otherBar) {


        }
}
