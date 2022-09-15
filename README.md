# Java-Spring-Boot

>Container Inversion of Control (IOC)

IOC armazena todas as configurações e todos objetos que usamos na aplicação

@Configuration, são as classes de configuração.

@Bean, objeto que é instanciado em um método

@Component, será uma classe que contem métodos e aplicações que serão uteis no projeto.

@Controller, controles (MVC)
@Service, onde opera nossos objetos e classes de serviço, onde contém as regras de negócio
@Repository, acessa os repositórios, base de dados

```
                                 HIERARQUIA                          
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
|                             Container IOC <- @Configuration <- @Bean     |
|                                     ^                                    |
|                                     |                                    |
|                 @Controller ->  @Component <- @Service                   |
|                                     ^                                    |
|                                     |                                    |
|                                @Repository                               |
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
```
