package regex;

import java.util.regex.Pattern;

public class passwardValidation {
    public static void main(String[] args) {
        String[] passwords = {
                "Passw0rd!",
                "Weak",
                "NoDigitOrSpecialChar",
                "shortP!",
                "LongEnoughButNoUppercase1",
                "StrongP@ssw0rd"
        };

        for (String string : passwords) {
            System.out.println(string + " is valid ? " + ValidatePassword(string));
        }
    }

    public static boolean ValidatePassword(String pass) {
        if (pass == null || pass.isEmpty()) {
            return false;
        }
        //        at least one   digit,   small   , capital   special      not space    minimum length 8         
        String passRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@!#%^$&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(passRegex);
        return pattern.matcher(pass).matches();
    }

    
}
