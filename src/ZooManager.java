/**
 * The Class ZooManager.
 */
public class ZooManager {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String args[]) {
		Zoo object = new Zoo();
		InputData input = new InputData();
		System.out
				.println("1.create Zone\n2.delete zone\n3.add animal\n4.Remove/death of animal\n5.display Zone list\n6.display cagelist\n7display animal list\n0.exit");
		while (true) {
			int choice = input.getChoice();
			switch (choice) {
			case 1:
				String name = input.getZoneName();
				String category = input.getCategory();
				object.createZone(name, category);
				break;

			case 2:
				int zoneId = input.getZoneId();
				object.deleteZone(zoneId);
				break;
			case 3:
				String category1 = input.getCategory();
				String animalName = input.getName();
				int animalWeight = input.getWeight();
				int animalAge = input.getAge();
				if (object.addAnimal(category1, animalName, animalWeight,
						animalAge)) {
					System.out.println("successfully added");
					break;
				} else {
					System.out.println("operation failed");
					break;
				}

			case 4:
				String category2 = input.getCategory();
				String animalName1 = input.getName();
				int animalId1 = input.getAnimalId();
				if (object.deathAnimal(category2, animalName1, animalId1)) {
					System.out.println("successfully added");
					break;
				} else {
					System.out.println("operation failed");
					break;
				}
			case 5:
				object.displayZoneList();
				break;
			case 6:
				Zone.displayCageList();
				break;
			case 7:
				Cage.displayAnimalList();
				break;
			case 0:
				System.out.println("Thank you");
				return;
			default:
				System.out.println("Enter valid choice");
				break;
			}
		}
	}

}
