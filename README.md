# Barrehtopia - Simple Demo

A minimal full-stack example: a page that says "Welcome to Barrehtopia"
with a button that fetches a message from the database via the backend.

## Structure

- `backend/` — Spring Boot + Maven + H2 in-memory database
- `frontend/index.html` — plain HTML/JS version (no build needed, open directly in browser)
- `frontend-angular/` — Angular 18 version

## Run the backend

```bash
cd backend
mvn spring-boot:run
```

Backend runs on http://localhost:8080
Endpoint: `GET /api/message` returns a string from the database.

## Run the frontend (plain HTML)

Just open `frontend/index.html` in a browser. Click the button.

## Run the frontend (Angular)

```bash
cd frontend-angular
npm install
npm start
```

Runs on http://localhost:4200
