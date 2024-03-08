package mathHelper;

import mathHelper.Logic.Process;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProcessTest {
    private final Process process = new Process();

    @Test
    void test1() {
        String expression = "2*x*-x=25";
        double expectedResult = Double.NaN;
        double actualResult = process.procces(expression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test2() {
        String expression = "2*x*x-7=25";
        double expectedResult = 4.0;
        double actualResult = process.procces(expression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test3() {
        String expression = "-2*x*x-7=25";
        double expectedResult = Double.NaN;
        double actualResult = process.procces(expression);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void test4() {
        String expression = "-2*-x*-x-7=25";
        double expectedResult = Double.NaN;
        double actualResult = process.procces(expression);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void test5() {
        String expression = "25=2*x+5";
        String expectedResult = "25";
        StringBuilder actualResult = process.findAfterOrBeforeEquals(new ArrayList<>(List.of(expression.split(""))));
        assertEquals(expectedResult, actualResult.toString());
    }
}