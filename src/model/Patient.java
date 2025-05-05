package model;

public class Patient {
    private String name;
    private String id;
    private String medicalHistory;

    public Patient(String name, String id) {
        this.name = name;
        this.id = id;
        this.medicalHistory = "";
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public String getMedicalHistory() { return medicalHistory; }

    public void addMedicalHistory(String entry) {
        this.medicalHistory += entry + "\n";
    }
}
