package businessintelligence;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Department {
    private String name;
    private Set<Employee> employees;
    private Company company;

    public Department(String name, Company company) {
        this(name, new HashSet<>(), company);
    }

    public Department(String name, Set<Employee> employees, Company company) {
        this.name = name;
        this.employees = employees;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(company.getName(), that.company.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company.getName());
    }
}
