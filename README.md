# CVDSLAB3
  AUTORES : Diego Chicuazuque y Felipe Martinez
  ## CREACION DE ESQUELETO
  primero debemos de crear el proyecto haciendo uso de las herramientas que nos da maven y lo que nos piden para ello ejecutamos el comando
  ![image](https://github.com/user-attachments/assets/e7dbbf92-f9ae-4490-9ed4-b9dde5345bf3)
  pantallazos ejecucion en consola
  ![image](https://github.com/user-attachments/assets/4f616808-b47a-47e2-87d4-6b111d1c89f5)
  ![image](https://github.com/user-attachments/assets/d6192dc0-04c6-409a-9381-8e33ef16dcb0)
  
  luego probamos que ya se creo intentando de nuevo ejecutar el comando mostrandonos que ya existe
  ![image](https://github.com/user-attachments/assets/3ce7d90b-75f1-42ab-941d-5712ad8cb107)
  
  Ahora entramos en el directorio del proyecto creado /library
  ![image](https://github.com/user-attachments/assets/8e9b94b8-5f00-4d39-8e73-2dd693ad9a1e)
  
  compilamos con los comandos de maven
  ![image](https://github.com/user-attachments/assets/681426dd-9ffe-4c41-bbc3-bdbeebfaee1b)
  
  Nos fijamos que nos sale un error con junit
  ![image](https://github.com/user-attachments/assets/87293afc-e50a-4b4f-b702-4eb34c691871)
  
  Agregamos la extension el el pom
  ![image](https://github.com/user-attachments/assets/bed1345e-5b02-4f68-8b58-e3a7969c8871)
  
  con esto arregamos el problema siguiendo la guia del laboratorio
  ![image](https://github.com/user-attachments/assets/b82fd8f7-8a3a-4385-bc73-ca92bc0902e3)
  
  Ahora agregamos los directorios que nos piden agregar en main y test y revisamos como quedo nuestro arbol del proyecto con el comando tree de maven 
  ![image](https://github.com/user-attachments/assets/9a4dd98f-ba06-4be7-b56c-27751a012aa1)
  
  
  
  ## AGREGAR CLASES
  En este caso unicamente se copio y pego el codigo dado en el laboratorio y luego de esto se compilo con mvn package
  ![image](https://github.com/user-attachments/assets/76e213b9-9dd9-466b-865a-6733d8e53a21)
  asi quedaria los .java que se debian agregar
  
  ![image](https://github.com/user-attachments/assets/e4409e4a-3362-4f2f-8b9d-d128520914db)
  
  
  ## PRUEBAS UNITARIAS Y TDD
  ### CREAR CLASE DE PRUEBA
  Primero creamos la prueba de unidad para agregar libros addBlock siguiendo los estandares
  ![image](https://github.com/user-attachments/assets/56feb402-6ad3-4573-9cd7-11f08b61b3a4)
  
  Ahora agregamos la implementacion para que las pruebas funcionen como deberian
  ![image](https://github.com/user-attachments/assets/1c11a0eb-5598-41f5-a9eb-9f1d2a8ef1f9)
  
  Creamos la prueba de unidad para prestar un libro loanABook siguiendo los estandares:
  ![image](https://github.com/user-attachments/assets/da2b321f-b6e9-48b5-986d-adbc2300ba39)
  
  Ahora agregamos la implementacion para que las pruebas funcionen como deberian
  ![image](https://github.com/user-attachments/assets/bef373a9-2710-4977-a7c3-0470d86561d8)
  
  seguido de esto lo realizamos para devolver libro returnBook
  ![image](https://github.com/user-attachments/assets/7d9c1be5-f0dc-4d89-82ac-37e316f486ce)
  
  Ahora agregamos la implementacion para que las pruebas funcionen como deberian
  ![image](https://github.com/user-attachments/assets/72cd330c-005d-4c5c-9910-edfa8bf5fa15)
  
 
  Se realiza una ultima compilacion para ver que todo funciona correctamente 
  ![image](https://github.com/user-attachments/assets/d1e1aa73-185f-42b7-bfab-cd13cf6ed6ba)

  


