package generics.genericexample02.model.entities;

public class Person {

    private String name;
    private Integer age;
    private Double height;
    private String email;

    public Person() {
    }

    public Person(String name, Integer age, Double height, String email) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("{ "+ "%s, %d anos | Altura: %.2fm | Email: %s" + " }",
                name, age, height, email
        );
    }
}
