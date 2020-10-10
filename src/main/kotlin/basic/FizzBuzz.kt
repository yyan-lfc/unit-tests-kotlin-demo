package basic

import exception.NotModException

class FizzBuzz {
    fun calculate(input: Int): String {
        return if (input % 3 == 0 && input % 5 == 0) {
            "FIZZBUZZ"
        } else if (input % 3 == 0) {
            "FIZZ"
        } else if (input % 5 == 0) {
            "BUZZ"
        } else {
            throw NotModException("Cannot Mod by 3 & 5.")
        }
    }
}