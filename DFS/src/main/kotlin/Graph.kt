class Graph(val n: Int){
    // 인접 리스트 활용
    private val adjList = Array(n){ mutableListOf<Int>()}
    private val visited = BooleanArray(n) { false }

    fun addEdge(u: Int, v: Int){
        adjList[u].add(v)
        adjList[v].add(u)
    }

    fun dfs(start : Int){
        visited[start] = true
        print("$start ")

        for(next in adjList[start]){
            if(!visited[next]){
                dfs(next)
            }
        }
    }


}

// n : 노드의 개수
// addEdge : 간선 추가


// 인접 리스트는 각 노드마다 연결된 노드들의 리스트를 유지하는 방식으로 그래프를 표현함.
// 인접 리스트는 공간 복잡도가 낮아 큰 그래프를 효율적으로 표현할 수 있으며,
// 특정 노드의 인접한 노드들을 찾는데 빠른 시간 복잡도를 가진다. 하지만, 특정 노드 간의 연결 여부를 확인하는 데는 O(n)의 시간 복잡도가 필요


// 따라서, 그래프의 크기와 알고리즘의 특성에 따라
// 인접행렬 또는 인접 리스트 중 하나를 선택하여 사용하면 된다.
// 둘 다 사용하지 않고 그래프 알고리즘을 구현하는 것은 가능하지만, 보다 효율적인 구현을 위해서는
// 적절한 방법을 선택하는 것이 좋다.