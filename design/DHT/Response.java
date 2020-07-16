package DHT;

import java.util.ArrayList;

/**
 * Wrapper object for response messages.
 */

public class Response {
    public String version;
    public String operation;
    public int numOfLines;
    public int responseCode;
    public String responseCodeMsg;
    public ArrayList<String> message;

    public Response(String version, String operation, int numOfLines,
                    int responseCode, String responseCodeMsg, ArrayList<String> responseMessage){
        this.version = version;
        this.operation = operation;
        this.numOfLines = numOfLines;
        this.responseCode = responseCode;
        this.responseCodeMsg = responseCodeMsg;
        this.message = responseMessage;
    }

    public String toString()
    {
        if(message.size() > 0)
        {
            String msg = "";
            for(String str : message){
                msg += str + " EOL";
            }
            return version +" "+ operation +" "+ numOfLines +" "+ responseCode +" "+ responseCodeMsg +" EOL" + msg;
        }
        else{
            return version +" "+ operation +" "+ numOfLines +" "+ responseCode +" "+ responseCodeMsg +" EOL";
        }
    }
}