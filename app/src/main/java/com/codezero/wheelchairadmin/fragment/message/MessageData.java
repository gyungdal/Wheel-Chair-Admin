package com.codezero.wheelchairadmin.fragment.message;

/**
 * Created by GyungDal on 2017-01-31.
 */

public class MessageData {
    private String idx, name, number, msg, company;
    public MessageData(String idx, String name, String number, String msg, String company){
        this.idx = idx;
        this.name = name;
        this.number = number;
        this.msg = msg;
        this.company = company;
    }
    public String getIdx(){return this.idx;}
    public String getName(){
        return this.name;
    }
    public String getNumber(){
        return this.number;
    }
    public String getMsg(){
        return this.msg;
    }
    public String getCompany(){
        return this.company;
    }
}
