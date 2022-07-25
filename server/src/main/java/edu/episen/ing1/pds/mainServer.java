package edu.episen.ing1.pds;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import com.google.gson.Gson;
import edu.episen.ing1.pds.server.databaseconnection.ConnectionCrud;
import edu.episen.ing1.pds.server.databaseconnection.JBDCconnection;
import edu.episen.ing1.pds.server.databaseconnection.Request;
import edu.episen.ing1.pds.server.serverconfiguration.serverConfig;
import edu.episen.ing1.pds.view.Problem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Text;

public class mainServer {
    private final static Logger logger = LoggerFactory.getLogger("Run Server");
    private static Socket socketClient;








    private static void constructOutputStream(Socket socket, Object message) throws IOException, InterruptedException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        //logger.info(message);
        out.println(message);
        logger.info("message envoyé");
    }

    private static void analyseInputStream(Socket socket, Request req){
        Object result = null;










        try {
            JBDCconnection conn = new JBDCconnection();
            conn.addNewConnection();
            ConnectionCrud connCrud = new ConnectionCrud();
            connCrud.setConnection(conn.getConnections().get(conn.getConnections().size()-1));



            switch (req.getNameRequest()){
                case "getBadges" : result = connCrud .getBadges();
                break;
                case "getEmployee" : result = connCrud .getEmployee();
                break;
                case "addProblem" :

                connCrud .addProblem("hhh");




                break;
                default: result = "No data found";

            }



            constructOutputStream(socket, result);
            socket.close();
            conn.closeAllConnections();
            conn.removeAllConnections();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    private static Request getRequest(Socket socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String received = in.readLine();
        Gson g = new Gson();
        Request req = g.fromJson(received, Request.class);
        return req;
    }

    private static ServerSocket runServer() throws IOException {
        Socket socketClient;
        serverConfig sc = new serverConfig();
        System.out.println("Server is running in port : " + sc.getPort());
        ServerSocket socketServer = new ServerSocket(sc.getPort());
        return socketServer;
    }

    private static Socket addClient(ServerSocket socketServer) throws IOException {
        socketClient = socketServer.accept();
        logger.info("new Client");
        return socketClient;
    }


    public static void main(String[] args) throws IOException {
        ServerSocket socketServer = runServer();
        Socket socket;
        Request req;

        while (true){
            socket = addClient(socketServer);
            req = getRequest(socket);
            analyseInputStream(socket,req);

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
