package rest.Rest_Beginning.model;

import javax.persistence.*;

@Entity
@Table(name = "employee_details")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee_Id")
    private int id;
    @Column(name = "Employee_Name",nullable = false)
    private  String name;
    @Column(name = "Employee_City")
    private  String city;
    @Column(name = "Employee_status")
    private String status;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee(int id, String name, String city, String status) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.status = status;
    }
    public Employee(){
        super();
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
