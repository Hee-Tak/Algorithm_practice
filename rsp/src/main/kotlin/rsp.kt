class Solution {
    fun solution(rsp: String): String {
        var answer: String = ""
        for(n in rsp){
            when(n){
                '2' -> answer += "0"
                '0' -> answer += "5"
                '5' -> answer += "2"
            }
        }
        return answer
    }
}

/**
 * level 0) 가위 바위 보
 * https://school.programmers.co.kr/learn/courses/30/lessons/120839
 */