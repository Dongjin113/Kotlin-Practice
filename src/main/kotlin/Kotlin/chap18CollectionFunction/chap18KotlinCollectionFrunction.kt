package Kotlin.chap18CollectionFunction


class chap18KotlinCollectionFrunction {
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

//    사과만 주세요
    val apples = fruits.filter { fruit -> fruit.name == "사과" }
    val apples1 = fruits.filterIndexed {idx, fruit ->
        println(idx)
        fruit.name =="사과"
    }
    val applePrice = fruits.filter {fruit -> fruit.name == "사과"}
        .map{fruit -> fruit.currentPrice}

    val applePrice1 = fruits.filter {fruit -> fruit.name == "사과"}
        .mapIndexed { idx, fruit ->
            println(idx)
            fruit.currentPrice}

//    all: 조건을 모두 만족하면 true 그렇지 않으면 false
    val isAllapple = fruits.all {fruit -> fruit.name =="사과"}
//    none: 조건을 모두 불만족하면 true 그렇지 않으면 false
    val isNoapple = fruits.none {fruit -> fruit.name =="사과"}
//    any: 조건을 하나라도 만족하면 true 그렇지 않으면 false
//    val isNoApple = fruits.any {fruit -> fruit.factoryPrice >= 10_000}
//    count: 개수를 센다 List의 size와 같다고 보면된다
    val fruitCount = fruits.count()
//    sortedBy:(오름차순)정렬을 한다
    val fruitCount1 = fruits.sortedBy{fruit -> fruit.currentPrice}
//    distinctBy : 변형된 값을 기준으로 중복을 제거한다
    val distinctFruitNames = fruits.distinctBy { fruit -> fruit.name }
        .map{fruit -> fruit.name}
//    fist: 첫번째 값을 가져온다(무조건 null이 아니어야함 firstOrNull: 첫번째 값 또는 null을 가져온다
    val fistValue = fruits.first() //last는 last
    val fistOrNullValue = fruits.firstOrNull()

//    List를 Map으로
//    groupBy 그룹핑을 해준다
    val map: Map<String, List<Fruit1>> = fruits.groupBy { fruit -> fruit.name }
//    List가 아니라 Fruit 한개가 들어갈때에는 associateBy를 사용할 수 있다
//    associateBy 를 사용하면 value값에 List가 들어가는것이 아니라 단일객체가 들어가게된다
    val map2: Map<Long, Fruit1> = fruits.associateBy { fruit -> fruit.price }
//    print(map["바나나"])
//    print(map2[1200])

//  Key와 Value를 동시에 처리할 수있다
    val map3: Map<String, List<Long>> = fruits
        .groupBy({fruit->fruit.name}, {fruit -> fruit.factoryPrice!! })
//    print(map3["바나나"])

    val map4: Map<String, List<Fruit1>> = fruits.groupBy { fruit -> fruit.name}
        .filter { (key,value) -> key =="사과" }

//    print(map4["사과"])

/*
//  중복된 name을 제거하고 List를 출력
    println(fruits.distinctBy{fruit -> fruit.name})
//  중복된 name을 제거하고 name 만출력
    println(fruits.distinctBy{fruit -> fruit.name}.map{fruit -> fruit.name})*/

// 중첩된 컬렉션 처리
    val fruitsIntList: List<List<Fruit1>> = listOf(
        listOf(
            Fruit1("사과1",19000),
            Fruit1("사과1",10600,2000),
            Fruit1("바나나1",10400),
            Fruit1("바나나1",10300,2000),
            ),
        listOf(
            Fruit1("사과2",15000,2000),
            Fruit1("사과2",16000),
            Fruit1("바나나2",17000,2000),
            Fruit1("바나나2",18000),
        ),
        listOf(
            Fruit1("사과3",11000,2000),
            Fruit1("사과3",12000),
            Fruit1("바나나3",13000,2000),
            Fruit1("바나나3",14000),
        )
    )

//    출고가와 현재가가 동일한 과일을 골라주세요!
//    flatMap을 사용하게 되면 List<List>가 단일 List로 바뀌게 된다 단일리스트로 바뀔때 조건을 lambda로 걸어줄 수 있다
    val samPriceFruits = fruitsIntList.flatMap { list -> list.filter{fruit -> fruit.factoryPrice == fruit.currentPrice} }
//    커스텀get을 사용하여 확장함수만 호출해서 사용할 수 있다

//    println(samPriceFruits)
    val samPriceFruits1 = fruitsIntList.flatMap{list -> list.samePriceFilter}
    
//    List<List<Fruit>>를 List<Fruit>로 그냥 바꿔줄때에는 flatten()이라는것을 사용할 수 있다

    println("flatten = " + fruitsIntList.flatten())
    println("fruitsIntList = $fruitsIntList")



}

data class Fruit1(
    val name: String,
    val price: Long,
    val factoryPrice: Long? = 1000, //출고가
    val currentPrice: Long? = 2000 //현재가
){
    val isSamePrice: Boolean
        get() = factoryPrice == currentPrice
}

val List<Fruit1>.samePriceFilter: List<Fruit1> get() = this.filter(Fruit1::isSamePrice)


private fun filterFruits(
    fruits: List<Fruit1>, filter: (Fruit1) -> Boolean
): List<Fruit1>{
    return fruits.filter(filter)
}