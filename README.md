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