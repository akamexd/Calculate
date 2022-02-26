package me.akamex.akamexcalculate.expression;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

public class Exp4jExpressionSolver implements ExpressionSolver {

    @Override
    public String toResult(String expression) {
        try {
            double result = new ExpressionBuilder(expression)
                    .function(new Function("cos", 1) {
                        @Override
                        public double apply(double... args) {
                            return Math.cos(args[0]);
                        }
                    }).function(new Function("acos", 1) {
                        @Override
                        public double apply(double... args) {
                            return Math.acos(args[0]);
                        }
                    }).function(new Function("sin", 1) {
                        @Override
                        public double apply(double... args) {
                            return Math.sin(args[0]);
                        }
                    }).function(new Function("asin", 1) {
                        @Override
                        public double apply(double... args) {
                            return Math.asin(args[0]);
                        }
                    }).function(new Function("tan", 1) {
                        @Override
                        public double apply(double... args) {
                            return Math.tan(args[0]);
                        }
                    }).function(new Function("atan", 1) {
                        @Override
                        public double apply(double... args) {
                            return Math.atan(args[0]);
                        }
                    })
                    .function(new Function("log", 1) {
                        @Override
                        public double apply(double... args) {
                            return Math.log(args[0]);
                        }
                    })
                    .build().evaluate();

            long resultLong = (long) result;
            if (resultLong == result) {
                return "= " + resultLong;
            }

            return "= " + result;
        } catch (Exception exception) {
            return ExpressionSolver.ERROR;
        }
    }
}
