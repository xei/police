// Written by Hamidreza Hosseinkhani - 2018
// https://github.com/xei/police

#include <ArduinoJson.h>


// Analog Input Pins
int i_a0 = A0;
int i_a1 = A1;
int i_a2 = A2;
int i_a3 = A3;
int i_a4 = A4;
int i_a5 = A5;

// Digital Input Pins
int i_d2 = 2;
int i_d4 = 4;
int i_d7 = 7;

// PWM Output Pins
int o_p3 = 3;
int o_p5 = 5;
int o_p6 = 6;
int o_p9 = 9;
int o_p10 = 10;
int o_p11 = 11;

// Digital Output Pins
int o_d8 = 8;
int o_d12 = 12;
int o_d13 = 13;

// Bluetooth module Baud rate
int BAUD_RATE_BLUETOOTH_MODULE = 9600;

// Delay between loop iterations
int DELAY_MS = 500;

void setup() {

  // Setup Input Pins
  pinMode(i_d2, INPUT);
  pinMode(i_d4, INPUT);
  pinMode(i_d7, INPUT);

  // Setup Output Pins
  pinMode(o_d8, OUTPUT);
  pinMode(o_d12, OUTPUT);
  pinMode(o_d13, OUTPUT);

  digitalWrite(o_d8, LOW);
  digitalWrite(o_d12, LOW);
  digitalWrite(o_d13, LOW);

  // Bluetooth module Baud rate
  Serial.begin(BAUD_RATE_BLUETOOTH_MODULE);

}

void loop() {
  
  parseActionJson(getActionJson());
  createStateJson().printTo(Serial);
  Serial.println();
  
  delay(DELAY_MS);

}

String getActionJson() {
  
  if(Serial.available() > 0) {
      return Serial.readString();
  } else {
    return "";
  }
  
}

void parseActionJson(String actionJson) {
  
  if(actionJson != "") {
    StaticJsonBuffer<200> jsonBuffer;
    JsonObject& jsonObj = jsonBuffer.parseObject(actionJson);
  
    analogWrite(o_p3, jsonObj["p3"]);
    analogWrite(o_p5, jsonObj["p5"]);
    analogWrite(o_p6, jsonObj["p6"]);
    analogWrite(o_p9, jsonObj["p9"]);
    analogWrite(o_p10, jsonObj["p10"]);
    analogWrite(o_p11, jsonObj["p11"]);
    digitalWrite(o_d8, jsonObj["d8"]);
    digitalWrite(o_d12, jsonObj["d12"]);
    digitalWrite(o_d13, jsonObj["d13"]);
  }
  
}

JsonObject& createStateJson() {
  
  StaticJsonBuffer<200> jsonBuffer;
  JsonObject& jsonObj = jsonBuffer.createObject();

  jsonObj["a0"] = analogRead(i_a0);
  jsonObj["a1"] = analogRead(i_a1);
  jsonObj["a2"] = analogRead(i_a2);
  jsonObj["a3"] = analogRead(i_a3);
  jsonObj["a4"] = analogRead(i_a4);
  jsonObj["a5"] = analogRead(i_a5);
  jsonObj["d2"] = digitalRead(i_d2);
  jsonObj["d4"] = digitalRead(i_d4);
  jsonObj["d7"] = digitalRead(i_d7);

  return jsonObj;
  
}
