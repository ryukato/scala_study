class Dollar(val amount: Int) extends AnyVal {
  override def toString() = "$" + amount
}

object ValueClassTest {
  def main(args: Array[String]): Unit = {
    val oneDollar = new Dollar(1)
    println(oneDollar.amount)
    println(oneDollar.toString)
  }

}
