package contracts;

import company.InsuranceCompany;
import objects.Person;
import objects.Vehicle;
import payment.ContractPaymentData;

public class SingleVehicleContract extends AbstractVehicleContract {
    private final Vehicle insuredVehicle;

    public SingleVehicleContract(String contractNumber, InsuranceCompany insurer, Person beneficiary, Person policyHolder, ContractPaymentData contractPaymentData, int coverageAmount, Vehicle insuredVehicle) {
        super(contractNumber, insurer, beneficiary, policyHolder, contractPaymentData, coverageAmount);
        if (insuredVehicle == null) {
            throw new IllegalArgumentException("Insured vehicle cannot be null");
        }
        this.insuredVehicle = insuredVehicle;
    }

    public Vehicle getInsuredVehicle() {
        return insuredVehicle;
    }

    @Override
    public void pay(int amount) {
        contractPaymentData.pay(amount);
    }
}