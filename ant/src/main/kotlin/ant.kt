class Solution {
    fun solution(hp: Int): Int {
        var answer: Int = 0
        var current: Int = hp
        val a: Int = 5 //장군개미   : 5
        val b: Int = 3 //병정개미   : 3
        val c: Int = 1 //일개미     : 1
        answer += current / a
        current = current % a
        answer += current / b
        current = current % b
        answer += current / c
        return  answer
    }
}

/**
 * level 0) 개미 군단
 * https://school.programmers.co.kr/learn/courses/30/lessons/120837
 */