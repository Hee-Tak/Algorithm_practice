//그래프의 간선 클래스
data class Edge2(val src: Int, val dest: Int, val weight: Int)

//그래프의 정점 수와 간선 리스트를 입력으로 받아 Boruvka 알고리즘을 수행하여
// 최소 신장 트리의 간선 리스트를 반환하는 함수
fun boruvka(graph: List<Edge2>, V: Int): List<Edge2> {
    //최소 신장 트리의 간선 리스트
    val mst = mutableListOf<Edge2>()

    //그래프의 각 정점의 소속 집합 번호를 저장하는 배열
    val parent = IntArray(V) { it }

    //각 소속 집합의 대표 정점 번호를 저장하는 배열
    val cheapest = IntArray(V) { -1 }

    //소속 집합의 개수
    var numSets = V

    //모든 소속 집합이 하나로 통합될 때까지 반복
    while(numSets > 1){
        //각 소속 집합의 대표 정점 번호를 초기화
        for(v in 0 until V) {
            cheapest[v] = -1
        }

        //각 간선을 순회하면서 최소 가중치 간선을 찾음
        for(e in graph){
            val src = e.src
            val dest = e.dest
            val set1 = find(parent, src)
            val set2 = find(parent, dest)

            if(set1 != set2){
                if(cheapest[set1] == -1 || e.weight < graph[cheapest[set1]].weight){
                    cheapest[set1] = e.weight
                }

                if(cheapest[set2] == -1 || e.weight < graph[cheapest[set2]].weight){
                    cheapest[set2] = e.weight
                }
            }

        }

        //각 소속 집합의 최소 가중치 간선을 통해 간선을 선택하고, 최소 신장 트리에 추가
        for(v in 0 until V){
            if(cheapest[v] != -1){
                val set1 = find(parent, v)
                val set2 = find(parent, graph[cheapest[v]].dest)

                //두 정점이 속한 소속 집합이 다르다면 두 소속 집합을 합친 후,
                //해당 간선을 최소 신장 트리에 추가
                if(set1 != set2){
                    union(parent, set1, set2)
                    mst.add(graph[cheapest[v]])
                    numSets--
                }
            }
        }


    }

    return mst
}

//정점의 소속 집합 번호를 찾는 함수 (Union-Find 알고리즘)
fun find(parent: IntArray, v: Int): Int {
    if(parent[v] != v){
        parent[v] = find(parent, parent[v])
    }
    return parent[v]
}

//두 정점이 속한 두 소속 집합을 합치는 함수 (Union-Find 알고리즘)
fun union(parent: IntArray, x: Int, y: Int){
    val xRoot = find(parent, x)
    val yRoot = find(parent, y)
    parent[xRoot] = yRoot
}