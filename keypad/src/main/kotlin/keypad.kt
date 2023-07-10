class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""



        var currentLeft : Pair<Int, Int> = Pair(3, 0)  //star
        var currentRight : Pair<Int, Int> = Pair(3, 2) //hash

        for(n in numbers){
            when(n){
                1, 4, 7 -> {// 1 || 4 || 7 은 문법적으로 잘못된 표현.
                    currentLeft = phone(n)
                    answer += "L"
                }
                3, 6, 9 -> {
                    currentRight = phone(n)
                    answer += "R"

                }
                2, 5, 8, 0 -> {
                    when(compare(distanceCheck(currentLeft,n), distanceCheck(currentRight, n), hand)){
                        "L" -> {
                            currentLeft = phone(n)
                            answer += "L"
                        }
                        "R" -> {
                            currentRight = phone(n)
                            answer += "R"
                        }
                    }

                }
            }
        }


        return answer
    }

    private fun findElementIndex(arr: Array<IntArray>, target: Int): Pair<Int, Int>{
        for(i in arr.indices){
            for(j in arr[i].indices){
                if(arr[i][j] == target){
                    return Pair(i, j)
                }
            }
        }
        return Pair(-1, -1)
    }

    private fun phone(n: Int): Pair<Int,Int>{
        val hash = -33
        val star = -77
        val phone = arrayOf(intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
            intArrayOf(star, 0, hash))

        val index = findElementIndex(phone, n)
        val (i, j) = index
        return Pair(i, j)
    }

    private fun distanceCheck(pair: Pair<Int, Int>, num : Int): Int{
        var target: Pair<Int, Int>
        when(num){
            2 -> target = Pair(1, 0)
            5 -> target = Pair(1, 1)
            8 -> target = Pair(1, 2)
            else -> target = Pair(1, 3) // num == 0
        }
        return Math.abs(pair.first - target.first) + Math.abs(pair.second - target.second)
    }

    private fun compare(checkL: Int, checkR: Int, hand: String): String{
        return when {
            checkL < checkR -> "L"
            checkR < checkL -> "R"
            else -> {
                if(hand == "left"){
                    "L"
                } else if(hand == "right"){
                    "R"
                } else{
                    throw IllegalArgumentException("Invalid hand value: $hand")
                }
            }
        }
    }



}

/**
 * 이거 아직 안되는 버전
 *
 */