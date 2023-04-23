/**
 * 그리디 알고리즘 (Greedy Algorithm) :
 * 최적해를 찾기 위해 각 단계에서 현재 상태에서 가장 좋은 선택을 하는 알고리즘.
 * 각 단계에서 최적의 선택을 하지만, 그 선택이 전체적으로 최적해를 보장하는 것은 아닐 수 있음.
 * 단순하고 빠른 구현이 가능하며, 일부 문제에서는 최적해를 구할 수 있는 효과적인 방법
 *
 * 특징
 * 1. 탐욕적 선택(잘못된 선택을 하지 않음) : 각 단계에서 현재 상태에서 가장 좋은 선택을 함
 * 2. 최적 부분 구조 (Optimal Substructure) : 문제를 작은 부분 문제로 나눌 수 있으며, 작은 부분 문제의 최적해가 전체 문제의 최적해를 보장함
 * 3. 역(또는 순진한) 속성(Greedy Choice Property) : 각 단계에서 선택한 최적해가 전체 최적해로 이어지는 속성이 있음
 *
 * 최소신장트리, 최단경로, 무게할당문제, 회의실 배정 등의 다양한 문제에 적용될 수 있음.
 *
 */


/**
 * 최단 경로 알고리즘 개요
 * 그래프에서 출발점으로부터 다른 정점까지의 가장 짧은 경로를 찾는 알고리즘.
 * 다양한 응용 분야에서 사용되며, 네트워크, 교통, 미로 찾기 등 다양한 분야에서 유용하게 적용됨
 * 가장 널리 사용되는 알고리즘
 * 1. 다익스트라 알고리즘
 * 2. 벨만-포드 알고리즘
 * 3. 플로이드-와샬 알고리즘
 */



fun main() {
    val graph = listOf(
        listOf(Edge(1, 10), Edge(2, 30), Edge(3, 15)),
        listOf(Edge(2, 20)),
        listOf(Edge(4, 5)),
        listOf(Edge(4, 20), Edge(5, 25)),
        listOf(Edge(5, 10)),
        emptyList()
    )

    val start = 0
    val distances = dijkstra(graph, start)

    for (i in distances.indices) {
        println("Distance from $start to $i is ${distances[i]}")
    }
    println("==================================")
    //============================================================
    val graph1 = Array(6) { IntArray(6) { Int.MAX_VALUE } }
    graph1[0][1] = 10
    graph1[0][2] = 30
    graph1[0][3] = 15
    graph1[1][2] = 20
    graph1[2][4] = 5
    graph1[3][4] = 20
    graph1[3][5] = 25
    graph1[4][5] = 10

    val distances1 = bellmanFord(graph1, 0, 6)

    println(distances.contentToString()) // [0, 10, 30, 15, 35, 25]
    println("==================================")
    //==============================================================
    val graph2 = Array(4) { IntArray(4) { Int.MAX_VALUE } }
    graph2[0][1] = 5
    graph2[0][2] = 10
    graph2[1][2] = 3
    graph2[2][0] = 6
    graph2[2][3] = 2
    graph2[3][3] = 0

    val distances2 = floydWarshall(graph2)

    for (i in 0 until distances2.size) {
        for (j in 0 until distances2[i].size) {
            print("${distances2[i][j]}\t")
        }
        println()
    }
}