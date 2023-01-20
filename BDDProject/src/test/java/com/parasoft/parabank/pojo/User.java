package com.parasoft.parabank.pojo;

import java.util.Random;
import java.util.stream.Collectors;

public class User {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String phone;
    private String ssn;
    private String username;

    private String accountNo;

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    private String Zipcode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSsn() {
//        String ssn = java.util.UUID.randomUUID().toString().split("-")[0];
//        System.out.println("returning ssn as " + ssn);
//        return ssn;
        return this.ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername() {

       // return firstName + lastName + System.currentTimeMillis();
        return this.username;
    }

    public String getPassword() {
       // String password = new Random().ints(10, 33, 122).mapToObj(i -> String.valueOf((char)i)).collect(Collectors.joining());

        String password = "Password@1";
        //System.out.println("returning password as " + password);
        return password;

    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phone='" + phone + '\'' +
                ", ssn='" + ssn + '\'' +
                ", username='" + username + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", Zipcode='" + Zipcode + '\'' +
                '}';
    }
}
