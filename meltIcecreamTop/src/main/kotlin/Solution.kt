import java.util.ArrayDeque
class Solution {
    public fun solution(preferences: String): String {
        val iceCream = arrayOf("C", "M", "S", "V", "Y")
        val stack = ArrayDeque<String>()
    }

    private fun trigger(people: String, target: String): Boolean {
        var taste = people
        var icecream = target

        //임시값
        taste = "CS"
        icecream = taste

    }
}

//입력값                               출력값
//preferences
//["CS", "SV"]                    ->  "CCVS"
//["SV", "VS", "SV", "VS"]        ->  "SV"
//["CM", "MS", "SC"]              ->  "CCMMS"
// 위층때매 녹아서 맛 합쳐진걸(침식당한걸) 어떻게 생각해봐야할듯