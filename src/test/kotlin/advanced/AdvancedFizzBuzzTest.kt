package advanced

import exception.NotModException
import io.mockk.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/*
 *  TODO: 讲解Mockito依赖
 *  TODO: 讲解Mock和Stub的用法 (Verify/When)
 * */

class AdvancedFizzBuzzTest {
    private lateinit var storage: FizzBuzzStorage

    private lateinit var inputDecodeClient: InputDecodeClient

    private lateinit var resultDisplayClient: ResultDisplayClient

    private var advancedFizzBuzz: AdvancedFizzBuzz? = null

    @BeforeEach
    internal fun setUp() {
        storage = mockkClass(FizzBuzzStorage::class)
        inputDecodeClient = mockkClass(InputDecodeClient::class)
        resultDisplayClient = mockkClass(ResultDisplayClient::class)

        advancedFizzBuzz = AdvancedFizzBuzz(storage, inputDecodeClient, resultDisplayClient)
    }

    @Test
    fun `should return FIZZ when mod by_3 not_5 after decode`() {
        val input = 8
        every { inputDecodeClient.decode(input) } returns 6
        every {resultDisplayClient.sync("FIZZ")} just Runs
        every {storage.send("FIZZ")} just Runs

        val result = advancedFizzBuzz?.calculate(input)

        verify { resultDisplayClient.sync("FIZZ") }
        verify { storage.send("FIZZ") }
        Assertions.assertEquals("FIZZ", result)
    }

    @Test
    fun `should return BUZZ when mod by 5 not 3 after decode`() {
        val input = 9
        every { inputDecodeClient.decode(input) } returns 10
        every {resultDisplayClient.sync("BUZZ")} just Runs
        every {storage.send("BUZZ")} just Runs

        val result = advancedFizzBuzz!!.calculate(input)

        verify { resultDisplayClient.sync("BUZZ") }
        verify { storage.send("BUZZ") }
        Assertions.assertEquals("BUZZ", result)
    }

    @Test
    fun `should return FIZZBUZZ when mod by 3 and 5 after decode`() {
        val input = 99
        every { inputDecodeClient.decode(input) } returns 15
        every {resultDisplayClient.sync("FIZZBUZZ")} just Runs
        every {storage.send("FIZZBUZZ")} just Runs

        val result = advancedFizzBuzz!!.calculate(input)

        verify { resultDisplayClient.sync("FIZZBUZZ") }
        verify { storage.send("FIZZBUZZ") }
        Assertions.assertEquals("FIZZBUZZ", result)
    }

    @Test
    fun `should throw exception when mod not by 3 nor 5 after decode`() {
        val input = 77
        every { inputDecodeClient.decode(input) } returns 1

        val exception = Assertions.assertThrows(NotModException::class.java) {
            advancedFizzBuzz!!.calculate(input)
        }

        Assertions.assertEquals("Cannot Mod by 3 & 5.", exception.message)
    }
}
