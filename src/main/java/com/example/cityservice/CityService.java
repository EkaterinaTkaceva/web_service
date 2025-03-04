package com.example.cityservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@WebService
public class CityService {
    private static final String URL = "jdbc:postgresql://localhost:5432/citydb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    static {
        try {
            Class.forName("org.postgresql.Driver"); // Загружаем драйвер вручную
            System.out.println("PostgreSQL JDBC Driver подключен!");
        } catch (ClassNotFoundException e) {
            System.err.println("Не удалось загрузить драйвер PostgreSQL!");
            e.printStackTrace();
        }
    }

    @WebMethod
    public List<City> searchCities(String name, String country, String theme, Integer population, Integer foundedYear) {
        List<City> cities = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM cities WHERE 1=1");

        if (name != null) query.append(" AND name ILIKE ?");
        if (country != null) query.append(" AND country ILIKE ?");
        if (theme != null) query.append(" AND theme ILIKE ?");
        if (population != null) query.append(" AND population >= ?");
        if (foundedYear != null) query.append(" AND founded_year >= ?");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {

            int index = 1;
            if (name != null) stmt.setString(index++, "%" + name + "%");
            if (country != null) stmt.setString(index++, "%" + country + "%");
            if (theme != null) stmt.setString(index++, "%" + theme + "%");
            if (population != null) stmt.setInt(index++, population);
            if (foundedYear != null) stmt.setInt(index++, foundedYear);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cities.add(new City(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("country"),
                        rs.getString("theme"),
                        rs.getInt("population"),
                        rs.getInt("founded_year")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8090/cityService", new CityService());
        System.out.println("SOAP-сервис запущен на http://localhost:8090/cityService");
    }
}