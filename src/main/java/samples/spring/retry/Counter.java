package samples.spring.retry;

public class Counter {
    private int attempts;
    private int recoveries;

    public void addAttempt() {
        this.attempts++;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getRecoveries() {
        return recoveries;
    }

    public void addRecovery() {
        this.recoveries++;
    }
}
