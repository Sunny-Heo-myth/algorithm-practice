package org.alan.algorithm.lab.builder;

import lombok.Getter;

import java.util.Objects;

@Getter
public class NyPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }
}
