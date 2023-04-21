fun main(){
    val graph = Graph()
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(1, 4)
    graph.addEdge(2, 5)

    println("BFS traversal: ")
    graph.bfs(0) // 시작 노드 0 에서 BFS 탐색 시작

}