//Part 1 – Base class
public class HealthProfessional {
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
