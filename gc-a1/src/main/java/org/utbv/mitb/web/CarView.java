package org.utbv.mitb.web;

import java.io.Serializable;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;

import org.utbv.mitb.domain.Car;
import org.utbv.mitb.domain.CarService;

@Named("carView")
@ViewScoped
public class CarView implements Serializable {
    private static final long serialVersionUID = 5970021238350672608L;

    private List<Car> cars;

    @Inject
    private CarService service;

    @PostConstruct
    public void init() {
        cars = service.createCars(50);
    }

    public List<Car> getCars() {
        return cars;
    }
}