package Kotlin

import kotlin.collections.withIndex
import kotlin.collections.withIndex as withIndex1

/*
1. 배열

2. 코틀린에서의 Collection - List, Set, Map

3. 컬렉션의 null 가능성, Java와 함께 사용하기

 */

//1.배열 잘사용하지 않는다 배열보다 리스트를 사용해라

fun main() {
    var array = arrayOf(100,200)
    //index를 이용한 for문 0부터 마지막 index까지의 Range를 가지고 for문을 돌린다
    //이때는 index를통해서 array의 값을가져왔는데 java와 문법이 똑같다
    for(i in array.indices){
        println("${i} ${array[i]}")
    }



    array = array.plus(300) //배열에 값을 쉽게 추가할 수 있다

    //withIndex()를 사용하면, 인덱스와 값을 한번에 가져올 수 있다.
    //index와 그 index의 값을 한번에 가져올 수 있다.
    for((idx, value) in array.withIndex1()){
        println("$idx $value")
    }

    SetMake()


}

//kotlin에서의 Collection
//컬렉션을 만들어 줄 때 불변인지, 가변인지를 설정해야 한다.
/*
Kotlin의 Collection
Kotlin은 불변/가변을 시작부터 지정해 주어야 한다는 사실을 꼭 기억해주어야 한다

불변 Collection: 컬렉션에 element를 추가,삭제할 수 없다
List, Set, Map
Collection을 만들자 마자
Collections.unModifiableList() 또는 Collections.unModifiableMap()등을
붙여준것이 불변이라고 생각하면 된다
!!불변 컬렉션이라 하더라도 Reference Type인 Element의 필드는 바꿀 수 있다.
EX)
불변 리스트에 Money라는 객체가 두개가있다
Kotlin.Money (price =1000)  Kotlin.Money (price =2000)
이때 새로운 Money를 넣을수는 없다 기존에 있는 Money를 뺄수도 없다
하지만 첫번째 Money에 접근해서 list.get(0)을 해서 첫번째 money에 접근한 다음에
그안에 있는 필드 즉 price를 (var이라면) 5000원으로 바꿀 수 있다
그래서 불변이라 하더라도 컬렉션 안에있는 Reference Type의 안에 있는 필드는
바꿀 수 있다는 점



가변 (Mutable) 컬렉션 : 컬렉션에 element를 추가, 삭제할 수 있다
MutableList, MutableSet, MutableMap



 */

// ====================List====================
fun makeList(){
    //<>에 타입을 적지 않아도 100,200이 Int이기 떄문에 자동으로 생략을 할 수 있다
    //listOf를 통해 "불변 리스트"를 만든다.
    val numbers = listOf(100,200)

    //하나를 가져오기
    numbers.get(0) //도가능하지만
    numbers[0] //으로 바로가져올 수 있다

    //for Each
    for(number in numbers){
        println(number)
    }

    // 전통적인 For문 느낌
    //인덱스도 함께 가져와야하는 상황에서는 numbers.withIndex를 통해서 가져올 수 있다
    for((idx, value ) in numbers.withIndex()){
        println("$idx $value")
    }



    //비어있는 리스트를 만들때에는 들어올 리스트의 타입이 무엇인지 명시해주어야한다
    //emptyList<타입>()을 통해서 비어있는 리스트를 만들 수도 있다
    val emptyList = emptyList<Int>()


    //emptyList의 타입을 사용하지않았는데 에러가 발생하지 않는다
    //그이유는 emptyList를 받는 printNumbers에 List<Int>로
    // Int Type을 추론할 수 있어서 에러가 발생하지 않는다
    printNumbers(emptyList())



}
private fun printNumbers(numbers: List<Int>){}

fun MutableListMake(){
    
    //기본구현체는 ArrayList이고 기타 사용법은  Java와 동일하다
    //가변리스트 만들기
    val numbers1 = mutableListOf(100,200)
    numbers1.add(300)
}

//우선 불변 리스트를 만들고, 꼭 필요한 경우 가변 리스트로 바꾸자!
//그래야 코드도 깔끔해지고 불필요한 가변 리스트 사용이 줄어들기 때문이다

//2. ================Collection-Set=================
/*
집합은 List와 다르게 순서가 없고, 같은 element는 하나만 존재할 수 있다.
자료구조적 의미만 제외하면 모든 기능이 List와 비슷하다!
 */

//불변집합
fun SetMake(){
    val numbers = setOf(100,200)

    //For Each
    for(number in numbers){
        println(number)
    }

    //전통적이 For문
    for((index,value1) in numbers.withIndex()){
        println("$index $value1")
    }


    //가변집합
    //기본 구현체는 LinkedHashSet이다
    val numbers2 = mutableSetOf(100,200)

}

