package businessintelligence

object BusinessIntelligenceService {
    /** Find the most occurring favorite food for the given company name. If there is a tie, any is accepted.  */
    fun favoriteFoodForCompany(employees: Set<Employee>, company: String): String? {
        return null
    }

    /** Find the most occurring favorite food for the given department name. If there is a tie, any is accepted.  */
    fun favoriteFoodForDepartment(employees: Set<Employee>, department: String): String? {
        return null
    }

    /** Find the average age for the given company name  */
    fun averageAgeForCompany(employees: Set<Employee>, company: String): Double {
        return 0.0
    }

    /** Find the average age for the given favorite food. Return -1 if nobody has this favorite food.  */
    fun averageAgeForFavoriteFood(employees: Set<Employee>, favoriteFood: String): Double {
        return 0.0
    }
}
