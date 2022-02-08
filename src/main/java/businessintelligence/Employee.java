package businessintelligence;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Employee {
    private String name;
    private Set<Department> departments;
    private Company company;
    private String favoriteFood;
    private int age;

    public Employee(String name, Company company, String favoriteFood, int age) {
        this(name, new HashSet<>(), company, favoriteFood, age);
    }

    public Employee(String name, Set<Department> departments, Company company, String favoriteFood, int age) {
        this.name = name;
        this.departments = departments;
        this.company = company;
        this.favoriteFood = favoriteFood;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name) &&
                Objects.equals(departments, employee.departments) &&
                Objects.equals(company, employee.company) &&
                Objects.equals(favoriteFood, employee.favoriteFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, departments, company, favoriteFood, age);
    }
}
