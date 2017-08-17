object SpecialFunctionTest {
  def main(args: Array[String]): Unit = {
    def echo(args: String*) = args.foreach(println)

    echo("one", "two")
    echo(Array("one", "two", "three"): _*)

    // named parameters

    def speed(distance: Int, time: Float): Float =
      distance / time


    println(speed(100, 10))
    println(speed(time=10, distance = 100))

    //default value parameters

    def printTime(out: java.io.PrintStream = Console.out) =
      out.println("time = " + System.currentTimeMillis())

    printTime()
    printTime(Console.err)
  }

}
