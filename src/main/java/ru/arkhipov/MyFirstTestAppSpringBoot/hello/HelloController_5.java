package ru.arkhipov.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController_5 {

    // Переменная для хранения ArrayList
    private List<String> arrayList;
    // Переменная для хранения HashMap
    private Map<Integer, String> hashMap;
    // Переменная для хранения текущего ключа в HashMap
    private int currentKey = 1;

    // Метод для приветствия
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    // Метод для обновления ArrayList
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "value") String s) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(s);
        return "Текущий список: " + arrayList.toString();
    }

    // Метод для обновления HashMap
    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "value") String s) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put(currentKey, s);
        currentKey++;
        return "Текущая HashMap: " + hashMap.toString();
    }

    // Метод для отображения количества элементов в ArrayList и HashMap
    @GetMapping("/show-all-length")
    public String showAllLength() {
        int arrayListSize = (arrayList != null) ? arrayList.size() : 0;
        int hashMapSize = (hashMap != null) ? hashMap.size() : 0;

        return String.format("Количество элементов в ArrayList: %d, Количество элементов в HashMap: %d",
                arrayListSize, hashMapSize);
    }
}
