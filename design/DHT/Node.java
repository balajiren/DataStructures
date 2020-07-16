package DHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.text.Utilities;

public class Node extends Thread {

    public int id;
    public int port;
    private String hostname;

    private boolean isFirstPeer = false;

    private int nextPeerId;
    private int nextPeerPort;
    private String nextPeerHostName;

    private int previousPort;
    private String previousHostName;

    private Hashtable<Integer, String> hashTable;

    public Node(String hostname, int port) {
        this.id = 1;
        this.hostname = hostname;
        this.port = port;
        this.isFirstPeer = true;
        this.previousHostName = this.hostname;
        this.previousPort = this.port;
        this.nextPeerHostName = this.hostname;
        this.nextPeerId = this.id;
        this.nextPeerPort = this.port;
        this.hashTable = new Hashtable<Integer, String>();
    }

    public Node(String hostname, int port, int previousPeerId, String previousHostName, int previousPort) {
        this.id = previousPeerId + 1;
        this.hostname = hostname;
        this.port = port;
        this.isFirstPeer = false;
        this.previousHostName = previousHostName;
        this.previousPort = previousPort;
        this.hashTable = new Hashtable<Integer, String>();
    }

    @Override
    public String toString(){
        return "Hostname: "+ this.hostname
                + " Port: "+ this.port
                + " Id: " + this.id
                + " NextHostname: " + this.nextPeerHostName
                + " NextPort: "+ this.nextPeerPort
                + " NextID: "+ this.nextPeerId
                + " isFirstPeer: " + this.isFirstPeer
                + " HashTable: " +this.hashTable.toString();
    }

    /**
     * A method to generate request.
     * @param operation Operation code.
     * @param numOfLines Number of lines in request.
     * @param peerId Peer Identification.
     * @return Request object.
     */
    public Request generateRequest(String operation, int numOfLines, int peerId){
        if(peerId == -1){
            return new Request(operation,
                    Settings.getInstance().Version, numOfLines);
        }
        return new Request(operation,
                Settings.getInstance().Version, numOfLines, peerId);
    }

    public Request generateRequest(String message){

        String[] ArrayMessage = message.trim().split("EOL");

        String version = null;
        String operation = null;
        int numOfLines = 0;
        int peerId = -1;

        ArrayList<String> Message = new ArrayList<String>();
        for(String str : ArrayMessage){
            if(str.toUpperCase().contains(Settings.getInstance().Version.toUpperCase())){
                String[] wordsInLine = str.trim().split("\\s+");
                operation = wordsInLine[0];
                version = wordsInLine[1];
                numOfLines = Integer.parseInt(wordsInLine[2]);
                if(wordsInLine.length == 5){
                    peerId = Utility.parseInt(wordsInLine[3]);
                }
            }
            else{
                Message.add(str);
            }
        }
        if(peerId == -1 && Message.size() == 0){
            return new Request(operation, version, numOfLines);
        }else if(peerId == -1 && Message.size() > 0)
        {
            return new Request(operation, version, numOfLines, Message);
        }
        else
        {
            return new Request(operation, version, numOfLines, peerId, Message);
        }
    }

    /**
     * A method to generate a Response object.
     * @param message Content of message.
     * @return Response object.
     */
    public Response generateResponse(String message){

        String[] ArrayMessage = message.trim().split("EOL");

        String version =  null;
        String operation = null;
        int numOfLines = 0;
        int responseCode = 0;
        String responseCodeMsg = null;

        ArrayList<String> responseMessage = new ArrayList<String>();
        for(String strValue : ArrayMessage){
            if(strValue.contains(Settings.getInstance().Version)){
                String[] wordsInLine = strValue.trim().split("\\s+");
                version = wordsInLine[0];
                operation = wordsInLine[1];
                numOfLines = Utility.parseInt(wordsInLine[2]);
                responseCode = Utility.parseInt(wordsInLine[3]);
                responseCodeMsg = wordsInLine[4];
            }
            else{
                responseMessage.add(strValue);
            }
        }
        Response response = new Response(version, operation, numOfLines, responseCode, responseCodeMsg, responseMessage);
        return response;
    }

