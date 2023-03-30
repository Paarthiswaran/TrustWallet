# TrustWallet
TrustWallet_Paarthiswaran

====================================================================

TrustWallet Android App Automation Project

====================================================================

This project is an automation project that uses Appium with java , POM (Page Object Model) design pattern , Maven and TestNG Framework 
to automate the process of creating a new wallet in the TrustWallet Android App.


====================================================================

Description :

====================================================================

The TrustWallet Android App is a decentralized mobile wallet for managing cryptocurrencies. The automation script is designed to automate the process of 
creating a new wallet in the app. The script uses Appium framework to interact with the app and simulate user actions, such as clicking buttons, swiping , 
clicking Checkboxes and selecting text in a specified order for the secret phrase etc. The POM design pattern is used to organize the code and make it easier 
to maintain and update.


====================================================================

Installation - Pre-requiste softwares needed:

====================================================================

Before running the automation script, you need to install the following:

1. Java Development Kit (JDK) version 8 or higher
2. Android Studio and Android SDK tools
3. Appium Server application
4. TrustWallet Android App
5. An Android Virtual Device (AVD) - created in Android Studio to run your automation scripts on

====================================================================

To install the project, follow these steps:

====================================================================

1. Clone the project from the GitHub repository to your local machine.
2. Open the project in your preferred IDE (Integrated Development Environment).
3. Install the necessary dependencies by running mvn install command in the project directory.
4. Create an AVD - Android Virtual Device in Android Studio or connect your real device to your computer and ensure that USB debugging is enabled.
5. Open the congig.properties file in the add the name of the AVD created in Step 4 as a value for the key "device".

Optional: If you want the avd to launch automatically when you run the test script without having an open device

6. Open the startEmulator.bat file present in  Src -> Utilities on Notepad++ and change the value of the AVD present in the file to the one created on step 4
7. Open the startEmulator.bat file present in  Src -> Utilities on Notepad++ and Replace the path of the emulator in the SDK Path 
   with the path in your machine where emulator is present

====================================================================

Usage

====================================================================

To use the automation script, follow these steps:

====================================================================
1. Open the AVD create on the Android Studio.
2. Navigate to the Path src -> test -> java -> trustwallet -> TrustWallet_TC_001_OpenApp.java file
3. Right click on the file and run as TestNg Test

====================================================================

Contributing

====================================================================

If you want to contribute to this project, please follow these guidelines:

1. Fork the repository and create a new branch for your changes.
2. Make your changes and write tests to ensure that everything is working correctly.
3. Submit a merge request and provide a detailed description of your changes.

====================================================================

License

====================================================================

This project is publicly available in GitHub.
