package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternMatcher {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("enter pattern : ");
                String reGpattern = sc.nextLine();
                Pattern pattern = Pattern.compile(reGpattern);
                Matcher matcher = pattern.matcher("Wellcome to the jewels world!");
                boolean found = false;
                if (matcher.find()) {
                    System.out.println("found: " + matcher.group() + " starting at " + matcher.start() + " ending at "
                            + matcher.end());
                    found = true;
                }
                if (!found) {
                    System.out.println("Match is not found");
                }
            }
        } catch (Exception e) {
            System.out.println("something wrong okkkk");
        }
    }
}
