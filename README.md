# Corba Labs

These labs use JDK 1.8 (Java 8), since CORBA classes are no longer available in later versions of Java.

## Table of content

- [How to run the labs on your machine:](#how-to-run-the-labs-on-your-machine)
    - [1. Install JDK 1.8](#1-install-jdk-18)
    - [2. Unzip the installed zip file](#2-unzip-the-installed-zip-file)
    - [3. Add the JDK to your project](#3-add-the-jdk-to-your-project)
    - [4. Add the JDK to the environment variables](#4-add-the-jdk-to-the-environment-variables)
- [Steps followed in the labs: CORBA lifecycle](#steps-followed-in-the-labs-corba-lifecycle)
    - [1. Define the IDL interface](#1-define-the-idl-interface)
    - [2. Compile the IDL file](#2-compile-the-idl-file)
    - [3. Implement the abstract object](#3-implement-the-abstract-object)
    - [4. Write and compile the server](#4-write-and-compile-the-server)
    - [5. Write and compile the client](#5-write-and-compile-the-client)
 - [Results](#results)

## How to run the labs on your machine
### 1. Install JDK 1.8

Check out this website: [OpenJDK Downloads](https://www.openlogic.com/openjdk-downloads?field_java_parent_version_target_id=416&field_operating_system_target_id=436&field_architecture_target_id=391&field_java_package_target_id=396) <br />
Choose the configurations depending on your own machine's characteristics.

### 2. Unzip the installed zip file

### 3. Add the JDK to your project

If you have Eclipse: <br />

**3.1. Add the JDK to the installed JREs:** <br />
Window > Preferences > Java > Installed JREs > Add > Standard VM > Next > Directory > Find and select your JDK folder > Finish > Check the newly added JDK to make it the default JDK for compilation (temporarily, you can always come back and undo that) > Apply and close.

**3.2. Add the JDK to your project's libray:** <br />
Left click the project > Build path > Configure build path > Libraries > Add library > JRE System library > Next > Execution environment > JavaSE 1.8 > Finish > Apply and close.

### 4. Add the JDK to the environment variables

**4.1.** Go to the location of the JDK folder, enter the `bin` folder, and copy the path in there. <br />
**4.2.** Go to the `environment variables` > `Path` > `Edit` > `Add` > Paste the copied path there > Apply `Ok` for all tabs. <br />
**4.3.** To test if it all works fine, go to the command prompt and check the version of `idlj`:
```
idlj -version
```
It should return the version of idlj.

## Steps followed in the labs: CORBA lifecycle

### 1. Define the IDL interface
hello.idl:
```
interface Hello {
  void sayHello();
}
```

### 2. Compile the IDL file
```
idlj -fall hello.idl
```

### 3. Implement the abstract object
HelloImpl.java:
```
public class HelloImpl extends HelloPOA {
  void sayHello() {
    // Implementation
  }
}
```

### 4. Write and compile the server 

### 5. Write and compile the client

## Results
- TP1: [TP1](TP1-Corba/)
- TP1: [TP2](TP2-Corba/)
- TP3: Still in progress... :hourglass_flowing_sand:
