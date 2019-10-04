package main

trait Direction

case object LeftDirection extends Direction

case object RightDirection extends Direction

case class Route(sum : Int, dir: List[Direction])
