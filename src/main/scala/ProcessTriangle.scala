package main

class ProcessTriangle() {

  var routes: List[Route] = Nil

  def processRoutes(rootNode: Node, route: Route = Route(0, Nil)): List[Route] = {

    if(rootNode.leftChild == None && rootNode.rightChild == None){
      val finalRoute = route.copy(sum = route.sum + rootNode.value)
      routes = finalRoute :: routes
    }
    else{
      processRoutes(rootNode.leftChild.get, route.copy(sum = route.sum + rootNode.value,dir = LeftDirection :: route.dir))
      processRoutes(rootNode.rightChild.get, route.copy(sum = route.sum + rootNode.value,dir = RightDirection :: route.dir))

    }
    routes
  }

  def searchMinPath = ???

  def printResult(route: Route) = {

  }

}
