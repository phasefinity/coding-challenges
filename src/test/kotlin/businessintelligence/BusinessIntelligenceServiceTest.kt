package businessintelligence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import businessintelligence.BusinessIntelligenceService.averageAgeForCompany
import businessintelligence.BusinessIntelligenceService.averageAgeForFavoriteFood
import businessintelligence.BusinessIntelligenceService.favoriteFoodForCompany
import businessintelligence.BusinessIntelligenceService.favoriteFoodForDepartment

class BusinessIntelligenceServiceTest {
    private val ZKB = Company("ZKB")
    private val ZKB_IT = Department("IT", ZKB)
    private val ZKB_LEGAL = Department("Legal", ZKB)
    private val ZKB_SALES = Department("Sales", ZKB)
    private val ZKB_BANKING = Department("Banking", ZKB)
    private val employee01 = Employee("Yadira Burke", ZKB, "Pizza", 22)
    private val employee02 = Employee("Logan Preston", ZKB, "Pizza", 26)
    private val employee03 = Employee("Hazel Dudley", ZKB, "Banana", 31)
    private val employee04 = Employee("Beckett Hobbs", ZKB, "Cordon Bleu", 33)
    private val employee05 = Employee("Madilyn Heath", ZKB, "Pizza", 35)
    private val employee06 = Employee("Caroline Shepherd", ZKB, "Spaghetti", 39)
    private val employee07 = Employee("Gracelyn Meza", ZKB, "Blueberry Pancakes", 47)
    private val employee08 = Employee("Aydan Sweeney", ZKB, "Blueberry Pancakes", 47)
    private val employee09 = Employee("Kolten Horn", ZKB, "Pizza", 48)
    private val employee10 = Employee("Penelope Graves", ZKB, "Cordon Bleu", 52)
    private val employee11 = Employee("Walker York", ZKB, "Cordon Bleu", 56)
    private val employee12 = Employee("Eric Spence", ZKB, "Blueberry Pancakes", 62)

    private val MIGROS = Company("Migros")
    private val MIGROS_IT = Department("IT", MIGROS)
    private val MIGROS_SALES = Department("Sales", MIGROS)
    private val MIGROS_HR = Department("Human Resources", MIGROS)
    private val employee13 = Employee("Camden Stein", MIGROS, "Spaghetti", 24)
    private val employee14 = Employee("Wesley Lynch", MIGROS, "Banana", 29)
    private val employee15 = Employee("Skyla Johns", MIGROS, "Spaghetti", 33)
    private val employee16 = Employee("Paulina Parsons", MIGROS, "Blueberry Pancakes", 46)
    private val employee17 = Employee("Jaslyn Duffy", MIGROS, "Blueberry Pancakes", 46)
    private val employee18 = Employee("Deanna Ross", MIGROS, "Cordon Bleu", 53)
    private val employee19 = Employee("Liam Doyle", MIGROS, "Cordon Bleu", 58)
    private val employee20 = Employee("Kiara Beard", MIGROS, "Blueberry Pancakes", 61)

    init {
        employee01.departments += setOf(ZKB_IT)
        employee02.departments += setOf(ZKB_IT, ZKB_BANKING)
        employee03.departments += setOf(ZKB_BANKING)
        employee04.departments += setOf(ZKB_LEGAL)
        employee05.departments += setOf(ZKB_IT)
        employee06.departments += setOf(ZKB_BANKING, ZKB_IT)
        employee07.departments += setOf(ZKB_SALES)
        employee08.departments += setOf(ZKB_SALES)
        employee09.departments += setOf(ZKB_BANKING)
        employee10.departments += setOf(ZKB_LEGAL, ZKB_BANKING)
        employee11.departments += setOf(ZKB_IT)
        employee12.departments += setOf(ZKB_SALES)
        employee13.departments += setOf(MIGROS_IT)
        employee14.departments += setOf(MIGROS_HR, MIGROS_IT)
        employee15.departments += setOf(MIGROS_IT)
        employee16.departments += setOf(MIGROS_SALES)
        employee17.departments += setOf(MIGROS_HR, MIGROS_SALES)
        employee18.departments += setOf(MIGROS_IT)
        employee19.departments += setOf(MIGROS_SALES)
        employee20.departments += setOf(MIGROS_SALES)

        ZKB.departments += setOf(ZKB_IT, ZKB_LEGAL, ZKB_SALES, ZKB_BANKING)
        ZKB.employees += setOf(
            employee01,
            employee02,
            employee03,
            employee04,
            employee05,
            employee06,
            employee07,
            employee08,
            employee09,
            employee10,
            employee11,
            employee12
        )
        ZKB_IT.employees += setOf(employee01, employee02, employee05, employee06, employee11)
        ZKB_LEGAL.employees += setOf(employee04, employee10)
        ZKB_SALES.employees += setOf(employee07, employee08, employee12)
        ZKB_BANKING.employees += setOf(employee02, employee03, employee06, employee09, employee10)

        MIGROS.departments += setOf(MIGROS_IT, MIGROS_SALES, MIGROS_HR)
        MIGROS.employees += setOf(employee13, employee14, employee15, employee16, employee17, employee18, employee19, employee20)
        MIGROS_IT.employees += setOf(employee13, employee14, employee15, employee18)
        MIGROS_SALES.employees += setOf(employee16, employee17, employee19, employee20)
        MIGROS_HR.employees += setOf(employee14, employee17)
    }

