fun main() {
    val sol = Solution()

    val n = 8
    val m = 6
    val fold = intArrayOf(1, -1, -1)
    val cut = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(2, 2),
        intArrayOf(4, 4)
    )

    val result = sol.solution(n, m, fold, cut)

    println("===============================")
    for (row in result) {
        for (element in row) {
            print("$element ")
        }
        println()
    }
}
