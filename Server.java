import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void run() throws IOException {
        int port = 8010; // we will define a port where our server will listen

        // Using ServerSocket class, we can define a port
        ServerSocket socket = new ServerSocket(port); // we opened a socket in the port 8010

        socket.setSoTimeout(10000); // we opened the socket port for 10secs

        // We did this to free the port every 10secs, or else we will face difficulties
        // to acquire that port everytime.
        // This is because port will be already in use, if we dont close the scoket.

        while (true) {
            try {
                System.out.println("Server is listening on Port " + port);

                Socket acceptedConnection = socket.accept(); // if a client requests for connection, we can accept it.

                System.out.println("Connection accepted from client in " + acceptedConnection.getRemoteSocketAddress()
                        + " address.");
                // getRemoteSocketAddress() will return the address of the socket of our client

                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
                // getOutputStream() will return output stream.
                // PrintWriter wants an output stream.
                // So, we passed the output stream to PrintWriter

                /*
                 * An OutputStream in Java sockets is used for sending data from the client to
                 * the server or from the server to the client.
                 */

                /*
                 * An InputStream in Java sockets is used for reading data sent from the server
                 * to
                 * the client or from the client to the server.
                 */

                /* PrintWriter will convert the text into bytes and send them to the Client */

                /*
                 * BuffereReader will combine the bytes of data coming from Client's side to
                 * give the results
                 */

                BufferedReader fromClient = new BufferedReader(
                        new InputStreamReader(acceptedConnection.getInputStream()));

                toClient.println("Hello from the Server");
                // this message will be converted into bytes and send to the Client

                toClient.close();
                fromClient.close();
                acceptedConnection.close();

            } catch (IOException e) {
                e.printStackTrace();

            }

        }
    }

    public static void main(String args[]) {

        Server server = new Server();
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}