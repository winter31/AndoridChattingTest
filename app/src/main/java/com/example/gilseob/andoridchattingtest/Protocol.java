package com.example.gilseob.andoridchattingtest;

import java.io.Serializable;

/**
 * Created by GILSEOB on 2017-07-09.
 */

public class Protocol implements Serializable {

    String clientIpCon;
    String sendMessageText;
    String receiveMessageText;
    String serverIpcon;

    public Protocol() {

    }

    public String getClientIpCon() {
        return clientIpCon;
    }

    public void setClientIpCon(String clientIpCon) {
        this.clientIpCon = clientIpCon;
    }

    public String getSendMessageText() {
        return sendMessageText;
    }

    public void setSendMessageText(String sendMessageText) {
        this.sendMessageText = sendMessageText;
    }

    public String getReceiveMessageText() {
        return receiveMessageText;
    }

    public void setReceiveMessageText(String receiveMessageText) {
        this.receiveMessageText = receiveMessageText;
    }

    public String getServerIpcon() {
        return serverIpcon;
    }

    public void setServerIpcon(String serverIpcon) {
        this.serverIpcon = serverIpcon;
    }

    @Override
    public String toString() {
        return "Protocol{" +
                "clientIpCon='" + clientIpCon + '\'' +
                ", sendMessageText='" + sendMessageText + '\'' +
                ", receiveMessageText='" + receiveMessageText + '\'' +
                ", serverIpcon='" + serverIpcon + '\'' +
                '}';
    }
}
