
public abstract class Base {
	protected String name; // Character Name
	protected int rarity; // 1-3 Star
	protected String attackType; // Physical/Magical
	protected int healthPoint, physicalDefense, magicalDefense, dodge; // Character Stats

	public Base(String name, int rarity, String attackType, int healthPoint, int physicalDefense, int magicalDefense,
			int dodge) {
		super();
		this.name = name;
		this.rarity = rarity;
		this.attackType = attackType;
		this.healthPoint = healthPoint;
		this.physicalDefense = physicalDefense;
		this.magicalDefense = magicalDefense;
		this.dodge = dodge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	public String getAttackType() {
		return attackType;
	}

	public void setAttackType(String attackType) {
		this.attackType = attackType;
	}

	public int getHealthPoint() {
		return healthPoint;
	}

	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}

	public int getPhysicalDefense() {
		return physicalDefense;
	}

	public void setPhysicalDefense(int physicalDefense) {
		this.physicalDefense = physicalDefense;
	}

	public int getMagicalDefense() {
		return magicalDefense;
	}

	public void setMagicalDefense(int magicalDefense) {
		this.magicalDefense = magicalDefense;
	}

	public int getDodge() {
		return dodge;
	}

	public void setDodge(int dodge) {
		this.dodge = dodge;
	}

}
