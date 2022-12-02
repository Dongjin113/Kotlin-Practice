package Kotlin;

public class JavaConditonalStatement {

    private void validateScoreInsNotNegative(int score){
        if(score < 0){
            //받아오는 score점수가 0보다작다면 이것은 0보다 작을수없다는 예외를 출력하는 함수
            throw new IllegalArgumentException(String.format("%s는 0보다 작을 수 없습니다.", score));
        }
    }

    public static void main(String args[]){

        JavaConditonalStatement t = new JavaConditonalStatement();

        t.validateScoreInsNotNegative(-3);

        int score = 10;
        //String grade = if(score >= 50){"P";} else { "F" };
        String grade1 = score >= 50 ? "P" : "F";
    }
}

class JavaConStateMent{

    public static void main(String[] args){

    }

    private String getPassOrFail(int score){
        if(score >= 50){
            return "P";
        } else {
            return "F";
        }
    }

    private String getGrade(int score){
        if(score >= 90){
            return "A";
        }else if (score >= 80) {
            return "B";
        }else if (score >= 70) {
            return "C";
        } else {
            return "D";
        }
    }

    private String getGradeWithSwitch(int score){
        switch (score /10){
            case 9: return "A";
            case 8: return "B";
            case 7: return "C";
            case 6: return "D";
            case 5: return "E";
            default: return "F";
        }
    }

    private boolean startsWithA(Object obj){
        //obj 객체를 받아서 String 객체라면 A로시작하는지 확인해서 String객체가 아니라면 false를 반환하는 함수
        if(obj instanceof String){
            return ((String) obj).startsWith("A");
        } else {
            return false;
        }
    }

    private void judgeNumber(int number){
        if(number == 1 || number ==0 || number == -1){
            System.out.println("어디서 많이 본 숫자입니다");
        } else {
            System.out.println("1,0,-1이 아닙니다");
        }
    }

    //값자체가 없을때 early return
    private void judgeNumber2(int number){
        if(number == 0 ){
            System.out.println("주어진 숫자는 0입니다");
            return;
        }
        if(number%2 == 0 ){
            System.out.println("주어진 숫자는 짝수입니다");
            return;
        }

        System.out.println("주어지는 숫자는 홀수입니다");

    }

}
