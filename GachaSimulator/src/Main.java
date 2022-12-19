// Nama: Hans Rhesa Andersen
// NIM: 2502032346

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	Scanner input = new Scanner(System.in);
	Random rand = new Random();
	ArrayList<String> nameList = new ArrayList<>();
	ArrayList<Base> characterList = new ArrayList<>();
	ArrayList<Base> inventory = new ArrayList<>();
	ArrayList<Base> temporaryList = new ArrayList<>();
	int a = 0, b = 0, c = 0;

	// Tujuan Program adalah untuk membuat simulasi Gacha
	public Main() {
		addDummy(); // Default Data
		int choice = 0;
		do {
			System.out.println("Menu");
			// Menambahkan Karakter Kedalam Gacha Pool Berserta Tingkat Kelangkaannya
			// Stats yang Didapat Random Berskala Dengan Tingkat Kelangkaannya
			System.out.println("1. Add Gacha Pool");

			// Menentukan Peluang Mendapatkan Sebuah Karakter Berdasarkan Tingkat
			// Kelangkaannya
			System.out.println("2. Set Gacha Rates");

			// Melakukan Gacha Berdasarkan Gacha Pool dan Rates yang Ditentukan
			System.out.println("3. Gacha!");

			// Melihat Karakter Yang Didapatkan Dari Gacha
			System.out.println("4. Characters");

			// Exit Program
			System.out.println("5. Exit");
			// Input Pilihan
			System.out.print(">> ");
			try {
				choice = input.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Please Input a Numerical Value!");
			}
			input.nextLine();

			if (choice == 1) {
				addGachaPool();
			} else if (choice == 2) {
				setGachaRates();
			} else if (choice == 3) {
				gacha();
			} else if (choice == 4) {
				characters();
			} else if (choice == 5) {
				System.out.println("Exiting Program...");
			}
		} while (choice != 5);
	}

	private void addGachaPool() {
		String name, attackType;
		int rarity = 0;

		do {
			System.out.print("Input Name [Unique]: "); // Nama yang di input harus unik
			name = input.nextLine();
		} while (nameList.contains(name));

		do {
			System.out.print("Input Rarity [1-3]: "); // Hanya ada 3 tipe rarity yaitu 1*, 2* dan 3* (Tertinggi)
			try {
				rarity = input.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Please Input a Numerical Value!");
			}
			input.nextLine();
		} while (!(rarity >= 1 && rarity <= 3));

		do {
			System.out.print("Input Attack Type [Physical | Magical]: ");
			// 2 Tipe Damage yaitu Physical (P) dan Magical (M)
			// Untuk Status Atk, Tipe Magical Hanya punya MAtk dan Physical haya punya PAtk
			attackType = input.nextLine();
		} while (!(attackType.equals("Physical") || attackType.equals("Magical")));

		if (attackType.equals("Physical")) {
			characterList.add(new Physical(name, rarity, attackType));
		} else {
			characterList.add(new Magical(name, rarity, attackType));
		}
		nameList.add(name);
		System.out.println("Successfully Added Character!");
		System.out.println("Press Enter to Continue...");
		input.nextLine();
	}

	private void setGachaRates() {
		do {
			System.out.println("Set Rates for 1*, 2*, 3* respectively [Has to equal 100%]");
			System.out.print("Set Rates for 1* (%): ");
			try {
				a = input.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Please Input a Numerical Value!");
			}
			input.nextLine();
			System.out.print("Set Rates for 2* (%): ");
			try {
				b = input.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Please Input a Numerical Value!");
			}
			input.nextLine();
			c = 100 - a - b;
			System.out.println("Rates for 3* is automatically set to be: " + c + " (%).");
		} while (!((a + b + c) == 100));
		System.out.println("Sucessfuly set gacha rates:");
		System.out.println("1*: " + a + "%.");
		System.out.println("2*: " + b + "%.");
		System.out.println("3*: " + c + "%.");
		System.out.println("Press Enter to Continue...");
		input.nextLine();
	}

	private void gacha() {
		if (!((a + b + c) == 100)) {
			System.out.println("Gacha Rate Hasn't Been Set Yet!");
			System.out.println("Press Enter to Continue...");
			input.nextLine();
			return;
		}

		if (characterList.isEmpty()) {
			System.out.println("There's no Character in the List Yet!");
			System.out.println("Press Enter to Continue...");
			input.nextLine();
			return;
		}

		int rng = rand.nextInt(99) + 1;

		int count = 0;
		if (rng <= a) { // 1* Character
			for (Base c : characterList) {
				if (c.rarity == 1) {
					count++;
					temporaryList.add(c);
				}
			}
		} else if (rng <= a + b) { // 2* Character
			for (Base c : characterList) {
				if (c.rarity == 2) {
					count++;
					temporaryList.add(c);
				}
			}
		} else if (rng <= a + b + c) { // 3* Character
			for (Base c : characterList) {
				if (c.rarity == 3) {
					count++;
					temporaryList.add(c);
				}
			}
		}
		int luck = rand.nextInt(count);
		System.out.println("You got a " + temporaryList.get(luck).getRarity() + "* Unit: "
				+ temporaryList.get(luck).getName() + "!");
		inventory.add(temporaryList.get(luck));
		temporaryList.clear();
		System.out.println("Press Enter to Continue...");
		input.nextLine();
		return;
	}

	private void characters() {
		if (inventory.isEmpty()) {
			System.out.println("You Have no Character!");
			System.out.println("Press Enter to Continue...");
			input.nextLine();
			return;
		}
		int count = 0;
		System.out.printf("| %-3s | %-16s | %-8s | %-10s | %-5s | %-5s | %-5s | %-5s | %-5s | %-5s |\n", "No", "Name",
				"Rarity", "Type", "HP", "PAtk", "MAtk", "PDef", "MDef", "Dodge");
		for (Base i : inventory) {
			count++;
			if (i instanceof Physical) {
				System.out.printf("| %-3d | %-16s | %-8d | %-10s | %-5d | %-5d | %-5d | %-5d | %-5d | %-5d |\n", count,
						i.getName(), i.getRarity(), i.getAttackType(), i.getHealthPoint(),
						((Physical) i).getPhysicalAttack(), 0, i.getPhysicalDefense(), i.getMagicalDefense(),
						i.getDodge());
			} else if (i instanceof Magical) {
				System.out.printf("| %-3d | %-16s | %-8d | %-10s | %-5d | %-5d | %-5d | %-5d | %-5d | %-5d |\n", count,
						i.getName(), i.getRarity(), i.getAttackType(), i.getHealthPoint(), 0,
						((Magical) i).getMagicAttack(), i.getPhysicalDefense(), i.getMagicalDefense(), i.getDodge());
			}
		}
		System.out.println("Press Enter to Continue...");
		input.nextLine();
	}
	
	private void addDummy() {
		characterList.add(new Physical("Pecorine", 1, "Physical"));
		characterList.add(new Magical("Kyaru", 1, "Magical"));
		characterList.add(new Physical("Kokkoro", 1, "Physical"));
		characterList.add(new Physical("Yukari", 1, "Physical"));
		characterList.add(new Magical("Yori", 1, "Magical"));
		characterList.add(new Magical("Yui", 1, "Magical"));
		characterList.add(new Magical("Misato", 2, "Magical"));
		characterList.add(new Physical("Miyako", 2, "Physical"));
		characterList.add(new Physical("Eriko", 2, "Physical"));
		characterList.add(new Magical("Akari", 2, "Magical"));
		characterList.add(new Physical("Muimi", 3, "Physical"));
		characterList.add(new Magical("Neneka", 3, "Magical"));
	}

	public static void main(String[] args) {
		new Main();
	}
}
