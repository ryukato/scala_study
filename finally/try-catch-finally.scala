import java.net.URL
import java.net.MalformedURLException

object TryCatchFinallyTest {
  def main(args: Array[String]): Unit = {
    println(urlFor("http://google.com"))
    println(urlFor("http://google.com").getClass.getName)
  }

  def urlFor(path: String) =
    try {
      new URL(path)
    } catch {
      case e: MalformedURLException => new URL("http://www.scala-lang.org")
    }
}
