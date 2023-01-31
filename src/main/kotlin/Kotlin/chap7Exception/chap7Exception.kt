package Kotlin.chap7Exception

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.IllegalArgumentException

class chap7Exception{

    //IOException을 처리하라는 말이 나오지않음  throws구문이없음
    fun readPrinter(){
        //Kotlin에서는 Checked Exception과 Unchecked Exception을 구분하지 않는다


        // 코틀린에서는 checked Exception throws를 통해서 무조건 이것은 어떤 예외가 난다는 것을
        // 메소드 시그니처에 명시해줘야하는 Java와는 다르게
        // Kotlin에서는 Checked Exception과 Unchecked Exception을 구분하지 않는다
        // 모두 Unchecked Exception으로 간주한다
        val currentFile = File(".")
        val file = File(currentFile.absolutePath+"/Kotlin.getA.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()

    }

    //kotlin에서는 try with resouces가 사라지고 use를 사용한다
    fun readPrinter2(path:String){
        BufferedReader(FileReader(path)).use{reader -> println(reader.readLine())}
    }

}


fun main() {
    /*
    1. try catch finally
    Java와 Kotlin의 문법이 완전히 동일하다
    2. Checked Exception과 Unchecked Exception
    3. try with resources
     */
}
//1.kotlin에서는 타입이 뒤에오기때문에 e : NumberFormatException 으로 써줌
//2. new를 사용하지않음
// 3.포맷팅이간결함

fun parseIntOrThrow1(str:String): Int{
    try{
        return str.toInt()
     }catch (e : NumberFormatException){
        throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다")
    }
}

fun parseIntOrThrow2(str:String): Int?{
    return try{
         str.toInt()
    }catch (e : NumberFormatException){
         null
    }
}

/*
코틀린에서 예외를 다루는 방법
-try catch finally 구문은 문법적으로 완전히 동일하다.
    -Kotlin에서는 try catch가 expression이다.
-kotlin에서 모든 예외는 Unchecked Exception이다.
-Kotlin에서는 try with resources 구문이 없다.
대신 코틀린의 언어적 특징을 활용해 close를 호출해준다.
 */