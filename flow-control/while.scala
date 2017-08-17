object WhileTest {
  def main(args: Array[String]): Unit = {
    println(gcdLoop(66, 72))
    def gcdLoop(x: Long, y: Long): Long = {
      var a = x
      var b = y

      while(a != 0) {
        val temp = a
        a = b % a
        b = temp
      }
      b
    }
  }

}
