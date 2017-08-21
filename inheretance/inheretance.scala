// import Element.elem

abstract class Element {
  import Element.elem
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length
  def demo() = println("Element's implementation invoked")
  // def above(that: Element): Element =
  //   new ArrayElement(this.contents ++ that.contents)
  // def above(that: Element): Element =
  //   elem(this.contents ++ that.contents)

  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }

  def widen(w: Int): Element = {
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) /2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }
  }

  def heighten(h: Int): Element = {
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) /2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }
  }

  // def beside(that: Element): Element =
  //   new ArrayElement(
  //     for (
  //       (line1, line2) <- this.contents zip that.contents
  //     ) yield line1 + line2
  //   )

  // def beside(that: Element): Element =
  //   elem(
  //     for (
  //       (line1, line2) <- this.contents zip that.contents
  //     ) yield line1 + line2
  //   )

  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for ((line1, line2) <- this1.contents zip that1.contents) yield line1 + line2
    )
  }

  override def toString = contents mkString "\n"
}

object Element { //compainon object for factory methods

  // class ArrayElement(conts: Array[String]) extends Element {
  //   def contents: Array[String] = conts
  // }

  private class ArrayElement(val contents: Array[String]) extends Element {
    override def demo() = println("ArrayElement's implementation invoked")
  }
  /*
  class LineElement(s: String) extends ArrayElement(Array(s)) {
    override def width = s.length
    override def height = 1
    final override def demo() = println("LineElement's implementation invoked")
  }
  */

  private class LineElement(s: String) extends Element {
    val contents = Array(s)
    override def width = s.length
    override def height = 1
    final override def demo() = println("LineElement's implementation invoked")
  }

  private class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int
  ) extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element = new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element = new UniformElement(chr, width, height)

  def elem(line: String): Element = new LineElement(line)
}




object InheretanceTest {
  def main(args: Array[String]): Unit = {
    // val ae = new ArrayElement(Array("hello", "world"))
    // println(ae)
    // println(ae.width)
    //
    // val e: Element = new ArrayElement(Array("hello", "world"))
    // println(e)
    // println(e.width)
    //
    // val e3: Element = new UniformElement('x', 2, 3)
    // println(e3.contents.mkString(""))
    //
    // e3.demo()
  }

}
