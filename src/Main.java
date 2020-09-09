

//package contacts;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        
        String action = "";
        java.util.ArrayList<Contacts> record = new java.util.ArrayList<Contacts>();
        
        while (!action.equals("exit")) {
            System.out.println("Enter action (add, remove, edit, count, list, exit):");
            action = input.nextLine().toLowerCase().trim();
            if (action.equals("add")) {
                System.out.println("Enter the name of the person: ");
                String name = input.nextLine();
                System.out.println("Enter the surname of the person: ");
                String surname = input.nextLine();
                System.out.println("Enter the number: ");
                String phoneNum = input.nextLine();
                //Add the new contact to the record
                record.add(new Contacts(name, surname, phoneNum));
            } else if (action.equals("remove")) {
                if (record.isEmpty()) {
                    System.out.println("No records to remove!");
                } else {
                    System.out.println("Select a record: ");
                    int index = input.nextInt()-1;
                    input.nextLine();
                    record.remove(index);
                    System.out.println("The record removed!");
                }

            } else if (action.equals("edit")) {
                if (record.isEmpty()) {
                    System.out.println("No records to edit!");
                } else {
                    //print the record
                    printRecord(record);
                    // Edit the record
                    System.out.println("Select a record:");
                    int index = input.nextInt()-1;
                    input.nextLine();
                    System.out.println("Select a field (name, surname, number):");
                    String field = input.nextLine().trim().toLowerCase();
                    System.out.println("Enter " + field + ": ");
                    if (field.equals("name")) {
                        String name = input.nextLine();
                        record.get(index).name = name;
                    } else if (field.equals("surname")) {
                        String surname = input.nextLine();
                        record.get(index).surname = surname;
                    } else {
                        String phoneNum = input.nextLine();
                        record.get(index).setPhoneNumber(phoneNum);
                        
                    }
                    System.out.println("The record updated!");
                }
                
            } else if (action.equals("count")) {
                System.out.printf("The Phone Book has %d records.\n", record.size());
                
            } else if (action.equals("list")) {
                printRecord(record);
            }
        } 
        
    }
    public static void printRecord(java.util.ArrayList<Contacts> record) {
        for (int i = 0; i < record.size(); i++) {
            Contacts e = record.get(i);
            System.out.printf("%d. %s %s, %s\n", i+1, e.name, e.surname, e.getPhoneNumber());
        }

    }
}



class Contacts {
    String name, surname;
    private String phoneNum;
    
    public Contacts(String name, String surname, String phoneNum) {
        this.name = name;
        this.surname = surname;
        setPhoneNumber(phoneNum);
        System.out.println("The record added.");
    }
    
    public void setPhoneNumber(String phoneNum) {
        if(checkNumber(phoneNum)) {
            this.phoneNum = phoneNum;
        } else if (phoneNum.isEmpty()){
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
        String pattern = "^\\+?[A-Za-z0-9]*([\\s-]*\\([A-Za-z0-9]{2,}\\))?([\\s-][A-Za-z0-9]{2,})*$";
        return java.util.regex.Pattern.compile(pattern).matcher(phoneNum).find();
    }
    
    public boolean hasNumber() {
        return !(phoneNum.isEmpty() && phoneNum.equals("[no number]"));
    }
    
    /*
    CRITERIA FOR VALID PHONE NUMBERS: 

    The phone number should be split into groups using a space or dash. One group is also possible.
    Before the first group, there may or may not be a plus symbol.
    The first group or the second group can be wrapped in parentheses, 
    but there should be no more than one group which is wrapped in parentheses. 
    There may be no groups wrapped in parentheses.
    A group can contain numbers, uppercase, and lowercase English letters. 
    A group should be at least 2 symbols in length. But the first group may be only one symbol in length.
    
    HINTS: 
        valid number:
        +0 (123) 456-789-ABcd
        +0 (123) 456
        (123) 234 345-456
        1111111111111
    */


    
    
    
    
}
