/**
 * Nitzan Saar Assignment 4: Bar Chart Racer
 */
public class Bar implements Comparable<Bar> {
        protected String name;
        protected int value;
        protected String category;
        protected String label;

        // Creates a new bar. You do this.
        public Bar(String name, int value, String category, String label) {
                this.name = name;
                this.value = value;
                this.category = category;
                this.label = label;

        }
        // Returns the name of this bar. You do this.
        public String getName() {
                return name;
        }
        // Returns the value of this bar.You do this.
        public int getValue() {
                return value;
        }
        // Returns the category of this bar. You do this.
        public String getCategory() {
                return category;
        }
        public String getLabel() {
                return label;
        }

        /*
        Compares two bars by value.
        Bar A is less than Bar B if the value of A is less than the value of B.
        Returns -1 if this < otherBar, 1 if this > otherBar, and 0 otherwise.
        If otherBar is null, throws a NullPointerException.
        if otherBar.name is null, or otherBar.value < 0, or otherBar.category is null, throws an IllegalArgumentException.
        */
        public int compareTo(Bar otherBar) {
                if(otherBar == null){
                        throw new NullPointerException("Error: Bar is null");
                }else if(otherBar.getName() == null || otherBar.getValue() < 0
                        || otherBar.getCategory() == null){
                        throw new IllegalArgumentException("Error: name is null, " +
                                "value is less than 0, or category is null");
                }else if(this.getValue() < otherBar.getValue()){
                        return -1;
                }else if(this.getValue() > otherBar.getValue()){
                        return 1;
                }
                return 0;
        }
}
