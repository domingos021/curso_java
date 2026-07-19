/*
 *Super class abstrata, da qual tanto a classe student quanto o instructor herdam os seus componentes
 */

package generics.set.exercfixacao.model.entities;

import java.util.Objects;

public abstract class Person {

    private final Integer code;
    private String name;
    private String email;


    public Person(Integer code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
    }


    public Integer getCode() {
        return code;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        return Objects.equals(code, person.code);
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}


/*
                 Person
                   ▲
          ┌────────┴────────┐
          │                 │
       Student          Instructor
                            │
                            │
                            ▼
                         Course
                            │
                            │
                            ▼
                       Enrollment
                            │
                    ┌───────┴───────┐
                    │               │
                 Student         Course
 */