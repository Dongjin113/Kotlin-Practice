public class Chap8JavaFunction {

    //2. default parameter 주어진 문자열을 N번 출력하는 예제
    //메소드를 3개나 만들어야하나?

    public static void main(String args[]){
        Chap8JavaFunction t = new Chap8JavaFunction();
       // t.printNameAndGender("FemaLe","둘리").name("둘리");

        String[] array = new String[]{"배","열","로"};
        t.printAll(array);
        t.printAll("콤","마","로");



    }

    public void repeat(String str, int num, boolean useNewLine){
        for(int i = 1; i <= num; i++){
            if(useNewLine){
                System.out.println(str);
            } else {
                System.out.println(str);
            }
        }

    }
    //@OverLoading 똑같은 이름을 가진 repeat 함수를 두개를 만들수있다
    public void repeat(String str, int num){
        //boolean값이 default로 true값을 가지는 repeat 함수를 출력
        repeat (str, num, true);
    }

    //@OverLoading 똑같은 이름을 가진 repeat 함수를 두개를 만들수있다
    public void repeat(String str){
        //default로 3, true값을 가지는 repeat 함수를 출력
        repeat (str, 3, true);
    }

    public void printNameAndGender(String name, String gender){
        System.out.println(name);
        System.out.println(gender);

    }

    //4. 같은 타입의 여러 파라미터 받기 (가변인자)
    //String 타입의 N개의 parameter를 받고 들어온 parameter는 strings라는 이름으로 들어왔다
    //Type ... 을 쓰면 가변인자 사용!
    //이함수를 호출하는쪽에서는 배열을 만들어서 넣어주거나 comma를 이용해 여러 파이라미터를 넣을수 있다
    public static void printAll(String... strings){
        for (String str : strings){
            System.out.print(str);
        }
            System.out.println();
    }


}
