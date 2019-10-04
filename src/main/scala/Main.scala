package main

object Main extends App{

  val fileName = args(0)

  val reader = new ReadFile

  val rootNode = reader.readIt(fileName)

  val processTriangle = new ProcessTriangle

  val allRoutes = processTriangle.processRoutes(rootNode)

  allRoutes.foreach{
    item => println(item)
  }

  val minPath = processTriangle.searchMinPath(allRoutes)

  println(processTriangle.printResult(minPath, rootNode))
}
