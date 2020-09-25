//package contacts;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;


public abstract class Contacts {
    public String name;
    public PhoneNum phoneNum;
    public LocalDateTime created;
    public LocalDateTime lastEditted;
    public static final String PERSON = "person";
    public static final String STORE = "organization";
    
    protected Contacts (String name, String phoneNum) {
        this.created = this.lastEditted = LocalDateTime.now(); // Intialize the date created, modified
        this.phoneNum = new PhoneNum(phoneNum); 
        setName(name);
    }
    public void setName(String name) {
        if (name == null || name.isEmpty())
            this.name = "[no data]";
        else
            this.name = name;
        this.lastEditted = LocalDateTime.now();
    }
    
}

class PersonContact extends Contacts {
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

    public void setSurName(String surname) {
        super.lastEditted = LocalDateTime.now();
        if (surname == null || surname.isEmpty())
            this.surname = "[no data]";
        else
            this.surname = surname;

    }

    public void setBirthDate (String birthDate) {
        super.lastEditted = LocalDateTime.now();
        if (checkBirthDate(birthDate))
            this.birthDate = LocalDate.parse(birthDate);
    }
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

class StoreContact extends Contacts {
    public String address;
    public StoreContact(String name, String address, String phoneNum) {
        super(name, phoneNum);
        this.address = address;
        System.out.println("The record added.");
    }

    @Override
    public String toString() {
        return  String.format("Organization name: %s\nAddress: %s\nNumber: %s\nTime created: %s\nTime last edit: %s\n" ,
        super.name, this.address, phoneNum.getPhoneNumber(), super.created.toString(), super.lastEditted.toString());
    }

    public void changeAddress(String address) {
        super.lastEditted = LocalDateTime.now();
        this.address = address;
    }    
}



class PhoneNum {
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
    
    private boolean checkNumber(String phoneNum) {
        String pattern = "^\\+?[A-Za-z0-9]*([\\s-]*\\([A-Za-z0-9]{2,}\\))?([\\s-]*[A-Za-z0-9]{2,})*$";
        return java.util.regex.Pattern.compile(pattern).matcher(phoneNum).find();
    }
    
    public boolean hasNumber() {
        return !(phoneNum.isEmpty() && phoneNum.equals("[no number]"));
    }

}

class Gender {
    public String gender;
    public Gender(String gender) {
        setGender(gender);
    }

    public void setGender(String gender) {
        String g = gender.toUpperCase().trim();
        if (checkGender(g))
            this.gender = g;
        else this.gender = "[no data]";     
    }

    public static boolean checkGender(String g) {
        if (g.equals("F") || g.equals("M")) 
            return true;
        return false;
    }

}



