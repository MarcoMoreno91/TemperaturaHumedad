# INTERFAZ GRÁFICA EN JAVA QUE REALIZA LA COMUNICACIÓN CON ARDUINO Y ENVIO DE DATOS DE TEMPERATURA Y HUMEDADPOR EL PUERTO SERIAL.


Fecha:	12/04/2018

Autor:	Marco Antonio Moreno Cortés

# Descripción:

Este proyecto realiza la comunicación de arduino con java medieante una intefaz grafica, en el cual del lado de la interfacaz en java 
recibe los datos por medio de la comunicaión serial que se envia de arduinocomo lo es la temperatura y la humeda que obtiene el sensor 
el cual se muestra en unas etiquetas creadase en java, también tiene un combo box en el cual podemos seleccionar el puerto al que deseamos
conectarnos así como un botón en cual realiza la comunicacion y un botón donde se enviara el mensaje que el usuario ingrese y un botón de
cerrar.

También el proyecto que se realizo muestra la humedad adicionalmente y la temperatura antes obtenidas en una pantalla LCD junto con la hora y la fecha y un mensaje Bienvenido este predefinido pero también un mensaje el cual el usuario ingresa desde la intefaz creada en java de manera que se pueda navegar los mensajes desde la interfaz y lleva un potenciómetro en el que se puede controlar el contraste de lapantalla LCD.

# Lista de componentes:


* 2  Resistencias de 330 ohmios.
* 1  Potenciómetro de 10K.
*    Cables.
* 1  Placa Arduino Uno.
* 1  Placa Protoboard.
* 1  Cable de impresora.
* 1  Pantalla LDC de 16x2.
* 1  Sensor de Temperatura y humedad DHT11.

## 1-Montado del Circuito.

![esquema circuito](https://user-images.githubusercontent.com/36495262/38909184-293be05a-4289-11e8-95ba-d0c50f040902.png)

## 2-Esquema del Circuito.

![esquemaeletrico](https://user-images.githubusercontent.com/36495262/38909508-7becf194-428a-11e8-8e81-6bee53786750.png)

## 3-Interfaz y Comunicación con arduino.

![temperatura](https://user-images.githubusercontent.com/36495262/38910077-47e240cc-428d-11e8-9701-0a7941aa353c.png)
 
![humedad](https://user-images.githubusercontent.com/36495262/38910605-b090a30a-428f-11e8-95c1-83958f50bef1.png)


## 4-Envio del Mensaje de interfaz en Java a Pantalla LCD.

![img_0665](https://user-images.githubusercontent.com/36495262/38910236-ff891ba6-428d-11e8-8e49-20313dfd53d7.JPG)

## 5-Envio de Datos de Temperatura y Humedad a Pantalla LCD.

![img_0666](https://user-images.githubusercontent.com/36495262/38910423-d6d4eaae-428e-11e8-8652-d5e8120fa2f6.JPG)

## 6-Envio de Feacha y Hora a Pantalla LCD.

![img_0667](https://user-images.githubusercontent.com/36495262/38910534-51bfdd3c-428f-11e8-8425-8375996b6da5.JPG)

## 7-Pantalla Bienvenido Mensaje Predeterminado.

![img_0675](https://user-images.githubusercontent.com/36495262/38910734-6415a22c-4290-11e8-905c-b0fc728fa2d0.JPG)



