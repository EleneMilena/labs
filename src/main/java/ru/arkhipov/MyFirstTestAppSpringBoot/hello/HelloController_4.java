package ru.arkhipov.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController_4 {

    // Переменная для хранения HashMap
    private Map<Integer, String> hashMap;
    // Переменная для хранения текущего ключа
    private int currentKey = 1;

    // Метод для приветствия
    @GetMapping("/hello4")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    // Метод для обновления HashMap
    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "value") String s) {
        // Если это первый вызов метода, создаем новый HashMap
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }

        // Добавляем значение в HashMap с текущим ключом
        hashMap.put(currentKey, s);
        currentKey++; // Увеличиваем ключ для следующего элемента

        // Возвращаем текущую карту в виде строки
        return "Текущая HashMap: " + hashMap.toString();
    }

    // Метод для отображения всех элементов HashMap
    @GetMapping("/show-map")
    public String showHashMap() {
        // Если HashMap пустая, возвращаем сообщение
        if (hashMap == null || hashMap.isEmpty()) {
            return "HashMap пустая";
        }

        // Возвращаем текущую HashMap
        return "Элементы HashMap: " + hashMap.toString();
    }
}
