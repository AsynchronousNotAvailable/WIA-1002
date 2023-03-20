package code;

public class Telephone {
    private String areaCode;
    private String number;

    static Telephone numberOfTelephoneObject;

    public Telephone(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    // public void setAreaCode(String areaCode) {
    //     this.areaCode = areaCode;
    // }
    
    // public void setNumber(String numbeString) {
    //     this.number = number;
    // }

    public String getAreaCode() {
        return this.areaCode;
    }
    
    public String getNumber() {
        return this.number;
    }

    public String makeFullNumber() {
        String areaCode = getAreaCode();
        String number = getNumber();
        return (areaCode.concat("-").concat(number));
    }
    public static void main(String[] args) {
        Telephone[] telList = new Telephone[5];
        int number = 79676300;
        for (int i = 0; i < telList.length; i++) {
            
            telList[i] = new Telephone("03", Integer.toString(number));
            System.out.println(telList[i].makeFullNumber());
            number++;
        }
    }
}