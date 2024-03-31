package String;

/**
 * stringMultiply
 */
public class stringMultiply {

    
    private static String multiply(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // Result can have at most n + m digits
        int[] result = new int[n + m];

        // Multiply each digit and store the result in result array
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (str1.charAt(i) - '0') * (str2.charAt(j) - '0');
                int sum = mul + result[i + j + 1]; // Add to the current digit
                result[i + j] += sum / 10; // Carry
                result[i + j + 1] = sum % 10; // Store the result digit
            }
        }

        // Convert result array to string
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            if (!(sb.length() == 0 && digit == 0)) { // Skip leading zeros
                sb.append(digit);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }  
    public static void main(String[] args) {
        String str1 = "123456789876";
        String str2 = "1212313";

        
        System.out.println(multiply(str1, str2));
    }
}