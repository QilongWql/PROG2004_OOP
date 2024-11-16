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


class HealthProfessional {
    protected int hpID;
    protected String hpName;
    protected String hpPhoneNum;
    protected String hpAddress;
    protected String hpGender;
    protected String[] hpLanguagesSpoken;
            
    public HealthProfessional(){
            this.hpID = 0;
            this.hpName = "";
            this.hpPhoneNum = "";
            this.hpAddress = "";
            this.hpGender = "";
            this.hpLanguagesSpoken = new String[0];
    }

    public HealthProfessional(int ID, String name, String phoneNum, String address, String gender, String[] languages){
        this.hpID = ID;
        this.hpName = name;
        this.hpPhoneNum = phoneNum;
        this.hpAddress = address;
        this.hpGender = gender;
        if (languages != null) {
            this.hpLanguagesSpoken = languages;
        } else {
            this.hpLanguagesSpoken = new String[0];
        }
    }
 
    public void printDetails() {
        System.out.println("\t" + "ID: " + this.hpID);
        System.out.println("\t" + "Name: " + this.hpName);
        System.out.println("\t" + "Phone number: " + this.hpPhoneNum);
        System.out.println("\t" + "Address: " + this.hpAddress);
        System.out.println("\t" + "Gender: " + this.hpGender);
        System.out.print("\t" + "Languages spoken: ");
        if (this.hpLanguagesSpoken != null) {
            for (String language : this.hpLanguagesSpoken) {
                System.out.print(language + " ");
            }
        }
        System.out.println();
    }
}

class GeneralPractitioner extends HealthProfessional {
    private String Degree;

    public GeneralPractitioner(int num, String per, String phnum, String add, String gender, String[] lang) {
        super();
        this.Degree = "";
    }

    public GeneralPractitioner(int ID, String name, String phoneNum, String address, String gender, String[] languages, String degree) {
        super(ID, name, phoneNum, address, gender, languages);
        this.Degree = degree;
    }

    private void isPrint() {
        super.printDetails();
        if (Degree != null) {
            System.out.println("\t" + "Specialization: " + this.Degree);
        }
    }

    public void GeneralPDetails() {
        System.out.println("The General Practitioner details are: " );
        isPrint();
        System.out.println();
    }
}

class Psychologist extends HealthProfessional {
    private String Professional;

    public Psychologist(int num, String per, String phnum, String add, String gender, String[] lang) {
        super();
        this.Professional = "";
    }

    public Psychologist(int ID, String name, String phoneNum, String address, String gender, String[] languages, String professional) {
        super(ID, name, phoneNum, address, gender, languages);
        this.Professional = professional;
    }

    private void isPrint() {
        super.printDetails();
        if (Professional != null) {
            System.out.println("\t" + "Professional: " + this.Professional);
        }
    }

    public void PsychologistDetails() {
        System.out.println("The Psychologist details are: ");
        isPrint();
        System.out.println();
    }

    public String getProfessional() {
        return Professional;
    }

    public void setProfessional(String Professional) {
        this.Professional = Professional;
    }
}

class Appointment {
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
}