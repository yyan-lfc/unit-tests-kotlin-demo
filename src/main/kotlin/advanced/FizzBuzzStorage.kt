package advanced

import advanced.base.FizzBuzzStorageBase

class FizzBuzzStorage : FizzBuzzStorageBase() {
    @Throws(Exception::class)
    override fun send(result: String?) {
        // sync result to MYSQL DB
        println("Start connect to Mysql") // 假设 - 开始连接数据库，建立JDBC连接
        System.out.printf("Save %s to FizzBuzzResult Table", result) // 假设 - 在数据库存储结果
        println("Close DB Connection") // 假设 - 关闭连接

        throw Exception("Only for testing not called here.")
    }
}