    /**
     * A method to process messages send and received by peer.
     * @param message Message
     */
    public String Protocol(String message){
        if(message.contains("ID"))
        {
            String messagePrefix = message.toUpperCase().trim().split("\\s+")[0];
            if(messagePrefix.equals(Settings.getInstance().Version.toUpperCase()))
                return IDQueryResponseProcess(generateResponse(message)).toString();
            else
                return IDQueryRequestProcess(generateRequest(message)).toString();
        }
        else if(message.contains("NEXT"))
        {
            String messagePrefix = message.toUpperCase().trim().split("\\s+")[0];
            if(messagePrefix.equals(Settings.getInstance().Version.toUpperCase())){
                return nextQueryResponseProcess(generateResponse(message)).toString();
            } else {
                return nextQueryRequestProcess(generateRequest(message)).toString();
            }
        }
        else if(message.contains("PULL"))
        {
            String messagePrefix = message.toUpperCase().trim().split("\\s+")[0];
            if(messagePrefix.equals(Settings.getInstance().Version.toUpperCase()))
                return pullQueryResponseProcess(generateResponse(message)).toString();
            else
                return pullQueryRequestProcess(generateRequest(message)).toString();
        }
        else if(message.contains("ADD"))
        {
            String messagePrefix = message.toUpperCase().trim().split("\\s+")[0];
            if(messagePrefix.equals(Settings.getInstance().Version.toUpperCase()))
                return addQueryResponseProcess(generateResponse(message)).toString();
            else
                return addQueryRequestProcess(generateRequest(message)).toString();
        }
        else if(message.contains("QUERY"))
        {
            String messagePrefix = message.toUpperCase().trim().split("\\s+")[0];
            if(messagePrefix.equals(Settings.getInstance().Version.toUpperCase()))
                return queryResponseProcess(generateResponse(message)).toString();
            else
                return queryRequestProcess(generateRequest(message)).toString();

        }
        else if(message.contains("RETRIEVE"))
        {
            String messagePrefix = message.toUpperCase().trim().split("\\s+")[0];
            if(messagePrefix.equals(Settings.getInstance().Version.toUpperCase()))
                return retrieveQueryResponseProcess(generateResponse(message)).toString();
            else
                return retrieveQueryRequestProcess(generateRequest(message)).toString();

        }
        else if(message.contains("REMOVE"))
        {
            String messagePrefix = message.toUpperCase().trim().split("\\s+")[0];
            if(messagePrefix.equals(Settings.getInstance().Version.toUpperCase()))
                return removeQueryResponseProcess(generateResponse(message)).toString();
            else
                return removeQueryRequestProcess(generateRequest(message)).toString();

        }
        else if(message.contains("INFO")){
            return this.toString();
        }
        return "";
    }

    /**
     * sendPreviousClient : A method to connect previous node in network.
     * @param message Message to send previous node.
     */
    public void sendPreviousClient(String message){
        try{
            this.client(previousHostName, previousPort, message);
        }  catch (IOException e){
            System.out.println("Redirect Client Error.");
        }
    }

    /**
     * sendNextClient : A method to connect next node in network.
     * @param message Message to send next node.
     */
    public void sendNextClient(String message){
        try{
            this.client(nextPeerHostName, nextPeerPort, message);
        }  catch (IOException e){
            System.out.println("Next Client Error.");
        }
    }

    /**
     * IDQueryResponseProcess : A method to processes an ID query response object.
     * @param response Response to be processed.
     * @return Generates a request object.
     */
    public Request IDQueryResponseProcess(Response response){
        switch(response.responseCode){
            case 301:
                String[] msg = response.message.get(0).trim().split("\\s+");
                previousHostName = msg[0];
                previousPort = Utility.parseInt(msg[1]);
                sendPreviousClient(generateRequest("ID", 0, id).toString());
                return generateRequest("ID", 0, id);
            case 200:
                sendPreviousClient(generateRequest("NEXT", 0, 0).toString());
                return generateRequest("NEXT", 0, 0);
            default:
                sendPreviousClient(generateRequest("ID", 0, id).toString());
                return generateRequest("ID", 0, id);
        }
    }

    /**
     * IDQueryRequestProcess : A method processes an ID query request.
     * @param request Request to be processed.
     * @return Generates a response object.
     */
    public Response IDQueryRequestProcess(Request request){
        ArrayList<String> responseMessage = new ArrayList<String>();
        if(id < nextPeerId && request.peerId > id && request.peerId > nextPeerId)
        {
            responseMessage.add(nextPeerHostName +" "+ nextPeerPort);
            return new Response(Settings.getInstance().Version, "ID", 1, 301, "Redirect", responseMessage);
        }
        else if(request.peerId > id && request.peerId < nextPeerId ||
                id > nextPeerId && request.peerId > id)
        {
            return new Response(Settings.getInstance().Version, "ID", 0, 200, "OK", responseMessage);
        }
        else if(id == nextPeerId)
        {
            if(id > request.peerId){
                return new Response(Settings.getInstance().Version, "ID", 0, 200, "OK", responseMessage);
            }
            else
            {
                //
                // Need more controls in here, this is what this DHT simple.
                //
                return nextQueryRequestProcess(request);
            }
        }
        else if(request.peerId == id){
            return new Response(Settings.getInstance().Version, "ID", 0, 400, "PeerExist", responseMessage);
        }
        else if(!request.version.trim().equals(Settings.getInstance().Version)){
            return new Response(Settings.getInstance().Version, "ID", 0, 401, "VersionError", responseMessage);
        }
        else
        {
            return new Response(Settings.getInstance().Version, "ID", 0, 503, "UnknownCondition", responseMessage);
        }
    }

