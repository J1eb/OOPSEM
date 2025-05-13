package objects;

public class Vehicle {
    private final String licensePlate;
    private final int originalValue;

    public Vehicle(String licensePlate, int originalValue) {
        if (!validateLicensePlate(licensePlate)) {
            throw new IllegalArgumentException("Invalid license plate");
        }
        this.licensePlate = licensePlate;
        this.originalValue = originalValue;
    }

    private boolean validateLicensePlate(String plate) {
        return plate.matches("[A-Z0-9]{7}");
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getOriginalValue() {
        return originalValue;
    }
}