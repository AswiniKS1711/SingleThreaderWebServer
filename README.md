# Single Threaded Web Server

## Process :
When client wants to establish a connection with the server, both of them will use Socket API to do so.
The operating system in the client machine will open a PORT. 
Similarly, a PORT will be opened on the server side too.

A PORT on the server side will be in listen() state always to check if any client wants to establish a connection.
If the server finds out that a client wants to establish a connection, it will open up another PORT for data communication with the client.
So, data transfer occurs using a different PORT on the server side, and not by the PORT it listens to incoming connections.

Since, it is a Single Threaded Web Server, so server can establish a connection with a single client at a given time. 
Once, the connection is stopped between the server and the client, then only the Server will be able to open a socket and establish a new connection with another client.
