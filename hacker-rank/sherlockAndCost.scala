import scala.io.StdIn.readLine
object SherlockAndCost {
  def main(args: Array[String]): Unit = {
    val numOfTestCases = readLine().trim.toInt

    0.until(numOfTestCases).foreach(_ => {
        val N = readLine().trim.toInt
        val numbers = scala.io.StdIn.readLine().split("""\s+""").map(s => s.trim.toInt)
        println(solve(numbers))
    })

    def solve(numbers: Array[Int]): Int = {
      var dpLow = 0
      var dpHigh = 0
      1.until(numbers.length).foreach(i => {
        val newLow = Math.max(dpLow, dpHigh + numbers(i-1)-1)
        val newHigh = Math.max(dpLow + numbers(i)-1, dpHigh + Math.abs(numbers(i)-numbers(i-1)))
        dpLow = newLow
        dpHigh = newHigh
      })
      Math.max(dpLow, dpHigh)
    }
  }
}
