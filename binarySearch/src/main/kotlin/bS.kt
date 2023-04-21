
fun main(){
    val arr1 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
    val arr2 = (1..100).toList().toIntArray()
    val arr3 = createRandomSortedArray(100, 43)
    //===========================================================
    val target1 = 9
    val idx1 = binarySearch(arr1, target1)

    if(idx1 == -1){
        println("해당 숫자를 찾을 수 없습니다.")
    } else {
        println("$target1 는 배열의 $idx1 인덱스에 있습니다.")
    }
    //===========================================================
    val target2 = ran(100)
    val idx2 = binarySearch(arr2, target2)
    if(idx2 == -1){
        println("해당 숫자를 찾을 수 없습니다.")
    } else {
        println("$target2 는 배열의 $idx2 인덱스에 있습니다.")
    }
    //============================================================
    val target3 = arr3.random()
    val idx3 = binarySearch(arr3, target3)
    if(idx3 == -1){
        println("Didn't find $target3, should be inserted at index ${-idx3-1}")
    } else{
        println("Found $target3 at index $idx3")
    }
}
fun ran(bound: Int): Int{
    val randomNumber1 = java.util.Random().nextInt(bound)
    val randomNumber2 = kotlin.random.Random.nextInt(bound)
    val randomNumber3 = (Math.random() * bound).toInt()
    val randomNumber4 = (System.currentTimeMillis() % bound + 1).toInt()
    val randomNum = (1..4).random()
    return when(randomNum) {
        1 -> randomNumber1
        2 -> randomNumber2
        3 -> randomNumber3
        4 -> randomNumber4
        else -> throw IllegalStateException("Unexpected random number: $randomNum")
    }

}

//fun createRandomArrayWithMissingNumbers(size: Int, n
//1. 빠져 있는 숫자들의 집합(set)을 만듦
//2. 1부터 100까지의 수를 가지고 있는 배열을 생성
//3. 집합에서 랜덤하게 하나의 숫자를 선택
//4. 선택한 숫자가 빠져있는 숫자라면, 다시 3번으로 돌아가서 다른 숫자를 선택
//5. 선택한 숫자가 빠져있지 않다면, 배열에서 해당 숫자를 삭제
//6. 배열의 크기가 원하는 크기가 될 때까지 3번부터 5번을 반복

fun createRandomSortedArray(target: Int, n: Int): IntArray {
    val arr = (1..target).shuffled().take(n).toIntArray()
    arr.sort()
    return arr
}

fun binarySearch(arr: IntArray, target: Int): Int {
    var left = 0
    var right = arr.size - 1

    while(left <= right){
        val mid = (left + right) / 2
        when{
            arr[mid] == target -> return mid
            arr[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return -1
}
