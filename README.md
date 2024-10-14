# Conversor de Monedas

Esta es una aplicación simple de conversión de monedas hecha en Java utilizando una API para obtener las tasas de cambio. Permite al usuario ingresar una cantidad en una moneda y convertirla a otra moneda de su elección.

## Características

- Conversión entre varias monedas: Dólar a Peso Argentino, Peso Argentino a Dólar, Dólar a Real Brasileño, Real Brasileño a Dólar, Dólar a Peso Boliviano y Peso Boliviano a Dólar.
- Validación de entradas para asegurar que las cantidades sean válidas.
- Manejo de errores para asegurar que la aplicación no falle inesperadamente.

## Requisitos

- Java 11 o superior
- Una API key de [ExchangeRate-API](https://www.exchangerate-api.com/)

## Instalación

1. Clona este repositorio.
   ```bash
   git clone https://github.com/tu-usuario/conversor-de-monedas.git

2. Navega al directorio del proyecto
  ```bash
  cd conversor-de-monedas
  ```

3. Asegúrate de tener un archivo config.properties en la carpeta src/resources con tu API key:
```
  apiKey="tu apikey"
```

## Uso

1. Compila y ejecuta la aplicación
   ```bash
   javac -d bin src/**/*.java
   java -cp bin com.aluracursos.conversorapp.Principal
   ```
   
2. Sigue las instrucciones en la consola para seleccionar la conversión deseada y la cantidad a convertir.

## Ejemplos de Uso

- Pantalla de inicio:
  ![image](https://github.com/user-attachments/assets/34d0f8dc-4a90-4098-ad6c-2dadd5232902)
- Selección de conversión:
  ![image](https://github.com/user-attachments/assets/3bf34a13-a810-4412-9668-c0fc4809c915)
- Resultado de la conversión:
  ![image](https://github.com/user-attachments/assets/9cc6919d-ceb5-44f6-a790-642ecc5d2d0c)

## Contribuciones
Las contribuciones son bienvenidas. Por favor, abre un issue o un pull request para discutir posibles mejoras.
