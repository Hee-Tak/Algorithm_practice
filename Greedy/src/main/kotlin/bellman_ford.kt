import java.lang.Exception

/**
 * 벨만-포드 알고리즘 :
 * 음의 가중치를 허용하는 그래프에서 최단 경로를 찾는 알고리즘
 */

fun bellmanFord(graph: Array<IntArray>, start: Int, n: Int): IntArray {
    val distances = IntArray(n) { Int.MAX_VALUE }
    distances[start] = 0

    for (i in 0 until n - 1) {
        for (from in 0 until n) {
            for (to in 0 until n) {
                if (graph[from][to] != Int.MAX_VALUE
                    && distances[from] != Int.MAX_VALUE
                    && distances[from] + graph[from][to] < distances[to]
                ) {
                    distances[to] = distances[from] + graph[from][to]
                }
            }
        }
    }

    return distances
}

// graph : 간선의 리스트를 나타냄
// start : 출발 정점,
// n : 정점의 개수
// bellmanFord : 출발 정점에서 부터 모든 정점까지의 최단 거리를 계산하여 distances 배열에 저장하고, 반환함




//============================================================
data class Edge3(val src: Int, val dest: Int, val weight: Int)

fun bellmanFord(edges: List<Edge3>, source: Int, V: Int): List<Int> {
    //출발점을 제외한 모든 정점까지의 거리를 무한대로 초기화
    val distances = MutableList(V) { Int.MAX_VALUE }
    distances[source] = 0

    //모든 간선을 순회하며 V-1 번 Relaxation을 수행
    for(i in 1 until V){
        for(edge in edges){
            val u = edge.src
            val v = edge.dest
            val weight = edge.weight

            if(distances[u] != Int.MAX_VALUE && distances[u] + weight < distances[v]) {
                distances[v] = distances[u] + weight
            }
        }
    }

    // 음수 사이클이 있는지 체크
    for(edge in edges) {
        val u = edge.src
        val v = edge.dest
        val weight = edge.weight

        if(distances[u] != Int.MAX_VALUE && distances[u] + weight < distances[v]) {
            throw Exception("Graph contains a negative-weight cycle")
        }
    }

    return distances
}