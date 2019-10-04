package main

class ProcessTriangle() {

  var routes: List[Route] = Nil

  def processRoutes(rootNode: Node, route: Route = Route(0, Nil)): List[Route] = {

    if(rootNode.leftChild.isEmpty && rootNode.rightChild.isEmpty){
      val finalRoute = route.copy(sum = route.sum + rootNode.value, dir = route.dir.reverse)
      routes = finalRoute :: routes
    }
    else{
      processRoutes(rootNode.leftChild.get, route.copy(sum = route.sum + rootNode.value,dir = LeftDirection :: route.dir))
      processRoutes(rootNode.rightChild.get, route.copy(sum = route.sum + rootNode.value,dir = RightDirection :: route.dir))

    }
    routes
  }

  def searchMinPath(routeList : List[Route]) = {
    var minPath = routeList(0)

    for(route <- routeList){
      if (route.sum < minPath.sum) minPath = route
    }
    minPath
  }

  def printResult(route: Route, rootNode: Node) = {

    print("Minimum path is: ")
    var node = rootNode

      for (path <- route.dir) {
        if (node.leftChild.isEmpty && node.rightChild.isEmpty) {
          println(" = " + route.sum)
        }
        else {
          if (path == LeftDirection) {
            print(node.value + " + ")
            node = node.leftChild.get
          }
          if (path == RightDirection) {
            print(node.value + " + ")
            node = node.rightChild.get
          }
        }
      }
    }

}
