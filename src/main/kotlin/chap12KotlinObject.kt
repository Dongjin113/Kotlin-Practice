interface test1{
    fun act()
}

//static 함수 변수

class Person1(
    var name: String,
    var age: Int,

){
    //static: 클래스가 인스턴스화 될 때 새로운 값이 복제되는게 아니라 정적으로 인스턴스끼리의 값을 공유
    //companion object : 클래스와 동행하는 유일한 오브젝트

    //kotlin 에는 static이없다
    //대신 companion object 블록 안에 넣어둔 변수와 함수가
    // Java의 static 변수의 함수인것처럼 사용이된다
    companion object Factory : test1{
        //그냥 val이라고 쓰면 MIN_AGE에 0이라는 값이 런타임시 할당되는데 만약에 const를 앞에 붙이면 컴파일시에 변수가 할당된다
        //const 진짜 상수에 붙이기 위한 용도. 기본 타입과 String에만 붙힐수 있다
        //사용법은 Java와 동일하다
        private const val MIN_AGE =1

        fun newBaby(name: String): Person1 {
            return Person1(name, MIN_AGE)
        }

        @JvmStatic
        fun newBaby1(name: String): Person1 {
            return Person1(name, MIN_AGE)
        }

        //companion object, 즉 동반객체도 하나의 객체로 간주된다.
        //때문에 이름을 붙일 수도 있고, interface를 구현할 수도 있다.
        override fun act() {
            println("나는 Person 클래스이 동행객체 Factory")
        }

        //companion object에 유틸성 함수들을 넣어도 되지만,
        //최상단 파일을 활용하는 것을 추천한다!
    }
}

class Person2(
    var name: String,
    var age: Int,
    ){
    companion object {
        private const val MIN_AGE =1
        fun newBaby(name: String): Person2 {
            return Person2(name, MIN_AGE)
        }
        @JvmStatic
        fun newBaby1(name: String): Person2 {
            return Person2(name, MIN_AGE)
        }

    }
}




//싱글톤
//Kotlin에서 Singleton 만드는 방법 object만을 붙혀주면 된다
object Singleton {
    var a: Int =0
}

fun main() {
    println(Singleton.a)
    Singleton.a +=10
    println(Singleton.a)
    println(Singleton)
    println(Singleton)
    println(Singleton)
}

//익명클래스
/*
특정 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용할 때 쓰는 클래스

Java에서는 new 타입이름()
Kotlin에서는 object : 타입이름
으로 익명클래스를 표현했다
 */

fun main1() {
    moveSomething(object : Movable1 {
        override fun move() {
            println("쿵쿵")
        }

        override fun fly() {
            println("파닥파닥")
        }


    })
}


private fun moveSomething(movable : Movable1){
    movable.move();
    movable.fly();
}


interface Movable1 {

    fun fly()
    fun move()
}
/*
Kotlin에서 object 키워드를 다루는 방법

-Java의 static 변수와 함수를 만드려면,
Kotlin 에서는 companion object를 사용해야 한다.
- companion object도 하나의 객체로 간주되기 때문에 이름을 붙일 수 있고,
다른 타입을 상속 받을 수도 있다.
-Kotlin에서 싱글톤 클래스를 만들 때 object 키워드를 사용한다.
-Kotlin에서는 익명 클래스를 만들 때 object : 타입을 사용하면 된다
 */

