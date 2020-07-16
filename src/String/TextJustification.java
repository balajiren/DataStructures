package String;
import java.util.*;

public class TextJustification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<String> fullJustify(String[] words, int maxWidth) {
	        List<String> res = new ArrayList<>();
	        int len = 0;
	        List<String> list = new ArrayList<>();
	        for (String w : words) {
	            if (len + w.length() > maxWidth) {
	                res.add(toString(list, maxWidth, len));
	                len = 0;
	                list = new ArrayList<>();
	            }
	            len += w.length() + 1;
	            list.add(w);
	        }
	        if (list.size() > 0) {
	            StringBuilder last = new StringBuilder(list.get(0));
	            for (int i = 1; i < list.size(); i++) {
	                last.append(" ");
	                last.append(list.get(i));
	            }
	            int spaces = maxWidth - last.length();
	            for (int i = 0; i < spaces; i++) last.append(" ");
	            res.add(last.toString());
	        }
	        return res;
	    }
	    
	    private String toString(List<String> list, int maxWidth, int len) {
	        StringBuilder sb = new StringBuilder();
	        if (list.size() == 1) {
	            sb.append(list.get(0));
	            for (int i = 0; i < maxWidth - list.get(0).length(); i++) sb.append(" ");
	            return sb.toString();
	        }
	        int textLen = len - list.size();
	        int spaces = maxWidth - textLen;
	        int avg = spaces / (list.size() - 1);
	        int extra = spaces % (list.size() - 1);
	        for (int i = 0; i < list.size() - 1; i++) {
	            sb.append(list.get(i));
	            for (int j = 0; j < avg; j++) sb.append(" ");
	            if (extra-- > 0) sb.append(" ");
	        }
	        sb.append(list.get(list.size() - 1));
	        return sb.toString();
	    }
}
