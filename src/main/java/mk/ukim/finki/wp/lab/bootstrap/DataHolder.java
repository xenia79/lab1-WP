package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

    @PostConstruct
    public void init() {
        chefs.add(new Chef(0L, "Ksenija", "Krstevska", "Youngest chef to ever be awarded three Michelin stars.", new ArrayList<>()));
        chefs.add(new Chef(1L, "Mario", "Ackov", "A master of healthy food.", new ArrayList<>()));
        chefs.add(new Chef(2L, "Veronika", "Kusakatova", "Bringing culinary creativity to your plate.", new ArrayList<>()));
        chefs.add(new Chef(3L, "Marija", "Simonova", "One of the best french chefs.", new ArrayList<>()));
        chefs.add(new Chef(4L, "Bojana", "Toseva", "Popular for best Macedonian food.", new ArrayList<>()));

        dishes.add(new Dish("dish_0", "Fettuccine Alfredo", "Italian", 35));
        dishes.add(new Dish("dish_1", "Teriyaki salmon", "Japanese", 60));
        dishes.add(new Dish("dish_2", "Paella Valenciana", "Spanish", 45));
        dishes.add(new Dish("dish_3", "Chicken Marengo", "French", 30));
        dishes.add(new Dish("dish_4", "Stuffed peppers", "Macedonian", 40));
    }
}