package com;

import java.util.ArrayList;
import java.util.List;

public class Volkswagen {
	private String modelo, color, interior;
	public static List<Volkswagen> modelsList = new ArrayList<Volkswagen>();
	public Volkswagen(String modelo) {
		this.modelo = modelo;
		this.color = "color pendiente";
		this.interior = "interior pendiente";
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getInterior() {
		return interior;
	}
	public void setInterior(String interior) {
		this.interior = interior;
	}
	
	@Override
	public String toString() {
		return "Volkswagen [modelo=" + modelo + ", color=" + color + ", interior="
				+ interior + "]";
	}
}
