package main

object Main extends App{

  val fileName = args(0)

  val reader = new ReadFile

  val lines = reader.readIt(fileName)



}
