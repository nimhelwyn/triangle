package main

object Main extends App{

  val fileName = args(0)

  val reader = new ReadFile

  val rootNode = reader.readIt(fileName)

  val processTriangle = new ProcessTriangle

  val allRoutes = processTriangle.processRoutes(rootNode)

  val minPath = processTriangle.searchMinPath(allRoutes)

  print(processTriangle.printResult(minPath, rootNode))

}
