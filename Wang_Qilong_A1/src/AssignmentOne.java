import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class AssignmentOne {
    
    //Part 3 – Using classes and objects
    public static void main(String[] args) {
        GeneralPractitioner GP1 = new GeneralPractitioner( 
            1, "GP - Dr Sergey Bromberg", "07-5612-7830", "58 Scarborough Street Southport, QLD 4215", "Male",
            new String[]{"English", "French"}, "MBBS"
        );
 
        GeneralPractitioner GP2 = new GeneralPractitioner(
            2, "GP - Dr Justin Wong", "07-5439-4323", "23 Nind St, Southport, QLD 4215", "Male",
            new String[]{"English", "Chinese"}, "MBBS"
        );

        GeneralPractitioner GP3 = new GeneralPractitioner(
            3, "GP - Dr Ali Zebarjad", "07-6320-2408", "47 George St, Southport, QLD 4215", "Male",
            new String[]{"Persian"}, "MBBS"
        );

        Psychologist Ps1 = new Psychologist(
            4, "Ms Julie Scott - Psychology", "07-6543-3210", "2 Nineteenth Ave, Palm Beach QLD 4221", "Female",
            new String[]{"English"}, "Psychological Medicine"
        );

        String[] languages = {"English", "Spanish"};
        Psychologist Ps2 = new Psychologist(
            5, "Dr. Smith", "07-4659-1048", 
            "570-580 Pine Ridge Rd, Coombabah QLD 4216", "Male", languages, "Clinical Psychology");
 
        GP1.GeneralPDetails();
        GP2.GeneralPDetails();
        GP3.GeneralPDetails();
        Ps1.PsychologistDetails();
        Ps2.PsychologistDetails();
        
        System.out.println("--------------------------------------------");
        
        
        // Part 5 – Collection of appointments
        ArrayList<Appointment> appointments = new ArrayList<>();
        createExistingAppointment(appointments, "John Doe", "234-4234-432", LocalTime.of(11, 30), GP2);
        createExistingAppointment(appointments, "Peter", "555-4342-567", LocalTime.of(14, 30), GP1);
        createExistingAppointment(appointments, "Brown", "523-7654-321", LocalTime.of(9, 0), Ps1);
        createExistingAppointment(appointments, "Davis", "526-4234-678", LocalTime.of(11, 15), Ps2);
 
        printAppointments(appointments);
 
        cancelBooking(appointments, "987-6543-321");
        cancelBooking(appointments, "555-4342-567");
        
        System.out.println("The updated collection of appointments");
        printAppointments(appointments);

        System.out.println("--------------------------------------------");
    }
 
    public static void createExistingAppointment(ArrayList<Appointment> appointments, String patientName, 
        String patientMobilePhone, LocalTime timeSlot, HealthProfessional selectedDoctor) {
        if (patientName.isEmpty() || patientMobilePhone.isEmpty() || timeSlot == null || selectedDoctor == null) {
            System.out.println("Invalid appointment information. Appointment cannot be created.");
            return;
        }
        Appointment newAppointment = new Appointment(patientName, patientMobilePhone, timeSlot, selectedDoctor);
        appointments.add(newAppointment);
        System.out.println("Appointment created successfully.");
    }
 
    public static void printAppointments(ArrayList<Appointment> appointments) {
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