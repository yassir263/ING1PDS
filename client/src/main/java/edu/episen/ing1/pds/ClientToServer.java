package edu.episen.ing1.pds;
import java.io.*;
import java.net.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.episen.ing1.pds.socketconfiguration.socketConnection;
import org.apache.log4j.Logger;

public class ClientToServer {

    private final static Logger logger = Logger.getLogger(ClientToServer.class);

    public Socket client;
    private PrintWriter out;
    private BufferedReader in;
    private ObjectMapper mapper = new ObjectMapper();
    private socketConnection sc;

    public Request sendRequest(Request req) throws Exception {
        String request = mapper.writeValueAsString(req);
        out = new PrintWriter(client.getOutputStream(), true);
        out.println(request);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String responseString = responseString = in.readLine();
        logger.info("responseString : " + responseString);
        req.setData(responseString);
        this.close();
        return req;
    }

    public void clientListen() throws IOException {
        sc = new socketConnection();
        System.out.println("Client is listening in ip adresse " + sc.getIp() + ":" + sc.getPort());
        client = new Socket(sc.getIp(), sc.getPort());
    }


    public ClientToServer() {
    }

    public void close() throws IOException {
        out.close();
        in.close();
        client.close();
    }
}