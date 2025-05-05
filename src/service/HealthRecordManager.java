package service;

import model.*;
import utils.FileHandler;
import java.util.ArrayList;

public class HealthRecordManager {
    private Patient patient;
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private ArrayList<Prescription> prescriptions = new ArrayList<>();

    public HealthRecordManager(Patient patient) {
        this.patient = patient;
    }

    public void addAppointment(Appointment a) {
        appointments.add(a);
    }

    public void addPrescription(Prescription p) {
        prescriptions.add(p);
    }

    public void saveRecord() {
        StringBuilder sb = new StringBuilder();
        sb.append("Patient Name: ").append(patient.getName()).append("\n");
        sb.append("Patient ID: ").append(patient.getId()).append("\n\n");

        sb.append("Medical History:\n").append(patient.getMedicalHistory()).append("\n");
        sb.append("Appointments:\n");
        for (Appointment a : appointments) sb.append("- ").append(a).append("\n");

        sb.append("\nPrescriptions:\n");
        for (Prescription p : prescriptions) sb.append("- ").append(p).append("\n");

        String filename = "records/Patient_" + patient.getId() + ".txt";
        FileHandler.saveToFile(filename, sb.toString());
    }
}
