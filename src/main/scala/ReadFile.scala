package main

import scala.io.Source

class ReadFile {

  def readIt(fileName: String) = {
    for (line <- Source.fromFile(fileName).getLines()) yield line
  }

}
