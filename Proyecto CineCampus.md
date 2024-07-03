# Proyecto CineCampus



El proyecto consiste en el desarrollo de una aplicación de gestión de películas para un sistema de cine llamado CineCampus. Esta innovadora aplicación tiene como objetivo centralizar y optimizar la administración de la vasta cantidad de información relacionada con la industria cinematográfica. Permitirá gestionar de manera eficiente y detallada datos sobre películas, actores, formatos, géneros y países.

La base de datos de CineCampus está estructurada para cubrir diversos aspectos esenciales de la información cinematográfica. Por ejemplo, la tabla `cinecampus.pelicula` contiene campos para registrar el código interno de la película, su nombre, duración y una sinopsis detallada, lo que permite tener una visión completa de cada título.

En cuanto a los actores, la tabla `cinecampus.actor` almacena información relevante como el nombre, nacionalidad, edad y el género al que pertenece el actor, enlazándose con la tabla `cinecampus.genero` que describe los distintos géneros cinematográficos. Además, se contempla una clasificación detallada de los tipos de actores y sus roles específicos en las películas mediante la tabla `cinecampus.tipoactor`, lo que facilita el registro y gestión de los diferentes papeles desempeñados en cada producción.

La aplicación también incluirá un apartado para gestionar los formatos de proyección de las películas, como se detalla en la tabla `cinecampus.formato`, que describe los distintos formatos disponibles, y la tabla `cinecampus.peliculaformato`, que vincula las películas con sus respectivos formatos y la cantidad disponible para cada uno.

La gestión de los protagonistas en las películas se realizará a través de la tabla `cinecampus.peliculaprotagonista`, que relaciona cada película con sus protagonistas y el tipo de actor que representan. Asimismo, la aplicación clasificará las películas por géneros y facilitará la búsqueda y filtrado según las preferencias de los usuarios, ya sean dramas, comedias, thrillers, ciencia ficción, etc.

Otro aspecto clave es la inclusión de la procedencia de las películas, permitiendo registrar y acceder a información sobre los países de origen de cada producción a través de la tabla `cinecampus.pais`.

Este sistema no solo mejorará la organización y accesibilidad de la información, sino que también contribuirá a una mejor experiencia tanto para los administradores del sistema como para los usuarios finales, proporcionando una plataforma robusta y detallada para la gestión integral de información cinematográfica.

#### Objetivos

- Crear una base de datos en MySQL siguiendo el esquema proporcionado en el DER.
- Desarrollar una aplicación en Java utilizando Maven para la gestión de dependencias.
- Implementar las funcionalidades CRUD (Crear, Leer, Actualizar, Eliminar) para las diferentes entidades del sistema.
- Diseñar un menú interactivo en la consola para navegar entre las distintas funcionalidades.

### Requisitos

1. **Base de Datos MySQL**
   - Crear una base de datos llamada `cinecampus`.
   - Crear las tablas según el DER proporcionado.
   - Poblar las tablas con algunos datos iniciales para pruebas.
2. **Aplicación Java**
   - Utilizar Maven para la gestión de dependencias.
   - Implementar las funcionalidades CRUD para las tablas del sistema.
   - Crear un menú de consola para interactuar con el usuario.

![cinecampus](C:\Users\developer\Desktop\cinecampus.png)

### Casos de Uso

#### Caso de Uso 1: Gestión de Actores

**Descripción**: Permitir al usuario agregar, editar, eliminar y listar actores.

**Flujo Principal**:

1. El usuario selecciona la opción "Gestionar Actores" en el menú principal.
2. El sistema muestra las opciones:
   - Agregar Actor.
   - Editar Actor.
   - Eliminar Actor.
   - Listar Actores.

#### Caso de Uso 2: Gestión de Películas

**Descripción**: Permitir al usuario agregar, editar, eliminar y listar películas.

**Flujo Principal**:

1. El usuario selecciona la opción "Gestionar Películas" en el menú principal.
2. El sistema muestra las opciones:
   - Agregar Película.
   - Editar Película.
   - Eliminar Película.
   - Listar Películas.

#### Caso de Uso 3: Gestión de Formatos

**Descripción**: Permitir al usuario agregar, editar, eliminar y listar formatos.

**Flujo Principal**:

1. El usuario selecciona la opción "Gestionar Formatos" en el menú principal.
2. El sistema muestra las opciones:
   - Agregar Formato.
   - Editar Formato.
   - Eliminar Formato.
   - Listar Formatos.

#### Caso de Uso 4: Asignación de Actores a Películas

**Descripción**: Permitir al usuario asignar actores a las películas y definir sus roles.

**Flujo Principal**:

1. El usuario selecciona la opción "Asignar Actores a Películas" en el menú principal.
2. El sistema muestra una lista de películas registradas.
3. El usuario selecciona una película de la lista.
4. El sistema muestra una lista de actores y permite asignarles roles.

#### Caso de Uso 5: Gestión de Géneros

