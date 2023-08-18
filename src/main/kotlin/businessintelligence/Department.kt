package businessintelligence

data class Department(
    var name: String,
    var company: Company,
) {
    val employees: MutableSet<Employee> = HashSet()
}
