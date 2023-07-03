class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0
        var x = (a.toString() + b.toString()).toInt()
        var y = (b.toString() + a.toString()).toInt()

        return if( x >= y){
            x
        } else{
            y
        }
    }
}
/**
 * level 0) 더 크게 합치기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181939
 *
 */