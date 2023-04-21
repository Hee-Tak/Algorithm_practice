import java.util.LinkedList
import java.util.Queue

// 그래프의 노드 개수
val N = 6

//그래프를 인접 리스트로 표현한 클래스
class Graph {
    val adjList: Array<LinkedList<Int>> = Array(N) { LinkedList() }

    // 간선 추가 함수
    fun addEdge(u: Int, v: Int){
        adjList[u].add(v)
        adjList[v].add(u)
    }

    // BFS 함수
    fun bfs(start: Int){
        val visited = BooleanArray(N) { false } //방문 여부를 저장하는 배열
        val queue: Queue<Int> = LinkedList() //BFS를 위한 큐
        queue.offer(start) //시작 노드를 큐에 삽입
        visited[start] = true //시작 노드를 방문 처리

        while(!queue.isEmpty()){
            val curr = queue.poll() //큐에서 노드를 하나 꺼냄
            print("$curr ") //노드를 방문한 것으로 처리하고 출력

            //인접한 노드들 중에서 방문하지 않은 노드를 큐에 삽입하고 방문 처리
            for(adjNode in adjList[curr]){
                if(!visited[adjNode]){
                    visited[adjNode] = true
                    queue.offer(adjNode)
                }
            }
        }
    }




}

// 너비 우선 탐색
// 인접 리스트를 활용하여 그래프를 표현하고, 큐를 이용하여 bfs를 구현.
// 시작 노드에서 bfs 탐색을 시작하고, 방문한 노드들을 출력함