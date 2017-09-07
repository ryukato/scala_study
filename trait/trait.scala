trait Philosophical {
  def philosophize() = println("I consume memory, therefore I am!")
}

trait HasLegs

class Animal

// class Frog extends Philosophical {
//   override def toString = "green"
// }

class Frog extends Animal with Philosophical with HasLegs {
  override def toString = "green"
  override def philosophize() =
    println("It ain't easy being " + toString + " !")
}

object TraitTest {
  def main(args: Array[String]): Unit = {
    val frog = new Frog
    frog.philosophize()

    val phil: Philosophical = frog
    phil.philosophize()
  }

}
