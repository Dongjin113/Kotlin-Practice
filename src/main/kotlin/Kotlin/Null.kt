package Kotlin

import java.lang.IllegalArgumentException

fun main() {

    //kotlin 에서는 null이 가능한 타입을 완전히 다르게 취급한다.
//null이 가능한 타입만을 위한 기능
//1. safe Call (안전한 호출)

    //val str: String? ="ABC"
    //println(str.length) //error
    //println(str?.length) //사용가능

    //safe call은 null이 아니면 뒤에것을 실행하고 아니면 전체가 null이된다
    //val str1: String? = null
    //println(str1?.length)

//2. Elvis 연산자
//앞의 연산 결과가 null이면 뒤의 값을 사용
/*
    //str3의 값이 null이 아니기때문에 str3?.length의 값인 3이 출력
    val str3: String? = "ABC"
    println(str3?.length ?: 0)
    //str4의 결과값이 null 이기때문에 0이 출력
    val str4: String? = null
    println(str4?.length ?: 0)

 */


//println(Kotlin.startsWith(null))
//println(Kotlin.startsWith("ABC"))

}
//null이 들어갈수 없는 boolean형이 반환
fun startsWithA1(str: String?): Boolean {
    //kotlin의 형태
    return str?.startsWith("A") ?: throw IllegalArgumentException("null이 들어왔습니다")

    /*
    //자바의 형태
    if (str == null){
        throw IllegalArgumentException("null이 들어왔습니다")
    }
    return str.Kotlin.startsWith("A")

     */
}





/*
Kotlin.startsWith()
함수 원형 : boolean Kotlin.startsWith(String prefix)
대상 문자열이 특정 문자 또는 문자열로 시작하는지 체크하는 함수이다.
해당 문자열로 시작되는지 여부를 확인하고 boolean에 맞춰 true/false 값을 반환한다.
 */

//null이 들어갈 수 있는 boolean형이 반환
fun startsWithA2(str: String?): Boolean? {
    return str?.startsWith("A")
    /*
    java형식
    if(str == null){
        return null
    }
    return str.Kotlin.startsWith("A")

     */
}




// null이들어갈수 없는 boolean형이 반환
fun startsWithA3(str: String?): Boolean{
    return str?.startsWith("A")  ?: false
    /*
    if(str ==null){
        return false
    }
    return str.Kotlin.startsWith("A")

     */
}
/*
//null일수도 있는데 왜 바로 함수 호출을 하려고 하느냐?
fun startsWithA4(str: String?): Boolean{
    str.Kotlin.startsWith("A")
}
 */

//nullable type이지만, 아무리 생각해도 null이 될 수 없는 경우 무조건 null이 아니야라는 신호
//null이 들어올 수도 있지만 절대 null이 들어올일이 없는경우
//null 값이 들어오면 NPE가 난다 정말 null이 아닌게 확실한 경우에만 널 아님 단언!! 을 사용해야 한다
fun startsWith(str:String?) :Boolean{
    return str!!.startsWith("A")
}


