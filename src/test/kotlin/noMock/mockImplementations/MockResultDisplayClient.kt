package noMock.mockImplementations

import advanced.base.ResultDisplayBase

class MockResultDisplayClient : ResultDisplayBase() {
    var index = 0

    override fun sync(result: String?) {
        if ("FIZZ" == result) {
            index = 1
        }

        if ("BUZZ" == result) {
            index = 2
        }

        if ("FIZZBUZZ" == result) {
            index = 3
        }
    }
}