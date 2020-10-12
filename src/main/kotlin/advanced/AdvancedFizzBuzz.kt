package advanced

import utils.Calculator

class AdvancedFizzBuzz(
    private var storage: FizzBuzzStorage?,
    private var inputDecodeClient: InputDecodeClient?,
    private var resultDisplayClient: ResultDisplayClient?
) {

    fun calculate(input: Int): String? {
        val result: String = Calculator.calculateFizzBuzz(inputDecodeClient!!.decode(input))
        resultDisplayClient!!.sync(result)
        storage!!.send(result)

        return result
    }
}