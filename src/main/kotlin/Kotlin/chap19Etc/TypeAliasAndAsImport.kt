package Kotlin.chap19Etc

import Kotlin.chap19Etc.testPK.a.printHelloWorld as HelloWorldA
import Kotlin.chap19Etc.testPK.b.printHelloWorld as HelloWorldB

class TypeAliasAndAsImport {
}

//요약해둔 타입별칭으로 대신사요ㅕㅇ할 수잇다
typealias FruitFilter = (Fruit) -> Boolean
data class Fruit (val name:String,val price:Int){}
fun filterFruits(fruits: List<Fruit>, filter: FruitFilter){}




typealias USGTMap = Map<String, UltraSuperGuardianTribe>
class UltraSuperGuardianTribe (val name: String)


//as improt: 어떤 클래스나 함수를 임표트 할 때 이름을 바꾸는 기능
fun main() {
    HelloWorldA()
    HelloWorldB()


    //구조분해 : 복합적인 값을 분해하여 여러 변수를 한 번에 초기화 하는 것
//    Data Class 는 ComponentN이란 함수도 자동으로 만들어 준다!
    val person = Person("둘리",100)
    val (name, age) = person
//    val name = person.component1() //첫번째 property를 가져온다
//    val age = person.component2() //두번째 property를 가져온다
    println("이름 : ${name}, 나이 : $age")




    val numbers = listOf(1,2,3)
    numbers.map { it + 1 }.forEach{println(it)}
//    for(number in numbers){
//        println(number)
//    }


//    label

    abc@for(i in 1..100){
        for (j in 1..100){
            if(j==2){
                break@abc //가운데있는 for문이 break되는것이아닌 밖에있는 for문이 break 된다
            }
            println("$i $j")
        }
    }


//    takeIf와 TakeUnless
    fun getNumberOrNull(number:Int): Int? {
        return if(number <= 0){
            null
        } else {
            number
        }
    }
// --> TakeIf를 통해 한줄로 사용할 수 있다
//    주어진 조건을 만족하면 그값이, 그렇지 않으면 null이 반환된다.
    fun getNumberOrNullV2(number:Int):Int? {
        return number.takeIf { it > 0 }
    }
//반대 만족하지않으면 그값이, 그렇지 않으면 null이 반환된다
    fun getNumberOrNullV3(number:Int):Int? {
        return number.takeUnless { it > 0 }
    }



}

//data class Person(
class Person(

    val name: String,
    val age: Int
){
//    연산자의 속성을가지고 있기 떄문에 operator를 붙혀줘야 한다
    operator fun component1(): String{
        return this.name
    }
    operator fun component2(): Int{
        return this.age
    }
}

//Jump와 Label
//-return : 기본적으로 가장 가까운 enclosing function 또는 익명함수로 값이 반환된다
//-break : 가장 가까운 루프가 제거된다
//-continue : 가장 가까운 루프를 다음 step으로 보낸다


/* 코틀린의 이모저모
* - 타입에 대한 별칭을 줄 수 있는 typealias 라는 키워드가 존재한다.
* - Import 당시 이름을 바꿀 수 있는 as import 기능이 존재한다.
* - 변수를 한 번에 선언할 수 있는 구조분해 기능이 있으며 componentN 함수를 사용한다
* - for문, while문과 달리 forEach에는 break와 continue를 사용할 수 없다
* - takeIf와 takeUnless를 활용해 코드양을 줄이고 method chaning을 활용할 수 있다*/