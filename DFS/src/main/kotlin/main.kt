fun main(){
    val graph = Graph(7)
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(1, 4)
    graph.addEdge(2, 5)
    graph.addEdge(2, 6)

    println("DFS Traversal: ")
    graph.dfs(0)
    //===================================
    val graph1 = Graph1(7)
    graph1.addEdge(0, 1)
    graph1.addEdge(0, 2)
    graph1.addEdge(1, 3)
    graph1.addEdge(1, 4)
    graph1.addEdge(2, 5)
    graph1.addEdge(2, 6)

    println("DFS Traversal: ")
    graph1.dfs(0)
    //==================================
    val graph2 = Graph2()
    graph2.addNode(0)
    graph2.addNode(1)
    graph2.addNode(2)
    graph2.addNode(3)
    graph2.addNode(4)
    graph2.addNode(5)
    graph2.addNode(6)

    graph2.addEdge(0, 1)
    graph2.addEdge(0, 2)
    graph2.addEdge(1, 3)
    graph2.addEdge(1, 4)
    graph2.addEdge(2, 5)
    graph2.addEdge(2, 6)

    graph2.dfs(0)



}


// dfs : 깊이 우선 탐색
// 그래프의 탐색 방법 중 하나로, 시작 노드에서 출발하여 인접한 노드들을 재귀적으로 탐색하는 방식.
// 그래프의 연결 정보가 인접 행렬로 주어져있다면, 인접 행렬을 활용하여 DFS를 구현할 수 있음
// 인접리스트도 마찬가지

// 하지만, 예를 들어 그래프가 특정한 규칙에 따라 생성되는 경우나,
// 입력 데이터가 특정한 형태로 주어져 그래프를 생성하는 경우 등에는 인접리스트(행렬)을 사용하지 않고 DFS를 구현할 수 있다.
// 이러한 경우에는 그래프의 연결 정보를 직접 처리하거나, 필요한 정보를 저장하는 변수를 이용하여 DFS를 구현할 수 있다.
