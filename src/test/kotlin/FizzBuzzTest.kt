import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/*
* TODO: Test Case 1: 解释单元测试的概念
* TODO: Test Case 2: 解释单元测试的结构 - Given-When-Then
* TODO: Test Case 3: 解释单元测试的结构 - Arrange-Act-Assert
* TODO: Test Case 4: 解释单元测试的命名规范
* */

// 代码：UT也是代码
class FizzBuzzTest {
    @Test //单个: 一次只验证一种情形
    fun `should return FIZZ when mod by 3 not 5`() {
        //某些假设: 构造输入
        val input = 6

        // 调用：UT需要调用被测代码
        // 工作单元：小的功能块
        val result:String = FizzBuzz().calculate(input)

        //检验: 验证输出
        assertEquals("FIZZ", result)
    }

    @Test
    fun `should return BUZZ when mod by 5 not 3`() {
        // Given - 测试准备
        val input = 10

        // When - 被测单元的调用
        val result:String = FizzBuzz().calculate(input)

        // Then - 断言
        assertEquals("BUZZ", result)
    }

    @Test
    fun `should return FIZZBUZZ when mod by 3 and 5`() {
        // Arrange - 测试准备
        val input = 15

        // Act - 被测单元的调用
        val result:String = FizzBuzz().calculate(input)

        // Assert - 断言
        assertEquals("FIZZBUZZ", result)
    }

    @Test
    /*
     * 测试命名方式：
     * - Java
     *  1. Snake Case - 蛇型 (更常见) - should_[结果]_when_[描述单一情形]
     *  2. Camel Case - 驼峰式 - should[结果]When[描述单一情形]
     * - Kotlin
     *  should [结果] when [描述单一情形]
    */
    fun `should throw exception when mod not by 3 nor 5`() {
        val exception = assertThrows<NotModException>("should throw NotModException") {
            val input = 1

            FizzBuzz().calculate(input)
        }

        assertEquals("Cannot Mod by 3 & 5.", exception.message)
    }
}
