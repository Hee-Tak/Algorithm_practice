class Solution {
    fun solution(n: Int, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var k1 = k
        while(k1 <= n){
            answer += k1
            k1 += k
        }
        return answer
    }
}
/**
 * level 0) 배열 만들기 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/181901
 */