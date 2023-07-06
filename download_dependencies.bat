@echo off

REM Lista dos diretórios dos microsserviços
set "microservices=03_api-gateway 03_book-service 03_cambio-service 03_naming-server"

REM Loop para navegar em cada diretório e executar o comando 'mvn dependency:resolve'
for %%d in (%microservices%) do (
  echo Downloading dependencies for the microservice: %%d
  cd %%d
  mvn dependency:resolve
  cd ..
)
