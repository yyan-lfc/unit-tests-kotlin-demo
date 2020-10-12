package advanced

import exception.NotModException
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/*
 *  TODO: 讲解Mockito依赖
 *  TODO: 讲解Mock和Stub的用法 (Verify/When)
 * */

class AdvancedFizzBuzzTest {
    @MockK
    private lateinit var storage: FizzBuzzStorage

    @MockK
    private lateinit var inputDecodeClient: InputDecodeClient

    @MockK
    private lateinit var resultDisplayClient: ResultDisplayClient

    private var advancedFizzBuzz: AdvancedFizzBuzz? = null

    @BeforeEach
    internal fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)

        advancedFizzBuzz = AdvancedFizzBuzz(storage, inputDecodeClient, resultDisplayClient)
    }

    @Test
    fun `should return FIZZ when mod by_3 not_5 after decode`() {
        val input = 8
        val encodedResult = "FIZZ"
        every { inputDecodeClient.decode(input) } returns 6
        every {resultDisplayClient.sync(encodedResult)} just Runs
        every {storage.send(encodedResult)} just Runs

        val result = advancedFizzBuzz?.calculate(input)

        verify { resultDisplayClient.sync(encodedResult) }
        verify { storage.send(encodedResult) }
        Assertions.assertEquals(encodedResult, result)
    }

    @Test
    fun `should return BUZZ when mod by 5 not 3 after decode`() {
        val input = 9
        val encodedResult = "BUZZ"
        every { inputDecodeClient.decode(input) } returns 10
        every {resultDisplayClient.sync(encodedResult)} just Runs
        every {storage.send(encodedResult)} just Runs

        val result = advancedFizzBuzz!!.calculate(input)

        verify { resultDisplayClient.sync(encodedResult) }
        verify { storage.send(encodedResult) }
        Assertions.assertEquals(encodedResult, result)
    }

    @Test
    fun `should return FIZZBUZZ when mod by 3 and 5 after decode`() {
        val input = 99
        val encodedResult = "FIZZBUZZ"
        every { inputDecodeClient.decode(input) } returns 15
        every {resultDisplayClient.sync(encodedResult)} just Runs
        every {storage.send(encodedResult)} just Runs

        val result = advancedFizzBuzz!!.calculate(input)

        verify { resultDisplayClient.sync(encodedResult) }
        verify { storage.send(encodedResult) }
        Assertions.assertEquals(encodedResult, result)
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
