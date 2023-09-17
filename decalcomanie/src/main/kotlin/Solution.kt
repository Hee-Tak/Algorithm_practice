class Solution {
    fun solution(n: Int, m: Int, fold: IntArray, cut: Array<IntArray>): Array<IntArray> {
        var n1 = n
        var m1 = m
        var ncount = 0
        var mcount = 0

        for (f in fold) {
            when (f) {
                1 -> {
                    n1 /= 2
                    ncount++
                }
                -1 -> {
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

        val resultMatrix = Array(numRows * 2) { IntArray(numCols) }

        for (i in 0 until numRows) {
            for (j in 0 until numCols) {
                val value = matrix[i][j]
                resultMatrix[i * 2][j] = value
                resultMatrix[i * 2 + 1][j] = value
            }
        }

        return resultMatrix
    }

    private fun expandHorizontally(matrix: Array<IntArray>): Array<IntArray> {
        val numRows = matrix.size
        val numCols = matrix[0].size

        val resultMatrix = Array(numRows) { IntArray(numCols * 2) }

        for (i in 0 until numRows) {
            for (j in 0 until numCols) {
                val value = matrix[i][j]
                resultMatrix[i][j * 2] = value
                resultMatrix[i][j * 2 + 1] = value
            }
        }

        return resultMatrix
    }
}