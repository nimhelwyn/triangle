package main

import scala.io.Source

class ReadFile {

  /**
    * This method reads the triangle from file
    * @param fileName the path of the source file
    * @return the root Node of the triangle
    */
  def readIt(fileName: String) = {
    val temp = for (line <- Source.fromFile(fileName).getLines.toList) yield line
    buildNodes(temp)
  }


  /**
    * This method split the lines into distinct strings and cast these strings to Int
    * @param line the line of the triangle
    * @return the line as a list of Ints
    */
  private def processLine(line: String) = {
    val lineAsList = line.split(" ")
    val lineAsListInt = lineAsList.map{
      item => item.toInt
    }
    lineAsListInt
  }

  /**
    * This method generates the Node system of the triangle
    * @param lines the list of lines for the triangle
    * @return the root Node
    */
  private def buildNodes(lines: List[String]) = {

    val values = lines.map{
      item => processLine(item)
    }

    val valuesReversed = values.reverse

    val nodeArrayList = valuesReversed.map{ array =>
        array.map(
          item => Node(item, None, None)
        )
    }

    def nodeSystem = {

      var nodeListList = nodeArrayList.map { array =>
        array.toList
      }

      for (i <- 1 until nodeListList.length) {

        nodeListList = nodeListList.map { item =>

          val temp = nodeListList(i)
          val temp2 = nodeListList(i - 1)

          if (item == temp) {
            item.map { node =>
              Node(node.value, Some(temp2(temp.indexOf(node))), Some(temp2(temp.indexOf(node) + 1)))
            }
          }
          else item
        }
      }
      val out = nodeListList.reverse(0)
      out(0)
    }
    nodeSystem
  }

}
