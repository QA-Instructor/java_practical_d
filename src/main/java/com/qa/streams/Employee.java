package com.qa.streams;

public class Employee {
    public Employee(String name, Integer age, Double salary, Long daysLeave) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.daysLeave = daysLeave;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getDaysLeave() {
        return daysLeave;
    }

    public void setDaysLeave(Long daysLeave) {
        this.daysLeave = daysLeave;
    }

    private String name;
    private Integer age;
    private Double salary;
    private Long daysLeave;
}
