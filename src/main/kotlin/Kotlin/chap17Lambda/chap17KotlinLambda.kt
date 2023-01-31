package Kotlin.chap17Lambda

class chap17KotlinLambda {
}

fun main() {
    val fruits = listOf(
        Fruit1("사과", 1000),
        Fruit1("사과", 1200),
        Fruit1("사과", 1200),
        Fruit1("사과", 1500),
        Fruit1("바나나", 3000),
        Fruit1("바나나", 3200),
        Fruit1("바나나", 2500),
        Fruit1("수박", 10000)
    )

    val isApple : (Fruit1) -> Boolean = fun(fruit: Fruit1): Boolean{
        return fruit.name == "사과"
    }

    val isApple2 : (Fruit1) -> Boolean = {fruit: Fruit1 -> fruit.name=="사과"}

    filterFruits(fruits, isApple)
}

class Fruit1(
    val name : String,
    val price : Long
){
}

private fun filterFruits(
    fruits: List<Fruit1>, filter: (Fruit1) -> Boolean
): List<Fruit1>{
 val results = mutableListOf<Fruit1>()
    for(fruit in fruits){
        if(filter(fruit)){
            results.add(fruit)
        }
    }
    return results
}

/* Kotlin에서 람다를 다루는 방법
* - 함수는 Java에서 2급시민이지만, 코틀린에서는 1급시민이다.
*   -때문에, 함수 자체를 변수에 넣을 수도 있고 파라미터로 전달할 수도 있다.
* - 코틀린에서 함수 타입은(파라미터 타입,  ..) -> 반환타입 이었다
* - 코틀린에서 람다는 두가지 방법으로 만들 수 있고,{} 방법이 더 많이 사용된다.
* -함수를 호출하며, 마지막 파라미터인 람다를 쓸 때는 소괄호 밖으로 람다를 뺄 수 있다.
* -람다의 마지막 expression 결과는 람다의 반환 값이다.
* -코틀린에서는 Closure를 사용하여 none-final 변수도 람다에서 사용 할 수 있다.
* */