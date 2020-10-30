package contacts;

/**
 * @author @thuanGIT
 * 
 */
public class Gender {
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

    /**
     * 
     * @param g
     * @return true if either M or F
     * Disclaimer: This is for testing purposes. Not all genders are included.
     * Further updates will expand to all genders.
     */
    public static boolean checkGender(String g) {
        if (g.equals("F") || g.equals("M")) 
            return true;
        return false;
    }

}
