import com.example.str;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class strTest {

    @Test
    void StringReverseCheck() {
        str s = new str();
        assertEquals("gnitset", s.reverse("testing"));
    }

    @Test
    void StringNullCheck() {
        str s = new str();
        assertNull(s.reverse("testing"));
    }
    
}
