package Kotlin;

public class chap10JavaInheritanceClass {
}

   abstract class JavaAnimal{

    protected  final String species;
    protected  final int legCount;

    public JavaAnimal(String species, int legCount) {
        this.species = species;
        this.legCount = legCount;
    }

    abstract public void move();

    public String getSpecies(){
        return species;
    }

    public int getLegCount(){
        return legCount;
    }
}

class JavaCat extends JavaAnimal{

    public JavaCat(String species) {
        super(species, 4);
    }

    @Override
    public void move() {
        System.out.println("고양이 다리는 4개인가? 네개인가?");
    }
}

final class JavaPenguin extends JavaAnimal implements JavaFlyable,JavaSwimable{

    private final int wingCount;

    public JavaPenguin(String species) {
        super(species, 2);
        this.wingCount = 2;
    }

    @Override
    public void move() {
        System.out.println("펭귄이 움직입니다~ 꿱꿱");
    }

    @Override
    public int getLegCount(){
        return super.legCount + this.wingCount;
    }

    @Override
    public void fly() {

    }

    @Override
    public void act() {
        JavaSwimable.super.act();
        JavaFlyable.super.act();
    }
}


interface JavaSwimable{

    default void act(){
        System.out.println("어푸 어푸");
    }

    void fly();

}

interface JavaFlyable{

    default void act(){
        System.out.println("파닥 파닥");
    }

}