object ForTest {
  def main(args: Array[String]): Unit = {
    println("print files of flow control directory")
    val filelist = (new java.io.File("./flow-control")).listFiles
    for(file <- filelist) println(file)

    println("printl iteration from 1 to 4 (including)")
    for(i <- 1 to 4) println("Iteration " + i)

    println("printl iteration from 1 to 4 (excluding)")
    for(i <- 1 until 4) println("Iteration " + i)

    println("print files of flow control directory, but filter .scala. This is imperative style")
    for(file <- filelist)
      if (file.getName.endsWith(".scala")) println(file)

      println("print files of flow control directory, but filter .scala. This is functional style")
    for(
      file <- filelist
      if file.isFile
      if file.getName.endsWith(".scala")
    ) println(file)

    println("Overlapped for loop")

    def fileLines(file: java.io.File) =
      scala.io.Source.fromFile(file).getLines().toList

    def grep(pattern: String) =
      for {
        file <- filelist
        if file.getName.endsWith(".scala") // till here, this is the first loop
        line <- fileLines(file)
        trimmed = line.trim
        if trimmed.matches(pattern) // the second loop
      } println(file + ": " + trimmed)

    grep("println\\((\\w+)\\)")

    println("Yield result from for loop")
    def scalaFiles = for {
      file <- filelist
      if file.getName.endsWith(".scala")
    } yield file

    println(scalaFiles.mkString(", "))
  }
}
