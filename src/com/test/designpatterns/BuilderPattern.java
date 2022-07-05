package com.test.designpatterns;

/**
 * @author SUBIN
 * https://refactoring.guru/design-patterns/builder
 * Builder is a creational design pattern that lets you construct complex objects step by step. 
 * The pattern allows you to produce different types and representations of an object using the same construction code.
 * 
 * Use the Builder pattern when you want your code to be able to create different representations of some product 
 * (for example, stone and wooden houses).
 * 
 * Pros and Cons
 You can construct objects step-by-step, defer construction steps or run steps recursively.
 You can reuse the same construction code when building various representations of products.
 Single Responsibility Principle. You can isolate complex construction code from the business logic of the product.
 
 The overall complexity of the code increases since the pattern requires creating multiple new classes.
 */

public class BuilderPattern {

    static class Coffee {

        private Coffee(Builder builder) {

            this.type = builder.type;

            this.sugar = builder.sugar;

            this.milk = builder.milk;

            this.size = builder.size;

        }


        private String type;

        private boolean sugar;

        private boolean milk;

        private String size;


        public static class Builder {

            private String type;

            private boolean sugar;

            private boolean milk;

            private String size;


            public Builder(String type) {

                this.type = type;

            }


            public Builder sugar(boolean value) {

                this.sugar = value;

                return this;

            }


            public Builder milk(boolean value) {

                this.milk = value;

                return this;

            }


            public Builder size(String value) {

                this.size = value;

                return this;

            }


            public Coffee build() {

                return new Coffee(this);

            }

        }


        @Override

        public String toString() {

            return String.format("Coffee [type=%s, sugar=%s, milk=%s, size=%s]", this.type, sugar, milk, size);

        }


    }


    public static void main(String[] args) {

        Coffee coffee = new BuilderPattern.Coffee.Builder("Mocha").milk(true).sugar(false).size("Large").build();

        System.out.println(coffee);


    }

}
