package company;

import contracts.AbstractContract;
import contracts.SingleVehicleContract;
import contracts.MasterVehicleContract;
import objects.Person;
import objects.Vehicle;
import payment.ContractPaymentData;
import payment.PremiumPaymentFrequency;
import payment.PaymentHandler;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class InsuranceCompany {
    private final LocalDateTime currentTime;
    private final Set<AbstractContract> contracts;
    private final PaymentHandler handler;

    public InsuranceCompany(LocalDateTime currentTime) {
        this.currentTime = currentTime;
        this.contracts = new HashSet<>();
        this.handler = new PaymentHandler();
    }

    public SingleVehicleContract insureVehicle(
            String contractNumber,
            Person beneficiary,
            Person policyHolder,
            int premium,
            PremiumPaymentFrequency frequency,
            Vehicle vehicle
    ) {
        // Validate input parameters
        if (contractNumber == null || contractNumber.isEmpty() ||
                policyHolder == null || premium < 300 || frequency == null || vehicle == null) {
            throw new IllegalArgumentException("Invalid parameters for insuring a vehicle.");
        }

        // Create payment data
        ContractPaymentData paymentData = new ContractPaymentData(premium, frequency, currentTime, premium);

        // Create the contract
        SingleVehicleContract contract = new SingleVehicleContract(
                contractNumber, this, beneficiary, policyHolder, paymentData, vehicle.getOriginalValue(), vehicle
        );

        // Add contract to the insurer's list and policyHolder's contracts
        contracts.add(contract);
        policyHolder.getContracts().add(contract);

        return contract;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public Set<AbstractContract> getContracts() {
        return contracts;
    }

    public PaymentHandler getHandler() {
        return handler;
    }
}