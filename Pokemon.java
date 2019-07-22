package pokemon;

/** ポケモンのデータを表すクラス */
public class Pokemon {
	private int number; // 番号
	private String name; // 名前
	private int attack; // 攻撃力
	private String type1; // タイプ1
	private String type2; // タイプ2
	// 以下getterとsetter

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}
}