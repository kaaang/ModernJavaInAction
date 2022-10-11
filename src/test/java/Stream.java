import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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




//    필터링
    @Test
    void filter1(){
        List<Dish> collect = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    void filter2(){
        List<Dish> collect = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    void filter3(){
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(integer -> integer%2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    void filter4(){
        List<Dish> collect = menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(toList());
        System.out.println(collect);
    }



//    맵핑
    @Test
    void mapping1(){
        List<String> collect = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    void mapping2(){
        List<Integer> collect = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    void mapping3(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = numbers.stream()
                .map(integer -> integer * integer)
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    void mapping4(){
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> collect = numbers1.stream()
                .flatMap(integer -> numbers2.stream()
                        .map(integer1 -> new int[]{integer, integer1}))
                .collect(toList());
        for (int[] ints : collect) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
    }

    @Test
    void mapping5(){
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> collect = numbers1.stream()
                .flatMap(integer -> numbers2.stream()
                        .filter(integer1 -> (integer + integer1)%3 == 0)
                        .map(integer1 -> new int[]{integer, integer1}))
                .collect(toList());
        for (int[] ints : collect) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
    }

//    검색과 매칭
    @Test
    void matching1(){
        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
    }

    @Test
    void matching2(){
        boolean b = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(b);
    }

    @Test
    void matching3(){
        boolean b = menu.stream().noneMatch(dish -> dish.getCalories() >= 1000);
        System.out.println(b);
    }

    @Test
    void matching4(){
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
    }


//    리듀싱
    @Test
    void reducing1(){
        Integer reduce = menu.stream()
                .map(dish -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }

}
