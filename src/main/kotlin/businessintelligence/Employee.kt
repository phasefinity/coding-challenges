package businessintelligence

class Employee(
    var name: String,
    var company: Company,
    var favoriteFood: String,
    var age: Int,
) {
    val departments: MutableSet<Department> = HashSet()
}
