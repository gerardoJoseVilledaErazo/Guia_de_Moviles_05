package com.example.orientacion_de_pantallas.models;

import java.io.Serializable;

public class ConversationModel implements Serializable {

    //Serializable lo que se busque es que me permita convertir el objeto a bytes
    private int imgContact;
    private String name, message, time;

    public ConversationModel(int imgContact, String name, String message, String time) {
        this.imgContact = imgContact;
        this.name = name;
        this.message = message;
        this.time = time;
    }

    public int getImgContact() {
        return imgContact;
    }

    public void setImgContact(int imgContact) {
        this.imgContact = imgContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ConversationModel{" +
                "imgContact=" + imgContact +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
