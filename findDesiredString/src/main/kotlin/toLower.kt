class Solution {
    fun solution(myString: String, pat: String): Int {
        val a = myString.toLowerCase()
        val b = pat.toLowerCase()
        return if(a.contains(b)){
            1
        } else {
            0
        }
    }
}

/**
 * level 0) 원하는 문자열 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181878
 */