**Descripción**: Permitir al usuario agregar, editar, eliminar y listar géneros.

**Flujo Principal**:

1. El usuario selecciona la opción "Gestionar Géneros" en el menú principal.
2. El sistema muestra las opciones:
   - Agregar Género.
   - Editar Género.
   - Eliminar Género.
   - Listar Géneros.

**Extensiones**:

- Si el usuario decide agregar un nuevo género, el sistema muestra un formulario para ingresar los datos del nuevo género.
- Si el usuario decide editar un género, el sistema muestra un formulario con los datos actuales del género para su modificación.
- Si el usuario decide eliminar un género, el sistema solicita confirmación antes de proceder.

#### Caso de Uso 6: Gestión de Países

**Descripción**: Permitir al usuario agregar, editar, eliminar y listar países.

**Flujo Principal**:

1. El usuario selecciona la opción "Gestionar Países" en el menú principal.
2. El sistema muestra las opciones:
   - Agregar País.
   - Editar País.
   - Eliminar País.
   - Listar Países.

**Extensiones**:

- Si el usuario decide agregar un nuevo país, el sistema muestra un formulario para ingresar los datos del nuevo país.
- Si el usuario decide editar un país, el sistema muestra un formulario con los datos actuales del país para su modificación.
- Si el usuario decide eliminar un país, el sistema solicita confirmación antes de proceder.

#### Caso de Uso 7: Gestión de Tipos de Actores

**Descripción**: Permitir al usuario agregar, editar, eliminar y listar tipos de actores.

**Flujo Principal**:

1. El usuario selecciona la opción "Gestionar Tipos de Actores" en el menú principal.
2. El sistema muestra las opciones:
   - Agregar Tipo de Actor.
   - Editar Tipo de Actor.
   - Eliminar Tipo de Actor.
   - Listar Tipos de Actores.

**Extensiones**:

- Si el usuario decide agregar un nuevo tipo de actor, el sistema muestra un formulario para ingresar los datos del nuevo tipo de actor.
- Si el usuario decide editar un tipo de actor, el sistema muestra un formulario con los datos actuales del tipo de actor para su modificación.
- Si el usuario decide eliminar un tipo de actor, el sistema solicita confirmación antes de proceder.

#### Caso de Uso 8: Consulta de Información Detallada de una Película

**Descripción**: Permitir al usuario consultar la información detallada de una película, incluyendo actores, formatos, y otros detalles relacionados.

**Flujo Principal**:

1. El usuario selecciona la opción "Consultar Información Detallada de una Película" en el menú principal.
2. El sistema muestra una lista de películas registradas.
3. El usuario selecciona una película de la lista.
4. El sistema muestra los detalles de la película seleccionada, incluyendo los actores que participan, los formatos disponibles, y otros detalles relacionados.

**Extensiones**:

- Si el usuario selecciona una película, el sistema muestra una vista detallada con toda la información relacionada con esa película.

#### Caso de Uso 9: Listar Actores por Película

**Descripción**: Permitir al usuario listar los actores que participan en una película específica.

**Flujo Principal**:

1. El usuario selecciona la opción "Listar Actores por Película" en el menú principal.
2. El sistema muestra una lista de películas registradas.
3. El usuario selecciona una película de la lista.
4. El sistema muestra una lista de actores que participan en la película seleccionada.

# Criterios de Evaluación

## 1. Gestión de Actores

- **Agregar Actor**
  -  El sistema permite agregar un nuevo actor con todos los campos requeridos (nombre, nacionalidad, edad, género).
  -  Los datos del nuevo actor se guardan correctamente en la base de datos.
  -  Se muestra un mensaje de confirmación tras agregar el actor.
- **Editar Actor**
  -  El sistema permite editar los datos de un actor existente.
  -  Los cambios se guardan correctamente en la base de datos.
  -  Se muestra un mensaje de confirmación tras editar el actor.
- **Eliminar Actor**
  -  El sistema permite eliminar un actor existente.
  -  El actor se elimina correctamente de la base de datos.
  -  Se muestra un mensaje de confirmación tras eliminar el actor.
- **Listar Actores**
  -  El sistema muestra una lista de todos los actores registrados.
  -  La lista incluye todos los detalles relevantes de los actores.

## 2. Gestión de Películas

- **Agregar Película**
  -  El sistema permite agregar una nueva película con todos los campos requeridos (código interno, nombre, duración, sinopsis).
  -  Los datos de la nueva película se guardan correctamente en la base de datos.
  -  Se muestra un mensaje de confirmación tras agregar la película.
- **Editar Película**
  -  El sistema permite editar los datos de una película existente.
  -  Los cambios se guardan correctamente en la base de datos.
  -  Se muestra un mensaje de confirmación tras editar la película.
- **Eliminar Película**
  -  El sistema permite eliminar una película existente.
  -  La película se elimina correctamente de la base de datos.
  -  Se muestra un mensaje de confirmación tras eliminar la película.
- **Listar Películas**
  -  El sistema muestra una lista de todas las películas registradas.
  -  La lista incluye todos los detalles relevantes de las películas.

