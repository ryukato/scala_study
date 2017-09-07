object Solution {
  def main(args: Array[String]): Unit = {
    val scores = Array(10, 5, 20, 20, 4, 5, 2, 25, 1)
    var lCount = 0;
    var lScore = scores(0)
    var hCount = 0;
    var hScore = scores(0)

    for (s <- scores) {
      if (s < lScore) {
        lCount += 1
        lScore = s
      }
      if (s > hScore) {
        hCount += 1
        hScore = s
      }
    }
    println(hCount + " " + lCount)

  }

}
