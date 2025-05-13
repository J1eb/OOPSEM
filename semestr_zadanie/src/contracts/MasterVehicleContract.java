package contracts;

import company.InsuranceCompany;
import objects.Person;

import java.util.HashSet;
import java.util.Set;

public class MasterVehicleContract extends AbstractVehicleContract {
    private final Set<SingleVehicleContract> childContracts;

    public MasterVehicleContract(String contractNumber, InsuranceCompany insurer, Person beneficiary, Person policyHolder) {
        super(contractNumber, insurer, beneficiary, policyHolder, null, 0);
        this.childContracts = new HashSet<>();
    }

    public Set<SingleVehicleContract> getChildContracts() {
        return childContracts;
    }

    public void requestAdditionOfChildContract(SingleVehicleContract childContract) {
        childContracts.add(childContract);
    }

    @Override
    public void pay(int amount) {
        for (SingleVehicleContract childContract : childContracts) {
            if (childContract.isActive()) {
                childContract.pay(amount / childContracts.size());
            }
        }
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    @Override
    public void setInactive() {
        // Mark this contract as inactive
        this.isActive = false;

        // Mark all child contracts as inactive
        for (SingleVehicleContract childContract : childContracts) {
            childContract.setInactive();
        }
    }
}