package org.utbv.mitb.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.utbv.mitb.domain.Car;
import org.utbv.mitb.domain.CarService;

@ViewScoped
@ManagedBean(name = "carView")
public class CarView implements Serializable {

	private static final long serialVersionUID = 5970021238350672608L;

	private List<Car> cars;

	@ManagedProperty("#{carService}")
	private CarService service;

	@PostConstruct
	public void init() {
		cars = service.createCars(50);
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setService(CarService service) {
		this.service = service;
	}
}