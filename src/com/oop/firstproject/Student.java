package com.oop.firstproject;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    private int id;
    private static AtomicInteger count = new AtomicInteger(0);
    private String name;
    private Gender gender;
    private String email;
    private LocalDate birthDate;
    private String photo;
    private double mark;
    private String comment;

    public Student(int id, String name, Gender gender, String email, LocalDate birthDate, String photo, double mark, String comment){
        this.id = count.incrementAndGet();
        this.name = name;
        this.gender = gender;
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
           throw new IllegalArgumentException("This email address doesn't match the expected format");
        }
        this.email = email;

        if (birthDate.getYear() < 1980 || birthDate.getYear() > 2009){
            throw new IllegalArgumentException("The birthdate isn't valid, user must be born between 1980 and 2009");
        }
        this.birthDate = birthDate;

        if(!photo.matches("^(?:[a-zA-Z]:\\\\)?[^\\\\/:*?\"<>|]+\\\\[^\\\\/:*?\"<>|]+\\.(?:jpg|jpeg|png)$")){
            throw new IllegalArgumentException("The photo path doesn't match the expected format");
        }
        this.photo = photo;

        if (mark < 0 || mark > 20){
            throw new IllegalArgumentException("The mark must be between 0 and 20");
        }
        this.mark = mark;

        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            throw new IllegalArgumentException("This email address doesn't match the expected format");
        }
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate.getYear() < 1980 || birthDate.getYear() > 2009){
            throw new IllegalArgumentException("The birthdate isn't valid, user must be born between 1980 and 2009");
        }
        this.birthDate = birthDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        if(!photo.matches("^(?:[a-zA-Z]:\\\\)?[^\\\\/:*?\"<>|]+\\\\[^\\\\/:*?\"<>|]+\\.(?:jpg|jpeg|png)$")){
            throw new IllegalArgumentException("The photo path doesn't match the expected format");
        }
        this.photo = photo;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        if (mark < 0 || mark > 20){
            throw new IllegalArgumentException("The mark must be between 0 and 20");
        }
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        String result = "Student : \n";
        result += "- id : " + this.id + "\n";
        result += "- name : " + this.name + "\n";
        result += "- gender : " + this.gender + "\n";
        result += "- email : " + this.email + "\n";
        result += "- birthDate : " + this.birthDate + "\n";
        result += "- path to photo : " + this.photo + "\n";
        result += "- mark : " + this.mark + "\n";
        result += "- comment : " + this.comment + "\n";
        return result;
    }
}
