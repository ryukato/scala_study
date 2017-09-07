abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

import scala.collection.mutable.ArrayBuffer
class BasicQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) = {println("BasicQueue put"); buf += x}
}

trait Doubling extends IntQueue {  // "Extending IntQueue" means that this trait can be mixed in only sub classes of IntQueue
  abstract override def put(x: Int) = {println("Doubling put"); super.put(2 * x)}
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = {println("Incrementing put"); super.put(x + 1)}
}

trait Fitlering extends IntQueue {
  abstract override def put(x: Int) = {println("Filtering put"); if (x >= 0 ) super.put(x)}
}

class MyDoublingQueue extends BasicQueue with Doubling

object StackableModificationTest {
  def main(args: Array[String]): Unit = {
    // val queue = new MyDoublingQueue
    // queue.put(10)
    // println(queue.get())
    //
    // val queue2 = new BasicQueue with Doubling
    // queue2.put(10)
    // println(queue2.get())

    val queueWithIncrementingAndFiltering = new BasicQueue with Incrementing with Fitlering with Doubling // Doubling -> Filtering -> Incrementing -> BasicQueue
    queueWithIncrementingAndFiltering.put(10)
    println(queueWithIncrementingAndFiltering.get())
  }

}
