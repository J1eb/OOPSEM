package payment;

import contracts.AbstractContract;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PaymentHandler {
    private final Map<AbstractContract, Set<PaymentInstance>> paymentHistory;

    public PaymentHandler() {
        this.paymentHistory = new HashMap<>();
    }

    public void pay(AbstractContract contract, int amount) {
        if (!contract.isActive()) {
            throw new IllegalStateException("Cannot pay for an inactive contract");
        }
        contract.pay(amount);

        PaymentInstance paymentInstance = new PaymentInstance(contract.getInsurer().getCurrentTime(), amount);
        paymentHistory.computeIfAbsent(contract, k -> new HashSet<>()).add(paymentInstance);
    }

    public Map<AbstractContract, Set<PaymentInstance>> getPaymentHistory() {
        return paymentHistory;
    }
}