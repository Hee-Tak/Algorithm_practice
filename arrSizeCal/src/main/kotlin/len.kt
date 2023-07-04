class Solution {
    fun solution(arr: IntArray, n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        val len : Int = arr.size
        val len2 : Int = len % 2
        when(len2){
            1 -> for(a in arr.indices){
                when(a%2){
                    1 -> answer += arr[a]
                    0 -> answer += arr[a]+n
                }
            }
            0 -> for(a in arr.indices){
                when(a%2){
                    0 -> answer += arr[a]
                    1 -> answer += arr[a]+n
                }
            }
        }

        return answer
    }
}


/**
 * level 0) 배열의 길이에 따라 다른 연산하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181854
 */