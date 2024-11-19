import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class AssignmentOne {
    public static void main(String[] args) {
        GeneralPractitioner GP1 = new GeneralPractitioner( 
            2, "Dr. Bob Smith", "987-654-3210", "456 Elm St, Othertown, USA", "Male",
            new String[]{"English", "French", "German"}, null
        );
 
        GeneralPractitioner GP2 = new GeneralPractitioner(
            2, "Dr. Bob Smith", "987-654-3210", "456 Elm St, Othertown, USA", "Male",
            new String[]{"English", "French", "German"}, "MBBS"
        );
        GP1.GeneralPDetails();
        GP2.GeneralPDetails(); 

        Psychologist Ps3 = new Psychologist(
            2, "Dr. Bob Smith", "987-654-3210", "456 Elm St, Othertown, USA", "Male",
            new String[]{"English", "French", "German"}, "Psychological Medicine"
        );

        Ps3.PsychologistDetails();

        String[] languages = {"English", "Spanish"};
        Psychologist psychologist = new Psychologist(1, "Dr. Smith", "123-456-7890", 
            "123 Main St", "Male", languages, "Clinical Psychology");
 
        psychologist.PsychologistDetails();

        LocalTime preferredTime = LocalTime.of(10, 0);
        Appointment Ap1 = new Appointment("SARR", "234-4234-432", preferredTime,GP2);
 
        Ap1.printDetails();



        ArrayList<Appointment> appointments = new ArrayList<>();
        createAppointment(appointments, "John Doe", "555-1234-5678", LocalTime.of(11, 30), GP1);
 
        printExistingAppointments(appointments);
 
        cancelBooking(appointments, "987-654-3210");
        cancelBooking(appointments, "555-1234-5678");
    }
 
    public static void createAppointment(ArrayList<Appointment> appointments, String patientName, 
        String patientMobilePhone, LocalTime timeSlot, HealthProfessional selectedDoctor) {
        if (patientName.isEmpty() || patientMobilePhone.isEmpty() || timeSlot == null || selectedDoctor == null) {
            System.out.println("Invalid appointment information. Appointment cannot be created.");
            return;
        }
        Appointment newAppointment = new Appointment(patientName, patientMobilePhone, timeSlot, selectedDoctor);
        appointments.add(newAppointment);
        System.out.println("Appointment created successfully.");
    }
 
    public static void printExistingAppointments(ArrayList<Appointment> appointments) {
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments.");
        } else {
            for (Appointment appointment : appointments) {
                appointment.printDetails();
            }
        }
    }
 
    public static void cancelBooking(ArrayList<Appointment> appointments, String patientMobilePhone) {
        boolean found = false;
        for (int i = 0; i < appointments.size(); i++) {
            if (Objects.equals(appointments.get(i).getPatientMobilePhone(), patientMobilePhone)) {
                appointments.remove(i);
                found = true;
                System.out.println("Appointment cancelled successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("No appointment found with the provided mobile phone number.");
        }
    }
}