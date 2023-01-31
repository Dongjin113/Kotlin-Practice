package Kotlin//Data Class
//Enum Class
//Sealed Class, Sealed Interface

//data라는 키워드를 클래스 앞에 붙이게 되면 이것을 Data Class라고 하고 
// 이 Data Class에서는 자동으로 equals와 hashCode, toString을 만들어 준다
data class PersonDto(
    private val name: String,
    private val age: Int,

    //여기에 named argument까지 활용하면 builder pattern을 쓰는 것 같은 효과도 누릴수 있다!
    //사실상 builder, equals, hashCode, toString이 모두 있는것!
)

class PersonDto1(
    private val name: String,
    private val age: Int,
)

fun main() {
    val dto1 = PersonDto("둘리",100)
    val dto2 = PersonDto("영이",200)
    val dto3 = PersonDto("둘리",100)
    println(dto1 == dto2)
    println(dto1 == dto3)
    println(dto1)

    val nodto1 = PersonDto1("둘리",100)
    val nodto2 = PersonDto1("영이",200)
    val nodto3 = PersonDto1("둘리",100)
    println(nodto1 == nodto2)
    println(nodto1 == nodto3)
    println(nodto1)

}

//Java에서는 JDK16부터 Kotlin의 data class 같은 record class를 도입


//Enum Class
enum class Country(
    private val code: String,
) {
    KOREA("KO"),
    AMERICA("US")
    ;
    /*
    When은 Enum Class 혹은 Sealed Class와 함께 사용할 경우, 더욱더 진가를 발휘한다
     */
}

//Enum에 대한 분기 처리를 할 때 코틀린에서는 when을 사용해서
//조금더 읽기쉬운 코드로 바꿀 수 있다
//컴파일러가 country의 모든 타입을 알고 있어 다른 타입에 대한 로직(else)를 작성하지 않아도 된다
//Enum에 변화가 있으면 알 수 있다.

fun handleCountry(country: Country){
    when (country){
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
    }
}

//Sealed Class, Sealed Interface
//sealed의 단어의 이미 봉일을 한
/*
상속이 가능하도록 추상클래스를 만들까 하는데...
외부에서는 이 클래스를 상속 받지 않았으면 좋겠어!!
하위 클래스를 봉인하자!!!
컴파일 타임 떄 하위 클래스의 타입을 모두 기억한다.
즉, 런타임때 클래스 타입이 추가될 수 없다.
하위 클래스는 같은 패키지에 있어야 한다.

Enum과 다른점
- 클래스를 상속받을 수 있다.
-하위 클래스는 멀티 인스턴스가 가능하다.



    //Enum의 특징
    //추가적인 클래스를 상속받을 수 없다.
    //인터페이스는 구현할 수 있으며, 각 코드가 싱글톤이다.


 */

//평범한 클래스 앞에 sealed만 작성해줬다
sealed class HyundaiCar(
    val name: String,
    val price: Long
)

//같은패키지에서 Avante와 sonata와 grandeur 라는 클래스를 만들었다
//sealed만 빼고본다면 그냥 abstract클래스와 다른게 없어보인다
//똑같이 함수 같은걸 추상메소드로 선언한다면 똑같이 아래에서 하위클래스를 모두 구현해주어야한다
//그런데 포인트는 컴파일 타임때 하위 클래스 타입을 모두 기억하고 런타임때 클래스 타입이 추가될 수 없다는 점이다
class Avante : HyundaiCar("아반떼",1_000L)

class Sonata : HyundaiCar("소나타",2_000L)

class Grandeur : HyundaiCar("그렌져",3_000L)

fun main2() {

}

//when하고 Sealed class의 인스턴스가 들어가게 되면
//이 Sealed class 타입이 무엇인지 is 타입으로 분기를 처리해줄수있는데 이때 Enum과 똑같이 코드가
//간략하고 else에 대한 코드를 추가로 작성해주지 않아도되고 Sealed Class의 하위 구현체가 추가되거나
// 제거됐을때 좀 더 쉽게 알아차릴수 있다

private fun handleCar(car: HyundaiCar){
    when (car){
    is Avante -> TODO()
    is Sonata -> TODO()
    is Grandeur -> TODO()
    }
}

//추상화가 필요한 Entitiy or DTO에 sealed class를 활용
// 추가로 JDK17에서도 Sealed Class가 추가됌 문법은 조금 다르다

/*
Kotlin에서 다양한 클래스를 다루는 방법
- Kotlin의 Data class를 사용하면 equals, hashCode, toString을 자동으로 만들어준다.
- Kotlin의 Enum Class는 Java의 Enum Class와 동일하지만, when과 함께 사용함으로써 큰 장점을 갖게 된다.
- Enum Class보다 유연하지만, 하위 클래스를 제한하는 Sealed Class 역시 when과 함께 주로 사용된다.
 */