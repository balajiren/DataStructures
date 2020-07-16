package String;

public class SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int count=0;
        int line = cols;
        int lines = 0;
        int next = 0;
        while(next< sentence.length) {
            while(line >= sentence[next].length()) {
                line-=sentence[next].length()+1;
                next++;
                if(next >=sentence.length) {
                    count++;
                    next=0;
                }
            }
            lines++;
            line=cols;
            if(lines >=rows) {
                break;
            }

        }

        return count;
    }
}
