import java.util.Random;

public class Physical extends Base implements Rng {
	Random rand = new Random();
	private int physicalAttack;

	public Physical(String name, int rarity, String attackType) {
		super(name, rarity, attackType, 0, 0, 0, 0);
		this.physicalAttack = randomizeAttack();
		this.healthPoint = randomizeHP();
		this.physicalDefense = randomizeDefense();
		this.magicalDefense = randomizeDefense();
		this.dodge = randomizeDodge();
	}
	
	public int randomizeHP() {
		int HP = 0;
		int max = 600;
		int min = 300;
		if (this.rarity == 1) {
			HP = rand.nextInt((max - min) + 1) + min;
			HP *= 1;
		} else if (this.rarity == 2) {
			HP = rand.nextInt((max - min) + 1) + min;
			HP *= 2;
		} else if (this.rarity == 3) {
			HP = rand.nextInt((max - min) + 1) + min;
			HP *= 3;
		}
		return HP;
	}
	
	public int randomizeAttack() {
		int attack = 0;
		int max = 250;
		int min = 50;
		if (this.rarity == 1) {
			attack = rand.nextInt((max - min) + 1) + min;
			attack *= 1;
		} else if (this.rarity == 2) {
			attack = rand.nextInt((max - min) + 1) + min;
			attack *= 2;
		} else if (this.rarity == 3) {
			attack = rand.nextInt((max - min) + 1) + min;
			attack *= 3;
		}
		return attack;
	}
	
	public int randomizeDefense() {
		int attack = 0;
		int max = 150;
		int min = 50;
		if (this.rarity == 1) {
			attack = rand.nextInt((max - min) + 1) + min;
			attack *= 1;
		} else if (this.rarity == 2) {
			attack = rand.nextInt((max - min) + 1) + min;
			attack *= 2;
		} else if (this.rarity == 3) {
			attack = rand.nextInt((max - min) + 1) + min;
			attack *= 3;
		}
		return attack;
	}
	
	public int randomizeDodge() {
		int dodge = 0;
		int max = 30;
		int min = 0;
		if (this.rarity == 1) {
			dodge = rand.nextInt((max - min) + 1) + min;
			dodge *= 1;
		} else if (this.rarity == 2) {
			dodge = rand.nextInt((max - min) + 1) + min;
			dodge *= 2;
		} else if (this.rarity == 3) {
			dodge = rand.nextInt((max - min) + 1) + min;
			dodge *= 3;
		}
		return dodge;
		
	}
	
	public int getPhysicalAttack() {
		return physicalAttack;
	}

	public void setPhysicalAttack(int physicalAttack) {
		this.physicalAttack = physicalAttack;
	}

}
