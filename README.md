### 需求
输入：一个整数数字

需求：
1. 数字能被3整除，且不能被5整除，输出FIZZ
2. 数字能被5整除，且不能被3整除，输出BUZZ
3. 数字能被3整除，也能被5整除，输出FIZZBUZZ
4. 数字不能被3整除，也不能被5整除，抛出异常

### 新需求 - Advanced FizzBuzz Manager
输入：一个整数数字

需求：
1. 基础需求同上
2. 输入的数字需要通过调用第三方服务(InputDecodeClient)解密后获取真实数字才能使用
3. 基础需求的计算结果需要同步给另一个第三方系统(ResultDisplayClient)
4. 基础需求的计算结果需要保存进入数据库