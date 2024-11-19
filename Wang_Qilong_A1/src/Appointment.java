import java.time.LocalTime;

public class Appointment {
    private String patientName;
    private String patientMobilePhone;
    private LocalTime timeSlot;
    private HealthProfessional selectedDoctor;

    public Appointment(){
        this.patientName = "";
        this.patientMobilePhone = "";
        this.timeSlot = null;
        this.selectedDoctor = null;
    }
    
    public Appointment(String patientName, String patientMobilePhone, LocalTime timeSlot, HealthProfessional selectedDoctor) {
        this.patientName = patientName;
        this.patientMobilePhone = patientMobilePhone;
        this.timeSlot = timeSlot;
        this.selectedDoctor = selectedDoctor;
    }

    public LocalTime getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(LocalTime timeSlot) {
        this.timeSlot = timeSlot;
    }

    public void printDetails() {
        System.out.println("\t" + "Patient Name: " + this.patientName);
        System.out.println("\t" + "Patient Mobile Phone: " + this.patientMobilePhone);
        System.out.println("\t" + "Preferred Time Slot: " + this.timeSlot);
        System.out.println("\t" + "Selected Doctor: ");
        if (this.selectedDoctor != null) {
            this.selectedDoctor.printDetails();
        } else {
            System.out.println("No doctor selected.");
        }
        System.out.println();
    }

    public String getPatientMobilePhone() {
        return patientMobilePhone;
    }

    public void setPatientMobilePhone(String patientMobilePhone) {
        this.patientMobilePhone = patientMobilePhone;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public HealthProfessional getSelectedDoctor() {
        return selectedDoctor;
    }

    public void setSelectedDoctor(HealthProfessional selectedDoctor) {
        this.selectedDoctor = selectedDoctor;
    }
}
