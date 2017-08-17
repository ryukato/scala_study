object MatchTest {
  def main(args: Array[String]): Unit = {
    val firstArgs = if (args.length > 0) args(0) else ""

    firstArgs match {
      case "salt" => println("pepper")
      case "chips" => println("salsa")
      case "eggs" => println("bacon")
      case _ => println("huh?")
    }

    println(getMatch(firstArgs))
  }

  def getMatch(s: String) = s match {
    case "salt" => "pepper"
    case "chips" => "salsa"
    case "eggs" => "bacon"
    case _ => "huh?"
  }
}
