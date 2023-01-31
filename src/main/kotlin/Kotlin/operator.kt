package Kotlin

class Money(val amount: Long) {

    operator fun plus(other: Money): Long {

        return this.amount + other.amount
    }
}

fun main() {
    //java와 kotlin은 완전히 동일하다
    //단항 연산자 ++ --
    //산술 연산자 + - * / %
    //산술대입 연산자 += -= *= /= %=
    //비교연산자 > < >= <=
    //논리연산자 && || !  Java처럼 Lazy연산을 수행한다.

    /*
    Kotlin만의 연산자
    in  !in : 컬렉션이나 범위에 포함되어 있다 , 포함되어 있지 않다 라는 뜻
    Kotlin.getA..b : a부터 b까지의 범위 객체를 생성한다
    Kotlin.getA[i] : a에서 특정 index i 로 값을 가져온다
    Kotlin.getA[i] = b :  a의 특정 index i에 b를 넣는다
     */


    //동등성(Equality) : 두 객체의 값이 같은가?
    //동일성(Identitiy) : 완전히 동일한 객체인가? 즉 주소가 같은가?
    /*
    Java
    1.JavaMoney(1000) 주소 : 0x101
    2.JavaMoney(1000) 주소 : 0x101
    3.JavaMoney(1000) 주소 : 0x201

    1,2 두 인스턴스는 정체성이 동일하다 Java에서 ==를 사용 레퍼런스가 같은지 확인하는 코드
    2,3 두 인스턴스의 값은 주소는 다르나 값은 동등하다 Java에서는 equals를 사용
    Java 동일성에 == 동등성에 equals를 직접호출

    Kotlin
    Kotlin에서는 동일성에 ===를 사용,
    동등성에 ==를 호출 ==를 사용하면 간접적으로 equals를 호출해 준다
     */

    //java와 다르게 객체를 비교할때 비교 연산자를 사용하면 자동으로 compareTo를 호출해준다


/*
    val money1 = JavaMoney(2_000L)
    val money2 = JavaMoney(1_000L)

    //kotlin은 자동적으로 compareTo를 호출해준다
    if(money1 > money2){
        println("money1이 money2보다 큽니다")
    }
    */

    /*
    val money1 = JavaMoney(1_000L)
    val money2 = money1
    val money3 = JavaMoney(1_000L)

    println(money1 === money2)
    println(money1 === money3)
    println(money1 == money3)



    //Lazy 연산이란 fun1또는 fun2를 하게되면 fun1을 호출했을때 true 가나온다
    //그럼Lazy 연산이란 fun2를 호출하지 않고 본문이 실행되는것을 말한다
    if(Kotlin.fun1() || Kotlin.fun2()){
        println("본문")
    }

    //fun2가 실행되면 false가 나와 fun1이 실행되지 않고 밖으로 나가는것을 Lazy연산이라고한다
    if(Kotlin.fun2() && Kotlin.fun1()){
        println("본문")
    }
     */

    //연산자 오버로딩

    val money1 = Money(1_000L)
    val money2 = Money(2_000L)
    println(money1+money2)
    println(money1.plus(money2))
    println(money1.amount+money2.amount)
    println(money1.amount.plus(money2.amount))

}

//Lazy연산
fun fun1(): Boolean{
    println("fun 1")
    return true;
}

fun fun2(): Boolean{
    println("fun 2")
    return false;
}

/*
Kotlin에서 연산자를 다루는 방법
- 단항연산자, 산술연산자, 산술대입연산자 Java와 똑같다~
- 비교 연산자 사용법도 Java와 똑같다~
    - 단, 객체끼리도 자동 호출되는 compareTo를 이용해
      비교 연산자를 사용할 수 있다.
- in, !in/ Kotlin.getA..b/ Kotlin.getA[i] / Kotlin.getA[i] = b와 같이 코틀린에서 새로 생긴 연산자도 있다.
 */