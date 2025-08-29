# uCanSearch – Dosenbild-Suchtool in JavaFX

**uCanSearch** ist ein einfaches JavaFX-Programm zum Durchsuchen eines lokalen Ordners mit Dosenbildern.  
Gib einen Begriff ein – und alle Bilder mit passenden Dateinamen werden als Ergebnis angezeigt. Die Suche kann beliebig oft wiederholt werden.

---

## 🔍 Funktionen

- Eingabefeld zur Suche nach beliebigen Begriffen
- Anzeige aller Bilder im Ordner, deren Dateiname den Suchbegriff enthält
- Suchvorgang kann beliebig oft durchgeführt werden, ohne das Programm neu zu starten
- Bilder werden dynamisch und scrollbar dargestellt

---

## 📁 Voraussetzungen

- **Java 21**
- **Maven**

---

## 🛠️ Projektstruktur

- `src/main/java/.../CanSearch.java` – Hauptklasse mit JavaFX-GUI
- Ordner für Bilder: Stelle sicher, dass ein lokaler Ordner mit Bildern vorhanden ist.  
  Beispielpfad im Code:  
  `C:\\Users\\prakt\\Documents\\Dosen_Fotos_small`  
  (Kann im Code angepasst werden)

---

## 🚀 Anwendung starten

1. Projekt klonen:

```bash
git clone https://github.com/deinBenutzername/CanSearch.git
cd CanSearch
