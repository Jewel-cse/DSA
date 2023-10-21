package regex;

import java.util.regex.Pattern;

public class validateDomain {
    public static void main(String[] args) {
        String[] domainNames = {
            "example.com",
            "subdomain.example.co.uk",
            "invalid-domain-",
            "domain-name-that-is-way-too-long.com",
            "good-domain.org",
            "2ndlevel.invalid"
        };

        for (String domain : domainNames) {
            System.out.println(domain+" is valid " + domainValid(domain));
        }
    }

    public static boolean domainValid(String domain) {
        if (domain == null || domain.isEmpty()) {
            return false;
        }
        String regexDomain = "^(?:(?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(regexDomain);
        return pattern.matcher(domain).matches();
    }
}
