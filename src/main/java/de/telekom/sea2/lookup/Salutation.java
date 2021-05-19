package de.telekom.sea2.lookup;

public enum Salutation {

	MR, MRS, OTHER;

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
			return "Frau";
		case MR:
			return "Herr";
		case OTHER:
			return "Divers";
		default:
			throw new IllegalArgumentException("Unexpected case!");
		}

	}
}
