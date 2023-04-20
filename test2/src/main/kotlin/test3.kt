fun main(){

    // split : 문자열을 특정 구분자를 기준으로 나누어 배열로 반환함
    val sentence = "이것은 엄청 긴 문장입니다. 이 문장을 끊어서 처리하는 것이 어려웠습니다."
    val words = sentence.split(" ")
    println(words)
    //"[이것은, 엄청, 긴, 문장입니다., 이, 문장을, 끊어서, 처리하는, 것이, 어려웠습니다.]"

    // substring : 문자열의 특정 범위를 추출합니다.
    val sen = "이것은 엄청 긴 문장입니다."
    val substring = sen.substring(0, 5)
    println(substring) //"이것은"

    // startsWith , endsWith : 문자열이 특정 접두사로 시작하는지(특정 접미사로 끝나는지) 여부를 확인
    val startsWith = sen.startsWith("이것은")
    val endsWith = sen.endsWith("입니다.")
    println(startsWith) // true
    println(endsWith) // true

    // contains : 문자열이 특정 부분 문자열을 포함하는지 여부를 확인
    val containsSubstring = sentence.contains("엄청 긴")
    println(containsSubstring) // true

    // replace : 문자열에서 특정 문자열을 다른 문자열로 치환함
    val replaced = sen.replace("문장", "문단")
    println(replaced) // "이것은 엄청 긴 문단입니다."
}