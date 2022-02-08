package businessintelligence;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static businessintelligence.BusinessIntelligenceService.*;
import static java.util.Set.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BusinessIntelligenceServiceTest {
    private static final Company ZKB = new Company("ZKB");
    private static final Department ZKB_IT = new Department("IT", ZKB);
    private static final Department ZKB_LEGAL = new Department("Legal", ZKB);
    private static final Department ZKB_SALES = new Department("Sales", ZKB);
    private static final Department ZKB_BANKING = new Department("Banking", ZKB);
    private static final Employee employee01 = new Employee("Yadira Burke", of(ZKB_IT), ZKB, "Pizza", 22);
    private static final Employee employee02 = new Employee("Logan Preston", of(ZKB_IT, ZKB_BANKING), ZKB, "Pizza", 26);
    private static final Employee employee03 = new Employee("Hazel Dudley", of(ZKB_BANKING), ZKB, "Banana", 31);
    private static final Employee employee04 = new Employee("Beckett Hobbs", of(ZKB_LEGAL), ZKB, "Cordon Bleu", 33);
    private static final Employee employee05 = new Employee("Madilyn Heath", of(ZKB_IT), ZKB, "Pizza", 35);
    private static final Employee employee06 = new Employee("Caroline Shepherd", of(ZKB_BANKING, ZKB_IT), ZKB, "Spaghetti", 39);
    private static final Employee employee07 = new Employee("Gracelyn Meza", of(ZKB_SALES), ZKB, "Blueberry Pancakes", 47);
    private static final Employee employee08 = new Employee("Aydan Sweeney", of(ZKB_SALES), ZKB, "Blueberry Pancakes", 47);
    private static final Employee employee09 = new Employee("Kolten Horn", of(ZKB_BANKING), ZKB, "Pizza", 48);
    private static final Employee employee10 = new Employee("Penelope Graves", of(ZKB_LEGAL, ZKB_BANKING), ZKB, "Cordon Bleu", 52);
    private static final Employee employee11 = new Employee("Walker York", of(ZKB_IT), ZKB, "Cordon Bleu", 56);
    private static final Employee employee12 = new Employee("Eric Spence", of(ZKB_SALES), ZKB, "Blueberry Pancakes", 62);

    private static final Company MIGROS = new Company("Migros");
    private static final Department MIGROS_IT = new Department("IT", MIGROS);
    private static final Department MIGROS_SALES = new Department("Sales", MIGROS);
    private static final Department MIGROS_HR = new Department("Human Resources", MIGROS);
    private static final Employee employee13 = new Employee("Camden Stein", of(MIGROS_IT), MIGROS, "Spaghetti", 24);
    private static final Employee employee14 = new Employee("Wesley Lynch", of(MIGROS_HR, MIGROS_IT), MIGROS, "Banana", 29);
    private static final Employee employee15 = new Employee("Skyla Johns", of(MIGROS_IT), MIGROS, "Spaghetti", 33);
    private static final Employee employee16 = new Employee("Paulina Parsons", of(MIGROS_SALES), MIGROS, "Blueberry Pancakes", 46);
    private static final Employee employee17 = new Employee("Jaslyn Duffy", of(MIGROS_HR, MIGROS_SALES), MIGROS, "Blueberry Pancakes", 46);
    private static final Employee employee18 = new Employee("Deanna Ross", of(MIGROS_IT), MIGROS, "Cordon Bleu", 53);
    private static final Employee employee19 = new Employee("Liam Doyle", of(MIGROS_SALES), MIGROS, "Cordon Bleu", 58);
    private static final Employee employee20 = new Employee("Kiara Beard", of(MIGROS_SALES), MIGROS, "Blueberry Pancakes", 61);

    static {
        ZKB.getDepartments().addAll(of(ZKB_IT, ZKB_LEGAL, ZKB_SALES, ZKB_BANKING));
        ZKB.getEmployees().addAll(of(employee01, employee02, employee03, employee04, employee05, employee06, employee07,
                employee08, employee09, employee10, employee11, employee12));
        ZKB_IT.getEmployees().addAll(of(employee01, employee02, employee05, employee06, employee11));
        ZKB_LEGAL.getEmployees().addAll(of(employee04, employee10));
        ZKB_SALES.getEmployees().addAll(of(employee07, employee08, employee12));
        ZKB_BANKING.getEmployees().addAll(of(employee02, employee03, employee06, employee09, employee10));

        MIGROS.getDepartments().addAll(of(MIGROS_IT, MIGROS_SALES, MIGROS_HR));
        MIGROS.getEmployees().addAll(of(employee13, employee14, employee15, employee16, employee17, employee18,
                employee19, employee20));
        MIGROS_IT.getEmployees().addAll(of(employee13, employee14, employee15, employee18));
        MIGROS_SALES.getEmployees().addAll(of(employee16, employee17, employee19, employee20));
        MIGROS_HR.getEmployees().addAll(of(employee14, employee17));
    }

    private static final Set<Employee> allEmployees = of(employee01, employee02, employee03, employee04, employee05,
            employee06, employee07, employee08, employee09, employee10, employee11, employee12, employee13, employee14,
            employee15, employee16, employee17, employee18, employee19, employee20);

    @Test
    public void testFavoriteFoodForCompany() {
        assertEquals("Pizza", favoriteFoodForCompany(ZKB.getEmployees(), "ZKB"));
        assertEquals("Pizza", favoriteFoodForCompany(allEmployees, "ZKB"));
        assertEquals("Blueberry Pancakes", favoriteFoodForCompany(MIGROS.getEmployees(), "Migros"));
        assertEquals("Blueberry Pancakes", favoriteFoodForCompany(allEmployees, "Migros"));
    }

    @Test
    public void testFavoriteFoodForDepartment() {
        assertEquals("Pizza", favoriteFoodForDepartment(ZKB.getEmployees(), "IT"));
        assertEquals("Cordon Bleu", favoriteFoodForDepartment(ZKB.getEmployees(), "Legal"));
        assertEquals("Blueberry Pancakes", favoriteFoodForDepartment(ZKB.getEmployees(), "Sales"));
        assertEquals("Pizza", favoriteFoodForDepartment(ZKB.getEmployees(), "Banking"));

        assertEquals("Spaghetti", favoriteFoodForDepartment(MIGROS.getEmployees(), "IT"));
        assertEquals("Blueberry Pancakes", favoriteFoodForDepartment(MIGROS.getEmployees(), "Sales"));
        assertTrue(of("Banana", "Blueberry Pancakes").contains(favoriteFoodForDepartment(MIGROS.getEmployees(), "Human Resources")));

        assertTrue(of("Pizza", "Spaghetti").contains(favoriteFoodForDepartment(allEmployees, "IT")));
        assertEquals("Cordon Bleu", favoriteFoodForDepartment(allEmployees, "Legal"));
        assertEquals("Blueberry Pancakes", favoriteFoodForDepartment(allEmployees, "Sales"));
        assertEquals("Pizza", favoriteFoodForDepartment(allEmployees, "Banking"));
        assertTrue(of("Banana", "Blueberry Pancakes").contains(favoriteFoodForDepartment(allEmployees, "Human Resources")));

    }

    @Test
    public void testAverageAgeForCompany() {
        assertEquals(41.5, averageAgeForCompany(ZKB.getEmployees(), "ZKB"));
        assertEquals(41.5, averageAgeForCompany(allEmployees, "ZKB"));
        assertEquals(43.75, averageAgeForCompany(MIGROS.getEmployees(), "Migros"));
        assertEquals(43.75, averageAgeForCompany(allEmployees, "Migros"));
    }

    @Test
    public void testAverageAgeForFavoriteFood() {
        assertEquals(32.75, averageAgeForFavoriteFood(allEmployees, "Pizza"));
        assertEquals(30, averageAgeForFavoriteFood(allEmployees, "Banana"));
        assertEquals(50.4, averageAgeForFavoriteFood(allEmployees, "Cordon Bleu"));
        assertEquals(51.5, averageAgeForFavoriteFood(allEmployees, "Blueberry Pancakes"));
        assertEquals(32, averageAgeForFavoriteFood(allEmployees, "Spaghetti"));

        assertEquals(32.75, averageAgeForFavoriteFood(ZKB.getEmployees(), "Pizza"));
        assertEquals(31, averageAgeForFavoriteFood(ZKB.getEmployees(), "Banana"));
        assertEquals(47, averageAgeForFavoriteFood(ZKB.getEmployees(), "Cordon Bleu"));
        assertEquals(52, averageAgeForFavoriteFood(ZKB.getEmployees(), "Blueberry Pancakes"));
        assertEquals(39, averageAgeForFavoriteFood(ZKB.getEmployees(), "Spaghetti"));

        assertEquals(-1, averageAgeForFavoriteFood(MIGROS.getEmployees(), "Pizza"));
        assertEquals(29, averageAgeForFavoriteFood(MIGROS.getEmployees(), "Banana"));
        assertEquals(55.5, averageAgeForFavoriteFood(MIGROS.getEmployees(), "Cordon Bleu"));
        assertEquals(51, averageAgeForFavoriteFood(MIGROS.getEmployees(), "Blueberry Pancakes"));
        assertEquals(28.5, averageAgeForFavoriteFood(MIGROS.getEmployees(), "Spaghetti"));
    }
}
