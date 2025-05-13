package objects;

import contracts.AbstractContract;
import java.util.HashSet;
import java.util.Set;

public class Person {
    private final String id;
    private final LegalForm legalForm;
    private int paidOutAmount;
    private final Set<AbstractContract> contracts;

    public Person(String id) {
        if (!validateId(id)) {
            throw new IllegalArgumentException("Invalid ID");
        }
        this.id = id;
        this.legalForm = id.length() == 10 ? LegalForm.NATURAL : LegalForm.LEGAL;
        this.paidOutAmount = 0;
        this.contracts = new HashSet<>();
    }

    private boolean validateId(String id) {
        return id.matches("\\d{8,10}");
    }

    public void payout(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.paidOutAmount += amount;
    }

    public int getPaidOutAmount() {
        return paidOutAmount;
    }

    public String getId() {
        return id;
    }

    public LegalForm getLegalForm() {
        return legalForm;
    }

    public Set<AbstractContract> getContracts() {
        return contracts;
    }
}