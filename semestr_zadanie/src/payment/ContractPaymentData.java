package payment;

import java.time.LocalDateTime;

public class ContractPaymentData {
    private int premium;
    private final PremiumPaymentFrequency premiumPaymentFrequency;
    private LocalDateTime nextPaymentTime;
    private int outstandingBalance;

    public ContractPaymentData(int premium, PremiumPaymentFrequency premiumPaymentFrequency, LocalDateTime nextPaymentTime, int outstandingBalance) {
        if (premium < 0 || outstandingBalance < 0 || premiumPaymentFrequency == null || nextPaymentTime == null) {
            throw new IllegalArgumentException("Invalid payment data");
        }
        this.premium = premium;
        this.premiumPaymentFrequency = premiumPaymentFrequency;
        this.nextPaymentTime = nextPaymentTime;
        this.outstandingBalance = outstandingBalance;
    }

    public void updateNextPaymentTime() {
        this.nextPaymentTime = this.nextPaymentTime.plusMonths(premiumPaymentFrequency.getMonths());
    }

    public void pay(int amount) {
        this.outstandingBalance -= amount;
    }

    public int getOutstandingBalance() {
        return outstandingBalance;
    }

    public LocalDateTime getNextPaymentTime() {
        return nextPaymentTime;
    }

    public PremiumPaymentFrequency getPremiumPaymentFrequency() {
        return premiumPaymentFrequency;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        if (premium < 0) {
            throw new IllegalArgumentException("Premium cannot be negative");
        }
        this.premium = premium;
    }

    public void setOutstandingBalance(int outstandingBalance) {
        if (outstandingBalance < 0) {
            throw new IllegalArgumentException("Outstanding balance cannot be negative");
        }
        this.outstandingBalance = outstandingBalance;
    }
}