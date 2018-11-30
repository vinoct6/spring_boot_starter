package com.learning.springboot.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class StarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }
}

@RestController
@RequestMapping("/app")
class AddController {

    @GetMapping("/sum")
    public Integer addWithRequestVariables(@RequestParam("a") String a, @RequestParam("b") String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    @GetMapping("/sum/{a}/{b}")
    public Integer addWithPathVariable(@PathVariable("a") String a, @PathVariable("b") String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    @PostMapping("/save")
    public Person savePerson(@RequestBody Person p) {
        System.out.println(p);
        return p;
    }

    @GetMapping("/nonrepeat/{string}")
    public Character firstNonRepeatingCharacter(@PathVariable("string") String string) {

        Map<Character, Integer> countMap = new HashMap<>();

        char[] chars = string.toCharArray();
        for (Character c : chars) {

            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }

        for (Character c : chars) {
            if (countMap.containsKey(c) && countMap.get(c) == 1) {
                return c;
            }
        }

        return null;

    }

}

class Person {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
