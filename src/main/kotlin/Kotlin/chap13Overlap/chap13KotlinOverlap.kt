package Kotlin.chap13Overlap//Kotlin의 static 중첩클래스

fun main() {

}

class House(
    private val address: String,
    private val livingRoom: LivingRoom
){
    inner class LivingRoom(
        private val area: Double
    ){
        val address: String
        //바깥클래스 참조를 위해 this@바깥클래스를 사용한다.
            get() = this@House.address
    }
}

//Kotlin의 중첩 클래스와 내부클래스
//기본적으로 바깥 클래스 참조하지 않는다. 바깥 클래스를 참조하고 싶다면 inner 키워드를 추가한다.

/*
-클래스 안에 클래스가 있는 경우 종류는 두가지 였따.
    -   (Java기준)static을 사용하는 클래스
    -   (Java기준)static을 사용하지 않는 클래스
-권장되는 클래스는 static을 사용하는 클래스이다

Kotlin 에서는 이러한 가이드를 따르기 위해
    -클래스 안에 기본클래스를 사용하면 바깥 클래스에 대한 참조가 없고
    -바깥 클래스를 참조하고 싶다면, inner 키워드를 붙여야 한다.


    Java
    클래스 안의 static 클래스 : 바깥 클래스 참조없음 권장되는 유형
    클래스 안의 클래스 : 바깥 클래스 참조 있음

    Kotlin
    클래스 안의 클래스 : 바깥 클래스 참조 없음 권장되는 유형
    클래스 안의 inner 클래스 : 바깥 클래스 참조 있음
 */
