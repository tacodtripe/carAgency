package com;

import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;
import java.util.Scanner;

public class VolkswagenList {

	public static void main(String[] args) {
		Scanner entry = new Scanner(System.in);
		boolean programBoolean = true;
		int userOption = 0;
		VolkswagenList list = new VolkswagenList();
		while(programBoolean) {
			boolean optionBoolean = true;
			do {
				try {
					System.out.println("Seleccione alguna opcion:" +
					           "\n(1) Mostrar todos los modelos" +
					           "\n(2) Agregar modelo" +
					           "\n(3) Editar modelo existente" +
					           "\n(4) Eliminar modelo existente" +
					           "\n(5) Buscar por caracteristica" +
					           "\n(0) Salir");
					userOption = entry.nextInt();
					if(userOption < 7 && userOption >= 0) {
						optionBoolean = false;
					} else {
						System.out.println("Opcion invalida");
					}
				} catch(InputMismatchException err) {
					System.out.println("Opcion invalida");
					entry.nextLine();
				}
			} while(optionBoolean);
			switch(userOption) {
			case 1:
				list.displayModels();
				break;
			case 2:
				boolean modelBoolean = true;
				String userModel = null;
					do {
					System.out.println("Ingrese el nombre de su modelo");
					entry = new Scanner(System.in);
					userModel = entry.nextLine();
					boolean alreadyExists = false;
					for(int i = 0; i < Volkswagen.modelsList.size(); i++) {
						if(Volkswagen.modelsList.get(i).getModelo().toLowerCase().equals(userModel.toLowerCase())) {
							System.out.println("El modelo ya existe");
							alreadyExists = true;
							break;
						}
						alreadyExists = false;
					}
					if(userModel.equals(" ") || userModel.length()<1 || alreadyExists) {
						System.out.println("Por favor ingrese un nombre valido");
					} else {
						modelBoolean = false;
					}
				} while(modelBoolean);
				list.addModel(userModel);
				break;
			case 3:
				boolean pickModelBoolean = true;
				int modelToModify = 0;
				do {
					try {
						list.displayModels();
						System.out.println("¿Que modelo desea modificar?");
						modelToModify = entry.nextInt() - 1;
						System.out.println("Esta por modificar el modelo: " + Volkswagen.modelsList.get(modelToModify).getModelo());
						pickModelBoolean = false;
					} catch (IndexOutOfBoundsException err) {
						System.out.println("Opcion invalida");
						entry = new Scanner(System.in);
					}
				} while (pickModelBoolean);
				boolean modifyBoolean = true;
				int modifyInput = 0;
				do {
					try {
						System.out.println("¿Que desea modificar?" +
					                       "\n(1) Color" +
								           "\n(2) Interior");
						modifyInput = entry.nextInt();
						if(modifyInput > 3 || modifyInput < 1) {
							System.out.println("Por favor ingrese una opcion valida");
						} else {
							modifyBoolean = false;
						}
					} catch(InputMismatchException err) {
						System.out.println("Opcion invalida");
						entry = new Scanner(System.in);
					}
				} while(modifyBoolean);
				switch(modifyInput) {
				case 1:
					System.out.println("Ingrese el nuevo color:");
					entry = new Scanner(System.in);
					String newColor = entry.nextLine();
					Volkswagen.modelsList.get(modelToModify).setColor(newColor);
					System.out.println("Color actualizado");
					break;
				case 2:
					System.out.println("Ingrese el tipo de interiores:");
					entry = new Scanner(System.in);
					String newSeatsType = entry.nextLine();
					Volkswagen.modelsList.get(modelToModify).setInterior(newSeatsType);
					System.out.println("Interiores actualizados");
					break;
				}
				break;
			case 4: 
				boolean deleteBoolean = true;
				do {
					try {
						list.displayModels();
						int deleteInput = entry.nextInt() - 1;
						if(deleteInput > Volkswagen.modelsList.size() || deleteInput < 0) {
							System.out.println("Por favor ingrese una opcion valida");
						} else {
							System.out.println("Esta por eliminar el modelo: " + Volkswagen.modelsList.get(deleteInput).getModelo());
							System.out.println("Confirme la eliminacion: (1) Si (2) No");
							int confirmDelete = entry.nextInt();
							if(confirmDelete < 3 || confirmDelete > 0) {
								if(confirmDelete == 1) {
									Volkswagen.modelsList.remove(deleteInput);	
								} else {
									System.out.println("Volviendo al menu principal");
								}				
							} else {
								System.out.println("Ingrese una opcion valida");
							}
							System.out.println("Modelo eliminado");
							deleteBoolean = false;
						}
					} catch(InputMismatchException err) {
						System.out.println("Opcion invalida");
						entry = new Scanner(System.in);
					}
				} while(deleteBoolean);
				break;
			case 5:
				boolean categoryOptionBoolean = true;
				int category = 0;
				do {
					try {
						System.out.println("¿Que categoria le gustaria buscar? (1) Modelo (2) Color (3) Interiores");
						category = entry.nextInt();
						if(category > 3 || category < 1) {
							System.out.println("Opcion invalida");
						} else {
							categoryOptionBoolean = false;
						}
					} catch(InputMismatchException err) {
						System.out.println("Opcion invalida");
					}
				} while(categoryOptionBoolean);
				categoryOptionBoolean = true;
				String categorySelected = "";
				switch(category) {
				case 1:
					categorySelected = "modelo";
				break;
				case 2:
					categorySelected = "color";
				break;
				case 3:
					categorySelected = "tipo de interiores";
				break;
				}
				Boolean foundElements = false;
				System.out.println("Por favor ingrese que " + categorySelected + " le gustaria buscar");
				entry = new Scanner(System.in);
				String userInput = entry.nextLine();
				switch(category) {
				case 1:
					for(int i = 0 ; i < Volkswagen.modelsList.size(); i++) {
						Volkswagen holder = Volkswagen.modelsList.get(i);
						if(holder.getModelo().equalsIgnoreCase(userInput)) {
							System.out.println((i + 1) + ". " + holder.getModelo() + ", " + holder.getColor() + ", " + holder.getInterior());
							foundElements = true;
						}
					}
					break;
				case 2:
					for(int i = 0 ; i < Volkswagen.modelsList.size(); i++) {
						Volkswagen holder = Volkswagen.modelsList.get(i);
						if(holder.getColor().equalsIgnoreCase(userInput)) {
							System.out.println((i + 1) + ". " + holder.getModelo() + ", " + holder.getColor() + ", " + holder.getInterior());
							foundElements = true;
						}
					}
					break;
				case 3:
					for(int i = 0 ; i < Volkswagen.modelsList.size(); i++) {
						Volkswagen holder = Volkswagen.modelsList.get(i);
						if(holder.getInterior().equalsIgnoreCase(userInput)) {
							System.out.println((i + 1) + ". " + holder.getModelo() + ", " + holder.getColor() + ", " + holder.getInterior());
							foundElements = true;
						}
					}
					break;
				}
				if(!foundElements) {
					System.out.println("No se econtraron elementos");
				}
				break;
			case 0:
				programBoolean = false;
				break;
			}
		}
		entry.close();
		System.out.println("Fin de ejecucion!");
	}
	
	public void addModel(String model) {
		Volkswagen holder = new Volkswagen(model);
		Volkswagen.modelsList.add(holder);
	}
	
	public void displayModels() {
		if(Volkswagen.modelsList.size() == 0) {
			System.out.println("No se han agregado modelos");
		} else {
			System.out.println("\nLos modelos disponibles son:");
			for(int i = 0; i < Volkswagen.modelsList.size(); i++) {
				System.out.println((i + 1) + ". " +
						           Volkswagen.modelsList.get(i).getModelo() + ", " +
						           Volkswagen.modelsList.get(i).getColor() + ", " +
						           Volkswagen.modelsList.get(i).getInterior());
			}
		}
	}
}
