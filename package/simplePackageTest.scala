package bobsrockets {
  package navigation {
    class Navigator

    package tests {
      class NavigatorSuite
    }
  }
}

package bobsdelights {
  abstract class Fruit(
    val name: String,
    val color: String
  )


}

object Fruits {
  import bobsdelights.Fruit
  object Apple extends Fruit("apple","red")
}

import java.util.regex

class AStarB {
  val pattern = regex.Pattern.compile("a*b")
}
