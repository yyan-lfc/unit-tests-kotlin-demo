package advanced

import advanced.base.InputDecodeBase
import java.lang.Exception
import kotlin.random.Random

class InputDecodeClient : InputDecodeBase() {
    override fun decode(input: Int): Int {
        val randomAddNumber = Random(10).nextInt() // 假设Random的算法是第三方API提供
        val randomRatio = Random(4).nextInt() // 假设Random的算法是第三方API提供
        val result = (randomAddNumber + input) * randomRatio

        throw Exception(String.format("Unsupported method for %s", result))
    }
}