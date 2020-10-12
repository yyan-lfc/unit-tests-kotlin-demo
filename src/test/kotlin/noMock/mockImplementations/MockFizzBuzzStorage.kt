package noMock.mockImplementations

import advanced.base.FizzBuzzStorageBase

class MockFizzBuzzStorage : FizzBuzzStorageBase() {
    var index = 0

    override fun send(result: String?) {
        if ("FIZZ" == result) {
            index = 5
        }

        if ("BUZZ" == result) {
            index = 6
        }

        if ("FIZZBUZZ" == result) {
            index = 7
        }
    }
}