package DHT;

import java.io.*;
import java.net.Socket;

/**
 *  A Service is a thread that logs and prints activity of a node in network.
 */
public class Service extends Thread {

//  p2p node that connected to this server.
    private Node peer;
//  Socket of connected peer node.
    private Socket socket = null;

    public Service(Socket socket, Node peer) {
        super("Service " + socket.getInetAddress());
        this.socket = socket;
        this.peer = peer;
    }

    /**
     * Logs to status of node in a file.
     * @param info Information to be logged.
     */
    public static void log(String info){
        try {

            PrintStream out = new PrintStream(new FileOutputStream("p2p.log", true));
            out.println(info);

        } catch (FileNotFoundException e) {

            System.out.println("No log file found.");
            e.printStackTrace();
            System.exit(-1);

        }
    }

    public void run() {
        try {

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            String inputLine;
            String outputLine;

            log("=== Peer " + peer.id + " logs ===");

            while ((inputLine = in.readLine()) != null) {

                log("Received -" + " Peer : "+ peer.id +" Port Number: "+ peer.port +" "+ inputLine);
                outputLine = this.peer.Protocol(inputLine).toString();

                log("Sent -" + " Peer : "+ peer.id +" Port Number: "+ peer.port +"     "+outputLine);
                out.println(outputLine);

                if (outputLine.equals("EXIT")){
                    break;
                }

                System.out.println(peer.toString());
            }

            // Close everything.
            out.close();
            in.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}