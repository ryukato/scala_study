import scala.collection.immutable.IndexedSeq

object FpStyleTest {
  def main(args: Array[String]): Unit = {
    // println(multiTable)
    println(multiTable2)
  }

  def makeRowSeq(row: Int) =
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }

  def makeRowSeq2(row: Int): IndexedSeq[String] = (1 to 10).map(col => {
    val prod = (row * col).toString
    " " * (4 - prod.length) + prod
  })


  // def makeRow(row: Int) = makeRowSeq(row).mkString
  def makeRow(row: Int) = makeRowSeq2(row).mkString

  def multiTable() = {
    val tableSeq =
      for(row <- 1 to 10)
      yield makeRow(row)

    tableSeq.mkString("\n")
  }

  def multiTable2() = {
    (1 to 10).map(makeRow).mkString("\n")
  }

}
