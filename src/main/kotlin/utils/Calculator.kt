package utils

import exception.NotModException

/*
* 讲解单元测试 - "单元的概念"
* 这里可以给calculator去写单元测试，针对calculateFizzBuzz方法
* 也可以把fizzbuzz和advancedFizzBuzz当做业务单元，为calculate方法编写，这个时候，calculateFizzBuzz这个方法就是单元的一部分，不需要mock
* */
class Calculator {
    companion object {
        fun calculateFizzBuzz(input: Int): String {
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
}
