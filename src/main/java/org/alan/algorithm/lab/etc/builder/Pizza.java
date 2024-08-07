package org.alan.algorithm.lab.etc.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    private final Set<Topping> toppings;

    public Set<Topping> getToppings() {
        return toppings;
    }

    abstract static class Builder<T extends Builder<T>> {
        private EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        protected abstract T self();

        public abstract Pizza build();
    }

    protected Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

}
