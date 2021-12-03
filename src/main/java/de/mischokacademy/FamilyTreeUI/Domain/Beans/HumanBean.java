package de.mischokacademy.FamilyTreeUI.Domain.Beans;

import javax.validation.constraints.NotBlank;

public class HumanBean {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
    private int age;
    private Integer mother;
    private Integer father;

    public String getFirstName() {
        return firstName;
    }

    @SuppressWarnings("unused")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @SuppressWarnings("unused")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    @SuppressWarnings("unused")
    public void setAge(int age) {
        this.age = age;
    }

    public Integer getMother() {
        return mother;
    }

    @SuppressWarnings("unused")
    public void setMother(Integer mother) {
        this.mother = mother;
    }

    public Integer getFather() {
        return father;
    }

    @SuppressWarnings("unused")
    public void setFather(Integer father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return "HumanBean{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", mother=" + mother +
                ", father=" + father +
                '}';
    }
}
