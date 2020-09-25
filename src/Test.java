public class Test {
     public static void main(String[] args) {
         String text = "24-11-2000";
        java.time.LocalDate date = java.time.LocalDate.parse(text);
        System.out.println(date);
    }
}
