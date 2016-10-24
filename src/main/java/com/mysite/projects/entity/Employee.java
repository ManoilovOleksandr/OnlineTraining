package com.mysite.projects.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "user", schema = "test")
public class Employee implements Serializable {
    private static final long serialVersionUID = -7988799579036225137L;

    private int id;
    private String name;
    private int age;
    private Boolean admin = false;
    private Date createdDate;

    @Id
    @Column(name = "id", columnDefinition = "INT(8)")
    @GenericGenerator(name = "my_employee_gen", strategy = "increment")
    @GeneratedValue(generator = "my_employee_gen")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    @Basic
    @Column(name = "name", length = 25)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age", nullable = false, columnDefinition = "INT")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "isAdmin")
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (age != employee.age) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (admin != null ? !admin.equals(employee.admin) : employee.admin != null) return false;
        return createdDate != null ? createdDate.equals(employee.createdDate) : employee.createdDate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (admin != null ? admin.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", admin=" + admin +
                ", createdDate=" + createdDate +
                '}';
    }
}
