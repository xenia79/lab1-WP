package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;
    private final ChefService chefService;

    public DishController(DishService dishService, ChefService chefService) {
        this.dishService = dishService;
        this.chefService = chefService;
    }

    // LIST PAGE
    @GetMapping
    public String getDishesPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("dishes", dishService.listDishes());
        model.addAttribute("error", error);
        return "listDishes";
    }

    // ADD DISH
    @PostMapping("/add")
    public String saveDish(@RequestParam String dishId,
                           @RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime){
        dishService.create(dishId, name, cuisine, preparationTime);
        return "redirect:/dishes";
    }

    // EDIT DISH
    @PostMapping("/edit/{id}")
    public String editDish(@PathVariable Long id,
                           @RequestParam String dishId,
                           @RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime){
        dishService.update(id, dishId, name, cuisine, preparationTime);
        return "redirect:/dishes";
    }

    // DELETE DISH
    @PostMapping("/delete/{id}")
    public String deleteDish(@PathVariable Long id){
        dishService.delete(id);
        return "redirect:/dishes";
    }

    // EDIT FORM
    @GetMapping("/dish-form/{id}")
    public String getEditDishForm(@PathVariable Long id, Model model){
        Dish dish = dishService.findById(id);
        if (dish == null) {
            return "redirect:/dishes?error=DishNotFound";
        }

        model.addAttribute("dish", dish);
        model.addAttribute("edit", true);
        return "dish-form";
    }

    // ADD FORM
    @GetMapping("/dish-form")
    public String getAddDishPage(Model model){
        model.addAttribute("dish", null);
        model.addAttribute("edit", false);
        return "dish-form";
    }
}
