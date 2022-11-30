class chap10KotlinInheritanceClass {
}

//2. 인터페이스
//3. 클래스를 상속할 때 주의할점

//1. 추상클래스
abstract class Animal( protected val species : String, protected open val legCount : Int){
    abstract fun move()
}

//kotlin에서는 상속을 받을때 extends가 아닌 :를 사용한다
//type을 사용할때의 :는 변수명에 한칸 뛰지 않고 바로 붙혀서 사용을하고 species: String
//상속을 받을때는 변수명에서 한칸을 뛴후 : 를 붙혀서 사용한다 class Cat (species: String) : Animal{}
class Cat (
    species : String
) : Animal(species, 4){

    // cat 클래스를 만드는데 species라는 String을 받는 생성자가 같이생기고
    //Animal class를 상속 받고있는데 cat class를 만들어줄때 Animal class의 constructor를 불러주고
    //아까받았던 species와 4라는 값을 넣어준다

    //@overide 라는 어노테이션이아니라 키워드 고정된 단어를 사용
    override fun move() {
        println("고양이 다리는 4개인가 네개인가?")
    }
}


class Penguin (
    species : String
        ) : Animal(species  , 2), Swimable, Flyable{
// 인터페이스 구현도 :을 사용한다
    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직입니다 꿱꾸ㅖㅒㄲ~")
    }

    //final 이라서 override할수 없어라는 에러
    //Kotlin에서 프로퍼티를 override 할 때 무조건 Open을 붙여 줘야만 한다
    //property를 override를 할때는 추상 프로퍼티가 아니라면 상속 받을때 프로퍼티에 open을 붙혀줘야한다
    //추상클래스에서 자동으로 만들어진 getter 새로정의 하기위해서 override 키워드랑 custum get을
    //사용하여 자바와 같은 기능을 가지게끔 해줬다
    //상위클래스에 접근하는 키워드는 java와 같이 super이다
    //Java와, Kotlin 모두 추상 클래스는 인스턴스화 할 수 없다.

    override val legCount: Int
        get() = super.legCount + this.wingCount


    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
        //중복되는 인터페이스를 특정할대는 super<타입>.함수를 사용한다
        //특정 상위 인터페이스를 오버라이드할때의 문법이 다르다
        //인터페이스역시 Java,Kotlin 둘다 인스턴스화 할수없다
        //Kotlin에서는 backing field값없는 프로퍼티를 인터페이스에 만들수있다
    }

    //값을 집어 넣어줄 수 있다
    override val swimAbility : Int
        get() =2


    override fun fly() {
        TODO("Not yet implemented")
    }
}

//2 인터페이스 Flyable 과 Swimmable 인터페이스
interface Swimable{

    //프로퍼티를 사용할 수 있다
    // default를 넣어주면 상속받았을때 override를 하지 않더라도 오류가 발생하지않는다
    val swimAbility : Int
        get() =3


    fun act() {
        //인터페이스에서 자유롭게 사용할 수 있다.
        println(swimAbility)
        println("어푸어푸")
    }

    fun fly()
}

interface Flyable{
    fun act() {
        println("파닥파닥")
    }
}

//3. 클래스를 상속받을대 주의할점

// Base class를 다른 클래스가 상속받을수 있도록 open으로 열어줬다
open class Base(
    //number 라는 프로퍼티도 누군가 override 할 수 있게끔 open으로 열어줬다
    open val number: Int = 100
) {
    //초기화블록
    init {
        //base class를 출력하고 number라는 변수값을 출력한다
        println("Base Class")
        println(number)
        //상위클래스의 생성자가 실행되는동안
        //하위클래스의프로퍼티 즉 Derived를 인스턴스화하는 말은
        //Derived에 number에 값을 집어넣어준다는것인데
        //상위클래스에서 number를 호출하게 되면
        //하위클래스에 있는 넘버를 가져온다
        //그러나 아직 상위클래스에 constructor가 먼저 실행된 단계라서
        //하위클래스의 number값이 초기화가되지 않은상태이다
        //그상태에서 하위클래스의 number에 접근해 100도 아니고 300도아닌
        //int의 기초값인 0이 출력된다
        //그래서 상위클래스의 constructor와 init 블락에서는
        //하위 클래스의 final이 아닌 field에 접근하면 안된다고 이야기 하고있다
        //하위 클래스에서 override하고있는 프로퍼티에 접근하면 안된다고 말하고 있다
        //상위클래스를 설계할 때 생성자 또는 초기화 블록에 사용되는 프로퍼티에는 open을 피해야 한다

    }
}

class Derived(
    override val number:Int
) : Base(number){
    init{
        //하위 Derived 클래스에서는 derived 클래스를 출력하고있다
        println("Dervived class")
    }
}

fun main() {
    Derived(300) //number값이 0이 나온다
}

//4. 상속 관련 키워드 4가지 정리
/*
1. final : override를 할 수 없게 한다
2. open: override를 열어준다
3. abstract : 반드시 override를 해야 한다
4. override : 상위 타입을 오버라이드 하고 있다.


코틀린에서 상속을 다루는 방법
- 상속 또는 구현을 할 때에 : 을 사용해야 한다.
- 상위 클래스 상속을 구현할 때 생성자를 반드시 호출해야 한다.
- override를 필수로 붙여야 한다.
- 추상 멤버가 아니면 기본적으로 오버라이드가 불가능하다.
    -open을 사용해주어야 한다.
- 상위 클래스의 생성자 또는 초기화 블록에서 open 프로퍼티를 사용하면 얘기치 못한 버그가 생길 수 있다.
 */