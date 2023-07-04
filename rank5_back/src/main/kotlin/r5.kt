class Solution {
    fun solution(num_list: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        val arr = num_list.sorted()
        for(a in 0..4){
            answer += arr[a]
        }
        return answer
    }
}

/**
 * level 0) 뒤에서 5등까지
 * https://school.programmers.co.kr/learn/courses/30/lessons/181853
 */