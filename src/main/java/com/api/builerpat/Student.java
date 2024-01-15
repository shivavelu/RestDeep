package com.api.builerpat;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class Student {

    private int id;
    private String first_name;
    private String second_name;
    private String email;

    public Student(int id, String first_name, String second_name, String email) {
        this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.email = email;
    }
    public Student(){

    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getEmail() {
        return email;
    }

  public String toString(){
        return "["+ this.id+","+this.first_name+","+this.second_name+","+this.email+"]";
  }

 // static inncer class object call method, this will not be required incase of external builder implementation
  public static StudentBuilder builder(){
        return new StudentBuilder();
  }

  /* Internal implementation using static inner class concept, this is how implemented by having lambok @Builder annotation */
  public static class StudentBuilder{
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
      public Student build(){
          return new Student(this.id,this.first_name,this.second_name,this.email);
      }
    }


}
