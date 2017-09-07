class Outer {
  class Inner {
    private def f() = println("f")

    class InnerMost {
      f() // no problem
    }
  }

  // (new Inner).f() // compile error -> not able to find f since it is private
}

package p {
  class Super {
    protected def f() = println("f")
  }

  class Sub extends Super {
    f()
  }

  class Other {
    (new Super).f() // compile error since f of Super is protected access.
  }
}
