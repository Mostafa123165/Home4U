package com.service.common.service;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

public class CamelCaseGenerator extends DisplayNameGenerator.Standard {
    @Override
    public String generateDisplayNameForClass(Class<?> testClass) {
        return super.generateDisplayNameForClass(testClass);
    }

    @Override
    public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
        return super.generateDisplayNameForNestedClass(nestedClass);
    }

    @Override
    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
        return replaceCamelCase(testMethod.getName());
    }

    private String replaceCamelCase(String input) {
        StringBuilder output = new StringBuilder();
        output.append(Character.toUpperCase(input.charAt(0)));
        for(int i = 1; i < input.length(); i++) {
            if(Character.isUpperCase(input.charAt(i))) {
                output.append(" ");
                output.append(input.charAt(i));
            }
            else {
                output.append(input.charAt(i));
            }
        }
        return output.toString();
    }
}