    /**
     * nextQueryRequestProcess : A method to process Next query request.
     * @param request Request to be processed.
     * @return Generates a response object.
     */
    public Response nextQueryRequestProcess(Request request){
        ArrayList<String> responseMessage = new ArrayList<String>();
        if(hostname.isEmpty() || port == 0){
            return new Response(Settings.getInstance().Version, "NEXT", 0, 501, "NextDoesNotExist", responseMessage);
        }
        responseMessage.add(nextPeerHostName +" "+ nextPeerPort +" "+ nextPeerId);
        return new Response(Settings.getInstance().Version, "NEXT", 1, 200, "OK", responseMessage);
    }

    /**
     * nextQueryResponseProcess : A method to process next query response.
     * @param response Response to be processed.
     * @return Generates request object.
     */
    public Request nextQueryResponseProcess(Response response){
        switch(response.responseCode){
            case 200:
                String[] msg = response.message.get(0).trim().split("\\s+");
                nextPeerHostName = msg[0];
                nextPeerPort = Utility.parseInt(msg[1]);
                nextPeerId = Utility.parseInt(msg[2]);
                ArrayList<String> message = new ArrayList<String>();
                message.add(this.hostname +" "+ this.port+" "+this.id);
                sendPreviousClient(new Request("PULL", Settings.getInstance().Version, 1, id, message).toString());
                return new Request("PULL", Settings.getInstance().Version, 1, id, message);
            case 501:
                sendPreviousClient(new Request("NEXT", Settings.getInstance().Version, 0).toString());
                return new Request("NEXT", Settings.getInstance().Version, 0);
            default:
                return new Request();
        }
    }

    /**
     * pullQueryRequestProcess : A method to process Pull query request.
     * @param request Request to be processed.
     * @return Generates response object.
     */
    public Response pullQueryRequestProcess(Request request){
        String[] msg = request.message.get(0).trim().split("\\s+");
        nextPeerHostName = msg[0];
        nextPeerPort = Utility.parseInt(msg[1]);
        nextPeerId =  Utility.parseInt(msg[2]);
        ArrayList<String> responseMessage = new ArrayList<String>();
        responseMessage.add("dummy");
        return new Response(Settings.getInstance().Version, "PULL", 1, 200, "OK", responseMessage);
    }

    /**
     * pullQueryResponseProcess : A method to process pull query response.
     * @param response Response to be processed.
     * @return Generates request object.
     */
    public Request pullQueryResponseProcess(Response response){
        switch(response.responseCode){
            case 200:
                sendPreviousClient(new Request("DONE", Settings.getInstance().Version, 0).toString());
                return new Request("DONE", Settings.getInstance().Version, 0);
            default:
                return new Request();
        }
    }

    /**
     * addQueryRequestProcess : A method to process add query request.
     * @param request Request to be processed.
     * @return Generates response object.
     */
    public Response addQueryRequestProcess(Request request){
        ArrayList<String> responseMessage = new ArrayList<String>();
        String msg = request.message.get(0).trim();
        int key = Utility.getKey(msg);
        if(hashTable.containsValue(msg)) {
            return new Response(Settings.getInstance().Version, "ADD", 0, 202, "Duplicate", responseMessage);
        } else if(id < key && nextPeerId < key
                || id == key){
        	hashTable.put(key, msg);
            return new Response(Settings.getInstance().Version, "ADD", 0, 200, "OK", responseMessage);
        } else {
            responseMessage.add(msg);
            sendNextClient(new Request("ADD", Settings.getInstance().Version, 0, id, responseMessage).toString());
            return new Response(Settings.getInstance().Version, "ADD", 0, 400, "NotResponsible", responseMessage);
        }

    }

    /**
     * addQueryResponseProcess : A method Process Add query response.
     * @param response Response to be processed.
     * @return Generates request object.
     */
    public Request addQueryResponseProcess(Response response){
        return new Request("DONE", Settings.getInstance().Version, 0);
    }

