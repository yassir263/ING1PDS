package edu.episen.ing1.pds.server.databaseconnection;

public class Request {

    private String nameRequest;
    private Object data;

    public String getNameRequest() {
        return nameRequest;
    }
    public void setNameRequest(){

    }

    public void setNameRequest(String nameRequest) {
        this.nameRequest = nameRequest;
    }

    public Object getData() {
        return data;
    }

    public Request() {

    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Request{" +
                "nameRequest='" + nameRequest + '\'' +
                ", data=" + data +
                '}';
    }
}