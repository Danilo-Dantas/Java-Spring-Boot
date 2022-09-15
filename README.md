# Java-Spring-Boot

>>>> Container IOC
.Inversion of Controler
.São delegadas a ele algumas tarefas que devem ser feitas, ex: abertura e fechamento de conexões com banco de dados.

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

