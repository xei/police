# POLICE
An Android-based thick controller for thin hardware agents, such as Robots, IoT devices, etc.

## Intro
Sometimes you are going to make a low-cost but poweful hardware device, for example an affordable autonomous robot or a smart-home peripheral. Assume that your device needs to have a powerful processor, accurate sensors like camera, GPS, Mic, Gyroscope, etc or of course a network connection! So you need a single-board computer like Raspberry Pi. However in some situations you can make a light hardware device via just a microcontroller and some electrical equipment (or use an Arduino board), and use the user's mobile phone as the master controller connected to the hardware.

## What is the "police" project
In this project, I made a passive slave controller by an Arduino board, that can connect to any types of digital or analog sensors and send sensors states to a mobile phone through the USB cable or Bluetooth.
I developed an Android app that is responsible for making appropriate policy based on the given sensors state and the sensors of the mobile phone. The policy will return to the Arduino board as an "Action" command and change some output pins signal of the microcontroller.
Making a good policy can be done inside the phone via some algorithms or it can be done inside a cloud through the internet. Furthermore it can be done with the user's actions. In other words, the Android app can be used as a remote controller to control and monitor the device or navigate a robot manually.

## Thin hardware agent
I used an Arduino Uno R3 board and a HC-06 Bluetooth module to make the passive device and a L298 driver to drive some DC motors.

### Schema
### Breadboard

## Controller application
The Android app is writen in Kotlin programming language and MVP architectural pattern. It can be used as a manual remote controller (also accepts voice commands) and also as the autonomous agent function.
