package edu.episen.ing1.pds;

public class Request {

    private String nameRequest;
    private Object data;
    private Object sendingdata;

    public String getNameRequest() {
        return nameRequest;
    }

    public void setNameRequest(String nameRequest) {
        this.nameRequest = nameRequest;
    }

    public Object getData() {
        return data;
    }

    public Request() {

    }


    public Request(String name) {
        this.nameRequest = name;
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