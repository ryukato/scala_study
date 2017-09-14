import scala.collection.mutable.Buffer

object Solution {
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner (System.in);
      val numberOfArray = sc.nextInt();
      val numberOfSteps = sc.nextInt();

      val seq:Seq[Buffer[Int]] = createArrayBuffer(numberOfArray);
      var lastAnswer = 0
      for(i <- 0.until(numberOfSteps)) {
        val queryType = sc.nextInt();
        val x = sc.nextInt();
        val y = sc.nextInt();
        val idx = (x ^ lastAnswer) % numberOfArray
        val buf = seq((idx))
        queryType match {
          case 1 => buf.append(y)
          case 2 => {
            lastAnswer = buf((y % buf.length))
            println(lastAnswer)
          }
        }

      }
  }

  def createArrayBuffer[T](n: Int): Seq[Buffer[T]] = {
    val arrayBufferSet = for (i <- 0.until(n)) yield Buffer[T]()
    arrayBufferSet
  }

  trait Query[T, B <: Buffer[T]] {
    def execute(x: Int, y: Int, l: Int, seq: Seq[B]): Option[Int]
    def findSeq(x: Int, lastAnswer: Int, seq: Seq[B]): Option[B] = {
      try {
        val idx = ((x ^ lastAnswer) % seq.size).toInt
        Some(seq(idx))
      } catch {
      case e: Exception => {
        println("findSeq" + e)
        None
      }
      }
    }
  }

  class QueryType1 extends Query[Int, Buffer[Int]] {
    override def execute(x: Int, y: Int, l: Int, seq: Seq[Buffer[Int]]): Option[Int] = {
      val buf = findSeq(x, l, seq).get.append(y)
      None
    }
  }


  class QueryType2 extends Query[Int, Buffer[Int]] {
    override def execute(x: Int, y: Int, l: Int, seq: Seq[Buffer[Int]]): Option[Int] = {
      val buf = findSeq(x, l, seq).get
      val newLastAnswer = buf(y % buf.length)
      Some(newLastAnswer)
    }
  }

  object QueryBuilder {
    def build(t: Int): Query[Int, Buffer[Int]] = t match {
      case 1 => new QueryType1()
      case 2 => new QueryType2()
    }
  }


}
