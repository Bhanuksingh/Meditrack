package model;

public class Appointment {
    private String date;
    private String doctor;
    private String notes;

    public Appointment(String date, String doctor, String notes) {
        this.date = date;
        this.doctor = doctor;
        this.notes = notes;
    }

    public String toString() {
        return date + " with Dr. " + doctor + " - " + notes;
    }
}
