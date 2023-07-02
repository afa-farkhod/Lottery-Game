# Lottery-Game
Lottery Game which is based on two digit number guessing

<p align="center">
  <img src="https://user-images.githubusercontent.com/24220136/223288162-cbb8b309-d69e-489f-ba80-f9589245f50c.png" alt="Image">
</p>

## [Implementation](https://github.com/af4092/Lottery-Game/tree/main/Lottery/src/org/eclipse/wb/swt)

- `SWTResourceManager.java` represents a simple lottery game implemented using the Java Swing and SWT libraries. The program displays a graphical user interface (GUI) window that allows the user to play the lottery game.
  - The code starts with import statements that bring in necessary classes from the `javax.swing` and `org.eclipse.swt` packages.
  - The class `Lottery` is defined and extends the `Shell` class from SWT. It represents the main window of the application.
  - The class contains several instance variables, such as "shlLottery" (the main shell), "Rules" (a label to display rules), `tfInput` (a text field to input the user's guess), `btnPlay` (a button to play the lottery), and `lbDisplay` (a label to display the lottery result).
  - The "main" method is the entry point of the application. It creates an instance of the "Lottery" class and opens the main window.
  - The `generateLotteryNumber` method generates a random two-digit lottery number.
  - The `checkMatch` method takes two arguments: the user's guess and the generated lottery number. It checks whether the guess matches the lottery number and returns the corresponding prize amount based on the matching criteria.
  - The "open" method sets up the GUI components, opens the main window, and starts the event loop to handle user interactions.
  - The `createContents` method creates and initializes the GUI components, sets their positions and sizes, and registers event listeners.
  - The event listener for the `btnPlay` button reads the user's guess from the `tfInput` text field, converts it to an integer, generates a lottery number, checks for a match, and updates the `lbDisplay` label with the lottery number and the result message.
  
- `Lottery.java` represents a utility class called `SWTResourceManager` that provides various methods for managing OS resources associated with SWT controls, such as colors, fonts, and images.
  - The code includes: Import statements for necessary SWT and Java IO classes.
  - A class-level comment describing the purpose of the class and its licensing information.
  - The class "SWTResourceManager" contains static methods for managing colors, images, and fonts used in SWT-based applications.
  - The class includes methods for obtaining system colors, creating custom colors, loading images from files, and creating decorated images.
  - The class uses various maps to cache and reuse created resources, such as colors, images, and decorated images.
  - The class also provides methods to dispose of the cached resources when they are no longer needed.
  - The `disposeColors`, `disposeImages`, and `disposeFonts` methods are used to release the operating system resources associated with the cached colors, images, and fonts, respectively.
