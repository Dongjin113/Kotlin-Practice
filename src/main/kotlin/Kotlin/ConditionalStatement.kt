package Kotlin

fun main() {

    /*
    1. if문
    2. Expression과 Statement
    3. switch와 when
     */

    println(scorein(42))
    println(scorenone(142))

}

/*
Java에서 if else 문은 Statement이지만
Kotlin에서의 if else문은 Expression이다

Statement: 프로그램의 문장, 하나의 값으로 도출되지 않는다
전체를 의미한다 그래서 하나로 값으로 도출되지 않는것이 Statement이다

Expression : 하나의 값으로 도출되는 문장

Expression은 Satement에 포함된 포함관계라 할 수 있다

int score = 30 + 40;  30+40은 70이라는 하나의 결과가나온다
Expression 이면서 Statement


Java String grade = if(score >= 50){"P";} else { "F" };
라고 사용한다면 Java에서는 error가난다 =을 통해서 값을 바로 대입할수 없다
이문장은 Statement 라고 할 수 있다.
Java에서는 3항 연산자는 하나의 값으로 취급하므로 에러가 없다!
String grade = score >= 50 ? "P" : "F";
score >= 50 가 true면 P false면 F가 출력이 된다
Expression 이면서 Statement


java if(0 <= score && score <=100) //java
kotlin도 사용할수 있지만 좀더 간단하게 사용할수 있다
if(score in 0..100)

 */

// 함수에서 Unit이 생략됌
fun validateScoreInsNotNegative(score:Int){
    if (score<0){
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다")
    }
}
//(score : Int): 함수반환  return타입
fun getPassOrFail(score : Int): String{
    if(score >= 50){
        return "P"
    } else {
        return "F"
    }
}

fun getPassOrFail1(score : Int): String{
    return if(score >= 50){
        "P"
    } else {
        "F"
    }
}

fun getGrade(score: Int): String{
    if(score >= 90){
        return "A";
    }else if (score >= 80) {
        return "B";
    }else if (score >= 70) {
        return "C";
    } else {
        return "D";
    }
}

fun getGrade1(score: Int): String{
    return if (score >= 90) {
        "A"
    } else if (score >= 80) {
        "B"
    } else if (score >= 70) {
        "C"
    } else {
        "D"
    }
}

fun scorenone(score:Int){
    if (score !in 0..100){
        throw IllegalArgumentException("${score}의 범위는 0~100에 포함되지 않습니다")
    }
}

fun scorein(score:Int){
    if (score in 0..100){
        throw IllegalArgumentException("${score}의 범위는 0~100에 포함됩니다")
    }
}


/*
 //score 의 값만을 가지고 분기를 칠 수 있는것이 아니라
 //Kotlin의 when에서는 다양한 조건을 가지고 분기를 칠 수 있다.
 wehn(값){
 조건부 -> 어떠한 구문
 조건부 -> 어떠한 구문
 else -> 어떠한 구문
 }
 어떠한 expression이라도 들어갈 수 있다(ex. is Type)
  */

//Java switch case =>  Kotlin when
fun getGradeWithSwitch(score:Int):String {
    return when (score / 10) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        6 -> "D"
        5 -> "E"
        in 90..99 -> "Kotlin.getA"
        in 80..89 -> "b"
        in 70..79 -> "c"
        in 60..69 -> "d"
        else -> "F"
    }
}

//is 어떠한 type인지 확인하는것
fun startsWithA(obj: Any): Boolean{
    return when (obj){
        is String -> obj.startsWith("A")
        else -> false
    }
}

//여러개의 조건을 동시에 검사할 수 있다(,로 구분)
fun judgeNumber(number: Int){
    when (number){
        1 , 0 , -1 -> println("어디서 많이 본 숫자입니다")
        else -> println("1,0,-1이 아닙니다")
    }
}

//값 자체가 없을때
fun judgeNumber2(number: Int){
    when { //어떠한 값이 있다면 값이 다음 조건에 해당하는지 살펴보고
        //값이 없다면 아래에있는 조건을 확인하여 수행
        number == 0 -> println("주어진 숫자는 0 입니다")
        number % 2 == 0 -> println("주어진 숫자는 짝수 입니다")
        else -> println("주어진 숫자는 홀수 입니다");
    }
}

/*
Kotlin에서 조건문을 다루는 방법
- if/ if-else / if -else if- else 모두 Java와 문법이 동일하다
- 단 Kotlin에서는 Expression으로 취급된다.
    -때문에 Kotlin에서는 삼항 연산자가 없다.
- Java의 switch는 Kotlin에서 when으로 대체되었고, when은 더 강력한 기능을 갖는다.

 */





