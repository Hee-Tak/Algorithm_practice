/**
 * 플로이드-와샬 알고리즘 :
 * 모든 정점 간의 최단 경로를 찾는 알고리즘
 */


fun floydWarshall(graph: Array<IntArray>): Array<IntArray> {
    val n = graph.size
    val distances = Array(n) { i -> IntArray(n) { j -> graph[i][j] } }

    for(k in 0 until n){
        for(i in 0 until  n){
            for(j in 0 until n){
                if(distances[i][k] != Int.MAX_VALUE && distances[k][j] != Int.MAX_VALUE &&
                    distances[i][k] + distances[k][j] < distances[i][j]) {
                    distances[i][j] = distances[i][k] + distances[k][j]
                }
            }
        }
    }

    return distances
}


// graph : 인접 행렬 형태의 그래프
// n : 정점의 개수
// floydWarshall : 모든 정점 간의 최단 거리를 계산하여 2차원 배열 형태로 반환
// 여기서는 Int.MAX_VALUE를 사용하여 무한대 값으로 초기화 하였음
