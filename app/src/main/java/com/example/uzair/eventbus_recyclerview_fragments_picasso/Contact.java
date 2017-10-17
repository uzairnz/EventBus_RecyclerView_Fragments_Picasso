package com.example.uzair.eventbus_recyclerview_fragments_picasso;

/**
 * Created by UZAIR on 10/16/2017.
 */

public class Contact {

    private String name, number;
    private int image;
    private String call;
    private String email;

    public Contact() {
    }

    public Contact(String name, String number, int image, String call, String email) {
        this.name = name;
        this.number = number;
        this.image = image;
        this.call = call;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getCall() {
        return call;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = email;
    }

    public void deleteContact (int position)
    {
        this.name = null;
        this.number = null;
        this.image = 0  ;
        this.call = null;
        this.email = null;
    }

}
