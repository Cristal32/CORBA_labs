# Corba Labs

These labs use JDK 1.8 (Java 8), since CORBA classes are no longer available in later versions of Java.

## How to run the labs on your machine:
### 1. Install JDK 1.8:

Check out this website: [OpenJDK Downloads](https://www.openlogic.com/openjdk-downloads?field_java_parent_version_target_id=416&field_operating_system_target_id=436&field_architecture_target_id=391&field_java_package_target_id=396) <br />
Choose the configurations depending on your own machine's characteristics.

### 2. Unzip the installed zip file.

### 3. Add the JDK to your poject:

If you have Eclipse, go to: <br />
`Window` > `Preferences` > `Java` > `Installed JREs` > `Add` > `Standard VM` > `Next` > `Directory` > Find and select your JDK folder > `Finish` > Check the newly added JDK to make it the default JDK for compilation (temporarily, you can always come back and undo that) > `Apply and close`.

### 4. Add the JDK to your project's libray:

Left click the project > `Build path` > `Configure build path` > `Libraries` > `Add library` > `JRE System library` > `Next` > `Execution environment` > `JavaSE 1.8` > `Finish` > `Apply and close`.

### 5. Add the JDK to the environment variables:

**5.1.** Go to the location of the JDK folder, enter the `bin` folder, and copy the path in there. <br />
**5.2.** Go to the `environment variables` > `Path` > `Edit` > `Add` > Paste the copied path there > Apply `Ok` for all tabs. <br />
**5.3.** To test if it all works fine, go to the command prompt and check the version of `idlj`:
```
idlj -version
```
It should return the version of idlj.




