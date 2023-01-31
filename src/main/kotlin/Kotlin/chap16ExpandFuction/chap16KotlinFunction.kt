package Kotlin.chap16ExpandFuction

import Kotlin.Person
import java.lang.IllegalArgumentException


class chap16KotlinFunction{
/*
1.확장함수
2.infix함수
3.inline함수
4.지역함수
 */

//1.확장함수
/*

Kotlin은 Java와 100% 호환하는 것을 목표로하고있다
기존 Java코드 위에 자연스럽게 코틀린 코드를 추가할 수는 없을까?

Java로 만들어진 라이브러리를 유지보수, 확장할 때 Kotlin 코드를 덧붙이고 싶어!!
어떤 클래스안에 있는 메소드처럼 호출할 수 있지만, 함수는 밖에 만들 수 있게 하자!!
-함수의 코드자체는 클래스의 밖에 있는데 마치 클래스 안에있는 멤버 함수처럼 호출해서 쓸수있게하는것

 */
fun main() {
    val str ="ABC"
    //원래 String에 있는 멤버함수처럼 사용할 수 있다.
    println(str.lastChar1())

    println()
    println("확장함수와 멤버함수")
    println(ExpandMemberFunction())

    println()
    println("Train의 확장함수의 오버라이딩")
    println(TrainMain())


}

//문자열의 가장 끝에 있는 문자를 가져오는 코드
//원래는 바로 함수이름이 들어오지만 문자열을 확정할것이니까
// String.lastChar이라는 함수를 생성해준다
fun String.lastChar1(): Char {
    //본인자신에 있는 마지막문자를 가져와야함으로
    //this를 통해서 함수가 불려진 instance를 가져오게된다
    return this[this.length - 1]
}


/*
fun = 확장함수도 함수이기 때문에 함수라는뜻
String 클래스를 확장하는구나라고 해서 String.이 들어가게된다
함수 안에서는 this를 통해서 불려진 instance의 접근이 가능하게 된다

fun 확장하려는클래스.함수이름(파라미터):리턴타입{
//this를 이용해 실제 클래스 안의 값에 접근
이때 this를 수신객체라고 부른다
그다음 확장하려는 클래스(String.lastChar1()에서의 String)
즉 this의 타입은 수신객체 타입이라고부른다
}
 */

/*
그러면 확장함수가 public이고,
확장함수에서 수신객체클래스의 private 함수를 가져오면 캡슐화가 깨지는것 아닌가?
그래서 확장함수는 클래스에 있는 private 또는 protected 멤버를 가져올 수 없다
 */

//멤버함수와 확장함수의 시그니처가 같으면?
//멤버함수가 우선적으로 호출이 된다
//확장함수를 만들었지만, 다른 기능의 똑같은 멤버함수가 생기면 오류가 발생할 수 있다
//확장함수가 오버라이드 될 수도 있다
fun chap16JavaPersonExpandPerson.nextYearAge(): Int {
println("확장 함수")
    return this.age +1
}

fun ExpandMemberFunction(){
    val person = chap16JavaPersonExpandPerson("A",100)
    //Kotlin내의 확장함수인 nextYearAge 와 Java의 person안의 멤버함수인 nextYearAge중
    //멤버함수인 Java의 nextYearAge가 출력이되는것을 볼 수 있다
    println(person.nextYearAge())
}

//확장함수의 오버라이드
/*
Train이라는 클래스에 대해서도 isExpensive라는 확장함수를 만들고
Srt란 클래스에 대해서도 isExpensive라는 확장함수를 만들었다

이경우 Train혹은 Srt변수를 만들어서 이변수에대해서 isExpensive를 부르면
Train의 Expensive가 불릴까 Srt의 Expensive가 불릴까?
 */

open class Train(
    val name: String = "새마울기차",
    val price: Int = 5_000
)

fun Train.isExpensive(): Boolean {
    println("Train의 확장함수")
    return this.price >= 10000
}

class Srt : Train("SRT",40_000)

fun Srt.isExpensive(): Boolean {
    println("Srt의 확장함수")
    return this.price >= 10000
}

fun TrainMain(){
    val train: Train = Train()
    println(train.isExpensive())// Train의 확장함수

    val Srt1: Train = Srt()
    println(Srt1.isExpensive())// Train의 확장함수

    val Srt2: Srt = Srt()
    println(Srt2.isExpensive()) // Srt의 확장함수
/*
    결국에 Train타입으로 선언하면 Train 확장함수
    똑같은 논리로 Train 타입으로 설정하면 Train의 확장함수 그게
    Srt instance건 Ktx의 instance건 중요하지 않다
    그 다음 Srt타입으로 선언하면 Srt 확장함수가 분리된다

    해당변수의 현재타입
    즉, 정적인 타입에 의해 어떤 확장함수가 호출될지 결정된다

    확장함수의 중간정리 3가지
    1. 확장함수는 원본 클래스의 private, protected 멤버 접근이 안된다!
    2. 멤버함수, 확장함수 중 멤버함수에 우선권이있다
    3. 확장함수는 현재 타입을 기준으로 호출된다!

    확장함수라는 개념은 확장프로퍼티와도 연결된다
    확장 프로퍼티의 원리는 확장함수 + custom getter와 동일하다
    */
    }
    fun String.lastChar2(): Char {
        //본인자신에 있는 마지막문자를 가져와야함으로
        //this를 통해서 함수가 불려진 instance를 가져오게된다
        return this[this.length - 1]
    }
    //확장함수는 확장프로퍼티와 연결된다
    // 확장 프로퍼티의 원리는 확장함수 + custom getter와 동일하다
    val String.lasChar: Char
        get() = this[this.length -1]

