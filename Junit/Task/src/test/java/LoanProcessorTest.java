import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class LoanProcessorTest {

    private LoanProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new LoanProcessor();
    }

    // 1. EQUIVALENCE PARTITIONING
    @ParameterizedTest
    @ValueSource(ints = {500, 750})
    void testValidCreditScorePartitions(int score) {
        assertDoesNotThrow(() -> processor.setCreditScore(score));
    }

    @ParameterizedTest
    @ValueSource(ints = {150, 900})
    void testInvalidCreditScorePartitions(int score) {
        assertThrows(IllegalArgumentException.class, () -> processor.setCreditScore(score));
    }

    // 2. BOUNDARY VALUE ANALYSIS (3-Value Approach)
    @ParameterizedTest
    @ValueSource(ints = {300, 301, 849, 850})
    void testCreditScoreBoundariesValid(int score) {
        assertDoesNotThrow(() -> processor.setCreditScore(score));
    }

    @ParameterizedTest
    @ValueSource(ints = {299, 851})
    void testCreditScoreBoundariesInvalid(int score) {
        assertThrows(IllegalArgumentException.class, () -> processor.setCreditScore(score));
    }

    // 3. STATE TRANSITION TESTING
    @Test
    void testValidLifecycleTransitions() {
        assertEquals(LoanProcessor.State.DRAFT, processor.getState());

        processor.submit();
        assertEquals(LoanProcessor.State.SUBMITTED, processor.getState());

        processor.beginReview();
        assertEquals(LoanProcessor.State.UNDER_REVIEW, processor.getState());

        processor.executeDecisionLogic(true, true);
        assertEquals(LoanProcessor.State.RESOLVED, processor.getState());
    }

    @Test
    void testInvalidStateTransitionSkipReview() {
        processor.submit();
        assertThrows(IllegalStateException.class, () -> processor.executeDecisionLogic(true, true));
    }

    // 4. DECISION TABLE TESTING
    @ParameterizedTest
    @CsvSource({
            "true, true, APPROVED",
            "true, false, MANUAL_REVIEW",
            "false, true, MANUAL_REVIEW",
            "false, false, REJECTED"
    })
    void testDecisionTableLogic(boolean isEmployed, boolean highIncome, LoanProcessor.Decision expectedDecision) {
        processor.submit();
        processor.beginReview();

        processor.executeDecisionLogic(isEmployed, highIncome);

        assertEquals(expectedDecision, processor.getDecision());
    }
}