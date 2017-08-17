object FirstClassFuncTest {
  def main(args: Array[String]): Unit = {
    val f = (x: Int) => x + 1
    println(f.apply(1))

    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    someNumbers.filter(x => x > 0).foreach(println)
    someNumbers.filter(_ > 0).foreach(println)
    someNumbers.filter(_ > 0).foreach(println _)
    println(someNumbers.filter(x => x > 100))

    val sumTowNumbers = (_:Int) + (_: Int)
    println(sumTowNumbers.apply(1000, 33333))
  }

}
