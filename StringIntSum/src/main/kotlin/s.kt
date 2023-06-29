class Solution {
    fun solution(num_str: String): Int {
        var answer: Int = 0
        for(i in num_str){
            answer += i.toInt() - 48
        }
        return answer
    }
}

/**
 * level 0) 문자열 정수의 합
 * https://school.programmers.co.kr/learn/courses/30/lessons/181849
 */