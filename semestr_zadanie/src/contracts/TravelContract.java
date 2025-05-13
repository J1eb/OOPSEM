package contracts;

import company.InsuranceCompany;
import objects.Person;
import payment.ContractPaymentData;

import java.util.Set;

public class TravelContract extends AbstractContract {
    private final Set<Person> insuredPersons;

    public TravelContract(String contractNumber, InsuranceCompany insurer, Person policyHolder, ContractPaymentData contractPaymentData, int coverageAmount, Set<Person> insuredPersons) {
        super(contractNumber, insurer, policyHolder, contractPaymentData, coverageAmount);
        if (insuredPersons == null || insuredPersons.isEmpty()) {
            throw new IllegalArgumentException("Insured persons cannot be empty");
        }
        this.insuredPersons = insuredPersons;
    }

    public Set<Person> getInsuredPersons() {
        return insuredPersons;
    }

    @Override
    public void pay(int amount) {
        contractPaymentData.pay(amount);
    }
}