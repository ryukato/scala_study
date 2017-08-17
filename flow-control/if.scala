object IfTest {
  def main(args: Array[String]): Unit = {
    val filename = if (!args.isEmpty) args(0) else "default.txt"
    println(filename)
  }
}
