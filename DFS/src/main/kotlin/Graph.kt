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
