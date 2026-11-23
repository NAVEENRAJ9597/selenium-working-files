import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class NumberAnalyzerTest {

    private NumberAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        analyzer = new NumberAnalyzer();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 8, -4, 100})
    void testIsEvenReturnsTrue(int number) {
        assertTrue(analyzer.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 7, -3, 99})
    void testIsEvenReturnsFalse(int number) {
        assertFalse(analyzer.isEven(number));
    }

    @Test
    void testFindMaxWithPositiveNumbers() {
        int[] input = {1, 5, 3, 9, 2};
        assertEquals(9, analyzer.findMax(input));
    }

    @Test
    void testFindMaxWithNegativeNumbers() {
        int[] input = {-10, -5, -20, -1};
        assertEquals(-1, analyzer.findMax(input));
    }

    @Test
    void testFindMaxThrowsExceptionOnEmptyArray() {
        int[] emptyArray = {};
        assertThrows(IllegalArgumentException.class, () -> analyzer.findMax(emptyArray));
    }

    @Test
    void testFindMaxThrowsExceptionOnNull() {
        assertThrows(IllegalArgumentException.class, () -> analyzer.findMax(null));
    }

    @Test
    void testCalculateFactorialStandardValues() {
        assertEquals(120, analyzer.calculateFactorial(5));
        assertEquals(5040, analyzer.calculateFactorial(7));
    }

    @Test
    void testCalculateFactorialBoundaries() {
        assertEquals(1, analyzer.calculateFactorial(0));
        assertEquals(1, analyzer.calculateFactorial(1));
    }

    @Test
    void testCalculateFactorialThrowsExceptionOnNegative() {
        assertThrows(IllegalArgumentException.class, () -> analyzer.calculateFactorial(-5));
    }
}