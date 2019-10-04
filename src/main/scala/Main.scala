package main

object Main extends App{

  val fileName = args(0)

  val reader = new ReadFile

  val rootNode = reader.readIt(fileName)

  val processTriangle = new ProcessTriangle


}
