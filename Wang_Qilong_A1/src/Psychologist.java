////Part 2 – Child classes of Psychologist
public class Psychologist extends HealthProfessional {
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