    //2.infix 함수 (중위함수) 함수를 호출하는 새로운 방법!!
    /*
    downTo, step 도 함수이다! (중위 호출 함수)
    변수.함수이름(argument) 대신 변수 함수이름 argument
    중위함수호출 : 변수랑 argument가 각각 하나만 있는경우에
    변수 함수이름 argument 이렇게 호출하게 해주는것을 중위함수 호출이라고한다

     */
    fun Int.add(other: Int):Int{
        return this + other
    }

    infix fun Int.add2(other: Int):Int{
        return this + other
    }

    fun indfixtest(){
        3.add(4)
        3.add2(5)
        3 add2 6 //infix라는 함수를 통해 3 add2 6이라는 형식으로 사용할 수 있다
        //함수를 똑같이 부르는데 코드가 DSL느낌이 난다
        //이렇게 함수를 부르는 방법을 다르게 할 수 있는것을 중위 함수라고 한다
        //infix는 멤버함수에도 붙힐 수 있다
    }

    //3.inline 함수
    /*
    함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 복사하는것


     */

    fun Int.add3(other: Int):Int{
        return this + other
    }

    inline fun Int.add4(other: Int):Int{
        return this + other
    }

    fun inlinerun(){
        3.add4(4)
    }

    //
    /*

        3.add4(4)
   --> 바이트코드로 변경시 원래는 add라는 함수도 이제 바이트상에서
   새로생기고 3.add(4)가 그 함수를 부르는 식으로 코드가 작성되어야 하는데
   inline이라는 키워드를 붙혔기 때문에

   덧셈하는 로직 자체가 그함수를 부르는 쪽에 복사 붙여넣기 된것이다
      public final void inlinerun() {
      byte $this$add4$iv = 3;
      int other$iv = 4;
      int $i$f$add4 = false;
      int var10000 = $this$add4$iv + other$iv;
   }
   * inline 복사 붙혀넣기를 사용하는 이유
   함수를 파라미터로 전달할 때에 오버헤드를 줄일 수 있다.
   하지만  inline 함수의 사용은 성능 측정과 함께 신중하게 사용되어야 한다!

   함수를 계속 중첩해서 쓰는 경우에는 이 함수가 다시 또 다른 함수를 부르고 또다른 함수를 부르면
   그 함수 call chain에 overhead가 생기다 보니까 이것을 줄이기 위해 inline이라는 것을 쓴다
    하지만 inline 함수의 사용은 성능 측정과 함께 신중하게 사용되어야 한다

    코틀린 라이브러리에서는 최적화를 어느 정도 해뒀기 때문에 적절하게 inline 함수가 붙어 있다

     */


    //4. 지역함수
    /*
    함수안에 함수를 선언할수 있는것을 지역함수라고한다
     */

    fun createPerson(firstName: String, lastName: String): Person {
        if(firstName.isEmpty()){
            throw IllegalArgumentException("firstName은 비어있을 수 없습니다! 현재 값 : $firstName")
        }

        if(lastName.isEmpty()){
        throw IllegalArgumentException("firstName은 비어있을 수 없습니다! 현재 값 : $lastName")
        }
        return Person(firstName, lastName, 100)//Person(firstName, lastName, 100)

    }

    //지역변수의 사용
    fun createPerson1(firstName: String, lastName: String): Person {
        fun validateName(name:String, filedName:String){
        if(name.isEmpty()){
            throw IllegalArgumentException("${filedName}은 비어있을 수 없습니다! 현재 값 : $name")
            }
        }
        /*
        validateName 이라는 것 자체를 함수안의 함수 fun 안의 fun을 만든 다음에
        아까 봤던 중복되는 부분을 제거하여 validateName이라는 하나의 함수를 만들어 이함수를 호출하게끔 헀다

        지역함수
        함수로 추출하면 좋을 것 같은데, 이 함수를 지금 함수 내에서만 사용하고 싶을 때 사용한다

        하지만 depth가 깊어지기도 하고, 코드가 그렇게 깔끔하지는 않는다
         */
        validateName(firstName,"fistName")
        validateName(lastName,"lastName")

        return Person(firstName, lastName, 100)//Person(firstName, lastName, 100)

    }

    /*
    Kotlin에서 다양한 함수를 다루는 방법
    -Java 코드가 있는 상황에서, Kotlin 코드로 추가 기능 개발을 하기 위해 확장함수와 확장프로퍼티가 등장했다.
        =확장 함수의 문법
        fun 확장하려는 클래스.함수이름(파라미터): 리턴타입{
        //this를 이용해 실제 클래스 안의 값에 접근
        }
    -확장함수는 원본 클래스의 private, protected 멤버 접근이 안된다!
    -멤버함수, 확장함수 중 멤버함수에 우선권이 있다!
    -확장함수는 현재 타입을 기준으로 호출된다!
    -Java에서는 static 함수를 쓰는것처럼 Kotlin의 확장함수를 쓸 수 있다.
    -함수 호출 방식을 바꿔즌 infix 함수가 존재한다.
    -함수를 복사-붙여넣기 하는 inline 함수가 존재한다.
    -Kotlin에서는 함수 안에 함수를 선언할 수 있고, 지역함수라고 부른다
     */

}