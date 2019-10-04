package main

object Main extends App{

  val fileName = args(0)

  val reader = new ReadFile

  reader.readIt(fileName)


}
