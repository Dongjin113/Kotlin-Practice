package Kotlin.chap15Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class chap15JavaArray {

    public static void main(){
    //java의 배열
    int[] array = {100,200};

    for(int i=0; i<array.length; i++){
        System.out.printf("%s %s", i, array[i]);
    }

        //Java의 리스트만드는 코드
        final List<Integer> numbers = Arrays.asList(100,200);

        //하나를 가져오기
        System.out.println(numbers.get(0));

        //For Each
        for(int number:numbers){
            System.out.println(number);
        }

        //전통적인 For문
        for(int i = 0; i<numbers.size(); i++){
            System.out.printf("%s %s",i,numbers.get(i));
        }
    }
}

//Map
class JavaMap{

    public static void main(){
    //JDK 8까지
    Map<Integer, String> map = new HashMap<>();
    map.put(100,"strwe");
    map.put(100,"strwe");

        //key를 가져와 key를 통해 접근
        for(int key : map.keySet()){
            System.out.println(key);
            System.out.println(map.get(key));
        }
        //entry라는 key와 value가 함께 들어있는 갳레를 가져와서 of문이 돈다
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    //JDK 9부터
    Map.of(1,"MONDAY",2,"TUESDAY");





    }
}