    private val allEmployees = setOf(
        employee01, employee02, employee03, employee04, employee05,
        employee06, employee07, employee08, employee09, employee10, employee11, employee12, employee13, employee14,
        employee15, employee16, employee17, employee18, employee19, employee20
    )

    @Test
    fun `test favoriteFoodForCompany`() {
        assertEquals("Pizza", favoriteFoodForCompany(ZKB.employees, "ZKB"))
        assertEquals("Pizza", favoriteFoodForCompany(allEmployees, "ZKB"))
        assertEquals("Blueberry Pancakes", favoriteFoodForCompany(MIGROS.employees, "Migros"))
        assertEquals("Blueberry Pancakes", favoriteFoodForCompany(allEmployees, "Migros"))
    }

    @Test
    fun `test favorite food for department`() {
        assertEquals("Pizza", favoriteFoodForDepartment(ZKB.employees, "IT"))
        assertEquals("Cordon Bleu", favoriteFoodForDepartment(ZKB.employees, "Legal"))
        assertEquals("Blueberry Pancakes", favoriteFoodForDepartment(ZKB.employees, "Sales"))
        assertEquals("Pizza", favoriteFoodForDepartment(ZKB.employees, "Banking"))

        assertEquals("Spaghetti", favoriteFoodForDepartment(MIGROS.employees, "IT"))
        assertEquals("Blueberry Pancakes", favoriteFoodForDepartment(MIGROS.employees, "Sales"))
        assertTrue(setOf("Banana", "Blueberry Pancakes").contains(favoriteFoodForDepartment(MIGROS.employees, "Human Resources")))

        assertTrue(setOf("Pizza", "Spaghetti").contains(favoriteFoodForDepartment(allEmployees, "IT")))
        assertEquals("Cordon Bleu", favoriteFoodForDepartment(allEmployees, "Legal"))
        assertEquals("Blueberry Pancakes", favoriteFoodForDepartment(allEmployees, "Sales"))
        assertEquals("Pizza", favoriteFoodForDepartment(allEmployees, "Banking"))
        assertTrue(setOf("Banana", "Blueberry Pancakes").contains(favoriteFoodForDepartment(allEmployees, "Human Resources")))

    }

    @Test
    fun `test average age for company`() {
        assertEquals(41.5, averageAgeForCompany(ZKB.employees, "ZKB"))
        assertEquals(41.5, averageAgeForCompany(allEmployees, "ZKB"))
        assertEquals(43.75, averageAgeForCompany(MIGROS.employees, "Migros"))
        assertEquals(43.75, averageAgeForCompany(allEmployees, "Migros"))
    }

    @Test
    fun `test average age for favorite food`() {
        assertEquals(32.75, averageAgeForFavoriteFood(allEmployees, "Pizza"))
        assertEquals(30, averageAgeForFavoriteFood(allEmployees, "Banana"))
        assertEquals(50.4, averageAgeForFavoriteFood(allEmployees, "Cordon Bleu"))
        assertEquals(51.5, averageAgeForFavoriteFood(allEmployees, "Blueberry Pancakes"))
        assertEquals(32, averageAgeForFavoriteFood(allEmployees, "Spaghetti"))

        assertEquals(32.75, averageAgeForFavoriteFood(ZKB.employees, "Pizza"))
        assertEquals(31, averageAgeForFavoriteFood(ZKB.employees, "Banana"))
        assertEquals(47, averageAgeForFavoriteFood(ZKB.employees, "Cordon Bleu"))
        assertEquals(52, averageAgeForFavoriteFood(ZKB.employees, "Blueberry Pancakes"))
        assertEquals(39, averageAgeForFavoriteFood(ZKB.employees, "Spaghetti"))

        assertEquals(-1, averageAgeForFavoriteFood(MIGROS.employees, "Pizza"))
        assertEquals(29, averageAgeForFavoriteFood(MIGROS.employees, "Banana"))
        assertEquals(55.5, averageAgeForFavoriteFood(MIGROS.employees, "Cordon Bleu"))
        assertEquals(51, averageAgeForFavoriteFood(MIGROS.employees, "Blueberry Pancakes"))
        assertEquals(28.5, averageAgeForFavoriteFood(MIGROS.employees, "Spaghetti"))
    }
}
