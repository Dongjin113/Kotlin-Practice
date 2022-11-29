import java.util.Arrays;
import java.util.List;

public class chap6JavaRepeat {

public static void main(String args[]){

    List<Long> numbers = Arrays.asList(1L, 2L, 3L);
    for(long number : numbers){
        System.out.println(number);
    }

    for(int i= 1; i<=3; i++){
        System.out.println(i);
    }

    for(int i= 3; i>=1; i--){
        System.out.println(i);
    }

    for(int i= 1; i<=3; i+=2){
        System.out.println(i);
    }

    for(int i= 3; i>=1; i-=2){
        System.out.println(i);
    }
    int i=0;
    while(i <= 3){
        System.out.println(i);
        i++;
    }

}
}
