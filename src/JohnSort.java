
import java.util.*;

public class TheBestName{
    public String[] sort(String[] names) {
       
    	public int compare(String a, String b) {
            if (a.equals(b)) return 0;
            if ("JOHN".equals(a)) return -1;
            if ("JOHN".equals(b)) return 1;

            int asum = 0; 
            for(int k=0; k < a.length(); k++){
                asum += a.charAt(k);
            }

            int bsum = 0;
            for(int k=0; k < b.length(); k++){
                bsum += b.charAt(k);
            }

            int diff = bsum - asum;
            if (diff != 0) return diff;
            return a.compareTo(b);      // default is to just sort
        }
    }
    
    public String[] sort(String[] arr){
        String[] ret = arr;
        Arrays.sort(ret, new APTComp());
        return ret;
    }
}