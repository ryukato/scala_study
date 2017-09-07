
object SequenceTest {
  def main(args: Array[String]): Unit = {
      import scala.collection.mutable.ListBuffer
      val buf = new ListBuffer[Int]
      buf += 1
      buf += 2
      println(buf)

      3 +=: buf

      println(buf.toList)
  }

}
