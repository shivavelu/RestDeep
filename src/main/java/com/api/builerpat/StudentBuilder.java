package com.api.builerpat;

public class StudentBuilder {

    private int id;
    private String first_name;
    private String second_name;
    private String email;

    public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public StudentBuilder setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public StudentBuilder setSecond_name(String second_name) {
        this.second_name = second_name;
        return this;
    }

    public StudentBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public static StudentBuilder builder(){
        return new StudentBuilder();
    }
    public StudentBuilder(){

    }

    public Student build(){
        return new Student(this.id, this.first_name,this.second_name,this.email);
    }
}
