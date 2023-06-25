import java.util.*

class Solution {
    fun dijkstra(graph: Array<IntArray>, start: Int): IntArray {
        val n = graph.size
        val dist = IntArray(n) { Int.MAX_VALUE }
        val visited = BooleanArray(n)

        dist[start] = 0

        for (i in 0 until n) {
            val u = findMinDistance(dist, visited)
            visited[u] = true

            for (v in 0 until n) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Int.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v]
                }
            }
        }

        return dist
    }

    private fun findMinDistance(dist: IntArray, visited: BooleanArray): Int {
        var min = Int.MAX_VALUE
        var minIndex = -1

        for (v in dist.indices) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v]
                minIndex = v
            }
        }

        return minIndex
    }
}

fun main() {
    val graph = arrayOf(
        intArrayOf(0, 1, 0, 0, 2),
        intArrayOf(1, 0, 3, 0, 0),
        intArrayOf(0, 3, 0, 2, 0),
        intArrayOf(0, 0, 2, 0, 1),
        intArrayOf(2, 0, 0, 1, 0)
    )

    val solution = Solution()
    val start = 0
    val dist = solution.dijkstra(graph, start)

    println("Shortest distances from vertex $start:")
    for (i in dist.indices) {
        println("Vertex $i: ${dist[i]}")
    }
}

/**
 *
 *     val graph = arrayOf(
 *         intArrayOf(0, 1, 0, 0, 2),
 *         intArrayOf(1, 0, 3, 0, 0),
 *         intArrayOf(0, 3, 0, 2, 0),
 *         intArrayOf(0, 0, 2, 0, 1),
 *         intArrayOf(2, 0, 0, 1, 0)
 *     )
 *
 *
 *
 *
 * 정점 0과 정점 1은 간선으로 연결되어 있으며, 가중치는 1입니다.
 * 정점 0과 정점 4는 간선으로 연결되어 있으며, 가중치는 2입니다.
 * 정점 1과 정점 2는 간선으로 연결되어 있으며, 가중치는 3입니다.
 * 정점 2와 정점 3은 간선으로 연결되어 있으며, 가중치는 2입니다.
 * 정점 3과 정점 4는 간선으로 연결되어 있으며, 가중치는 1입니다.
 */