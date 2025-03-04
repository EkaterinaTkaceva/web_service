package com.example.cityclient;

import com.example.cityservice.City;
import com.example.cityservice.CityService;

import java.util.List;
import java.util.Scanner;

public class CityServiceClient {
    public static void main(String[] args) {
        CityService service = new CityService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Введите название города (или Enter, чтобы пропустить):");
            String name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("exit")) {
                running = false; // Устанавливаем флаг завершения программы
                continue; // Пропускаем оставшуюся часть итерации и идём на выход
            }
            System.out.println("Введите страну (или Enter, чтобы пропустить):");
            String country = scanner.nextLine().trim();

            System.out.println("Введите тему (или Enter, чтобы пропустить):");
            String theme = scanner.nextLine().trim();
            Integer population = null;
            Integer foundedYear = null;

            System.out.println("Введите минимальное население (или 0, чтобы пропустить):");
            String populationInput = scanner.nextLine().trim();
            if (!populationInput.isEmpty()) {
                try {
                    int parsedPopulation = Integer.parseInt(populationInput);
                    if (parsedPopulation > 0) {
                        population = parsedPopulation;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: население должно быть числом.");
                }
            }


            System.out.println("Введите год основания (или 0, чтобы пропустить):");
            String yearInput = scanner.nextLine().trim();
            if (!yearInput.isEmpty()) {
                try {
                    int parsedYear = Integer.parseInt(yearInput);
                    if (parsedYear > 0) {
                        foundedYear = parsedYear;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: год основания должен быть числом.");
                }
            }
            // Отправляем запрос на сервер
            List<City> cities = service.searchCities(
                    name.isEmpty() ? null : name,
                    country.isEmpty() ? null : country,
                    theme.isEmpty() ? null : theme,
                    population,
                    foundedYear
            );

            // Выводим результат
            if (cities.isEmpty()) {
                System.out.println("Города не найдены.");
            } else {
                System.out.println("Найденные города:");
                for (City city : cities) {
                    System.out.printf("%s, %s (%s) - %d чел., основан в %d\n",
                            city.getName(), city.getCountry(), city.getTheme(),
                            city.getPopulation(), city.getFoundedYear());
                }
            }
        }
        System.out.println("Выход из программы...");
        scanner.close();
    }
}