//2. ================Collection-Map=================
/*
집합은 List와 다르게 순서가 없고, 같은 element는 하나만 존재할 수 있다.
자료구조적 의미만 제외하면 모든 기능이 List와 비슷하다!
 */


fun MapMake(){
    //Map에 어떤값을 넣으면서 맵을 초기화할수 있다
    //수정가능한 key와 value를 넣을 수 있는 Map이여야하니까 mutableMapOf()를 사용해 준다
    //타입을 추론할 수 없어, 타입을 지정해 주었다
    //가변 Map이기 때문에(key, value)를 넣을 수 있다.
    //Java처럼 put을 쓸 수도 있고, map[key] =value을 쓸 수도 있다.

    val oldMap = mutableMapOf<Int, String>()
    oldMap.put(1,"MONDAY") //JAVA와 동일
    oldMap[2] = "TUESDAY" //라고 사용할 수 있다

    for(key in oldMap.keys){
        println(key)
        println(oldMap.keys)
        println(oldMap[key])
    }

    for((key,value ) in oldMap.entries){
        println(key)
        println(value)
    }


    //불변 맵
    //mapOf(key to value)를 사용해 불변 map을 만들 수 있다.
    //to는 엄밀히 말하면 중위 호출 step과 같은 Pair 라는 클래스를 만들어주고
    //a라는 첫번째값 (1)과 b라는 두번째값(MONDAY)을 가지고있다
    mapOf(1 to "MONDAY" , 2 to "TUESDAY")
    
    //Kotlin에서도 동일하게 MutableMap을 만들어 넣을 수도 있고,
    //정적 팩토리 메소드를 바로 활용할 수도 있다.
}

//3. 컬렉션의 null 가능성, Java와 함께 사용하기

//?의 위치에 따라 null가능성 의미가 달라지므로 차이를 잘 이해해야 한다!

//List<Int?> : 리스트에 null이 들어갈 수 있지만, 리스트는 절대 null이 아님
//List<Int>? : 리스트에는 null이 들어갈 수 없지만, 리스트는 null일 수 있음
//List<Int?>? : 리스트에 null이 들어갈 수도 있고, 리스트가 null일 수도 있음

//JAVA와 함께 사용할때의 주의점
/*
Java는 읽기 전용컬렉션과 변경 가능 컬렉션을 구분하지 않는다.
1.문제발생
Kotlin의 불변 리스트를 생성 (listof)
-> Java에서 Kotlin의 리스트를 가져온다
-> java는 읽기전용과 변경가능을 구분하지않는다 그래서 불변인지 몰라 element를 추가할 수가 있따
-> 그다음 다시 kotlin으로오면 불변인데 element가 추가되었네 하면서 오동작을 일으킬 수 있다

2.문제발생
Java는 non-nullable과 nullable을 구분하지 않는다
Kotlin에 null이 들어갈 수 없는 리스트가 있다
그런데 Java에서 가져온다 우리는 구분하지 않는다 하면서 null을 넣는다
Kotlin에서 우리는 null이 없다는 상태로 가정을하고 non-nullable라고 생각했는데 null이 들어있다며 오류발생

이러한 문제를 해결하려면
Kotlin 쪽의 컬렉션이 Java에서 호출되면 컬렉션 내용이 변할 수 있음을 감안해야 한다.
다시 돌아왔을때 방어로직을 짜거나
Kotlin쪽에서 Collections.unmodifableXXX()를 활용하면 변경 자체를 막을 수는 있다!

Kotlin에서 Java컬렉션을 가져다 사용할때 플랫폼 타입을 신경써야 한다.
Java :List<Integer> 드립니다~
-> Kotlin :List<Int?> List<Int>? List<Int?>? 어떤거지..?

Java 코드를 보며, 맥락을 확인하고, Java 코드를 가져오는 지점을 Wrapping한다

 */


/*
Kotlin에서 배열과 컬렉션을 다루는 방법
-배열의 사용법이 약간 다르다
-코틀린에서는 컬렉션을 만들때도 불변/가변을 지정해야 한다.
-List, Set, Map에 대한 사용법이 변경,확장되었다.
-Java와 Kotlin코드를 섞어 컬렉션을 사용할 때에는 주의해야 한다.
    -Java에서 Kotlin 컬렉션을 가져갈 때는 불변 컬렉션을 수정할 수도 있고,
    non-nullable 컬렉션에 null을 넣을 수도 있다.
    -Kotlin에서 Java컬렉션을 가져갈 때는 플랫폼 타입을 주의해야 한다.
 */




