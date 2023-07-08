class Solution {
    fun solution(age: Int): String {
        return change(age)
    }

    private fun change(n: Int): String{
        var m = n.toString()
        var result: String = ""
        for(c in m){
            when(c){
                '0' -> result += "a"
                '1' -> result += "b"
                '2' -> result += "c"
                '3' -> result += "d"
                '4' -> result += "e"
                '5' -> result += "f"
                '6' -> result += "g"
                '7' -> result += "h"
                '8' -> result += "i"
                '9' -> result += "j"
            }
        }
        return result
    }
}

/**
 * level 0) 외계행성의 나이
 * https://school.programmers.co.kr/learn/courses/30/lessons/120834
 */