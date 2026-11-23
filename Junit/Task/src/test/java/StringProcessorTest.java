import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringProcessorTest {
    public StringProcessor processor;

    @BeforeEach
    void preload() {
        processor = new StringProcessor();
    }

    @Test
    void testReverseValidString() {
        assertEquals("gnitset", processor.reverse("testing"));
    }

    @Test
    void testReverseNull() {
        assertNull(processor.reverse(null));
    }

    @Test
    void testReverseNumber() {
        assertEquals("321", processor.reverse(123));
    }
}