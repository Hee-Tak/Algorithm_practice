import java.util.PriorityQueue

//그래프의 노드 개수
val N = 6

//그래프를 인접 리스트로 표현한 클래스
class Graph{
    val adjList: Array<MutableList<Pair<Int, Int>>> = Array(N) { mutableListOf() }

    // 간선 추가 함수
    fun addEdge(u: Int, v: Int, weight: Int){
        adjList[u].add(Pair(v, weight))
        adjList[v].add(Pair(u, weight))
    }

    // 프림 알고리즘 함수
    fun primMST(): Int{
        val key = IntArray(N) { Int.MAX_VALUE} // 각 노드의 키(거리)를 저장하는 배열
        val visited = BooleanArray(N) { false } // 방문 여부를 저장하는 배열
        val pq: PriorityQueue<Pair<Int, Int>> = PriorityQueue(compareBy { it.second }) // 우선순위 큐

        key[0] = 0 // 시작 노드의 키를 0으로 설정
        pq.offer(Pair(0, 0)) // 시작 노드를 우선순위 큐에 삽입

        while(!pq.isEmpty()){
            val curr = pq.poll().first // 현재 노드를 우선순위 큐에서 꺼냄
            visited[curr] = true // 현재 노드를 방문 처리

            //현재 노드에 인접한 노드들에 대해서
            for(adjNode in adjList[curr]){
                val next = adjNode.first
                val weight = adjNode.second

                // 방문하지 않은 노드 중에서 기존의 키보다 더 작은 키가 있는 경우
                if(!visited[next] && weight < key[next]){
                    key[next] = weight //키를 갱신하고
                    pq.offer(Pair(next, key[next])) // 우선 순위 큐에 삽입
                }
            }
        }

        var mstWeight = 0 // 최소 신장 트리의 총 가중치
        for(i in 0 until N){
            mstWeight += key[i] // 모든 노드의 키(거리) 를 더함
        }
        return mstWeight // 최소 신장 트리의 총 가중치를 반환
    }
}

// 위 코드에서 primMST 함수는 주어진 그래프에 대해서 프림 알고리즘을 수행하고
// 최소 신장 트리의 총 가중치를 반환한다.

// 우선순위 큐에서 꺼낸 노드의 방문 여부를 확인하고,
// 방문하지 않은 노드 중에서 기존의 키보다 더 작은 키가 있는 경우,
// 키를 갱신하고 우선순위에 삽입한다.
// 이렇게 계속해서 최소 거리를 가지는 노드를 선택하면서 최소 신장 트리를 구성한다.

// 마지막으로, 모든 노드의 키(거리)를 더한 값을 최소 신장 트리의 총 가중치로 반환한다.
// 이렇게 프림 알고리즘은 모든 노드를 방문하지 않아도 최소 신장 트리를 구할 수 있다.
// 시간 복잡도 : O(E log V)

//============================================================
// 노드 중심의 알고리즘.
// 시작 노드에서부터 출발하여 트리를 확장해나가는 방식
// 인접리스트 또는 인접 행렬로 그래프를 표현
// 현재 트리와 연결된 노드들 중에서 최소 가중치를 가진 간선을 선택한다.
// 프림 알고리즘은 트리를 확장하면서 사이클이 생기는지 검사할 필요가 없다.
// 프림 알고리즘은 노드 중심으로 연산하므로, 노드의 개수가 많을 경우에는 효율적이다.