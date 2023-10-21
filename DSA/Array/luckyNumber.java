import java.util.ArrayList

public class luckyNumber {
    public static void main(String[] args) {
        System.out.println(isLucky(5));
        
    }
    public static Boolean isLucky(int n)
    {
        ArrayList<Integer> lst = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lst.add(i);
            
        }
        //lst.remove(0);
        //System.out.println(lst.size()+" "+ n);
        int k = 1;
        while(k<n){
            for (int i = k; i < lst.size(); i += k) {  //every 2nd delete
                if(lst.get(i) == n)
                    return false;
                lst.remove(i);
                System.out.print(lst.get(i)+" ");
            }
            k++;
        }
        return true;
    }
}
