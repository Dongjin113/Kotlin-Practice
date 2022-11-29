import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.BufferUnderflowException;

public class chap7JavaException {

    public static void main(String args[]) throws IOException {
        chap7JavaException t = new chap7JavaException();
        //System.out.println(t.parseIntOrThrow2("tt"));
        t.readFile1();
        //t.readFile2("a.txt");
    }

    //주어진 문자열을 정수로 변경하는 예제
    private int parseIntOrThrow1(@NotNull String str){
        try{
         return Integer.parseInt(str);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(String.format("주어진 %s는 숫자가 아닙니다", str));
        }
    }

    //주어진 문자열을 정수로 변경하는 예제 실패하면 null을 반환
    private Integer parseIntOrThrow2(@NotNull String str){
        try{
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            return null;
        }
    }

    //checked Exception, Unchecked Exception
    public void readFile1() throws IOException{
        // . 현재위치를 의미
        File currentFile = new File(".");
        System.out.println("currentFile: "+currentFile);
        File file=new File(currentFile.getAbsolutePath()+"/a.txt");
        System.out.println("file: "+file);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        System.out.println(reader.readLine());
        reader.close();
    }

    //try with resources 구문
    //try 하고 괄호가 생겨서 괄호 안에 외부자원을 만들어주고
    //try가 끝나면 자동으로 외부자원을 닫아주는 구문이다
    public void readFile2(String path) throws IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            System.out.println(reader.readLine());
        }
    }
}
