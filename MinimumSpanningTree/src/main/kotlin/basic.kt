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
    println("=============================")
    //==========================================
    //Boruvka Algorithm
    val graph2 = listOf(
        Edge2(0, 1, 4),
        Edge2(0, 7, 8),
        Edge2(1, 2, 8),
        Edge2(1, 7, 11),
        Edge2(2, 3, 7),
        Edge2(2, 8, 2),
        Edge2(2, 5, 4),
        Edge2(3, 4, 9),
        Edge2(3, 5, 14),
        Edge2(4, 5, 10),
        Edge2(5, 6, 2),
        Edge2(6, 7, 1),
        Edge2(6, 8, 6),
        Edge2(7, 8, 7)
    )
    /* 생김새
        4       8
      0 --- 1 --- 7
      |  \  /|
     8|   11 |4
      |  /  \|
      2 --- 3 --- 4
           |  9
           |   \
           14   10
            |  /
            5 --- 6
            |   2
            |   |
            6 - 8

     */
    val mst2 = boruvka(graph2, 9)
    // [Edge(src=6, dest=7, weight=1), Edge(src=2, dest=8, weight=2),
    // Edge(src=5, dest=6, weight=2), Edge(src=0, dest=1, weight=4),
    // Edge(src=2, dest=5, weight=4), Edge(src=2, dest=3, weight=7),
    // Edge(src=0, dest=7, weight=8), Edge(src=3, dest=4, weight=9)]
    /*
         4       8
      0 --- 1     |
                7 |
                    |
      |              |
     8|          11 |4
      |              |
      2 --- 3       |
      |       \     |
     4|        14\   |10
      |          \  |
      5 --- 6 --- 7 |
            2     1 |
             \     \|
              6 --- 8
     */
    for(edge in mst2){
        println("${edge.src} - ${edge.dest} : ${edge.weight}")
    }
}



