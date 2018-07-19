package com.di;

public class details {

    private  String username;
    private  int age;
    private  String gender;


    @Override
    public String toString() {

         return super.toString() + "details{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public details(String username, int age, String gender) {
        this.username=username;
        this.age=age;
        this.gender=gender;


    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
