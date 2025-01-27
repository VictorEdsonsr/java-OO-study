package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main{
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        var test = new TestClass();
        new Processor().process(test);
    }
}

class Processor{
    public void process(Object object) throws InvocationTargetException, IllegalAccessException {
        var methods = object.getClass().getDeclaredMethods();

        for(Method method : methods){
            if (method.isAnnotationPresent(SayHello.class)){
                System.out.println("Hello World!");
                method.invoke(object);
            }
        }
    }
}

class TestClass{
    @SayHello
    public void loading(){
        System.out.println("Loading...");
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface SayHello{
}