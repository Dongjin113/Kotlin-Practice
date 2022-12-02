package Kotlin

import java.lang.IllegalArgumentException

//public을 사용하지 않더라도 기본이 public이다
//생성자는 class의 옆에 생성해준다
//생성자constructor는 생략이가능하다
//class Kotlin.Chap9KotlinClass constructor(name: String, age:Int){
class Chap9KotlinClass (name: String, age:Int){

    //타입은 생성자에서 지정해주었기 떄문에 생략이 가능하다
    val name: String = name
    var age: Int = age
    }
    //프로퍼티 = 필드 + getter + setter
    //코틀린에서는 필드만 만들면 getter, setter를 자동으로 만들어준다.



//생성자에서 프로퍼티를 만들수 있고 body에는 아무것도 없어 생략이 가능하다
class Chap9KotlinClass1 (val name: String, var age:Int)

//나이 검증 ()내에있는 생성자를 주생성자(primary constructor)라고 부르며 반드시 존재해야 한다
class Chap9KotlinClass2 (val name: String, var age:Int){
    //init이라는 블록이 존재 클래스가 초기화되는 시점에 한번 호출되는 블록
    //생성자가 생성되는 시점에 호출된다
    init {
        if(age<=0){
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다")
        }
        println("주생성자 초기화블록")
    }
    //첫번째 생성자는 가장 위쪽class와 같이 상성되지만 그이후의 추가 생성자는
    //constructor()라는 keyword와 함께 생성해야한다
    //this(name,1)위에 있는 생성자를 호출한다는 내용
    //부생성자(secondary constructor 최종적으로 주생성자를 this로 호출해야 한다.
    //body를 가질 수 있다
    //최초로 태어나는 아이는 1살이니 age가 1의 default값을 가진 생성자를 하나더 생성한다
    constructor(name:String): this(name,1){println("1번째 constructor")}

    //두번째 constructor은 첫번째 constructor를 호출하고 첫번째 constructor은 주생성자를 호출한다
    constructor(): this("홍길동"){println("2번째 constructor")}



    override fun toString(): String {
        return "Kotlin.Chap9KotlinClass2(name='$name', age=$age)"
    }


}
//추가로 constructor을 만들기보다는 constructor에 default parameter을 사용하는게 더 깔끔하다

class Chap9KotlinClass3 (val name: String = "홍길동", var age:Int = 1){
    init {
        if(age<=0){
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다")
        }
        println("주생성자 초기화블록")
    }

    fun isAdult(): Boolean = age >=20

    fun isAdult1(): Boolean {
        return age >=20
    }

    //프로퍼티 custom getter property처럼 보이게 만들수있다
    //custum getter를 사용하면 자기 자신을 변형해 줄 수도 있다
    val isAdult3: Boolean
        get() = this.age >= 20
        //get(){return this.age >= 20} 으로도 사용가능

    //name을 get할때 무조건  대문자로 바꾸어 주도록 해보기



    override fun toString(): String {
        return "Kotlin.Chap9KotlinClass3(name='$name', age=$age)"
    }

}

class Chap9KotlinClass4 (
    //프로퍼티는 getter와 setter을 자동으로만들어준다
    //custum getter을 만들기 위해 자동으로 만들어주지 말라고 우선 val을 지워준다
    name: String = "홍길동",
    var age:Int = 1
    ) {
    /*
    val name = name
        get(){
            //name이 들어와서 이 name을 가져올 때 이 custum getter가불려서
            //대문자로 바꿔서 반환하는 것처럼 된다
            //정확히는 name대신 filed라는 키워드가 들어가야한다
            //원래있던 val name 은 getter을 포함하고있었기 때문에
            //return name.uppercase()
            return field.uppercase()
            // name.uppercase라고 생각해보면 밖에서 name을 불렀을때 get이 불린다
            // get을 부르면 name이라는 filed가먼저 호출이 된다
            // 근데 밖에서 person.name 하면 name에 대한 getter가 호출이 되는데
            // 똑같이 안에서도 name이라고하면 name에 대한 getter가 호출이 된다
            // 그럼 name이라는 것은 name에대한 getter을 호출하는거니까 다시 get을부른다
            // get을부르면 name을부르고 name을부르면 get을부르는 무한루프가 발생한다
            // 그래서 무한루프를 막기위해 자기자신을 가르키는 filed라는 예약어가 생겨서
            // filed를 사용하면 val name 진짜name을 가르키는 것을 의미하게 된다

        }
        //또는 get() =

     */
    //set이 실행이 되면 들어오는 문자를 대문자로 바꿔 field에 집어넣어준다
    var name = name
        set(value){
            field = value.uppercase()
        }

    init {
        if(age<=0){
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다")
        }
        println("주생성자 초기화블록")
    }
    //name을 get할때 무조건  대문자로 바꾸어 주도록 해보기
}



//하지만 만약 주생성자에 parameter가 하나도 없을때에는
// 기본적으로 생성자를 하나를 만들어줘 굳이 생성자가 없이 사용해도 괜찮다
class Student


fun main() {
    //val person = Kotlin.Chap9KotlinClass1("둘리",100)

    /*
    //java의 getter setter 또한 동일하게 불러와서 사용할 수 있다.
    val person = Person("둘리",100)
    person.age = 10 // setter : Java person.setAge(10)
    println(person.name) //getter : Java person.getName()
    println(person.age)

    val person1 =Person("둘리")
     */
    println("1 "+ Chap9KotlinClass2())
    println("2 "+ Chap9KotlinClass2("영수"))
    println("3 "+ Chap9KotlinClass2("영국이",5))
    println("4 "+ Chap9KotlinClass3())
    println("isAdult() "+ Chap9KotlinClass3().isAdult())
    println("isAdult3 "+ Chap9KotlinClass3().isAdult3)
    println("isAdult1() "+ Chap9KotlinClass3().isAdult1())

}

//어쩔수 없이 부생성자를 사용하는경우 예를 들어 Alien이 와서 Person으로 바껴야하는경우
//주생성자에 Alien을 넣을수는 없음으로 Converting과 같이 어떤객체를 다른 객체로 바꾸는경우에는
//부생성자를 사용 할 수도 있음에도 그보다는 정적팩토리 메소드를 추천한다

/*
Kotlin에서 클래스를 다루는방법
- 코틀린에서는 필드를 만들면 getter와 (필요에 따라) setter가 자동으로 생긴다.
    -때문에 이를 프로퍼티 라고 부른다.
- 코틀린에서는 주생성자가 필수이다.
- 코틀린에서는 consturctor 키워드를 사용해 부생성자를 추가로 만들 수 있다.
    - 단 default parameter나 정적 팩토리 메소드를 추천한다.
- 실제 메모리에 존재하는 것과 무관하게 custom getter와 custom setter를 만들 수있다
- custom getter, custom setter에서 무한루프를 막기 위해 filed라는 키워드를 사용한다.
    - 이를 backing field라고 부른다
 */