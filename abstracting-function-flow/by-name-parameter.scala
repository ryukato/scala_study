object ByNameParameterTest {
  def main(args: Array[String]): Unit = {
    var assertionsEnabled = true

    def byNameAssert(predicate: => Boolean): Unit =
      if (assertionsEnabled && !predicate) throw new AssertionError

    byNameAssert(5 > 3)

    assertionsEnabled = false
    byNameAssert(5 < 3) // AssertionError is not thrown since predicate is passed as call-by-name parameter.
    /*
    call-by-name parameter is not evaluated before passed into function or method
    */

  }

}
