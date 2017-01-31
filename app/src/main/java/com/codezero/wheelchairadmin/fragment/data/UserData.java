package com.codezero.wheelchairadmin.fragment.data;

/**
 * Created by GyungDal on 2017-01-31.
 */

public class UserData {
    private String modelNumber, companyName, userName, phoneNumber, modelAddress;
    public boolean isTitle;
    public UserData(){
        this.modelAddress = this.companyName = this.userName = this.phoneNumber = this.modelNumber = "";
        this.isTitle = true;
    }
    public UserData(String modelNumber, String companyName, String userName, String phoneNumber, String modelAddress){
        this.modelNumber = modelNumber;
        this.companyName = companyName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.modelAddress = modelAddress;
        this.isTitle = false;
    }
    public String getModelNumber(){
        return this.modelNumber;
    }
    public String getCompanyName() {
        return this.companyName;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getModelAddress(){
        return this.modelAddress;
    }
}
