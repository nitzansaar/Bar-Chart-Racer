import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BarTest {
    Bar bar;
    Bar bar1;

    @BeforeEach
    void setup(){
        bar = new Bar("Nitzan", 37, "Athlete", "Boxing");
        bar1 = new Bar("Spencer", 6, "Athlete", "Football");
    }
    @Test
    void compareTo() {
        assertTrue(bar.compareTo(bar1) == 1);
        assertTrue(bar1.compareTo(bar) == -1);
        assertTrue(bar.compareTo(bar) == 0);
    }
}
