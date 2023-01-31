package Kotlin.chap17Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class chap17JavaLambda {

    /*
    1.자바에서 람다를 다루기 위한노력
    2.코틀린에서의 람다
    3.Closure
    4.다시 try with resources
     */
}

class Fruit{
    private final String name;
    private final int price;


    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName(){ return name; }
    public int getPrice(){
        return price;
    }
    //과일가게
    List<Fruit> fruits = Arrays.asList(
            new Fruit("사과",1_000),
            new Fruit("사과",1_200),
            new Fruit("사과",1_200),
            new Fruit("사과",1_500),
            new Fruit("바나나",3_000),
            new Fruit("바나나",3_200),
            new Fruit("바나나",2_500),
            new Fruit("수박",10_000)
    );

    private List<Fruit> findApples(List<Fruit> fruits) {
        List<Fruit> apples = new ArrayList<>();
        for(Fruit fruit : fruits){
            if (fruit.getName().equals("사과")){
                apples.add(fruit);
            }
        }
        return apples;
    }

    private List<Fruit> findBanana(List<Fruit> fruits){
        List<Fruit> bananas = new ArrayList<>();
        for(Fruit fruit : fruits){
            if(fruit.getName().equals(name)){
                bananas.add(fruit);
            }
        }
        return bananas;
    }
    //이름을 중복이 있어 이름을 파라미터로 받는형식으로 변경으로 리펙토링
    private List<Fruit> findBanana(List<Fruit> fruits, String name){
        List<Fruit> results = new ArrayList<>();
        for(Fruit fruit : fruits){
            if(fruit.getName().equals(name)){
                results.add(fruit);
            }
        }
        return results;
    }

    //이름을 중복이 있어 이름을 파라미터로 받는형식으로 변경으로 리펙토링
    private List<Fruit> filterFruits(List<Fruit> fruits, FruitFilter fruitFilter){
        List<Fruit> results = new ArrayList<>();
        for(Fruit fruit : fruits){
            if(fruitFilter.isSelected(fruit)){
                results.add(fruit);
            }
        }
        return results;
    }
}

//요구하는 경우의 수가 늘어남에 따라 인터페이스와 익명클래스를 활용하기로한다
interface FruitFilter{
    boolean isSelected(Fruit fruit);
}
class unknown1 implements FruitFilter{

    @Override
    public boolean isSelected(Fruit fruit) {
        return Arrays.asList("사과","바나나").contains(fruit.getName())&&fruit.getPrice()>5_000;
    }
}

//익명클래스를 사용하는것은 복잡하다
/*
다양한 Filter가 필요할 수도 있다
과일간의 무게를 비교를 한다거나, N개의 과일을 한번에 비교한다거나 등등

이름없는함수 lambda 등장 JDK8부터
FruitFilter와 같은 인터페이스 Predicate, Consumer등을 많이 만들어 두었다!
 */

