public class LoanProcessor {

    public enum State { DRAFT, SUBMITTED, UNDER_REVIEW, RESOLVED }
    public enum Decision { PENDING, APPROVED, REJECTED, MANUAL_REVIEW }

    private State currentState = State.DRAFT;
    private Decision finalDecision = Decision.PENDING;

    public void setCreditScore(int score) {
        if (score < 300 || score > 850) {
            throw new IllegalArgumentException();
        }
    }

    public void submit() {
        if (currentState != State.DRAFT) throw new IllegalStateException();
        currentState = State.SUBMITTED;
    }

    public void beginReview() {
        if (currentState != State.SUBMITTED) throw new IllegalStateException();
        currentState = State.UNDER_REVIEW;
    }

    public void executeDecisionLogic(boolean isEmployed, boolean highIncome) {
        if (currentState != State.UNDER_REVIEW) throw new IllegalStateException();

        if (isEmployed && highIncome) {
            finalDecision = Decision.APPROVED;
        } else if (!isEmployed && !highIncome) {
            finalDecision = Decision.REJECTED;
        } else {
            finalDecision = Decision.MANUAL_REVIEW;
        }

        currentState = State.RESOLVED;
    }

    public State getState() { return currentState; }
    public Decision getDecision() { return finalDecision; }
}