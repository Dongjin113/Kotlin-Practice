package Kotlin

import Kotlin.chap8Function.Chap8JavaFunction

/*
//코틀린에서 함수를 다루는방법
1. 함수 선업 문법
2. default parameter
3. named argument(parameter)
4.같은 타입의 여러 파라미터 받기 (가변인자)
 */

fun main() {

//    Kotlin.repeat1("str")//값을 전부 넣지 않으면 오류가발생
    repeat1("str1",3, true)

    //2. default parameter 주어진 문자열을 N번 출력하는 예제
    //값을 넣지 않으면 자동으로 default값이 들어와서 출력
    repeat2("str2",5)
    repeat2("str3")
    repeat2("str4",3, true)
//    Kotlin.repeat2("str4",true, 5) 변수의 순서에 맞게 사용해 주어야 한다

//3.named argument
//  기본값이 지정되어 있고 기본값을 다시한번 넣어주기 싫으면
//  어떤 Parameter에 값을 넣을꺼라고 함수를 호출해주어서 사용할 수 있다.
// 이것을 named argument라고 한다
    repeat3("str5", useNewLine = false)


// builder를 직접 만들지 않고 builder의 장점을 가지게 된다
    repeat3("str5", useNewLine = false)
//변수의 순서를 잘못 사용한 경우 바꿔서 사용할 수 있다.
    repeat2("str4",useNewLine=true, num=5)
//Kotlin에서 Java함수를 가져다 사용할 때는 named argument를 사용할 수 없다.
// Kotlin엣 Java함수를 가져다 사용할 때는 JVM상에서 Java가 바이트 코드로 구현됐을때
// parameter 이름을 보존하고 있지 않아 그 이름을 통해서 가져오는 named argument를 사용 할 수 없다
    var java = Chap8JavaFunction()
    //java.repeat(num=3, str="dd")

    printAll("콤","마","로")
    val array = arrayOf("배","열","로")
    //kotlin에서는 배열을 가변인자에 넣어줄때 앞에 *을 붙여줘야한다 *array
    //spread 연산자라 해서 배열 안에 있는 것들을 마치 그냥,를 쓰는 것처럼 꺼내준다
    printAll(*array)


}
// kotlin에서는 {}와 return 를 없애고 =을 쓸수가 있다
fun max(a: Int, b:Int):Int{
    return if (a>b){
         a
    } else {
         b
    }
}
// {}와 return을 삭제 중괄호 안에서 return으로 어떤값을 준다고 표현하는대신에
//이 함수의 값은 이것의 결과물이야
// a거나 b야 a가b 보다 크면 a이고 아니면 b야 라고 표현해줄수있다
fun max1(a: Int, b:Int):Int=
     if (a>b){
        a
    } else {
        b
    }

//한줄로 변경 가능
fun max2(a: Int, b:Int):Int= if (a>b){ a } else { b }

//중괄호를 생략이 가능하다
fun max3(a: Int, b:Int):Int= if (a > b) a  else  b

//두변수 모두 Int타입을 반환하기 떄문에 max3의 반환 함수를 생략이 가능하다
//타입이 생략이 가능한 문법적 이유는 함수를 쓸때 중괄호가 아닌 =을 썻기때문에 반환타입이 생략이 가능하다

fun max4(a: Int, b:Int)= if (a > b) a  else  b

//만약 {}중괄호를 사용할때에는 반환타입이 Unit이 아닌경우 반환타입을 명시해줘야한다
//fun max5(Kotlin.getA: Int, b:Int) { return if (Kotlin.getA>b){Kotlin.getA} else {b}}
fun max6(a: Int, b:Int):Int { return if (a>b){a} else {b}}

// when을 사용하여 한번 표현 해봤다
fun max7(a: Int, b:Int):Int = when{ a>b -> a else -> b }

/*
함수는 클래스 안에 있을 수도, 파일 최상단에 있을 수도 있다,
또한, 한 파일 안에 여러 함수들이 있을수도 있다
 */




//2. default parameter 주어진 문자열을 N번 출력하는 예제
//kotlin도 java와 동일하게 Overloading, Overload 기능이 있다
fun repeat1(
    str : String,
    num : Int,
    useNewLine : Boolean
    ) {
    for(i in 1..num){
        if(useNewLine){
            println(str)
        } else {
            println(str)
        }
    }
}

fun repeat2(
    str : String,
    num : Int = 3,
    useNewLine : Boolean = true
    ){
    for(i in 1..num){
        if(useNewLine){
            println(str)
        } else {
            println(str)
        }
    }
}


//3.named argument
// num은 3을 그대로쓰고싶고 useNewLine은 false를 쓰고싶다!
fun repeat3(
    str : String,
    num : Int = 3,
    useNewLine : Boolean = true
){
    for(i in 1..num){
        if(useNewLine){
            println(str)
        } else {
            println(str)
        }
    }
}

//builder의 장점 동일 타입이 연속해서 존재할때
// builder라는 것이 결국에는 어떤객체를 인스턴스화 할 때 사용하는 것이긴 하지만
//Parameter가 많은경우 동일한 타입의 경우 바꿔서 사용할때

fun printNameAndGender(name: String, gender: String){
    println(name)
    println(gender)
}

//4. 같은 타입의 여러 파라미터 받기 (가변인자)
//...대신 vararg를 사용한다
fun printAll(vararg strings: String){
    for(str in strings){
        println(str)
    }
}

/*
코틀린에서 함수를 다루는방법
함수의 문법은 Java와 다르다!
-접근지시어 fun 함수이름(파라미터):반환타입{}
-body가 하나의 값으로 간주되는 경우 block({})을 없앨 수도 있고, block이 없다면 반환 타입을 없앨 수도 있다.
-함수 파라미터에 기본값을 설정해줄 수 있다.
-함수를 호출 할때 특정 파라미터를 지정해 넣어줄 수 있다.
-가변인자에는 vararg 키워들 사용하며, 가변인자 함수를 배열과 호출할 때는 *를 붙여주어야 한다.
 */