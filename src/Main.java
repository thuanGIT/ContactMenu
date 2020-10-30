//package contacts;
//import contacts.*;
public class Main {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        
        String action = "";
        java.util.ArrayList<Contacts> record = new java.util.ArrayList<Contacts>();
        boolean badInput = false;
        while (!action.equals("exit")) {
            // Start with a new action
            System.out.print((!badInput)?"Enter action (add, remove, edit, count, list, info, exit): ": "");
            action = input.nextLine().toLowerCase().trim();

             /**
              * Add option
                -   Choose between a person/ a store contact
              */
            if (action.equals("add")) {
                System.out.print("Enter the type (person, organization): ");
                String type = input.nextLine().toLowerCase().trim();
                
                // Divide into cases
                switch(type) {
                    case Contacts.PERSON: // Person case => Ask questions on a person's information
                        System.out.print("Enter the name of the person: ");
                        String name = input.nextLine();
                        System.out.print("Enter the surname of the person: ");
                        String surname = input.nextLine();
                        System.out.print("Enter the birth date: ");
                        String birthDate = input.nextLine();
                        System.out.print((PersonContact.checkBirthDate(birthDate))? "":"Bad birth date!\n");
                        System.out.print("Enter the gender (M, F): ");
                        String gender = input.nextLine().toLowerCase().trim();
                        System.out.print((Gender.checkGender(gender))? "":"Bad gender!\n");
                        System.out.print("Enter the number: ");
                        String phoneNum = input.nextLine();

                        //Add the new contact to the record (person)
                        record.add(new PersonContact(name, surname,phoneNum, gender, birthDate));

                        break;

                    case Contacts.STORE: // Store case => Ask store's information
                        System.out.print("Enter the organization name: ");
                        String storeName = input.nextLine();
                        System.out.print("Enter the address: ");
                        String address = input.nextLine();
                        System.out.print("Enter the number: ");
                        String number = input.nextLine();

                        //Add the new contact to the record (store)
                        record.add(new StoreContact(storeName, address, number));
                        
                        break;
                    default: continue;
                }


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
                    System.out.print("Select a record:");
                    int index = input.nextInt()-1;
                    input.nextLine();

                    Contacts contact = record.get(index);
                    boolean person = false;
                    
                    // Check if that contact is a person
                    if (contact instanceof PersonContact){
                        System.out.print("Select a field (name, surname, birth, gender, number):");
                        person = true;
                    }
                    else {
                        System.out.print("Select a field (organization name, address, number):"); 
                    }
                   
                    String field = input.nextLine().trim().toLowerCase();
                    System.out.print("Enter " + field + ": ");
                    String value = input.nextLine().trim();

                    // Print message
                    System.out.println("The record updated!");

                    if (person) {
                        switch (field.toLowerCase()) {
                            case "name": contact.setName(value);;break;
                            case "surname":((PersonContact)contact).setSurName(value);break;
                            case "birth":
                                System.out.print((PersonContact.checkBirthDate(value))? "":"Bad birth date!\n");
                                ((PersonContact)contact).setBirthDate(value); 
                                break;
                            case "gender":
                                System.out.print((Gender.checkGender(value))? "":"Bad gender!\n");
                                ((PersonContact)contact).gender.setGender(value);
                                break;
                            case "number": contact.phoneNum.setPhoneNumber(value); break;
                            default: System.out.println("Not supported!");
      
                        } 

                    } else {
                        switch (field.toLowerCase()) {
                            case "organization name":contact.setName(value);;break;
                            case "address":((StoreContact)contact).address = value;break;
                            case "number":contact.phoneNum.setPhoneNumber(value); break;
                            default: System.out.println("Not supported!");
                    }

                   
                }
            }
            
            // Printing size of the contact book
            } else if (action.equals("count")) {
                System.out.printf("The Phone Book has %d records.\n", record.size());
            
            // List the name of the contacts
            } else if (action.equals("list")) {
                printRecord(record);
            
            // Display information of contact based on 
            } else if (action.equals("info")) {
               // Print record (just name)
                printRecord(record);

                // Ask specifically which record
                System.out.print("Enter index to show info: ");
                int index = input.nextInt() - 1;
                input.nextLine();
                System.out.print(record.get(index).toString());
            } else {
                // If an action is incorrectly typed
                badInput = true;
            }

            // Set badInput to false
            badInput = false;

            // Separate previous action with \n
            System.out.println();
        }
        
        input.close();
        
    }

    public static void printRecord(java.util.ArrayList<Contacts> record) {
        for (int i = 0; i < record.size(); i++) {
            Contacts e = record.get(i);
            if (e instanceof PersonContact)
                System.out.printf("%d. %s\n", i+1, (((PersonContact)e).name + " " + ((PersonContact)e).surname));
            else
                System.out.printf("%d. %s\n", i+1, e.name);
        }
    }

}



