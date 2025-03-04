package com.example.cityservice;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class City {
        private int id;
        private String name;
        private String country;
        private String theme;
        private int population;
        private int foundedYear;

        public City() {}  // Нужен для SOAP

        public City(int id, String name, String country, String theme, int population, int foundedYear) {
            this.id = id;
            this.name = name;
            this.country = country;
            this.theme = theme;
            this.population = population;
            this.foundedYear = foundedYear;
        }

        @XmlElement
        public int getId() { return id; }

        @XmlElement
        public String getName() { return name; }

        @XmlElement
        public String getCountry() { return country; }

        @XmlElement
        public String getTheme() { return theme; }

        @XmlElement
        public int getPopulation() { return population; }

        @XmlElement
        public int getFoundedYear() { return foundedYear; }

}
