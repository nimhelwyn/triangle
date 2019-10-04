package main

import scala.io.Source

class ReadFile {

  /**
    * This method reads
    * @param fileName the path of the source file
    * @return a list of lines in the source file
    */
  def readIt(fileName: String) = {
    for (line <- Source.fromFile(fileName).getLines.toList) yield line
  }

  def processLine(line: String) = {
    val lineAsList = line.split(" ")
    val lineAsListInt = lineAsList.map{
      item => item.toInt
    }
    lineAsListInt
  }

  

}
