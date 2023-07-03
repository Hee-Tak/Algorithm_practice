class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        var even: String = ""
        var odd: String = ""
        for(n in num_list){
            if(n % 2 == 0){
                even += n.toString()
            } else {
                odd += n.toString()
            }
        }
        answer += (even.toInt()+odd.toInt())
        return answer
    }
}
/**
 * level 0) 이어 붙인 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/181928
 */