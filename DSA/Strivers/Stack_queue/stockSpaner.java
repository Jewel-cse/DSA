import java.util.ArrayList;
import java.util.List;

public class stockSpaner {
    List<Integer> st;
    public stockSpaner() {
        st = new ArrayList<>();
    }
    
    public int next(int price) {
        st.add(price);
        int count = 0;
        for (int i = st.size() - 1; i >= 0; i--) {
            if (st.get(i) <= price) {
                count++;
            } else
                break;
        }
        return count;
    }
}
