package String;

public class DecodeString {

    public String decodeString(String s) {
        StringBuffer result = new StringBuffer();
        int currentInt =0;
        for(int i=0;i<s.length();i++) {

            Character c = s.charAt(i);
            if(c >= '0' && c<='9') {
                currentInt = currentInt*10 + (c-'0');
            } else {
                if(c =='[') {

                    int count=1;
                    i++;
                    StringBuffer sb = new StringBuffer();
                    while(count!=0) {
                        if(s.charAt(i) == '[') count++;
                        if(s.charAt(i) == ']') count--;
                        if(count!=0) sb.append(s.charAt(i++));

                    }
                    for(int j=0;j<currentInt;j++) {

                        result.append(decodeString(sb.toString()));
                    }
                    currentInt=0;


                } else {
                    result.append(c);
                }



            }


        }
        return result.toString();
    }



}
