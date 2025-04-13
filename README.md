# 🔗 URL Shortener

A full-stack, scalable URL Shortener built with **React** and **Spring Boot**

## ⚙️ Tech Stack

### Frontend
- ⚛️ React
- 🧭 React Router DOM
- 🎨 CSS Modules / Tailwind (custom styling)

### Backend
- ☕ Spring Boot
- 🗄️ JPA + H2 / PostgreSQL (configurable)
- 📦 RESTful JSON API

## 🧠 Features

- ✅ Shorten long URLs with unique, shareable short links
- ✅ Redirection with statistics support (future enhancement)
- ✅ Clean, modern UI with responsive design

## 🚀 How to Run Locally

### 🔧 Backend (Spring Boot)
1. Clone the repo:
   ```bash
   git clone https://github.com/your-username/url-shortener.git
   cd url-shortener/backend
   ```
2. Run the app (via your IDE or CLI):
   ```bash
   ./mvnw spring-boot:run
   ```
3. The backend should be up at: `http://localhost:8080`

> Note: Replace `application.properties` with your DB configs if using PostgreSQL or another DB.

### 🎨 Frontend (React)
1. Navigate to frontend folder:
   ```bash
   cd ../frontend
   ```
2. Install dependencies and start dev server:
   ```bash
   npm install
   npm start
   ```
3. The frontend will run at: `http://localhost:3000`

---

## 🛡️ API Overview

### `POST /api/auth/register`
- Body: `{ "username": "user", "password": "pass" }`
- Creates a new user

### `POST /api/auth/login`
- Body: `{ "username": "user", "password": "pass" }`
- Returns: JWT Token

### `POST /api/url/shorten`
- Headers: `Authorization: Bearer <token>`
- Body: `{ "longUrl": "https://example.com" }`
- Returns: Short URL

### `GET /api/url/user`
- Headers: `Authorization: Bearer <token>`
- Returns: List of user's shortened URLs

---

## 📁 Folder Structure

```
src/
│
├── pages/
│   ├── Home.js
│   ├── Login.js
│   ├── Register.js
│   ├── Dashboard.js
│
├── components/
│   └── Navbar.js
│
├── App.js
└── index.js
```

---

## 💡 Future Enhancements

- 🔐 JWT-based Auth (via custom `useAuth` hook)
- 🧰 Spring Security + JWT
- ✅ User authentication: Register, Login (JWT tokens)
- ✅ Personalized Dashboard to:
      1. View all shortened URLs
      2. Copy short links
      3. View original long URLs
- 📊 Click analytics and URL stats
- 📅 Expiry time for short URLs
- 📈 Charts on Dashboard
- 🔐 Forgot password & OAuth logins
- 🌐 Custom domains

---

## 🧑‍💻 Author

Made with ❤️ by Sunil (https://github.com/snerall1)  
Feel free to fork, contribute or star the project!
