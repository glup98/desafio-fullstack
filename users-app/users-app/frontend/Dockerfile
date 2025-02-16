FROM node:18-alpine AS builder

WORKDIR /app

COPY package.json package-lock.json ./
RUN npm install --legacy-peer-deps

COPY . .

ENV VITE_PORT=5173
ENV VITE_BACKEND_URL=http://localhost:8080

EXPOSE 5173

RUN npm run build

FROM node:18-alpine

WORKDIR /app

RUN npm install -g serve

COPY --from=builder /app/dist /app

CMD ["serve", "-s", ".", "-l", "5173"]
