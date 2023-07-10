//1차 코드
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
 * 이거 아직 안되는 버전 (내가 머리 굴려서 짜낸거)
 *
 */



//2차 코드

class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var left = Pair(3, 0)   //왼손 초기 위치 *
        var right = Pair(3, 2)  //오른손 초기 위치 #

        for(number in numbers){
            when(number){
                1, 4, 7 -> {
                    answer += "L"
                    left = Pair((number -1) / 3, 0)
                }
                3, 6, 9 -> {
                    answer += "R"
                    right = Pair(number / 3, 2)
                }
                else -> {   //가운데 열 숫자
                    val target = if(number == 0) Pair(3, 1) else Pair((number - 1) / 3, 1)
                    val leftDistance = calculateDistance(left, target)
                    val rightDistance = calculateDistance(right, target)

                    if(leftDistance < rightDistance){
                        answer += "L"
                        left = target
                    } else if(rightDistance < leftDistance){
                        answer += "R"
                        right = target
                    } else {
                        if(hand == "left"){
                            answer += "L"
                            left = target
                        } else {
                            answer += "R"
                            right = target
                        }
                    }
                }
            }
        }
        return answer
    }

    private fun calculateDistance(hand: Pair<Int, Int>, target: Pair<Int, Int>) : Int {
        return Math.abs(hand.first - target.first) + Math.abs(hand.second - target.second)
    }


}
//위의 코드는 키패드를 잘못 생각함
/*
    0   1   2
    3   4   5
    6   7   8
    9   *   #       왜 이따구로했지 ㅁㄹ
 */
//========================================================================
// 3차 코드 : 해결 (+2점)

/*
    키패드 숫자
    1   2   3
    4   5   6
    7   8   9
    *   0   #

 */
class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var left = Pair(3, 0)   //왼손 초기 위치 *
        var right = Pair(3, 2)  //오른손 초기 위치 #

        for(number in numbers){
            when(number){
                1, 4, 7 -> {
                    answer += "L"
                    left = Pair((number -1) / 3, 0)
                }
                3, 6, 9 -> {
                    answer += "R"
                    right = Pair((number-3) / 3, 2)
                }
                else -> {   //가운데 열 숫자
                    val target = if(number == 0) Pair(3, 1) else Pair((number - 2) / 3, 1)
                    val leftDistance = calculateDistance(left, target)
                    val rightDistance = calculateDistance(right, target)

                    if(leftDistance < rightDistance){
                        answer += "L"
                        left = target
                    } else if(rightDistance < leftDistance){
                        answer += "R"
                        right = target
                    } else {
                        if(hand == "left"){
                            answer += "L"
                            left = target
                        } else {
                            answer += "R"
                            right = target
                        }
                    }
                }
            }
        }
        return answer
    }

    private fun calculateDistance(hand: Pair<Int, Int>, target: Pair<Int, Int>) : Int {
        return Math.abs(hand.first - target.first) + Math.abs(hand.second - target.second)
    }


}








/**
 * level 1) [카카오 인턴] 키패드 누르기 (정답률 50%)
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256
 */