object CurryingTest {
  def main(args: Array[String]): Unit = {
    println(plainOldSum(1,2))
    println(curriedSum(1)(2))
    println(curriedSum2(1)(2))

    val onePlus = curriedSum(1)_
    println(onePlus)
    println(onePlus(5))

    println(twice( _ +1, 5)) // 5 + 1 => + 1 => 7.0

    withPrintWriter(new java.io.File("date.txt"), writer => writer.println(new java.util.Date))
  }
  def plainOldSum(x: Int, y: Int) = x + y

  def curriedSum(x: Int)(y: Int) = x + y
  def curriedSum2(x: Int) = plainOldSum(x: Int, _: Int)

  def twice(op: Double => Double, x: Double) = op(op(x))

  def withPrintWriter(file: java.io.File, op: java.io.PrintWriter => Unit) = {
    val writer = new java.io.PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

}
