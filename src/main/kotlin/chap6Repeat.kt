fun main() {

    /*
    반복문 = 무언가를 반복할때 List와 배열과 같이 사용하는경우가 많다
    1. for-each문
    2. 전통적for문
    3.Progression과 Range
    4.while


    ..연산자는 범위를 만들어내는 연산자
    Range라는 실제 클래스가 존재 (등차수열을 상속받고있음)
    3 downTo 1: 시작값 3, 끝값1, 공차가 -1인 등차수열
    1..5 step 2 : 시작값 1, 끝값5, 공차가 2인 등차수열
    downTo, step도 함수이다!(중위 호출 함수)
    변수.함수이름(argument)대신 변수 함수이름 argument
     */
    //listOf는 list를 만들어주는 코드
    val numbers = listOf(1L,2L,3L)

    //:대신 in을 사용
    for (number in numbers){
        println(number)
    }
    println("for반복문 1씩증가")
    for(i in 1..3){
        println(i)
    }
    println("for반복문 1씩감소")
    for(i in 3 downTo 1){
        println(i)
    }

    println("for반복문 2씩증가")
    //1부터 5까지 공차가 1인 등차수열이 생성된다
    //이등차수열에 대해서  step이란 함수를 불러 2를 집어넣어준다
    //kotlin에서 전통적인 for문은 등차가 1인 등차수열을 사용한다
    for(i in 1..5 step 2){
        println(i)
    }
    println("for반복문 2씩감소")
    for(i in 5 downTo 1 step 2){
        println(i)
    }

    //while문은 java와 완전이 똑같다 do while도 동일
    var i = 1
    while(i <= 3){
        println(i)
        i++
    }

    /*
    - for each문에서 Java는 : Kotlin은 in을 사용한다.
    - 전통적인 for문에서 Kotlin은 등차수열과 in을 사용한다.
    - 그 외 for문 문법은 모두 동일하다.
    - while문과 do while문은 완전히 동일하다.

     */

}