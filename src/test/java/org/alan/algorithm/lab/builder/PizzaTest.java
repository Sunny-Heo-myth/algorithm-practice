package org.alan.algorithm.lab.builder;

import org.junit.jupiter.api.Test;

public class PizzaTest {

    @Test
    public void NyPizzaTest() {
        // given
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.LARGE)
                .addTopping(Pizza.Topping.PEPPER)
                .addTopping(Pizza.Topping.ONION)
                .build();

        // when, then
        for (Pizza.Topping topping : nyPizza.getToppings()) {
            System.out.println(topping);
        }
    }

    @Test
    public void CalzoneTest() {
        // given
        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.MUSHROOM)
                .addTopping(Pizza.Topping.SAUSAGE)
                .sauceInside()
                .build();

        // when, then
        for (Pizza.Topping topping : calzone.getToppings()) {
            System.out.println(topping);
        }
        System.out.println(calzone.isSauceInside());
    }
}
