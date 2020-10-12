package advanced

class ResultDisplayClient {
    @Throws(Exception::class)
    fun sync(result: String?) {
        // sync result to 3rd-Party Client
        System.out.printf("Start Sync %s ...%n", result) // 假设 - 开始连接
        println("Sync Step 1...") // 假设 - 执行同步第一步
        println("Sync Step 2...") // 假设 - 执行同步第二步
        println("Sync Step 3...") // 假设 - 执行同步第三步
        println("Sync Finished") // 假设 - 关闭连接

        throw Exception("Only for testing not called here.")
    }
}