import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class TraderQuestion {

    private List<Transaction> transactions;

    @BeforeEach
    void before(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    @Test
    void test(){
        for (Transaction transaction : transactions) {
            System.out.println("transaction = " + transaction);
        }
    }



    @Test
    void q1(){
        /*
            2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오
         */
        List<Transaction> collect = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    void q2(){
        /*
            거래자가 근무하는 모든 도시를 중복없이 나열하시오
         */
        List<String> collect = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    void q3(){
        /*
            Cambridge 에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오
         */
        List<Trader> cambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println(cambridge);
    }


    @Test
    void q4(){
        /*
            모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오
         */
        List<Trader> collect = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    void q5(){
        /*
            밀라노에 거래자가 있는가
         */
        boolean milan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milan);
    }

    @Test
    void q6(){
        /*
            Cambridge 에서 거주하는 거래자의 모든 트랜잭션 값을 출력하시오
         */
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    @Test
    void q7(){
        /*
            전체 트랜잭션 중 최대값은 얼마인가?
         */
        Optional<Integer> reduce = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(reduce.get());
    }

    @Test
    void q8(){
        /*
            전체 트랜잭션 중 최솟값은 얼마인가?
         */
        Optional<Transaction> min = transactions.stream()
                .min(comparing(Transaction::getValue));
        System.out.println(min.get());
    }
}
