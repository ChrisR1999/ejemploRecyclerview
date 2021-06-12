package com.antsoftware.ejemplorecyclerview.db.models;

public class SubjectsBoardModel {
    private int id;
    private int fkStudent;
    private int fkSubject;

    public SubjectsBoardModel(){}

    public SubjectsBoardModel(int id, int fkStudent, int fkSubject) {
        this.id = id;
        this.fkStudent = fkStudent;
        this.fkSubject = fkSubject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkStudent() {
        return fkStudent;
    }

    public void setFkStudent(int fkStudent) {
        this.fkStudent = fkStudent;
    }

    public int getFkSubject() {
        return fkSubject;
    }

    public void setFkSubject(int fkSubject) {
        this.fkSubject = fkSubject;
    }
}
