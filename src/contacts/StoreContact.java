package contacts;

public class StoreContact extends Contacts {
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
        super.lastEditted = java.time.LocalDateTime.now();
        this.address = address;
    }    
}

