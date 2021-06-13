package com.antsoftware.ejemplorecyclerview.db.models;

public class StudentsModel {
    private int registry;
    private String name;
    private int age;
    private String subjects;

    public StudentsModel(){}

    public StudentsModel(int registry, String name, int age) {
        this.registry = registry;
        this.name = name;
        this.age = age;
    }
    public StudentsModel(int registry, String name, int age, String subjects) {
        this.registry = registry;
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    public int getRegistry() {
        return registry;
    }

    public void setRegistry(int registry) {
        this.registry = registry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }
}
