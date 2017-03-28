package zdm.fate.common.constant;

public enum Buff {
	NOTFOUND("0"), EDITFREE("1"), THIRTEENTH("2"), ANONYMOUS("3"), UNREASONABLE("4");

	private String str;
	private Buff(String str) {
		this.str = str;
	}

	public String getStr() {
		return this.str;
	}
}
