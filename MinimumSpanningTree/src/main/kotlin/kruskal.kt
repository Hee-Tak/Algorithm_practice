// 그래프의 노드 개수와 간선 개수
val N1 = 6
val E1 = 8

// 간선을 표현하는 클래스
data class Edge(val u: Int, val v: Int, val weight: Int)

// Union-Find 자료구조를 활용한 클래스
class UnionFind(val size: Int){
    val parent = IntArray(size)
    val rank = IntArray(size)

    init {
        for(i in 0 until size){
            parent[i] = i
            rank[i] = 0
        }
    }

    fun find(x: Int): Int{
        if(parent[x] != x){
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(x: Int, y: Int){
        val rootX = find(x)
        val rootY = find(y)

        if(rootX == rootY){
            return
        }

        if(rank[rootX] < rank[rootY]){
            parent[rootX] = rootY
        } else {
            parent[rootY] = rootX
            if(rank[rootX] == rank[rootY]){
                rank[rootX]++
            }
        }
    }

}

class Graph1 {
    val edgeList = mutableListOf<Edge>()

    // 간선 추가 함수
    fun addEdge(u: Int, v: Int, weight: Int){
        edgeList.add(Edge(u, v, weight))
    }

    // 크루스칼 알고리즘 함수
    fun kruskalMST(): List<Edge> {
        val mst = mutableListOf<Edge>()
        edgeList.sortBy{ it.weight } //간선을 가중치 순으로 정렬
        val uf = UnionFind(N) // Union-Find 자료구조 초기화

        for(edge in edgeList){
            if(uf.find(edge.u) != uf.find(edge.v)){ //두 노드가 같은 집합에 속하지 않으면
                uf.union(edge.u, edge.v) // 두 노드를 합침
                mst.add(edge) // 최소 신장 트리에 해당 간선을 추가
            }
        }

        return mst
    }

}

// 간선 중심의 알고리즘이며, 모든 간선을 가중치 순으로 정렬한 후에 최소 신장 트리를 구성하는 방식
// 간선 리스트로 그래프를 표현.
// 크루스칼 알고리즘은 그리디한 선택으로, 현재 그래프에서 최소 가중치를 가진 간선을 선택한다.
// 크루스칼 알고리즘은 선택한 간선이 사이클을 생성하는지 검사하여 사이클을 방지한다.
// 크루스칼 알고리즘은 간선을 중심으로 연산하므로, 간선의 개수가 많을 경우에는 효율적이다.