class Graph1(val n: Int){
    private val adjMatrix = Array(n) {BooleanArray(n){ false } }
    private val visited = BooleanArray(n) { false }

    fun addEdge(u: Int, v: Int){
        adjMatrix[u][v] = true
        adjMatrix[v][u] = true
    }

    fun dfs(start: Int){
        visited[start] = true
        print("$start ")

        for(next in 0 until n){
            if(adjMatrix[start][next] && !visited[next]){
                dfs(next)
            }
        }

    }

}
// 인접 행렬과 인접 리스트는 그래프를 표현하고 알고리즘을 구현하는 두가지 주요한 방법이다.
// 인접 행렬은 2차원 배열로 그래프를 표현하며, 노드간의 연결 정보를 행렬의 원소로 저장한다.
// 인접 행렬은 노드 간의 연결 여부를 빠르게 확인할 수 있어 O(1)의 시간 복잡도를 가지지만, 그래프의 크기가 크면 공간 복잡도가 높아질 수 있다.
// 또한, 노드의 개수가 많지 않은 경우에만 사용 가능
