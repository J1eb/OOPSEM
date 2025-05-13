package contracts;

import company.InsuranceCompany;
import objects.Person;
import payment.ContractPaymentData;

public abstract class AbstractContract {
    private final String contractNumber;
    protected final InsuranceCompany insurer;
    protected final Person policyHolder;
    protected final ContractPaymentData contractPaymentData;
    protected int coverageAmount;
    protected boolean isActive;

    public AbstractContract(String contractNumber, InsuranceCompany insurer, Person policyHolder, ContractPaymentData contractPaymentData, int coverageAmount) {
        if (contractNumber == null || contractNumber.isEmpty() || insurer == null || policyHolder == null || contractPaymentData == null || coverageAmount < 0) {
            throw new IllegalArgumentException("Invalid contract data");
        }
        this.contractNumber = contractNumber;
        this.insurer = insurer;
        this.policyHolder = policyHolder;
        this.contractPaymentData = contractPaymentData;
        this.coverageAmount = coverageAmount;
        this.isActive = true;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public Person getPolicyHolder() {
        return policyHolder;
    }

    public InsuranceCompany getInsurer() {
        return insurer;
    }

    public int getCoverageAmount() {
        return coverageAmount;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setInactive() {
        this.isActive = false;
    }

    public ContractPaymentData getContractPaymentData() {
        return contractPaymentData;
    }

    public void updateBalance() {
        contractPaymentData.updateNextPaymentTime();
    }

    public abstract void pay(int amount);

    public void setCoverageAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Coverage amount cannot be negative");
        }
        this.coverageAmount = amount;
    }
}