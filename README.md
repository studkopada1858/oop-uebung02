_Übungsaufgabe zur Veranstaltung [Programmieren 2](https://hsro-wif-prg2.github.io) im [Bachelorstudiengang Wirtschaftsinformatik](https://www.fh-rosenheim.de/technik/informatik-mathematik/wirtschaftsinformatik-bachelor/) an der [Hochschule Rosenheim](http://www.fh-rosenheim.de)._


# Set und Duplikate

In dieser Übung implementieren wir die Datenstruktur _Set_ (siehe Interface `StringSet`) und verwenden sie anschließend um Wörter in Texten zu finden, welche mindestens zwei mal vorkommen.


## Teilaufgabe 1

Vervollständigen Sie die Klasse `StringSetImpl`, indem Sie die `add`, `contains`, `remove` und `size` Methoden implementieren.

- Implementieren Sie das Set als Baumstruktur, wie in der [Vorlesung](https://hsro-wif-prg2.github.io/03-tree-set/) besprochen.
- Implementieren Sie die notwendige Hilfsklasse als _innere Klasse_.
- Die Klasse `String` stellt die Methoden `equals` und `compareTo` bereit, um Strings miteinander zu vergleichen ([Dokumentation](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html)).
- Verifizieren Sie, dass der Test `testSetTest` fehlerfrei abläuft.


## Teilaufgabe 2

Implementieren Sie die statische Methode `Duplikate.findeDuplikate()`, in der Sie nun das Set verwenden, um die Wörter in einem String zu finden, welche mindestens zwei mal vorkommen.

- Die Methode `String.split` zerlegt einen einzelnen String in ein Array von mehreren Strings.
- Die Methode `String.replaceAll` kann verwendet werden, um bestimmte Zeichen aus einem String zu entfernen; bestehende Strings sind in Java unveränderlich (_immutable_), lesen Sie dazu die [Dokumentation](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#replaceAll-java.lang.String-java.lang.String-).
- Verifizieren Sie, dass der Test `testFindeDuplikate` fehlerfrei abläuft.
