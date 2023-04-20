//String 배열 다루기
fun main(){
    val arr = arrayOf("apple", "banana", "cherry")

    // size, length : 배열의 크기 또는 길이를 반환  .size
    val size = arr.size
    println(size);

    // get : 배열에서 특정 인덱스의 요소를 반환    .get(index)
    val element = arr.get(1)
    println(element);

    // set : 배열에서 특정 인덱스의 요소를 변경    .set(index, 값)
    arr.set(2, "grape")
    println(arr.contentToString()); // "[apple, banana, grape]"

    // contains : 배열에 특정 요소가 포함되어 있는지 여부를 확인 .contains(value)
    val containsBanana = arr.contains("banana")
    println(containsBanana) // true

    // indexOf : 배열에서 특정 요소의 인덱스를 반환.
    // 해당 요소가 배열에 없으면 -1 반환
    val index = arr.indexOf("banana")
    println(index) // 1

    // joinToString : 배열의 요소들을 특정 구분자를 이용하여 문자열로 합침
    val joined = arr.joinToString(", ")
    println(joined) // "apple, banana, cherry" (근데 사실 아까 cherry를 grape 로 바꾸긴함)

    // forEach : 배열의 각 요소에 대해 지정된 동작을 수행
    arr.forEach { element ->
        println(element)
    }



}