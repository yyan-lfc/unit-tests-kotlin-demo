package advanced

import advanced.base.FizzBuzzStorageBase
import advanced.base.InputDecodeBase
import advanced.base.ResultDisplayBase
import utils.Calculator

class AdvancedFizzBuzz(
    private var storage: FizzBuzzStorageBase?,
    private var inputDecodeClient: InputDecodeBase?,
    private var resultDisplayClient: ResultDisplayBase?
) {

    fun calculate(input: Int): String? {
        val result: String = Calculator.calculateFizzBuzz(inputDecodeClient!!.decode(input))
        resultDisplayClient!!.sync(result)
        storage!!.send(result)

        return result
    }
}