package de.mischokacademy.FamilyTreeUI.Domain;

public class Human {
    private String firstName;
    private String lastName;
    private int age;
    private Human mother;
    private Human father;

    public Human() {
    }

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getGenerationCount() {
        if (this.getMother() == null && this.getFather() == null) {
            return 1;

        } else if (this.getMother() != null && this.getFather() == null) {
            return 1 + this.getMother().getGenerationCount();

        } else if (this.getMother() == null && this.getFather() != null) {
            return 1 + this.getFather().getGenerationCount();

        } else {
             int getMotherGeneration = this.getMother().getGenerationCount();
             int getFatherGeneration = this.getFather().getGenerationCount();

            if (getMotherGeneration > getFatherGeneration) {
                return 1 + getMotherGeneration;

            } else {
                return 1 + getFatherGeneration;
            }
        }
    }

    public int getFamilyAge() {
        if (this.getMother() == null && this.getFather() == null) {
            return this.getAge();

        } else if (this.getMother() != null && this.getFather() == null) {
            return this.getAge() + this.getMother().getFamilyAge();

        } else if (this.getMother() == null && this.getFather() != null) {
            return this.getAge() + this.getFather().getFamilyAge();

        } else {
            return this.getAge() +
                    this.getMother().getFamilyAge() +
                    this.getFather().getFamilyAge();
        }
    }

    @SuppressWarnings("unused")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @SuppressWarnings("unused")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", mother=" + mother +
                ", father=" + father +
                '}';
    }
}
