class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)

  val numer: Int = n/g
  val denom: Int = d/g

  // auxilary constructor
  def this(n: Int) = this(n, 1)

  override def toString() = numer + "/" + denom
  def add(that: Rational): Rational =
    new Rational(numer * that.denom + denom * that.numer, denom * that.denom)

  def multiply(that: Rational): Rational = new Rational(numer * that.numer, denom * that.denom)

  def devide(that: Rational): Rational = new Rational(numer * that.denom, denom * that.numer)

  def minus(that: Rational): Rational = new Rational(numer * that.denom - denom * that.numer, denom * that.denom)

  def +(that: Rational): Rational = this.add(that)

  def +(i: Int): Rational = new Rational(numer + 1 * denom, denom)

  def -(that: Rational): Rational = this.minus(that)

  def -(i: Int): Rational = new Rational(numer - 1 * denom, denom)

  def *(that: Rational): Rational = this.multiply(that)

  def *(i: Int): Rational = new Rational(numer * i, denom)

  def /(that: Rational): Rational = this.devide(that)

  def /(i: Int): Rational = new Rational(numer, denom * i)

  def lessThan(that: Rational): Boolean =
    this.numer * that.denom < that.numer * this.denom
  def max(that: Rational): Rational =
    if (lessThan(that)) that else this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def compare(that: Rational) =
    (this.numer * that.denom) - (that.numer * this.denom)  
}
