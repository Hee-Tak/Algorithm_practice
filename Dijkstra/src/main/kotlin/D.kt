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
    println("========================================")

    val graph1 = arrayOf(
        intArrayOf(0, 1, 0, 2, 0),
        intArrayOf(1, 0, 3, 0, 2),
        intArrayOf(0, 3, 0, 0, 1),
        intArrayOf(2, 0, 0, 0, 2),
        intArrayOf(0, 2, 1, 2, 0)
    )

    val sol1 = Solution()
    val start1 = 0
    val dist1 = sol1.dijkstra(graph1, start1)

    println("Shortest distances from vertex $start:")
    for(i in dist1.indices){
        println("Vertex $i: ${dist1[i]}")
    }
    println("==============================================")
}

/**
 *     val graph = arrayOf(
 *         intArrayOf(0, 1, 0, 0, 2),
 *         intArrayOf(1, 0, 3, 0, 0),
 *         intArrayOf(0, 3, 0, 2, 0),
 *         intArrayOf(0, 0, 2, 0, 1),
 *         intArrayOf(2, 0, 0, 1, 0)
 *     )
 * 정점 0과 정점 1은 간선으로 연결되어 있으며, 가중치는 1입니다.
 * 정점 0과 정점 4는 간선으로 연결되어 있으며, 가중치는 2입니다.
 * 정점 1과 정점 2는 간선으로 연결되어 있으며, 가중치는 3입니다.
 * 정점 2와 정점 3은 간선으로 연결되어 있으며, 가중치는 2입니다.
 * 정점 3과 정점 4는 간선으로 연결되어 있으며, 가중치는 1입니다.
 */


fun a(){
    val graph1 = arrayOf(
        intArrayOf(0, 2, 0, 0, 6, 8, 0, 0, 0),  //0
        intArrayOf(2, 0, 15, 0, 0, 0, 9, 0, 0), //1
        intArrayOf(0, 15, 0, 2, 0, 0, 1, 0, 0), //2
        intArrayOf(0, 0, 2, 0, 0, 0, 0, 0, 7),  //3
        intArrayOf(6, 0, 0, 0, 0, 6, 0, 3, 0),  //4
        intArrayOf(8, 0, 0, 0, 6, 0, 4, 0, 0),  //5
        intArrayOf(0, 9, 1, 0, 0, 4, 0, 5, 11), //6
        intArrayOf(0, 0, 0, 0, 3, 0, 5, 0, 12), //7
        intArrayOf(0, 0, 0, 7, 0, 0, 11, 12, 0) //8
    )

    val graph2 = arrayOf(   //시작노드, 인접노드, 가중치
        intArrayOf(0, 1, 2),
        intArrayOf(0, 5, 8),
        intArrayOf(0, 4, 6),
        intArrayOf(1, 2, 15),
        intArrayOf(1, 6, 9),
        intArrayOf(2, 3, 2),
        intArrayOf(2, 6, 1),
        intArrayOf(3, 8, 7),
        intArrayOf(4, 5, 6),
        intArrayOf(4, 7, 3),
        intArrayOf(5, 6, 4),
        intArrayOf(6, 7, 5),
        intArrayOf(6, 8, 11),
        intArrayOf(7, 8, 12)
    )
}