package DHT;

import java.util.ArrayList;

/**
 * Wrapper object for request messages.
 */

public class Request {
    public String operation;
    public String version;
    public int numOfLines;
    public int peerId;
    public ArrayList<String> message;

    public Request(String operation, String version, int numOfLines) {
        this.operation = operation;
        this.version = version;
        this.numOfLines = numOfLines;
        this.message = new ArrayList<String>();
    }
    public Request(String operation, String version, int numOfLines, int peerId){
        this.operation = operation;
        this.version = version;
        this.numOfLines = numOfLines;
        this.peerId = peerId;
        this.message = new ArrayList<String>();
    }
    public Request(String operation, String version, int numOfLines, ArrayList<String> responseMessage){
        this.operation = operation;
        this.version = version;
        this.numOfLines = numOfLines;
        this.message = responseMessage;
    }
    public Request(String operation, String version, int numOfLines, int peerId, ArrayList<String> responseMessage){
        this.operation = operation;
        this.version = version;
        this.numOfLines = numOfLines;
        this.peerId = peerId;
        this.message = responseMessage;
    }

    public Request() {}

    public String toString()
    {
        if(message.size() > 0)
        {
            String msg = "";
            for(String str : message){
                msg += str + " EOL";
            }
            if(peerId > 0)
                return operation +" "+ version +" "+ numOfLines +" "+ peerId + " EOL" + msg;
            else
                return operation +" "+ version +" "+ numOfLines + " EOL" + msg;
        }
        else if(peerId == 0)
        {
            return operation +" "+ version +" "+ numOfLines +" EOL";
        }
        return operation +" "+ version +" "+ numOfLines +" "+ peerId +" EOL";
    }
}
