package regex;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class emailValidation {
    public static void main(String[] args) {
        String[] emails = {
            "user@example.com",
            "john.doe123@gmail.com",
            "invalid-email",
            "missing@tld.",
            "@missingusername.com"
        };
    
        for (String string : emails) {
            System.out.println(string +" is valid ? " + ValidateEmail(string));
        }
        
    }

    public static boolean ValidateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
