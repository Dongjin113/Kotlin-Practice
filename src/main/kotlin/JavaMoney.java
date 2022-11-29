import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class JavaMoney implements Comparable<JavaMoney>{

    private final long amount;

    public JavaMoney(long amount){
        this.amount = amount;
    }

    public JavaMoney plus(JavaMoney other){
        return new JavaMoney(this.amount+ other.amount);
    }

    //들어오는 JavaMoney와 현재 인스턴스 JavaMoney간에 크기를 비교하는 코드
    //compareTo 주어진게 더 작으면 양수 같으면0 더 크면 음수를 반환

    @Override
    public int compareTo(@NotNull JavaMoney o) {
        return Long.compare(this.amount, o.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JavaMoney javaMoney = (JavaMoney) o;
        return amount == javaMoney.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "JavaMoney{" +
                "amount=" + amount +
                '}';
    }
}

class Testt {
    public static void main(String args[]){
        /*
        JavaMoney money1 = new JavaMoney(2_000L);
        JavaMoney money2 = new JavaMoney(1_000L);

        if(money1.compareTo(money2) > 0){
            System.out.println("Money1이 Money2보다 금액이 큽니다");
        }

         =======

        JavaMoney money1 = new JavaMoney(1_000L);
        JavaMoney money2 = money1;
        JavaMoney money3 = new JavaMoney(1_000L);

        System.out.println(money1 == money2);
        System.out.println(money1 == money3);
        System.out.println(money1.equals(money3));
        =====
         */

        JavaMoney money1 = new JavaMoney(1_000L);
        JavaMoney money2 = new JavaMoney(2_000L);
        System.out.println(money1.plus(money2));

    }
}
