FROM node:latest as node
WORKDIR /foodie-application
COPY . .
RUN npm install
RUN npm run build --prod

FROM nginx:alpine
COPY --from=node /foodie-application/dist/foodie-application /usr/share/nginx/html