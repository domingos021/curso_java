package main.projetobd_demo_dao_jdbc.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class Seller implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer Id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private Double baseSalary;

    private Department department;  // a seller has a department which is an object

    public Seller() {
    }

    public Seller(Integer id, String name, String email, LocalDate birthDate, Double baseSalary, Department department) {
        this.Id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Id == null) ? 0 : Id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Seller other = (Seller) obj;
        if (Id == null) {
            if (other.Id != null)
                return false;
        } else if (!Id.equals(other.Id))
            return false;
        return true;
    }


    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return String.format(
                Locale.of("pt", "BR"),
                "Seller #%s | %s | %s | Nas: %s | Salário: R$ %.2f | Dept: %s",
                getId(),
                name,
                email,
                (birthDate != null ? birthDate.format(fmt) : "N/A"),
                baseSalary,
                (department != null ? department.getName() : "N/A")
        );
    }
}
