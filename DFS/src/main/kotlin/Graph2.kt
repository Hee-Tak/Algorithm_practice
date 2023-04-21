// 그래프의 노드 클래스
class Node(val value: Int){
    val neighbors = mutableListOf<Node>()
    var visited = false
}

// 그래프 클래스
class Graph2 {
    private val nodes = mutableMapOf<Int, Node>()

    // 노드 추가 메서드
    fun addNode(value: Int){
        nodes[value] = Node(value)
    }

    // 간선 추가 메서드
    fun addEdge(from: Int, to: Int){
        val fromNode = nodes[from]
        val toNode = nodes[to]

        // 무방향 그래프라면 양쪽으로 간선 추가
        fromNode?.neighbors?.add(toNode!!)
        toNode?.neighbors?.add(fromNode!!)
    }

    //============================================

    // DFS 메서드
    fun dfs(start: Int){
        val startNode = nodes[start]
        startNode?.let{
            dfsVisit(it)
        }
    }

    // DFS 재귀 함수
    private fun dfsVisit(node: Node){
        node.visited = true
        println("Visited Node: ${node.value}")

        for(neighbor in node.neighbors){
            if(!neighbor.visited){
                dfsVisit(neighbor)
            }
        }

    }


}


// 그래프의 연결 정보를 인접행렬이나 인접리스트를 사용하지 않고,
// 노드와 간선 정보를 클래스로 표현.
// 노드 클래스는 그래프의 노드를 나타내고, 인접한 노드들을 neighbors 리스트에 저장.
// Graph2 클래스에서는 노드와 간선을 추가하는 메서드와 dfs를 구현한 메서드를 제공.
// dfs는 재귀함수로 구현됨