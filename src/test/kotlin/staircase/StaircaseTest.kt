package staircase

import java.math.BigInteger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StaircaseTest {
    @ParameterizedTest
    @CsvSource(
        "0,1",
        "1,1",
        "2,1",
        "3,1",
        "4,1",
        "5,1",
        "6,1",
        "7,1",
        "8,1",
        "9,1",
        "10,1",
        "100,1"
    )
    fun `test ways to climb staircase with single steps`(steps: Int, expectedWays: BigInteger) {
        assertEquals(expectedWays, Staircase.waysToClimbStairs(steps, 1))
    }

    @ParameterizedTest
    @CsvSource(
        "0,1",
        "1,1",  // 1
        "2,2",  // 11 2
        "3,3",  // 111 21 12
        "4,5",  // 1111 211 121 112 22
        "5,8",  // 11111 2111 1211 1121 1112 221 212 122
        "6,13",  // 111111 21111 12111 11211 11121 11112 2211 2121 2112 1221 1212 1122 222
        "7,21",  // 1111111 211111 121111 112111 111211 111121 111112 22111 21211 21121 21112 12211 12121 12112 11221 11212 11122 2221 2212 2122 1222
        "8,34",
        "9,55",
        "10,89",
        "100,573147844013817084101"
    )
    fun `test ways to climb staircase with double steps`(steps: Int, expectedWays: BigInteger) {
        assertEquals(expectedWays, Staircase.waysToClimbStairs(steps, 2))
    }

    @ParameterizedTest
    @CsvSource(
        "0,1",
        "1,1",  // 1
        "2,2",  // 11 2
        "3,4",  // 111 21 12 3
        "4,7",  // 1111 211 121 112 22 31 13
        "5,13",  // 11111 2111 1211 1121 1112 221 212 122 311 131 311 23 32
        "6,24",  // 111111 21111 12111 11211 11121 11112 2211 2121 2112 1221 1212 1122 222 3111 1311 1131 1113 321 312 231 213 123 132 33
        "7,44",  // 1111111 211111 121111 112111 111211 111121 111112 22111 21211 21121 21112 12211 12121 12112 11221 11212 11122 2221 2212 2122 1222 31111 13111 11311 11131 11113 3211 3121 3112 2311 2131 2113 1321 1312 1231 1213 1123 1132 322 232 223 331 313 133
        "8,81",
        "9,149",
        "10,274",
        "100,180396380815100901214157639"
    )
    fun `test ways to climb staircase with triple steps`(steps: Int, expectedWays: BigInteger) {
        assertEquals(expectedWays, Staircase.waysToClimbStairs(steps, 3))
    }

    @ParameterizedTest
    @CsvSource(
        "0,1",
        "1,1",  // 1
        "2,2",  // 11 2
        "3,4",  // 111 21 12 3
        "4,8",  // 1111 211 121 112 22 31 13 4
        "5,15",  // 11111 2111 1211 1121 1112 221 212 122 311 131 311 23 32 41 14
        "6,29",  // 111111 21111 12111 11211 11121 11112 2211 2121 2112 1221 1212 1122 222 3111 1311 1131 1113 321 312 231 213 123 132 33 411 141 114 42 24
        "7,56",  // 1111111 211111 121111 112111 111211 111121 111112 22111 21211 21121 21112 12211 12121 12112 11221 11212 11122 2221 2212 2122 1222 31111 13111 11311 11131 11113 3211 3121 3112 2311 2131 2113 1321 1312 1231 1213 1123 1132 322 232 223 331 313 133 4111 1411 1141 1114 421 412 241 214 142 124 43 34
        "8,108",
        "9,208",
        "10,401",
        "100,17943803336550012914104102513"
    )
    fun `test ways to climb staircase with quadruple steps`(steps: Int, expectedWays: BigInteger) {
        assertEquals(expectedWays, Staircase.waysToClimbStairs(steps, 4))
    }

    @Test
    fun `test ways to climb staircase does not yield stack overflow`() {
        Staircase.waysToClimbStairs(10000, 1)
        Staircase.waysToClimbStairs(10000, 2)
        Staircase.waysToClimbStairs(10000, 3)
        Staircase.waysToClimbStairs(10000, 4)
    }
}
