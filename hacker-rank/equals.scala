
import scala.io.StdIn.readLine
object EqualsTest {
  def main(args: Array[String]): Unit = {
    val numOfTestCases = readLine().trim.toInt
    Range(0, numOfTestCases).foreach(i => {
      val numberCount = readLine().trim.toInt
      val numbers = scala.io.StdIn.readLine().split("""\s+""").map(s => s.trim.toInt)
      println(calOpCount(numbers))
    })

    def steps(i: Int): Int = {
      if (i==0) 0
      else if (i == 1 || i == 2 || i == 5) 1
      else (i/5 + (i%5)/2 + ((i%5)%2))
    }

    def calOpCount(source: Array[Int]): Int = {
       val min = source.min;
       val result = for {base <- 0.to(2)} yield (source.map(s => steps(s - min + base)).sum)
       result.min
    }
  }
}
