
/**
 * 다익스트라 알고리즘 :
 * 한 출발점에서 다른 모든 정점까지의 최단 경로를 찾는 알고리즘
 */

import java.util.PriorityQueue

data class Edge(val to: Int, val weight: Int)

fun dijkstra(graph: List<List<Edge>>, start: Int): IntArray {
    val n = graph.size
    val distance = IntArray(n) { Int.MAX_VALUE }
    distance[start] = 0

    val pq = PriorityQueue<Pair<Int, Int>>(compareBy {it.second})
    pq.offer(Pair(start, 0))

    while(pq.isNotEmpty()){
        val (node, dist) = pq.poll()

        if(distance[node] < dist) continue

        for(edge in graph[node]) {
            val newDist = distance[node] + edge.weight
            if(newDist < distance[edge.to]) {
                distance[edge.to] = newDist
                pq.offer(Pair(edge.to, newDist))
            }
        }
    }
    return distance
}

// graph : 인접 리스트 형태의 그래프
// start : 출발 정점
// dijkstra : 출발 정점에서부터 모든 정점까지의 최단 거리를 계산하여 distance 배열에 저장하고, 반환한다.
// 여기서는 우선순위 큐 를 사용하여 최적화된 방식으로 다익스트라 알고리즘을 구현