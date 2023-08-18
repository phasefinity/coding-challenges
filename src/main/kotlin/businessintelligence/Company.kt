package businessintelligence

data class Company(var name: String) {
    val departments: MutableSet<Department> = HashSet()
    val employees: MutableSet<Employee> = HashSet()
}
