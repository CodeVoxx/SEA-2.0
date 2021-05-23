// **********************
// **      SEA-2.0     **
// **    Salutation    ** 
// **********************


package de.telekom.sea2.lookup;

public enum Salutation {

	MRS, MR, OTHER;

	public static Salutation fromString(String string) {

		switch (string) {
		case "MRS":
		case "W":
		case "Woman":
		case "mrs":
			return MRS;
		case "Mr":
		case "MR":
		case "Herr":
		case "herr":
		case "m":
		case "M":
			return MR;
		case "OTHER":
		case "other":
		case "divers":
		case "Divers":
			return OTHER;
		default:
			throw new IllegalArgumentException("Unexpected value: " + string);
		}
	}

	@Override
	public String toString() {
		switch (this) {
		case MRS:
			return "MRS";
		case MR:
			return "MR";
		case OTHER:
			return "OTHER";
		default:
			throw new IllegalArgumentException("Unexpected case " + this);
		}
	}
	

	public Byte toByte() {
		switch (this) {
		case MRS:
			return 0;
		case MR:
			return 1;
		case OTHER:
			return 2;
		default:
			throw new IllegalArgumentException("Unexpected case " + this);
		}
	}

	public static Salutation fromByte(Byte bite) {
		switch (bite) {
		case 0:
			return MRS;
		case 1:
			return MR;
		case 2:
			return OTHER;
		default:
			throw new IllegalArgumentException("Unexpected value.");
		}
	}
}
