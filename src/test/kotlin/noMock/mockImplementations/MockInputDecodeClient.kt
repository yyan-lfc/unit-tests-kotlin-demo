package noMock.mockImplementations

import advanced.base.InputDecodeBase

class MockInputDecodeClient : InputDecodeBase() {
    override fun decode(input: Int): Int {
        if (input == 8) {
            return 6
        }

        if (input == 9) {
            return 10
        }

        if (input == 99) {
            return 15
        }

        if (input == 77) {
            return 1
        }

        return 0
    }
}