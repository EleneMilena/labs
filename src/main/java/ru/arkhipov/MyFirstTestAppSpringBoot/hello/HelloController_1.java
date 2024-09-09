package ru.arkhipov.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController_1 {
        // Инициализируем переменную класса для хранения списка
        private List<String> arrayList;

        // Метод для приветствия
        @GetMapping("/hello1")
        public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
            return String.format("Hello %s!", name);
        }

        // Метод для обновления списка
        @GetMapping("/update-array")
        public String updateArrayList(@RequestParam(value = "value") String s) {
            // Если это первый вызов метода, создаем новый список
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }

            // Добавляем значение в список
            arrayList.add(s);

            // Возвращаем текущий список в виде строки
            return "Текущий список: " + arrayList.toString();
        }
    }

