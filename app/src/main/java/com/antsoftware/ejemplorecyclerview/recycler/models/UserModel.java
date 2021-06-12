package com.antsoftware.ejemplorecyclerview.recycler.models;

public class UserModel {
    private String id;
    private String name;
    private String age;
    private String cedula;

    public UserModel(){}
    public UserModel(String id,String name, String age, String cedula ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cedula = cedula;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
