package contacts;
import java.time.LocalDate;
import java.util.regex.*;

public class PersonContact extends Contacts {
    public String surname;
    public LocalDate birthDate;
    public Gender gender;
    
    public PersonContact(String name, String surname, String phoneNum, String gender, String birthDate) {
        super(name, phoneNum);
        setSurName(surname);
        setBirthDate(birthDate);
        this.gender = new Gender(gender); 
        System.out.println("The record added.");
    }

    /**
     * 
     * @param surname
     */
    public void setSurName(String surname) {
        updateDate();
        if (surname == null || surname.isEmpty())
            this.surname = "[no data]";
        else
            this.surname = surname;

    }
    /**
     * 
     * @param birthDate
     * @see PersonContact#checkBirthDate(String)
     */

    public void setBirthDate (String birthDate) {
        updateDate();
        if (checkBirthDate(birthDate))
            this.birthDate = LocalDate.parse(birthDate);
    }
    /**
     * 
     * @param birthDate
     * @return true if valid (dd-mm-yy) or false if invalid (otherwise)
     * This allows the same format with the requirement
     * @
     */
    public static boolean checkBirthDate(String birthDate) {
        String valid = "^(0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])[-](19|20)\\d\\d$";
        return Pattern.compile(valid).matcher(birthDate).find();
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nSurname: %s\nBirth date: %s\nGender: %s\nNumber: %s\nTime created: %s\nTime last edit: %s\n" ,
            super.name, this.surname, (birthDate == null)? "[no data]":birthDate.toString(), gender.gender,phoneNum.getPhoneNumber(), super.created.toString(), super.lastEditted.toString());
    }
    
}
