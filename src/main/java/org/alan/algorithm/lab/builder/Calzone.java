package org.alan.algorithm.lab.builder;

import lombok.Getter;

@Getter
public class Calzone extends Pizza{
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false;

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }
        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }
    }

    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}
