fun main() {
    val person = Person("개발자")
    val person1 = Person(null)

    println(startsWithA(person.name))
    println(startsWithA(person1.name))
}

fun startsWithA(str : String): Boolean{
    return str.startsWith("A")
}










//Person에서 Nullable 이라는 Annotation이 붙어있어 오류
//NotNull로 변경시 오류 삭제
//kotlin 에서 Java코드를 가져다사용할때는 Null에대한 Annotation을 kotlin에서 이해한다
//null에 관련된 Annotation을 사용한다면 kotlin에서 이것을 인식하고 이해해서 활용이 가능하다
//만약에 Nullable 또는 NotNull이 없다면 kotlin에서는 가져온 값이 null이 들어 갈 수 있는 타입인지
// null이 들어 갈 수 없는 타입인지 알수가 없다
//그래서 이러한 타입을 플랫폼 타입이라고 부른다 이런경우 런타임시 exception이발생할수있다

/*
kotlin에서 null을 다루는 방법
-코틀린에서 null이 들어갈 수 있는 타입은 완전히 다르게 간주된다
 -한 번 null 검사를 하면 non-null임을 컴파일러가 알 수 있다.
-null이 아닌 경우에만 호출되는 Safe Call(?.)이 있다
-null인 경우에만 호출되는 Elvis 연산자 (?:)가 있다
-null 이 절대 아닐때 사용할 수 있는 널 아님 단언(!!)이 있다
-Kotlin에서 Java 코드를 사용할 때 플랫폼 타입 사용에 유의해야 한다
    -Java 코드를 읽으며 널 가능성 확인 / Kotlin으로 wrapping 해야한다
 */