    /**
     * retrieveQueryRequestProcess : A method to process retrieve query request.
     * @param request Request to be processed.
     * @return Generates response object.
     */
    public Response retrieveQueryRequestProcess(Request request){
        ArrayList<String> responseMessage = new ArrayList<String>();
        String msg = request.message.get(0).trim();
        int key = Utility.parseInt(msg);
        if(hashTable.containsKey(key)){
        	String value = hashTable.get(key);
        	responseMessage.add("\nFound at peer: "+id+" at key: "+key+" with value: "+value);
            return new Response(Settings.getInstance().Version, "RETRIEVE", 0, 200, "OK", responseMessage);
        } else if(id < key && nextPeerId < key
                || id == key) {
            return new Response(Settings.getInstance().Version, "RETRIEVE", 0, 201, "NotPresent", responseMessage);
        } else {
            responseMessage.add(msg);
            sendNextClient(new Request("RETRIEVE", Settings.getInstance().Version, 0, id, responseMessage).toString());
            return new Response(Settings.getInstance().Version, "RETRIEVE", 0, 400, "NotResponsible", responseMessage);
        }
    }

    /**
     * retrieveQueryResponseProcess : A method to process retrieve query response.
     * @param response Response to be processed.
     * @return Generates a request object.
     */
    public Request retrieveQueryResponseProcess(Response response){
        return new Request("DONE", Settings.getInstance().Version, 0);
    }

    /**
     * removeQueryRequestProcess : A method to process remove query request.
     * @param request Request to be processed.
     * @return Generates response object.
     */
    public Response removeQueryRequestProcess(Request request){
        ArrayList<String> responseMessage = new ArrayList<String>();
        String msg = request.message.get(0).trim();
        int key = Utility.parseInt(msg);
        if(hashTable.containsKey(key)){
        	String value = hashTable.get(key);
        	hashTable.remove(key);
        	responseMessage.add("\nRemoved at peer: "+id+" at key: "+key+" with value: "+value);
            return new Response(Settings.getInstance().Version, "REMOVE", 0, 200, "OK", responseMessage);
        } else if(id < key && nextPeerId < key
                || id == key) {
            return new Response(Settings.getInstance().Version, "REMOVE", 0, 201, "NotPresent", responseMessage);
        } else {
            responseMessage.add(msg);
            sendNextClient(new Request("REMOVE", Settings.getInstance().Version, 0, id, responseMessage).toString());
            return new Response(Settings.getInstance().Version, "REMOVE", 0, 400, "NotResponsible", responseMessage);
        }
    }

    /**
     * removeQueryResponseProcess : A method to process remove query response.
     * @param response Response to be processed.
     * @return Generates a request object.
     */
    public Request removeQueryResponseProcess(Response response){
        return new Request("DONE", Settings.getInstance().Version, 0);
    }

    /**
     * queryRequestProcess : A method to process query request.
     * @param request Request to be processed.
     * @return Generates response object.
     */
    public Response queryRequestProcess(Request request){
        ArrayList<String> responseMessage = new ArrayList<String>();
        String msg = request.message.get(0).trim();
        int key = Utility.getKey(msg);
        if(hashTable.containsValue(msg)){
        	responseMessage.add("\nFound at peer: "+id+" at key: "+key+" ");
            return new Response(Settings.getInstance().Version, "QUERY", 0, 200, "OK", responseMessage);
        } else if(id < key && nextPeerId < key
                || id == key) {
            return new Response(Settings.getInstance().Version, "QUERY", 0, 201, "NotPresent", responseMessage);
        } else {
            responseMessage.add(msg);
            sendNextClient(new Request("QUERY", Settings.getInstance().Version, 0, id, responseMessage).toString());
            return new Response(Settings.getInstance().Version, "QUERY", 0, 400, "NotResponsible", responseMessage);
        }
    }

    /**
     * queryResponseProcess : A method to process query response.
     * @param response Response to be processed.
     * @return Generates a request object.
     */
    public Request queryResponseProcess(Response response){
        return new Request("DONE", Settings.getInstance().Version, 0);
    }

    /**
     * client : A method to deal with communication with other nodes.
     * @param hostname Node's hostname.
     * @param port Node's port number.
     * @param command Command message to be processed.
     * @throws IOException Input/Output exception.
     */
    public void client(String hostname, int port, String command) throws IOException {

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            System.setProperty("java.net.preferIPv4Stack", "true");
            socket = new Socket(hostname, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Unknown host");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Client I/O error.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromService;

        out.println(command);

        if ((fromService = in.readLine()) != null) {
            this.Protocol(fromService);
            System.out.println(this.toString());
        }
        out.close();
        in.close();
        stdIn.close();
        socket.close();
    }

    /**
     * To run thread for peer node.
     */
    public void run(){
        if(!isFirstPeer){
            String startRequest = generateRequest("ID", 0, id).toString();
            try {
                client(previousHostName, previousPort, startRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
