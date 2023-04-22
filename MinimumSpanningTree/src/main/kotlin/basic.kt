// 최소 신장 트리 Minimum Spanning Tree (MST)
// 그래프에서 모든 노드를 연결하면서
// 가장 적은 비용을 갖는 트리를 찾는 알고리즘

// 크루스칼 Kruskal
// 프림 Prim
// 보르우카 Boruvka

fun main(){
    //Prim Algorithm
    val graph = Graph()
    graph.addEdge(0, 1, 4)
    graph.addEdge(0, 2, 3)
    graph.addEdge(1, 2, 1)
    graph.addEdge(1, 3, 2)
    graph.addEdge(2, 3, 4)
    graph.addEdge(3, 4, 2)
    graph.addEdge(4, 5, 6)
    println(graph.primMST())    //출력 : 16
    //===========================================
    //Kruskal Algorithm
    val graph1 = Graph1()
    graph1.addEdge(0, 1, 9)
    graph1.addEdge(0, 2, 12)
    graph1.addEdge(1, 2, 6)
    graph1.addEdge(1, 3, 18)
    graph1.addEdge(1, 4, 10)
    graph1.addEdge(2, 4, 8)
    graph1.addEdge(3, 4, 15)
    graph1.addEdge(3, 5, 20)
    val mst = graph1.kruskalMST()
    println("Minimum Spanning Tree:")
    for(edge in mst){
        println("${edge.u} - ${edge.v} : ${edge.weight}")
    }
    //==========================================

}



