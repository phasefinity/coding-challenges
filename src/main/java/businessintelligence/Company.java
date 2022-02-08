package businessintelligence;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Company {
    private String name;
    private Set<Department> departments;
    private Set<Employee> employees;

    public Company(String name) {
        this(name, new HashSet<>(), new HashSet<>());
    }

    public Company(String name, Set<Department> departments, Set<Employee> employees) {
        this.name = name;
        this.departments = departments;
        this.employees = employees;
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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
