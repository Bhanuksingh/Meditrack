import model.*;
import service.HealthRecordManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // strict date validation

        // Step 1: Patient Details
        String name = "";
        while (name.isEmpty()) {
            System.out.print("Enter patient name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) System.out.println("❌ Name cannot be empty.");
        }

        String id = "";
        while (id.isEmpty()) {
            System.out.print("Enter patient ID: ");
            id = scanner.nextLine().trim();
            if (id.isEmpty()) System.out.println("❌ ID cannot be empty.");
        }

        Patient patient = new Patient(name, id);

        // Step 2: Add Medical History
        System.out.println("Enter medical history entries (type 'done' to finish):");
        while (true) {
            String entry = scanner.nextLine().trim();
            if (entry.equalsIgnoreCase("done")) break;
            if (entry.isEmpty()) {
                System.out.println("⚠️ Entry cannot be empty.");
                continue;
            }
            patient.addMedicalHistory(entry);
        }

        HealthRecordManager manager = new HealthRecordManager(patient);

        // Step 3: Add Appointments
        System.out.println("Add appointments (type 'done' as date to finish):");
        while (true) {
            System.out.print("Appointment date (YYYY-MM-DD): ");
            String date = scanner.nextLine().trim();
            if (date.equalsIgnoreCase("done")) break;

            if (!isValidDate(date, dateFormat)) {
                System.out.println("❌ Invalid date format. Please use YYYY-MM-DD.");
                continue;
            }

            System.out.print("Doctor's name: ");
            String doctor = scanner.nextLine().trim();
            if (doctor.isEmpty()) {
                System.out.println("❌ Doctor name cannot be empty.");
                continue;
            }

            System.out.print("Notes: ");
            String notes = scanner.nextLine().trim();

            manager.addAppointment(new Appointment(date, doctor, notes));
        }

        // Step 4: Add Prescriptions
        System.out.println("Add prescriptions (type 'done' as medicine name to finish):");
        while (true) {
            System.out.print("Medicine name: ");
            String medicine = scanner.nextLine().trim();
            if (medicine.equalsIgnoreCase("done")) break;
            if (medicine.isEmpty()) {
                System.out.println("❌ Medicine name cannot be empty.");
                continue;
            }

            System.out.print("Dosage (e.g., 500mg): ");
            String dosage = scanner.nextLine().trim();
            if (dosage.isEmpty()) {
                System.out.println("❌ Dosage cannot be empty.");
                continue;
            }

            System.out.print("Instructions: ");
            String instructions = scanner.nextLine().trim();
            if (instructions.isEmpty()) {
                System.out.println("❌ Instructions cannot be empty.");
                continue;
            }

            manager.addPrescription(new Prescription(medicine, dosage, instructions));
        }

        // Step 5: Save Record
        manager.saveRecord();
        scanner.close();
    }

    // Utility method for date validation
    private static boolean isValidDate(String dateStr, SimpleDateFormat sdf) {
        try {
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
