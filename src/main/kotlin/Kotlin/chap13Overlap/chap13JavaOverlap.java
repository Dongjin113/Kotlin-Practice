package Kotlin.chap13Overlap;

public class chap13JavaOverlap {
}
//내부클래스
class JavaHouse1{

    private String address;
    private LivingRoom livingRoom;

    public JavaHouse1(String address){
        this.address = address;
        this.livingRoom = new  LivingRoom(10);
    }

    public LivingRoom getLivingRoom(){
        return livingRoom;
    }

    //javahouse안에 LivingRoon이라는 중첩클래스
   //static을 붙이게 된다면 바깥 클래스를 바로 불러올 수 없다.
    public  class LivingRoom {
        private double area;
        public LivingRoom(double area){
            this.area = area;
        }

        public String getAddress(){
            //바깥 클래스인 JavaHouse를 바로 참조해서 밖의 클래스의 field를 가져와서 사용한다
            return JavaHouse1.this.address;
        }
        /*
        Effectice Java 3rd Edition - Item24, Item86
        1.내부 클래스는 숨겨진 외부 클래스 정보를 가지고 있어,
        참조를 해지하지 못하는 경우 메모리 누수가 생길 수 있고,
        이를 디버깅 하기 어렵다.

        2.내부 클래스의 직렬화 형태가 명확하게 정의되지 않아 직렬화에 있어 제한이 있다

        클래스안에 클래스를 만들때는 static 클래스를 사용하라

         */
    }

}
