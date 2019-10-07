package main

class ProcessTriangle() {

  var routes: List[Route] = Nil

  /**
    * The method which processes all possible paths
    * @param rootNode a node of triangle which contains children as well
    * @param route
    * @return all possible paths to the bottom as List[Route]
    */
  def processRoutes(rootNode: Node, route: Route = Route(0, Nil)): List[Route] = {

    if(rootNode.leftChild.isEmpty && rootNode.rightChild.isEmpty){        //if not a final children element, then we invoke method for children
      val finalRoute = route.copy(sum = route.sum + rootNode.value, dir = route.dir.reverse)
      routes = finalRoute :: routes
    }
    else{
      processRoutes(rootNode.leftChild.get, route.copy(sum = route.sum + rootNode.value,dir = LeftDirection :: route.dir))
      processRoutes(rootNode.rightChild.get, route.copy(sum = route.sum + rootNode.value,dir = RightDirection :: route.dir))

    }
    routes
  }

  /**
    * This method select minimum path by sum value
    * @param routeList all possible paths
    * @return minimum oath as Route
    */
  def searchMinPath(routeList : List[Route]) = {
    var minPath = routeList(0)

    for(route <- routeList){
      if (route.sum < minPath.sum) minPath = route
    }
    minPath
  }

  /**
    * This method prints the stack of minimum path
    * @param route the Route of minimum path
    * @param rootNode the root element of the triangle
    */
  def printResult(route: Route, rootNode: Node) = {

    print("Minimum path is: ")
    var node = rootNode

      for (path <- route.dir) {
        if (node.leftChild.nonEmpty && node.rightChild.nonEmpty) {
          print(node.value + " + ")
          if (path == LeftDirection) {
            node = node.leftChild.get
          }
          if (path == RightDirection) {
            node = node.rightChild.get
          }
        }
      }
    println(node.value + " = " + route.sum)
    }

}
