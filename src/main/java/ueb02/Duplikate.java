package ueb02;

class Duplikate {
	/**
	 * Gibt ein StringSet mit den Wörtern zurück, welche mindestens zwei mal im Text vorkommen.
	 * Alle Satzzeichen im Text sollen ignoriert werden.
	 * @param text Eingabetext, kann Satzzeichen enthalten welche ignoriert werden.
	 * @return StringSet mit den Wörtern, welche mind. zwei mal vorkommen.
	 */
	static StringSet findeDuplikate(String text) {
		// set mit einmalig vorkommenden Elementen
		StringSet impl = new StringSetImpl();

		// set mit Duplikaten
		StringSet dup  = new StringSetImpl();

		// regex = [^a-zA-Z 0-9]  -> liefert alle nicht a-z, A-Z und 0-9 und ' ' und setzt diese mit ''

		for (String c : text.replaceAll("[^a-zA-Z 0-9]", "").split(" ")) {

			// versuche jeden String c dem Set impl hinzuzufuegen. Schlaegt das fhel, da ist es ein
			// Duplikat und kann dem Duplikate-Set hinzugefuegt werden
			if (!impl.add(c))
				dup.add(c);
		}
		return dup;
	}
}
