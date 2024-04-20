import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class Client {

    public void run() throws UnknownHostException, IOException {

        int port = 8010;

        /*
         * "localhost" will give the IP address of my machine and it will be assigned to
         * InetAddress
         */
        InetAddress address = InetAddress.getByName("localhost");

        // we opened a socket for the given address and port
        Socket socket = new Socket(address, port);

        PrintWriter toServer = new PrintWriter(socket.getOutputStream());
        // PrintWriter will convert the data into bytes and send it to the Server

        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // BufferedReader will convert the data bytes coming from Server side to give
        // the actual result

        toServer.println("Hello from the Client");

        String line = fromServer.readLine(); // readLine() will give the results coming from Server side

        System.out.println("Response from the Server is " + line);

        toServer.close();
        fromServer.close();
        socket.close();
    }

    public static void main(String args[]) {
        try {
            Client client = new Client();
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
