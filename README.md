# Mejoras para el Código del Gestor de Ingresos y Gastos

Este documento describe una serie de mejoras propuestas para el código actual del gestor de ingresos y gastos desarrollado en Java. Las sugerencias se basan en buenas prácticas de programación, limpieza de código, mantenimiento y extensibilidad.

## 🧹 Refactorización y Limpieza de Código

### 1. Evitar la repetición de objetos `Scanner`
- Actualmente se crea un nuevo `Scanner` cada vez que se llama a un método. Se recomienda reutilizar una única instancia de `Scanner` o pasarla como parámetro a los métodos.

### 2. Separación de responsabilidades
- Los métodos `pedirIngreso` y `pedirGasto` combinan lógica de negocio con entrada por consola. Sería ideal separar esta lógica para facilitar pruebas unitarias y futura implementación con interfaz gráfica.

### 3. Validación de entradas
- Extraer la validación de cantidades (positivas y dentro del saldo) a métodos auxiliares para evitar duplicación de lógica y mejorar la legibilidad.

### 4. Manejo de entradas no válidas
- Actualmente, si el usuario introduce un texto en lugar de un número, el programa lanza una excepción. Se debe añadir control de errores con `try-catch` para evitar que la aplicación se bloquee.

## ✨ Mejoras de diseño

### 5. Uso de enumeraciones para tipos de gasto
- Reemplazar el `switch` basado en `int` por un `enum` de tipo `GastoTipo`, mejorando la claridad y reduciendo errores por selección inválida.

### 6. Introducción de una clase `Usuario`
- Encapsular el nombre, saldo e historial de gastos de cada usuario en una clase `Usuario`, promoviendo un diseño más orientado a objetos.

### 7. Posibilidad de registrar múltiples ingresos y gastos
- Añadir soporte para listas de ingresos y gastos, lo que permitiría mantener un historial y generar reportes o estadísticas.

## 🧪 Pruebas y Extensibilidad

### 8. Preparación para pruebas automatizadas
- Refactorizar métodos para eliminar dependencias con la consola (`Scanner`), facilitando pruebas unitarias con datos simulados.

### 9. Exportación de datos
- Añadir funcionalidad para exportar ingresos y gastos a archivos CSV o JSON para su posterior análisis.

### 10. Uso de JavaDoc
- Añadir documentación a las clases y métodos para mejorar la mantenibilidad del código.

---

Estas mejoras buscan optimizar el código existente, facilitar su evolución futura y prepararlo para nuevas funcionalidades o integración en sistemas más grandes.
