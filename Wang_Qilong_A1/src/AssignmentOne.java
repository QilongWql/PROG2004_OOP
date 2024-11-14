public class AssignmentOne {
    public static void main(String[] args) {
        HealthProfessional hp1 = new HealthProfessional(12, "Tom", "Roud123", "123445677");
        HealthProfessional hp2 = new HealthProfessional(13, "PFDFHom", "Roud1FFS3", "127");
        hp1.printDetails();
        hp2.printDetails();
    }
}

class HealthProfessional{
    public int ID;
    public String name;
    public String phoneNum;
    public String address;
            
    public HealthProfessional(){
            this.ID = 0;
            this.name = "";
            this.phoneNum = "";
            this.address = "";
    }
    public HealthProfessional(int ID, String name, String phoneNum, String address){
            this.ID = ID;
            this.name = name;
            this.phoneNum = phoneNum;
            this.address = address;
    }
    public void printDetails(){
            System.out.println("ID: " + this.ID);
            System.out.println("Name: " + this.name);
            System.out.println("Phone number: " + this.phoneNum);
            System.out.println("Address: " + this.address);
    }
}
