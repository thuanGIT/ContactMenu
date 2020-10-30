package contacts;
import java.util.regex.*;

public class PhoneNum {
    private String phoneNum;

    public PhoneNum (String phoneNum) {
        setPhoneNumber(phoneNum);
    }

    public void setPhoneNumber(String phoneNum) {
        if(checkNumber(phoneNum)) {
            this.phoneNum = phoneNum;
        } else if (phoneNum.isEmpty() || phoneNum == null){
            this.phoneNum = "[no number]";
        } else {
            this.phoneNum = "[no number]";
            System.out.println("Wrong number format!");
        }
        
    }
    
    public String getPhoneNumber() {
        return phoneNum;
    }

    /**
     * @param phoneNum
     * @return
     */
    
    private boolean checkNumber(String phoneNum) {
        String pattern = "^\\+?[A-Za-z0-9]*([\\s-]*\\([A-Za-z0-9]{2,}\\))?([\\s-]*[A-Za-z0-9]{2,})*$";
        return Pattern.compile(pattern).matcher(phoneNum).find();
    }
    
    public boolean hasNumber() {
        return !(phoneNum.isEmpty() && phoneNum.equals("[no number]"));
    }

}

