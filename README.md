# prueba-tecnica-backend
Evaluar las habilidades y conocimientos del candidato en temas de experiencia de usuario e interfaz de usuario UX/UI, con las herramientas de Java y Framework Spring Boot y Front End Angular

# 1. Se crea estructura para proyecto backend

- springboot 3.5
- se agreaga a las dependencias :
  - spring-boot-starter-web
  - mysql-connector-j
  - spring-boot-starter-data-rest
  - spring-boot-starter-test
  - estructura de paquetes sugerida en la prueba
    ![Archivo pdf con prueba solicitada.](Prueba_Tecnica_Desarrollor_Full_Stack_SP.pdf)



# 2. Generacion de clasess con generador openapi

Se genera los diferentes vervos de http con ayuda del generador de openapi para mantener un poco el estandar de http y api rest.

Se crea proyecto independiente 'OPENAPI' para despues copiar las clases generadas al proyecto 'demo' y poder tener control sobre las ellas y depurar los warnings generados.

Se crea OpenAPI Material
  - Se crea archivo 'openapi.yml' que  contiene las cacteristicas de la api material
  - Paths
    - get  /material               Consultar todos los material
    - post /material               Crea un material
    - put  /material               Actualiza un material
    - get  /material/{type}        Consulta material filtrado por tipo
    - get  /material/{purchaseAt}  Consulta material filtrado por purchaseAt
    - get  /material/{city}        Consulta material filtrado por city



# 3. Copia de clases generadas por 'openapi' a proyecto 'demo'

Se paa las clases generadas a 'domo' en las carpetas correspondientes y se hace depuracion de la clases.

- Se crea paquete 'common' para colocar las interfaces y clases compartidas por toda la app
- Se agregas las dependencias  de swagger documentacion y las de validaciones.
 


# 4. Creacion de JPA repository y clases de entidad para coneccion con mysqldb
se crean clase para administrar la coneccion de base de datos mysql y clases ApiUtil donde se crearan funcionalidase para ayuadar a convertir la data que proviene de la base de datos a los dto que se enviaran en la respuesta de la api.

- Se crea administador de jpa para MySQL
- Se crea ApiUtil
- Se comienza con logica de negocio para extraer data y pasarla al controlador
- se crea un decorador '@EnumValidator' para validar campo 'Status' de la DTO 'Material'



# 5. Creacion de logica de negocio de la api
se crean las diferentes metodos en el las clases repository como en las calse business y ApiUtil para transformasr la info de la base de datos a la respuesta de la api.

 - Se crea metodo 'listMaterial()' en 'MaterialBusines' para traer de la DB y formater respuesta.
 - Se crea metodo 'listMaterial()' en 'MaterialController' para transportar informacion del servico 'MaterialBusines' a fuera del   api.
