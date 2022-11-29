fun main() {
    /*

    println("Hello world")


    //변수를 지정하는방법 변수 : int      ex) number1:Long
    //가변 값을 바꿀수 있음
    var number1 : Long = 10L

    var number3 //값을 넣지 않았기 때문에 컴파일러가 타입을 추론하지못해 에러가발생
    var number4: Long //타입을 지정해줘 에러가나지않음
    println(number4)// 변수만 지정해줘 값이 없어 에러가남
    number4 = 5 //변수의 값을 지정해줌
    println(number4) // 값이 들어와서 에러가나지않음

    //불변 값을 바꿀수없음
    val number2 = 10L
    number2 = 5L // 한번 값이 지정됐기때문에 변경을 할 수 없음
    val number5: Long //초기값을 지정해주지않은경우에는 무조건 타입을 지정해줘야함
    number5 =10L //초기값을 지정하지 않은 최초한번은 값을 지정해줄수 있음

    /*
    =자바=
    Primitive type - 변수에 값 자체를 저장
    정수형 byte, short, int, long
    실수형 float, double
    문자형 char
    논리형 boolean

    Reference type - 메모리상에 객체가 있는 위치를 저장
    종류 - Class, Interface, Array 등


    =kotlin=
    숫자 , 문자, 불리언과 같은 몇몇 타입은 내부적으로 특별한 표현을 갖는다.
    이타입들은 실행시에 primitive Value로 표현되지만,코드에서는 평범한 클래스처럼 보인다
    */



    var number6 = 10L
    var number9 = 1_000L

    //kotlin은 기본적으로 null이 들어갈 수 없도록 설정했다 null을 넣어주고싶다면 타입을 설정하고 ? 를 붙여줘야한다
    var number7 : Long? = 1_000L
    number7 = null

    var number10 = 10L
    number10 = null

    //코틀린에서 객체를 instance화 할때 new를 붙히지 않아야한다
    var person = Person("고가")
    var person1 = new Person("고가")
}
class Person(name: String) {
}

/*
코틀린에서 변수를 다루는 방법
모든 변수는 var / val을 붙여 줘야한다.
-var: 변경 가능하다/ val: 변경 불가능하다(read-only)
-타입을 명시적으로 작성하지 않아도, 타입이 추론된다.
-Primitive Type과 Reference Type을 구분하지 않아도 된다.
-Null이 들어갈 수 있는 변수는 타입뒤에 ?를 붙여주어야 한다.
    -아예 다른 타입으로 간주된다
-객체를 인스턴스화 할 때 new를 붙이지 않아야 한다.
 */
 */
}