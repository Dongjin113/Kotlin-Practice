package Kotlin

fun main() {
    /*
    //Java Byte, Short, Int, Long , Float, Double, 부호없는정수들
    //Kotlin
    //Kotlin 에서는 선언된 기본값을 보고 타입을 추론한다
    val number1 = 3 //Int
    val number2 = 3L // Long
    val number3 = 3.0f// Float
    val number4 = 3.0 //double
    // java 기본타입간의 변환은 암시적으로 이루어져야한다
    // kotlin 에서는 기본타입간의 변화는 명시적으로 이루어져야한다

    val number5 =4
    val number6:Long = number5 //에러가 발생 Kotlin에서는 암시적 타입 변경이 불가능하다
    
    to기본타입으로 변경해서 사용해야한다
    val number6:Long = number5.toLong()
    println(number5 +number6)



    print("1")
    Kotlin.printAgeIfPerson1(null)
    print("2")
    Kotlin.printAgeIfPerson1(Person(null))
    print("3")
    Kotlin.printAgeIfPerson1("사수")
    print("4")
    Kotlin.printAgeIfPerson1(Person("사슴"))

    val person = Person("둘리")
    println("이름 : ${person.name}")
*/

 //   println("이름 : $name")
    val name = "둘리"
    //큰따음표 세개를 사용하면 자유롭게 문자열을 작성할수있다
    val str =
    """
        가나다라마바사
        ABC
        EFG
        ${name}
    """.trimIndent()

    println(str)

    //Kotlin에서 문자열의 특정 문자 가져오기
    val str1 = "ABC"
    println(str1[0])
    println(str1[2])





}

fun printAgeIfPerson(obj:Any) {
    //is == java instanceof    obj가 Person 이면 true Person이 아니면 false 반환
    if (obj is Person) {
        //Kotlin의 형변환 as Person은  java의 (Person)과 같은 의미이다
        val person = obj as Person
        println(person.name)
        //as Person은 생략이 가능

        println(obj.name)
    }


    /*
    if(!(obj is Person)){
        println(obj.name)
    }

    if(obj !is Person){
        println(obj.name)
    }
}*/
}

fun printAgeIfPerson1(obj:Any?) {
    //NPE가 발생
    //val person = obj as Person
    //println(person.name)

    //값을 null을 출력
    //as? 1. value가 Type이면 잘 캐스팅이되고 2. value가 null이면 전체 값이 null이 출력
    //3. value가 Type이 아니면 에러가 아닌대신 null이 나온다

    if(obj is Person) {
        val person = obj as? Person
        println(person?.name)
    }else{
        val person1 = obj
        println(person1)
    }




/*
Kotlin의 특이한 타입 3가지
1. Any
- Java의 Object 역할. (모든 객체의 최상위 타입)
- 모든 Primitive Type의 최상의 타입도 Any이다
- Any 자체로는 null을 포함할 수 없어 null을 포함하고 싶다면, Any?로 표현.
- Any에 equals /hashCode / toString 존재.


2. Unit
-Unit은 Java의 void와 동일한 역할.
-(살짝 어려운내용 ) void와 다르게 Unit은 그 자체로 타입 인자로 사용 가능하다.
-함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입을 의미,
즉, 코틀린의 Unit은 실제 존재하는 타입이라는 것을 표현

3.Nothing
-Nothing은 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
- 무조건 예외를 반환하는 함수/ 무한루프 함수 등

4.String interpolation/ String indexing
 */

}

/*
Kotlin에서 Type을 다루는 방법
- 코틀린의 변수는 초기값을 보고 타입을 추론하며, 기본 타입들 간의 변환은 명시적으로 이루어진다.
- 코틀린에서는 is, !is, as, as? 를 이용해 타입을 확인하고 캐스팅한다.
- 코틀린의 Any는 Java의 Object와 같은 최상위 타입이다.
- 코틀린의 Unit은 Java의 void와 동일하다
- 코틀린에 있는 Noting은 정상적으로 끝나지 않는 함수의 반환을 의미한다.
- 문자열을 가공할때 ${변수}와 """""""를 사용하면 깔끔한 코딩이 가능하다.
- 문자열에서 문자를 가져올때의 Java의 배열처럼[] 를 사용한다

 */