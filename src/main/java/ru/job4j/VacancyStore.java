package ru.job4j;

import java.util.ArrayList;
import java.util.List;

public class VacancyStore {
    private final List<Vacancy> vacancies = new ArrayList<>();

    public void add(Vacancy vacancy) {
        vacancies.add(vacancy);
    }

    public List<Vacancy> findAll() {
        return vacancies;
    }
}