## 3. Gestión de Formatos

- **Agregar Formato**
  -  El sistema permite agregar un nuevo formato con la descripción correspondiente.
  -  Los datos del nuevo formato se guardan correctamente en la base de datos.
  -  Se muestra un mensaje de confirmación tras agregar el formato.
- **Editar Formato**
  -  El sistema permite editar la descripción de un formato existente.
  -  Los cambios se guardan correctamente en la base de datos.
  -  Se muestra un mensaje de confirmación tras editar el formato.
- **Eliminar Formato**
  -  El sistema permite eliminar un formato existente.
  -  El formato se elimina correctamente de la base de datos.
  -  Se muestra un mensaje de confirmación tras eliminar el formato.
- **Listar Formatos**
  -  El sistema muestra una lista de todos los formatos registrados.
  -  La lista incluye todas las descripciones de los formatos.

## 4. Asignación de Actores a Películas

- **Asignar Actores a Películas**
  -  El sistema permite seleccionar una película y asignarle actores.
  -  El sistema permite definir el rol del actor en la película.
  -  Los datos de asignación se guardan correctamente en la base de datos.
  -  Se muestra un mensaje de confirmación tras asignar el actor a la película.
- **Editar Asignación de Actor a Película**
  -  El sistema permite editar la asignación de un actor a una película.
  -  Los cambios se guardan correctamente en la base de datos.
  -  Se muestra un mensaje de confirmación tras editar la asignación.
- **Eliminar Asignación de Actor a Película**
  -  El sistema permite eliminar la asignación de un actor a una película.
  -  La asignación se elimina correctamente de la base de datos.
  -  Se muestra un mensaje de confirmación tras eliminar la asignación.

## 5. Gestión de Géneros

- **Agregar Género**
  -  El sistema permite agregar un nuevo género con la descripción correspondiente.
  -  Los datos del nuevo género se guardan correctamente en la base de datos.
  -  Se muestra un mensaje de confirmación tras agregar el género.
- **Editar Género**
  -  El sistema permite editar la descripción de un género existente.
  -  Los cambios se guardan correctamente en la base de datos.
  -  Se muestra un mensaje de confirmación tras editar el género.
- **Eliminar Género**
  -  El sistema permite eliminar un género existente.
  -  El género se elimina correctamente de la base de datos.
  -  Se muestra un mensaje de confirmación tras eliminar el género.
- **Listar Géneros**
  -  El sistema muestra una lista de todos los géneros registrados.
  -  La lista incluye todas las descripciones de los géneros.

## 6. Gestión de Países

- **Agregar País**
  -  El sistema permite agregar un nuevo país con la descripción correspondiente.
  -  Los datos del nuevo país se guardan correctamente en la base de datos.
  -  Se muestra un mensaje de confirmación tras agregar el país.
- **Editar País**
  -  El sistema permite editar la descripción de un país existente.
  -  Los cambios se guardan correctamente en la base de datos.
  -  Se muestra un mensaje de confirmación tras editar el país.
- **Eliminar País**
  -  El sistema permite eliminar un país existente.
  -  El país se elimina correctamente de la base de datos.
  -  Se muestra un mensaje de confirmación tras eliminar el país.
- **Listar Países**
  -  El sistema muestra una lista de todos los países registrados.
  -  La lista incluye todas las descripciones de los países.

## 7. Gestión de Tipos de Actores

- **Agregar Tipo de Actor**
  -  El sistema permite agregar un nuevo tipo de actor con la descripción correspondiente.
  -  Los datos del nuevo tipo de actor se guardan correctamente en la base de datos.
  -  Se muestra un mensaje de confirmación tras agregar el tipo de actor.
- **Editar Tipo de Actor**
  -  El sistema permite editar la descripción de un tipo de actor existente.
  -  Los cambios se guardan correctamente en la base de datos.
  -  Se muestra un mensaje de confirmación tras editar el tipo de actor.
- **Eliminar Tipo de Actor**
  -  El sistema permite eliminar un tipo de actor existente.
  -  El tipo de actor se elimina correctamente de la base de datos.
  -  Se muestra un mensaje de confirmación tras eliminar el tipo de actor.
- **Listar Tipos de Actores**
  -  El sistema muestra una lista de todos los tipos de actores registrados.
  -  La lista incluye todas las descripciones de los tipos de actores.

## 8. Consulta de Información Detallada de una Película

- Consultar Información Detallada de una Película
  -  El sistema permite seleccionar una película de la lista de películas registradas.
  -  El sistema muestra todos los detalles de la película seleccionada, incluyendo actores, formatos, y otros datos relacionados.
  -  La información mostrada es correcta y está completa.

## 9. Listar Actores por Película

- Listar Actores por Película
  -  El sistema permite seleccionar una película de la lista de películas registradas.
  -  El sistema muestra una lista de actores que participan en la película seleccionada.
  -  La información mostrada es correcta y está completa.