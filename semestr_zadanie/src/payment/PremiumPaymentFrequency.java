package payment;

public enum PremiumPaymentFrequency {
    ANNUAL(12), SEMI_ANNUAL(6), QUARTERLY(3), MONTHLY(1);

    private final int months;

    PremiumPaymentFrequency(int months) {
        this.months = months;
    }

    public int getMonths() {
        return months;
    }
}