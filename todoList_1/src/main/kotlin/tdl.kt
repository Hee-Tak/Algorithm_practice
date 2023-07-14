class Solution {
    fun solution(todo_list: Array<String>, finished: BooleanArray): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        val len = todo_list.size // = finished.size
        for(i in 0..len-1){
            if(!finished[i]) answer += todo_list[i]
        }
        return answer
    }
}
/**
 * level 0) 할 일 목록
 * https://school.programmers.co.kr/learn/courses/30/lessons/181885
 */