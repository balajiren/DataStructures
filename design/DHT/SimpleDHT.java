package DHT;

import java.io.IOException;
import java.net.ServerSocket;

public class SimpleDHT {

    public final static String HELP = "For usage of program please see README.md !";

    /**
     * InitializeNode : Processes command line arguments and intiliaze peer node.
     * @param commands Command line arguments.
     * @return A peer node.
     */
    public static Node InitializeNode(String[] commands)
    {
        try{
            if(commands[2].trim().toUpperCase().equals("F")){
                return new Node(commands[0], Integer.parseInt(commands[1]));
            } else {
                return new Node(commands[0], Integer.parseInt(commands[1]),
                        Integer.parseInt(commands[2]),
                        commands[3], Integer.parseInt(commands[4]));
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Initialization error!");
            System.out.println(HELP);
            System.exit(0);
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        if(args.length > 0)
        {
            ServerSocket serviceSocket = null;
            // Start node.
            Node peer = InitializeNode(args);
            peer.run();

            try {

                serviceSocket = new ServerSocket(peer.port);
                System.out.println("Service for " + peer.port + " started!");
                // Start Peer listening service.
                while (true) {
                    new Service(serviceSocket.accept(), peer).start();
                }
            } catch (IOException e) {

                System.err.println("Error while listening port: " + peer.port);
                if(serviceSocket != null){
                    serviceSocket.close();
                }
                System.exit(-1);
            }
        }
        else
        {
            System.out.println(HELP);
            System.exit(0);
        }
    }
}