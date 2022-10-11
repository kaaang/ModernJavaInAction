import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.*;

class Stream {

    private List<Dish> menu = Dish.menu;

    @Test
    void test1(){
        List<String> collect = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    void t2(){
        List<String> collect = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    void t3(){
        
    }
}
