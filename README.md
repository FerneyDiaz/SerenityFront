# Facilpass-qa-api-serenity

[![gradle](https://img.shields.io/badge/gradle-v4.9.X-yellow.svg)](https://gradle.org/install/)
[![maven](https://img.shields.io/badge/maven-v3.6.X-red.svg)](https://maven.apache.org/)


>A simple Gradle & Maven project to test ADL DevOps Java Serenity &&  Cucumbert  Pipelines. `:wq`
>
>Developed with all :heart: in the world by ADL DevOps team

## Pre requisitos

Debe tener instalado en su computador.

* [Git](http://git-scm.com/)
* [Gradle](https://gradle.org)


## Instalación

Se usa [Gradle](http://www.gradle.org), para desarrollar la herramienta de automatización que genere valor a los productos desarrollados por el equipo. 
Se puede usar [la instalación de  Gradle](http://www.gradle.org/installation) o usar [Gradle wrapper](http://www.gradle.org/docs/current/userguide/gradle_wrapper.html) dentro de este proyecto.

* ´git clone https://github.avaldigitallabs.com/avaldigitallabs/facilpass-commons-qa-api` este repositorio

##  Ejecución de lost tests

Con el parametro **-Denvironment** se pueden tomar los siguientes valores: 

   * dev
   * stg
   
Por defecto los casos corren ejecutando Chrome.

```bash
./gradlew clean test aggregate -Denvironment=pro
```

Los resultados de las pruebas quedan en la carpeta `target/site/serenity`

##  configuración  de WebDriver  y otros temas  extras de Serenity 
Serenity usa el archivo `serenity.conf` en la ruta `src/test/resources` este archivo contiene las distintas configuraciones de la ejecucuión de las pruebas.  

### Environment-specific configurations
Se pueden configurar distintas propiedades y valores, para ejecutar en los distintos ambientes de pruebas. Aquí se encuentran configurados dos ambientes y uno por defecto, __dev__ and _stg_ con diferentes valores para cada ambiente:
```json
environments {
  default {
    base.url.eks ="https://fap-commons-stg-bsl-api.avaldigitallabs.com/"
  }
  dev {
    base.url.eks ="https://fap-commons-dev-bsl-api.avaldigitallabs.com/"
  }
  stg {
    base.url.eks ="https://fap-commons-stg-bsl-api.avaldigitallabs.com/"
  }
}
```
> **_NOTA:_** En la sección de arriba :point_up: para este proyecto se configuran las diferentes urls base de las diferentes apis que maneja la celulá
  
Se usa la propuedad `environment` para determinar en que ambiente se ejecuta la prueba. Por ejemplo para correr los casos de pruebas en ambiente stage se puede ejecutar el siguiente comando:
```json
$ ./gradlew clean test aggregate -Denvironment=stg
```

## Intalación del webdrive local
```bash
brew tap homebrew/cask && brew cask install chromedriver
```

### Estructura del proyecto
En este proyecto se encuentra la siguiente estructura de archivos:
```Gherkin
gradle
  + libraries.gradle                      |Archivo donde estan configuradas todas las librerias
src
  + main                                  | Codigó main
    + java                                | Codigó main
    + com.avaldigitallabs.facilpass       | Paquete base
      + models                            | DTOs, Pojos, VOs, etc ...
  + test                                  |
    + java                                | Test y códigos de soporte
    + com.avaldigitallabs.facilpass       | Paquete base
      + fact                              | Serenity Fact
          + enum.java                     | Distintos tipos de opciones que puede ofrecer un fact
          + fact.java                     | Clase que implementa del fact
      + navigations                       | Urls por las que se van a navegar
      + questions                         | Serenity Questions
      + runners                           | Ubicación de todos los runners que se desean configurar
        + RunnerTestSuite.java            | Main class
      + stepdefinitions                   | Unión entre el gherkin y código java
      + task                              | Serenity task
      + ui                                | Path de los diferentes formularios seprados por funcionalidades
      + utils                             | Funcionalidades utilitarias
    + resources                           |
      + data                              | Data correspondiente a el backoffice
      + features                          | Archivos Feature
      + webdriver                         | Ubicación de los webdriver
        + mac                             | Ubicación de los webdriver para mac
      + serenity.conf                     | Config file for Serenity
serenity.properties                       | General properties Serenity
```


## Instalación del  webdrive en local

```bash
brew tap homebrew/cask && brew cask install chromedriver

```

## Como agregar nuevos datos de un usuario o información para listas, pasos o ajustes?

* Agregar los datos en el archivo correspondiente al ambiente ya sea `dev` o `stage*` y en una de las siguientes rutas `resource/backoffice/stg.properties` o `resource/core/stg.properties` 
* El registro debe quedar de la siguiente manera dentro del archivo
```json
nombre.unico.json = "{"json":"valor"}"
nombre.texto = "texto"
```
* Luego de haber agregado el o los nuevos datos para usar en las ejecuciones, mapeamos el nombre dentro de uno de los siguientes archivos segun se haya guarado el archvio, si se agrego en backoffice se debe mapear en la clase `BackOfficePropertiesFile.java` si se agrego en la carpeta del core se debe mapear en la clase `AdditionalPropertiesFile.java` 
```java
  @Key("nombre.unico.json")
  String getJson();

  @Key("nombre.texto")
  String getText();  
```
* Una vez que se hace esa configuración ya se pueden usar esos valores para usar con Serenity de la forma en que se quiera trabajar la data

## Como ejecutar las diferentes task de gradle

Esta parte se puede realizar mediante gradlew o configurando o agregando un nuevo build de gradle desde intellij

* Para ejecutar todo el proyecto

```bash
./gradlew clean test -Denvironment=pro
```
Build de intellij
```bash
 Task: clean test
 VM options: -Xms2048m -Xmx2048m    
 Arguments: -Denvironment=stg
```

* Para ejecutar un tag en especificó

```bash
./gradlew clean test -Denvironment=pro -Dcucumber.options.tags="@FPB-666"
```
Build de intellij
```bash
 Task: clean test
 VM options: -Xms2048m -Xmx2048m    
 Arguments: -Denvironment=stg -Dcucumber.options.tags="@FPB-666"
```

* Para agregar la licensía a los nuevos archivos

```bash
./gradlew licenseFormat
```
Build de intellij
```bash
Task: licenseFormat
```
