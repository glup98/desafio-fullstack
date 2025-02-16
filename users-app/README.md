# 🛠️ Mantenedor de Usuarios

Este proyecto es un mantenedor de usuarios que permite realizar operaciones **CRUD** a través de una API RESTful desarrollada en **Java con Spring Boot**, junto con un **frontend en React**.

La aplicación está diseñada para ser ejecutada en contenedores utilizando **Docker y Docker Compose**, aunque también se puede ejecutar manualmente.

---

## 🚀 Tecnologías Utilizadas

- **Backend:** Java 17 + Spring Boot 3.4.x + H2 Database
- **Frontend:** React 19 + TypeScript + Vite
- **Documentación API:** Swagger UI + OpenAPI
- **Gestión de Contenedores:** Docker & Docker Compose

---

# Instrucciones de Ejecución

Este documento describe cómo ejecutar la aplicación utilizando **Docker y Docker Compose**.

---

## **📌 Requisitos Previos**

Asegúrate de tener instalados los siguientes programas:

- [Docker](https://www.docker.com/get-started) (versión 20+ recomendada)
- [Docker Compose](https://docs.docker.com/compose/install/) (versión 2.0+ recomendada)

Para verificar la instalación, ejecuta:

```bash
docker --version
# Debe mostrar la versión de Docker

docker-compose --version
# Debe mostrar la versión de Docker Compose
```

---

## **🚀 Pasos para Ejecutar la Aplicación**

### 1️⃣ **Clonar el repositorio**

```bash
git clone <URL_DEL_REPOSITORIO>
cd users-app
```

### 2️⃣ **Levantar la aplicación con Docker Compose**

Ejecuta el siguiente comando en la raíz del proyecto:

```bash
docker-compose up -d
```

Esto levantará los servicios en segundo plano.

### 3️⃣ **Verificar que los contenedores están corriendo**

```bash
docker ps
```

Deberías ver algo similar a:

```
CONTAINER ID   IMAGE                   STATUS          PORTS
abcdef123456   users-app-frontend      Up 10 seconds  0.0.0.0:5173->5173/tcp
123456abcdef   users-app-backend       Up 10 seconds  0.0.0.0:8080->8080/tcp
```

### 4️⃣ **Acceder a la aplicación**

- **Frontend:** [`http://localhost:5173`](http://localhost:5173)
- **Backend (API o Swagger UI):** [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

---

## **🛑 Cómo detener la aplicación**

Para apagar los contenedores sin eliminarlos:

```bash
docker-compose down
```

Esto detendrá la aplicación, pero podrás volver a iniciarla con:

```bash
docker-compose up -d
```

Si deseas **eliminar los contenedores, imágenes y volúmenes**:

```bash
docker-compose down --volumes --rmi all
```

Esto eliminará:

- Contenedores
- Imágenes Docker (`--rmi all`)
- Volúmenes (`--volumes`)

---

# 🛠️ Ejecución Manual (Si Docker Falla)

## ➤ Backend

Si el contenedor del backend no se ejecuta correctamente, puedes ejecutarlo manualmente:

### 1️⃣ Instalar Dependencias y Construir el Backend

```bash
cd backend
mvn clean install
```

### 2️⃣ Ejecutar el Backend

```bash
mvn spring-boot:run
```

## ➤ Frontend

Si el contenedor del frontend no se ejecuta correctamente, puedes ejecutarlo manualmente:

### 1️⃣ Instalar Dependencias

```bash
cd frontend
npm install --legacy-peer-deps
```

### 2️⃣ Ejecutar el Frontend en Modo Desarrollo

```bash
npm run dev
```

Esto abrirá la aplicación en http://localhost:5173.

### 3️⃣ Generar una Versión de Producción

```bash
npm run build
```

Esto generará los archivos optimizados en la carpeta dist/.

Desarrollado con ❤️ (y mucho café) de por medio. ☕️
