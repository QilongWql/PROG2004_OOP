//Part 2 – Child classes of General Practitioner
public class GeneralPractitioner extends HealthProfessional {
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

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String Degree) {
        this.Degree = Degree;
    }
}
