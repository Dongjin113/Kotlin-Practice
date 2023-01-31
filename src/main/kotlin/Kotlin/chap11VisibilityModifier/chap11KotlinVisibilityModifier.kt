package Kotlin

class chap11KotlinVisibilityModifier {
}

//접근제어자

//1. 자바와 코틀린의 가시성 제어
/*
Java의 접근제어
public = 모든 곳에서 접근가능
protected = 같은 패키지 또는 하위 클래스에서만 접근 가능
default 같은 패키지에서만 접근 가능
private 선언된 클래스 내에서만 접근 가능

Kotlin
public = 모든 곳에서 접근가능
protected = 선언된 클래스(Java에서는 같은 패키지 내에서 접근이 가능했지만 Kotlin에서는 선언된 클래스내에서만 접근이 가능하다)
또는 하위 클래스에서만 접근 가능
kotlin에서는 패키지를 namespace를 관리하기 위한 용도로만 사용! 가시성 제어에는 사용되지 않는다

default 라는 것은 사라졌다 => internal 이라는 새로운 가시성 제어 지시어가 생겼다 ( 같은 모듈에서만 접근 가능)

모듈이란 ?
한번에 컴파일되는 Kotlin 코드
Gradle을 사용한다면 Gradle Source Set Gradle에서 만든 project가 될 것이다
IDEA Module
Maven Project
Gradle Source Set
Ant Task<kotlinc>의 호출로 컴파일 파일의 집합

internal을 사용하게되면 상위 모듈과 하위 모듈이 존재할때 하위 모듈에 있는
internal이 붙은 class나 함수를 상위 모듈에서 가져오지 못한다

private(동일하다) 선언된 클래스 내에서만 접근 가능

Java의 기본 접근 지시어는 default
Kotlin의 기본 접근 지시어는 public

코틀린은 .kt 파일에 변수, 함수, 클래스 여러개를 바로 만들 수 있다.


 */


//2. 코틀린 파일의 접근 제어

//3. 다양한 구성요소의 접근 제어

//4. Java와 Kotlin을 함께 사용할 경우 주의할 점

//코틀린은 .kt 파일에 변수, 함수, 클래스 여러개를 바로 만들 수 있다.
val a =3
fun add(a:Int,b:Int): Int {
    return a+b
}
class Cat31()

//public 기본값 어디서든 접근할 수 있다.
//protected 파일(최상단)에는 사용 불가능
//왜나하면 protected가 코틀린에서는 선정된 클래스와 하위 클래스에 작동하는 지시어인데
//애당초 클래스가 아닌 파일에는 사용할 수 없다
//protected val w =5

//internal 같은 모듈엣만 접근가능
//private 은 같은 파일 내에서만 접근할 수있게해준다

//클래스, 생성자, 프로퍼티의 접근 지시어

    //클래스: 위에 정리한것과 동일하다

    //생성자: 생성자도 의미자체는 똑같다. 단! 생성자에 접근 지시어를 붙이려면,
    // constructor를 직접 써주어야 한다 class Bus internal constructor(val price:Int)
    // open을 써주는 이유는 protected는 자신과 하위클래스만 사용이 가능하기 때문에
    // 하위 클래스를 못만들도록 final이 자동으로 설정되어있어 open을 붙혀주어야 한다
open class Cat2 protected constructor(){}

//Java의 유틸성코드 만들때 abstract class + private constuctor을 사용해서 인스턴스화를 막았다
    //생성자에 접근제어자를 붙이는 용례 중 하나가 Java에서 유틸성 코드를 만들 때 추상 클래스를만들고
    //private 생성자를 만들어서 아예 인스턴스화도 할수 없고 상속도 받을수 없게끔 이렇게
    //유틸성 코드를 작성할 때 많이 활용했는데 Kotlin에서도 비슷하게 가능하다

//abstract 클래스를 만들고 private constructor를 사용해서 Kotlin에서도 비슷하게 가능하다
//그러나 파일 최상단에 바로 유틸 함수를 작성하면 매우 편하다
fun isDirectoryPath(path: String): Boolean{
    return path.endsWith("/")
}

/*Java 유틸성코드 EX
public abstract class StringUtils{
    private StringUtil(){}
    public boolean Kotlin.isDirectoryPath(String path){
        return path.endsWith("/")
    }
}
 */

//프로퍼티의 가시성 범위도 동일하다
    //단! 프로퍼티의 가시성을 제어하는방법으로는 두가지가 있다
    //val 앞에 붙여 한번에 접근 지시어를 정하는 방법이있고
    //custom getter나 custom setter를 만들었던 것처럼 사용하여
    // getter와 setter에 각각의 다른 가시성을 부여할 수 있다.
class propertyVisibilityModifier(
    internal val name: String, //name에 대한 getter를 interner로 사용한다
    private val owner: String, //owner에 대한 getter와 setter를 private로 만들고싶다
    price: Int
){
    //pulbic이 기본 접근제어자 이기때문에 price에 접근하는 getter는
    // 현재 public 상태이다
    var price = price
        private set
}

/*
//Java와 Kotlin을 함께 사용할 때 주의할 점
Internal은 바이트 코드 상 public이 된다
때문에 Java 코드에서는 Kotlin 모듈의 internal 코드를 가져올 수 있다
예를 들어 상위모듈이 Java로이루어져있고
하위모듈이 Kotlin으로 이루어져있다면 하위 모듈에 있는 internal이라고 감싸진 field나
함수 등을 상위 모듈의 Java에서는 바로 가져올수있다
그래서 Java 코드에서는 코틀린 모듈의 internal 코드를 가져올 수있다

Kotlin의 protected와 Java의 protected는 다르다
Java는 같은 패키지의 Kotlin protected 멤버에 접근할 수 있다

 */

/*
코틀린에서 접근제어를 다루는 방법
-Kotlin에서 패키지는 namespace 관리용이기 떄문에 protected는 의미가 달라졌다.
- Kotlin에서는 default가 사라지고 모듈간의 접근을 통제하는 internal이 새로 생겼다.
- 생성자에 접근 지시어를 붙일 떄는 constructor를 명시적으로 써주어야 한다.
- 유틸성 함수를 만들 때는 파일 최상단을 이용하면 편리하다.
- 프로퍼티의 custom setter에 접근 지시어를 붙일 수 있다.
- Java에서 Kotlin 코드를 사용할때는 internal과 protected는 주의해야 한다.

 */



