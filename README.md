# Lojinha Automação Web
Esse é um repositório que contém a automação de alguns testes Web de um software denominado Lojinha. Os sub-tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologias Utilizadas

- Java
  https://www.oracle.com/java/technologies/downloads/
- Maven
  https://maven.apache.org/
- JUnit
  https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.0-M1
- Selenium WebDriver
  https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.0.0
- Selenium ChromeDriver
  https://chromedriver.chromium.org/downloads

## Testes Automatizados

Teste de validação de login e senha e cadastro de produtos. Validação de partições de equivalência, valor limite e mensagem apresentada relacionadas ao valor do produto na Lojinha, que estão vinculados diretamente à regra de negócio que diz que o valor do produto deve estar entre R$ 0,01 e R$ 7.000,00.

## Notas Gerais
Sempre utilizamos a anotação BeforeEach e AfterEach para abertura de browser para que seja realizado o login.
Armazenamos os dados que são enviados para Web através do uso de classes POJO.
Sempre utilizamos o padrão de design PageObject para aprimorar a  manutenção dos testes realizados e reduzir a duplicação de código.
Nesse projeto fazemos o uso do JUnit 5.8, o que nos dá a possibilidade de usar a anotação DisplayName para dar descrições em português para nossos testes.
