package model;

public class Prescription {
    private String medicine;
    private String dosage;
    private String instructions;

    public Prescription(String medicine, String dosage, String instructions) {
        this.medicine = medicine;
        this.dosage = dosage;
        this.instructions = instructions;
    }

    public String toString() {
        return medicine + " (" + dosage + ") - " + instructions;
    }
}
