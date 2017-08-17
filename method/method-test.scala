import scala.io.Source

object LongLines {
  def processFile(filename: String, width: Int) = {
    // val source:Source = Source.fromFile(filename)
    // for(line <- source.getLines())
    //   processLine(filename, width, line)

    /*
    // we can declare a function in another function
    def readLinesOfFile(filename: String): Iterator[String] = {
      try {
        Source.fromFile(filename).getLines
      }catch{
        case e: java.io.IOException => Iterator()
      }
    }
    */
    val filter = (s: String) => s.trim.length > width
    // readLinesOfFile(filename).filter(line => line.length > width).foreach(line => println(filename + ": " + line.trim))
    readLinesOfFile(filename).filter(filter).foreach(line => println(filename + ": " + line.trim))
  }

  def readLinesOfFile(filename: String): Iterator[String] = {
    try {
      Source.fromFile(filename).getLines
    }catch{
      case e: java.io.IOException => Iterator()
    }
  }

  def processLine(filename: String, width: Int, line: String) = {
    if (line.length > width)
      println(filename + ": " + line.trim)
  }
}

object FindLongLines {
  def main(args: Array[String]): Unit = {
    val width = args(0).toInt
    for(arg <- args.drop(1))
      LongLines.processFile(arg, width)
  }
}
