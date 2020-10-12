package advanced

import exception.NotModException

class AdvancedFizzBuzz(
    private var storage: FizzBuzzStorage?,
    private var inputDecodeClient: InputDecodeClient?,
    private var resultDisplayClient: ResultDisplayClient?
) {

    fun calculate(input: Int): String? {
        val realNumber = inputDecodeClient!!.decode(input)
        val result: String

        result = if (realNumber % 3 == 0 && realNumber % 5 == 0) {
            "FIZZBUZZ"
        } else if (realNumber % 3 == 0) {
            "FIZZ"
        } else if (realNumber % 5 == 0) {
            "BUZZ"
        } else {
            throw NotModException("Cannot Mod by 3 & 5.")
        }
        resultDisplayClient!!.sync(result)
        storage!!.send(result)

        return result
    }
}