package contacts;
import java.time.LocalDateTime;

/**
 * @version - 2.1
 * @author - thuanGIT
 * @since - October 28th, 20202
 * 
 */
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
    /**
     * @param name - the first name of a person/ name of a store
     */
     
    public void setName(String name) {
        if (name == null || name.isEmpty()) 
            this.name = "[no data]";
        else
            this.name = name;
        this.lastEditted = LocalDateTime.now();
    }

    protected void updateDate() {
        // Update the editted date
        this.lastEditted = LocalDateTime.now();
    }
    
}








