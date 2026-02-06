# CardCompare  
*A Card Comparison Game Module for a Desktop Games Suite*

## Overview

**CardCompare** is a Java-based desktop card game module that visualizes and compares playing cards using different rule sets (Bridge, Hearts, Spades, War). It was originally developed using a custom graphical framework and has since been restored to run in a modern VS Code + Java environment.

This project follows a **Model–View–Controller (MVC)** design and is intended to be included as part of a larger **Desktop Games Suite**.

---

## Features

- Multiple card comparison rule sets:
  - Bridge
  - Hearts
  - Spades
  - War
- Graphical card rendering
- Custom comparison logic per game type
- Modular design for easy expansion
- Framework-based window management

---

## Technology Stack

- **Language:** Java 17
- **GUI Framework:** APCS CVM (Custom educational framework)
- **IDE:** VS Code (originally NetBeans)
- **Build System:** None required (plain Java)
- **Architecture:** MVC (Model–View–Controller)

---

## Project Structure

```
CardCompare/
│
├─ src/
│   └─ cardcompare/
│       ├─ CardCompare.java          # Main entry point
│       ├─ CardCompareModel.java     # Game logic / state
│       ├─ CardCompareGUI.java       # Base GUI renderer
│       ├─ BridgeCompareGUI.java
│       ├─ HeartsCompareGUI.java
│       ├─ SpadesCompareGUI.java
│       ├─ CardComparator.java       # Comparator interface
│       ├─ BridgeTrickComparator.java
│       ├─ HeartsTrickComparator.java
│       ├─ SpadesTrickComparator.java
│       └─ WarComparator.java
│
├─ lib/
│   ├─ APCSCVM.jar                   # Graphics & window framework
│   └─ APCSCard.jar                  # Playing card model
│
├─ .vscode/
│   └─ settings.json                 # VS Code Java classpath config
│
└─ README.md
```

---

## External Dependencies

This project depends on two external JAR files:

| JAR | Purpose |
|----|--------|
| `APCSCVM.jar` | Provides `CVMProgram`, graphics utilities, and window management |
| `APCSCard.jar` | Provides `PlayingCard`, suits, and card-related constants |

These must be placed in the `lib/` directory and added to the Java classpath.

---

## Setup Instructions (VS Code)

### Prerequisites

- Java Development Kit **17**
- VS Code
- **Java Extension Pack** for VS Code

---

### 1. Clone or Extract the Project

Place the project in a local directory:

```
CardCompare/
```

---

### 2. Add Dependencies

Create a `lib/` directory and place:

```
lib/
 ├─ APCSCVM.jar
 └─ APCSCard.jar
```

---

### 3. Configure VS Code

Create `.vscode/settings.json` with the following content:

```json
{
  "java.project.sourcePaths": ["src"],
  "java.project.referencedLibraries": [
    "lib/APCSCVM.jar",
    "lib/APCSCard.jar"
  ]
}
```

Restart VS Code after saving.

---

### 4. Run the Program

Open:

```
src/cardcompare/CardCompare.java
```

Click **Run ▶ main** above:

```java
public static void main(String[] args)
```

A graphical window will open displaying the selected card comparison game.

---

## Running from Command Line (Windows)

From the project root:

```powershell
javac -cp "lib\APCSCVM.jar;lib\APCSCard.jar" src\cardcompare\*.java
java  -cp "lib\APCSCVM.jar;lib\APCSCard.jar;src" cardcompare.CardCompare
```

---

## Entry Point

The main entry point is:

```java
cardcompare.CardCompare
```

Within `main`, different games can be launched by uncommenting:

```java
testWar();
testHearts();
testSpades();
testBridge();
```

---

## Architecture Overview

### Model
- `CardCompareModel`
- Encapsulates game state and comparison logic

### View
- `CardCompareGUI` and subclasses
- Responsible for rendering cards and text

### Controller
- `CVMProgram`
- Manages the application loop and user interaction

---

## Extending the Project

To add a new card game:

1. Create a new `CardComparator` implementation
2. Create a matching `CompareGUI` class
3. Add a test method in `CardCompare.java`
4. Launch using `CVMProgram`

This modular design allows the project to scale cleanly within a larger game suite.

---

## Legacy Notes

- Originally developed in **NetBeans** using **Ant**
- NetBeans configuration files are no longer required
- All absolute library paths have been replaced with relative paths
- The project has been modernized for Java 17

---

## Known Limitations

- Uses a legacy educational graphics framework
- Not packaged as a single executable JAR
- No automated tests

---

## License

This project is part of a personal/educational **Desktop Games Suite**.  
External libraries (`APCSCVM.jar`, `APCSCard.jar`) are subject to their original licenses.
