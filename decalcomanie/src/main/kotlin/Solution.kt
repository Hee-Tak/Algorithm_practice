class Solution {
    fun solution(n: Int, m: Int, fold: IntArray, cut: Array<IntArray>): Array<IntArray> {
        var n1 = n      //8
        var m1 = m      //6
        var ncount = 0
        var mcount = 0

        for (f in fold) {   //1 ,-1, -1
            when (f) {
                -1 -> {
                    n1 /= 2
                    ncount++
                }
                1 -> {
                    m1 /= 2
                    mcount++
                }
            }
        }

        var paper = Array(n1) { IntArray(m1) { 1 } }

        for (c in cut) {
            val i = c[0]-1
            val j = c[1]-1
            if (i >= 0 && i < n1 && j >= 0 && j < m1) {
                paper[i][j] = 0
            }
        }

        /*
        for(i in 0 until n1){
            for(j in 0 until m1){
                print("${paper[i][j]} ")
            }
            println()
        }//마지막까지 접은 paper 확인
        */
        //=======================여기 위까진 ok. paper 됐음

        for (i in 1..ncount) {
            paper = expandVertically(paper)
        }

        for (j in 1..mcount) {
            paper = expandHorizontally(paper)
        }

        return paper
    }

    private fun expandVertically(matrix: Array<IntArray>): Array<IntArray> {
        val numRows = matrix.size
        val numCols = matrix[0].size
        val p = numRows * 2
        val q = numCols
        val resultMatrix = Array(p) { IntArray(q) }

        for (i in 0 until numRows) {
            for (j in 0 until numCols) {
                resultMatrix[i][j] = matrix[i][j]
            }
        }

        for(i in numRows until p){
            for(j in 0 until q){
                resultMatrix[i][j] = matrix[p-1-i][j]
            }
        }

        /*
        println("***************************")
        for(i in 0 until p){
            for(j in 0 until q){
                print("${resultMatrix[i][j]} ")
            }
            println()
        }
        println("***************************")
        */

        return resultMatrix
    }

    private fun expandHorizontally(matrix: Array<IntArray>): Array<IntArray> {
        val numRows = matrix.size
        val numCols = matrix[0].size
        val p = numRows
        val q = numCols * 2

        val resultMatrix = Array(p) { IntArray(q) }

        for (i in 0 until numRows) {
            for (j in 0 until numCols) {
                val value = matrix[i][j]
                resultMatrix[i][j] = value
            }

            for(j in numCols until q){
                resultMatrix[i][j] = matrix[i][q-1-j]
            }
        }

        /*
        println("+++++++++++++++++++++++++++++")
        for(i in 0 until p){
            for(j in 0 until q){
                print("${resultMatrix[i][j]} ")
            }
            println()
        }
        println("+++++++++++++++++++++++++++++")
        */

        return resultMatrix
    }
}