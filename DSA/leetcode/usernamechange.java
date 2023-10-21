import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class usernamechange {
    public static void main(String[] args) {
        List<String> name =( Arrays. asList("bea", "superhero", "ace"));
        List<String> result = new ArrayList<>();
        result = possibleChanges(name);
        System.out.println(result);

    }
    public static List<String> possibleChanges(List<String> usernames) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < usernames.size(); i++) {
            Boolean flag = true;
            String name = usernames.get(i);
            int strlen = name.length();
            for (int j = 1; j < strlen; j++) {
                if(name.charAt(j)<name.charAt(0)){
                    result.add("Yes");
                    flag = false;
                    break;
                }
            }
            if(flag){
                result.add("No");
            }
            
        }
        
        return result;
        }
}
