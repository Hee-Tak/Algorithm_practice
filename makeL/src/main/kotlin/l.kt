class Solution {
    fun solution(myString: String): String {
        var answer: String = ""
        for(m in myString){
            if(m < 'l'){
                answer += "l"
            } else{
                answer += m
            }
        }
        return answer
    }
}

/**
 * level 0) l로 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181834
 */