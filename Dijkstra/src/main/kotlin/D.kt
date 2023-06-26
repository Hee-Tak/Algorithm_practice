import java.util.*

class Solution {
    fun dijkstra(graph: Array<IntArray>, start: Int): IntArray {    //인접 행렬 방식 그래프 꺼먹음
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

    fun dijkstraTrack(graph: Array<IntArray>, start: Int, end: Int): Pair<Int, List<Int>> {
        val n = graph.size
        val dist = IntArray(n) { Int.MAX_VALUE }
        val visited = BooleanArray(n)
        val previous = IntArray(n) { -1 }

        dist[start] = 0

        for(i in 0 until n){
            val u = findMinDistance(dist, visited)
            visited[u] = true

            for(v in 0 until n){
                if(!visited[v] && graph[u][v] != 0 && dist[u] != Int.MAX_VALUE && dist[u]+graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v]
                    previous[v] = u
                }
            }
        }

        val path = mutableListOf<Int>()
        var current = end
        while(current != -1){
            path.add(current)
            current = previous[current]
        }

        path.reverse()
        return Pair(dist[end], path)

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

    val graph2 = a()
    val sol2 = Solution()
    val start2 = 0

    val dist2 = sol2.dijkstra(graph2, start2)
    println("시작정점 ${start}으로부터의 최단 거리")
    for(i in dist2.indices){
        println("Vertex $i: ${dist2[i]}")
    }
    println("=============================================")

    val end2 = 8
    val result = sol2.dijkstraTrack(graph2, start2, end2)
    val shortestDistance = result.first
    val shortestPath = result.second
    println("Shortest Distance : $shortestDistance")
    println("Shartest Path : $shortestPath")

    println("=============================================")

    val graph3 = a()
    val sol3 = Solution()

    print("시작 노드를 입력하세요(0 ~ 8): ")
    var start3 = readLine()?.toInt()
    if(start3 !in 0..8){

        println("좀 똑바로 입력하지 에휴")
        start3 = (0..8).random()
    }
    println("시작노드 : $start3")
    print("목표 노드를 입력하세요(0 ~ 8): ")
    var end3 = readLine()?.toInt()
    if(end3 !in 0..8){ //|| end3 == start)

        println("이것도 제대로 안뽑아?")
        //do{
        //    end3 = (0..8).random()
        //} while(end3 == start3)
        end3 = (0..8).random()
    }
    println("목표노드 : $end3")

    val result1 = sol2.dijkstraTrack(graph3, start3!!, end3!!)
    val shortestDistance1 = result1.first
    val shortestPath1 = result1.second
    println("최단 거리 : $shortestDistance1")
    println("최단 경로 : $shortestPath1")

    println("===============================================================")

    val graph4 = b()
    val start4 = 0
    val end4 = 6
    val (distance4, shortestPath4) = graph4.dijkstra2(start4, end4)
    println("인접 리스트 Shortest distance from $start4 to $end4 : $distance4")
    println("인접 리스트 Shortest path: $shortestPath4")


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


fun a(): Array<IntArray>{   //인접 행렬 방식
    val graph1 = arrayOf( //인접행렬
        intArrayOf(0, 2, 0, 0, 6, 8, 0, 0, 0),  //0
        intArrayOf(2, 0, 15, 0, 0, 0, 9, 0, 0), //1
        intArrayOf(0, 15, 0, 2, 0, 0, 1, 0, 0), //2
        intArrayOf(0, 0, 2, 0, 0, 0, 0, 0, 7),  //3
        intArrayOf(6, 0, 0, 0, 0, 6, 0, 3, 0),  //4
        intArrayOf(8, 0, 0, 0, 6, 0, 4, 0, 0),  //5
        intArrayOf(0, 9, 1, 0, 0, 4, 0, 5, 11), //6
        intArrayOf(0, 0, 0, 0, 3, 0, 5, 0, 12), //7
        intArrayOf(0, 0, 0, 7, 0, 0, 11, 12, 0) //8
    ) // 인접 행렬 형태의 그래프
    // 노드들 간의 연결 관계를 2차원 배열로 나타내는 방식


    return graph1
}

fun b(): adjListGraph {     //인접 리스트 방식
    val n = 9
    val graph = adjListGraph(n)
    graph.addEdge(0, 1, 2)
    graph.addEdge(0, 5, 8)
    graph.addEdge(0, 4, 6)
    graph.addEdge(1, 2, 15)
    graph.addEdge(1, 6, 9)
    graph.addEdge(2, 3, 2)
    graph.addEdge(2, 6, 1)
    graph.addEdge(3, 8, 7)
    graph.addEdge(4, 5, 6)
    graph.addEdge(4, 7, 3)
    graph.addEdge(5, 6, 4)
    graph.addEdge(6, 7, 5)
    graph.addEdge(6, 8, 11)
    graph.addEdge(7, 8, 12)

    return graph


    //시작노드, 인접노드, 가중치
    // 간선의 정보를 인접 리스트 형태로 표현한 것
}

class adjListGraph(val n: Int){
    val adjList: MutableList<MutableList<Pair<Int, Int>>> = MutableList(n) { mutableListOf() }

    fun addEdge(u: Int, v: Int, weight: Int){
        adjList[u].add(Pair(v, weight))
        adjList[v].add(Pair(u, weight)) // 무방향 그래프인 경우 추가
    }

    fun dijkstra2(start: Int, end: Int): Pair<Int, List<Int>> {
        val dist = IntArray(n) { Int.MAX_VALUE }
        val previous = IntArray(n) { -1 }
        val visited = BooleanArray(n)

        dist[start] = 0

        val priorityQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        priorityQueue.offer(Pair(start, 0))

        while(priorityQueue.isNotEmpty()){
            val (current, _) = priorityQueue.poll()

            if(visited[current]) continue

            visited[current] = true

            for((neighbour, weight) in adjList[current]){
                val newDistance = dist[current] + weight
                if(newDistance < dist[neighbour]) {
                    dist[neighbour] = newDistance
                    previous[neighbour] = current
                    priorityQueue.offer(Pair(neighbour, newDistance))
                }
            }
        }

        val path = mutableListOf<Int>()
        var current = end
        while(current != -1){
            path.add(current)
            current = previous[current]
        }
        path.reverse()

        return Pair(dist[end], path)
    }
}


/**
 * 아래는 인접행렬 다익스트라
 */
fun dijkstra4(graph: Array<IntArray>, start: Int, end: Int): Int {
    val n = graph.size
    val dist = IntArray(n) { Int.MAX_VALUE }
    val visited = BooleanArray(n)

    dist[start] = 0

    for (i in 0 until n) {
        val u = findMinDistance1(dist, visited)
        visited[u] = true

        for (v in 0 until n) {
            if (!visited[v] && graph[u][v] != 0 && dist[u] != Int.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                dist[v] = dist[u] + graph[u][v]
            }
        }
    }

    return dist[end]
}

private fun findMinDistance1(dist: IntArray, visited: BooleanArray): Int {
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