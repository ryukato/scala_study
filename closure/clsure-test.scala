object ClosureTest {
  def main(args: Array[String]): Unit = {
    var more = 1
    val addMore = (x: Int) => x + more // open term, captures more, which is free vairable. And closure has reference to more variable.
    // val addMore = (x: Int) => x + 1  // closed term
    println(addMore(10))

    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    var sum= 0
    someNumbers.foreach(sum += _)
    println(sum)

    def makeIncreaser(more: Int) = (x: Int) => x + more

    val inc1 = makeIncreaser(1)
    println(inc1(999))
  }

}
