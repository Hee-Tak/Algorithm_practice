fun main() {
    No1()
    No2()
}


fun No1(){
    val sol = Solution()

    val n = 8
    val m = 6
    val fold = intArrayOf(1, -1, -1)
    val cut = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(2, 2),
        intArrayOf(4, 4)
    )
    val Qnumber = 1

    val result = sol.solution(n, m, fold, cut)


    printResult(n, m, fold, cut, Qnumber, result)
}

fun No2() {
    val sol = Solution()
    val n = 4
    val m = 4
    val fold = intArrayOf(1, 1)
    val cut = arrayOf(
        intArrayOf(3,1)
    )
    val Qnumber = 2

    val result = sol.solution(n, m, fold, cut)

    printResult(n, m, fold, cut, Qnumber, result)
}

private fun printResult(n: Int, m: Int, fold: IntArray, cut: Array<IntArray>, Qnumber: Int, result: Array<IntArray>) {
    println("n: $n \t m: $m \t")

    println("<fold>")
    for(i in 0 until fold.size){
        print("${fold[i]} ")
    }
    println()

    println("<cut>")
    for(i in 0 until cut.size){
        for(j in 0 until cut[0].size){
            print("${cut[i][j]} ")
        }
        println()
    }

    println("========No.$Qnumber===========")
    for (row in result) {
        for (element in row) {
            print("$element ")
        }
        println()
    }
    println("--------------------------------------------")
}
