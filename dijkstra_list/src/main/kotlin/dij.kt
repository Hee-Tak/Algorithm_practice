import java.util.*

data class Edge(val destination: Int, val weight: Int)

fun dijkstra(graph: Array<MutableList<Edge>>, source: Int): IntArray {
    val n = graph.size
    val distance = IntArray(n) { Int.MAX_VALUE }
    val visited = BooleanArray(n)

    distance[source] = 0

    val priorityQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    priorityQueue.offer(source to 0)

    while (priorityQueue.isNotEmpty()) {
        val (vertex, dist) = priorityQueue.poll()

        if (visited[vertex]) continue

        visited[vertex] = true

        for (edge in graph[vertex]) {
            val newDistance = dist + edge.weight

            if (newDistance < distance[edge.destination]) {
                distance[edge.destination] = newDistance
                priorityQueue.offer(edge.destination to newDistance)
            }
        }
    }

    return distance
}

fun main() {
    val n = 5 // 그래프의 정점 수

    // 인접 리스트 생성
    val graph = Array(n) { mutableListOf<Edge>() }

    // 간선 추가
    graph[0].add(Edge(1, 9))
    graph[0].add(Edge(2, 3))
    graph[0].add(Edge(3, 2))
    graph[0].add(Edge(4, 7))
    graph[2].add(Edge(1, 2))
    graph[2].add(Edge(3, 4))

    val source = 0 // 출발 정점

    val shortestDistances = dijkstra(graph, source)

    for (i in shortestDistances.indices) {
        println("Distance from $source to $i: ${shortestDistances[i]}")
    }
}