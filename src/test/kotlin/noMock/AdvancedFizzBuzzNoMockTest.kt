package noMock

import advanced.AdvancedFizzBuzz
import exception.NotModException
import noMock.mockImplementations.MockFizzBuzzStorage
import noMock.mockImplementations.MockInputDecodeClient
import noMock.mockImplementations.MockResultDisplayClient
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AdvancedFizzBuzzNoMockTest {
    private lateinit var storage: MockFizzBuzzStorage
    private lateinit var inputDecodeClient: MockInputDecodeClient
    private lateinit var resultDisplayClient: MockResultDisplayClient
    private var advancedFizzBuzz: AdvancedFizzBuzz? = null

    @BeforeEach
    internal fun setUp() {
        storage = MockFizzBuzzStorage()
        inputDecodeClient = MockInputDecodeClient()
        resultDisplayClient = MockResultDisplayClient()

        advancedFizzBuzz = AdvancedFizzBuzz(storage, inputDecodeClient, resultDisplayClient)
    }

    @Test
    fun `should return FIZZ when mod by_3 not_5 after decode`() {
        val input = 8

        val result = advancedFizzBuzz?.calculate(input)

        Assertions.assertEquals("FIZZ", result)
        Assertions.assertEquals(1, resultDisplayClient.index)
        Assertions.assertEquals(5, storage.index)
    }

    @Test
    fun `should return BUZZ when mod by 5 not 3 after decode`() {
        val input = 9

        val result = advancedFizzBuzz!!.calculate(input)

        Assertions.assertEquals("BUZZ", result)
        Assertions.assertEquals(2, resultDisplayClient.index)
        Assertions.assertEquals(6, storage.index)
    }

    @Test
    fun `should return FIZZBUZZ when mod by 3 and 5 after decode`() {
        val input = 99

        val result = advancedFizzBuzz!!.calculate(input)

        Assertions.assertEquals("FIZZBUZZ", result)
        Assertions.assertEquals(3, resultDisplayClient.index)
        Assertions.assertEquals(7, storage.index)
    }

    @Test
    fun `should throw exception when mod not by 3 nor 5 after decode`() {
        val input = 77

        val exception = Assertions.assertThrows(NotModException::class.java) {
            advancedFizzBuzz!!.calculate(input)
        }

        Assertions.assertEquals("Cannot Mod by 3 & 5.", exception.message)
    }
}
