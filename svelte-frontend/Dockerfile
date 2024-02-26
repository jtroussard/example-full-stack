# Node image for building the frontend
FROM node:14 as build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# Nginx to serve the built application
FROM nginx:alpine
COPY --from=build /app/public /usr/share/nginx/html
