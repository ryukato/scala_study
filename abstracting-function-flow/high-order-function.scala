object HighOrderFunctionTest {
  def main(args: Array[String]): Unit = {
    def filesMatching(
      files: Iterable[java.io.File] = (new java.io.File(".")).listFiles,
      query: String,
      matcher: (String, String) => Boolean): Iterable[java.io.File] = {
        files.filter(file => matcher(file.getName, query))
    }

    // filesEnding is partial function of filesMatching
    def filesEnding(query: String) = filesMatching(_: Iterable[java.io.File], query, _.endsWith(_))

    def filesContaining(
      files: Iterable[java.io.File] = (new java.io.File(".")).listFiles,
      query: String
    ) = filesMatching(files, query, _.contains(_))

    //curried function - filesEnding(s: String) returns function(files: Iterable)
    filesEnding(query=".scala")((new java.io.File("./abstracting-function-flow")).listFiles).foreach(file => println(file.getName))

    filesContaining(
      files = (new java.io.File("./abstracting-function-flow")).listFiles,
      query="high-order").foreach(file => println(file.getName))

    // (new java.io.File("./abstracting-function-flow")).listFiles.foreach(file => println(file.getName))

    def filesHere = (new java.io.File(".")).listFiles

    def matchedFiles(matcher: String => Boolean) =
      filesHere.filter(file => matcher(file.getName))

    def fileEndingMatcher(query: String) = matchedFiles(_.endsWith(query))

    fileEndingMatcher(".MD").foreach(println)

  }

}
