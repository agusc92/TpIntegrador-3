# Trabajo Integrador 3 SpringBoot

# Integrantes
- **Grupo 6**
    - Agustin La Battaglia

    - Luciana La Battaglia



## Sede 

Quequen

![Imagen de el campus](https://tsnnecochea.com.ar/media/uploads/2023/09/UNICEN-Quequen-2-728x546.webp)


# Propiedades de el trabajo

## General

**URL general:** *http://localhost:8080/api*

**Base de datos:** _integrador3_

## recursos

|consigna|tipo|endpoint|
|---------|---|--------|
|a)Matricular **estudiante**| `POST`|*api/estudiantes*|
|b)Inscribir **estudiante** en **carrera**|`POST`|*api/estudiante_carrera*|
|c)**Estudiantes** por edad|`GET`|*api/estudiantes*|
|d)Buscar **estudiante** por LU|`GET`|*api/estudiantes/lu/{lu}*|
|e)Buscar **estudiante** por genero|`GET`|*api/estudiantes/genero/{genero}*|
|f)Carrera por cantidad de __estudiantes__ inscriptos|`GET`|*api/carreras/reporte*|
|g)__Estudiantes__ filtrados por __carrera__ y ciudad|`GET`|*api/estudiantes/{carrera}/{ciudad}*|


### Ejemplo body punto a

```json
 {
    "dni": 12950356,
    "nombre": "Domini",
    "apellido": "Larderot",
    "edad": 70,
    "genero": "Female",
    "ciudad": "Mengyin",
    "lu": 84506
  } 
  ```

### Ejemplo body punto b

```json
{
  "anio_inscripcion": 2020,
  "anio_graduacion": 2025,
  "antiguedad": 4,
  "id_carrera": 1,
  "dni_estudiante": 12950356
}

```
