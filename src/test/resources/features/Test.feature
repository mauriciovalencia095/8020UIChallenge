Feature: Test de pagina personajes

  Background: Login
    Given El usuario abre la url


    Scenario: El usuario que todos los personajes tienen un nombre y la opción ver detalle
      When el usuario valida que esta en la pagina principal "Personajes"
      Then el usuario valida que los personajes tienen nombre y el boton ver detalle


    Scenario Outline: El usuario valida la informacion de los personajes
      When el usuario va al detalle de informacion del personaje numero "<numeroPersonaje>"
      Then el usuario valida el "<nombre>" , la "<especie>", "<estatus>", el "<genero>" y la "<url>"
      And el usuario regresa a la pagina principal por medio de la opcion Home
      Examples:
        | numeroPersonaje | nombre       | especie | estatus | url                                           | genero |
        | 1               | Rick Sanchez | Human   | Alive   | https://vue-aknxx1.stackblitz.io/character/1  | Male   |
        | 14              | Alien Morty  | Alien   | unknown | https://vue-aknxx1.stackblitz.io/character/14 | Male   |
        | 17              | Annie        | Human   | Alive   | https://vue-aknxx1.stackblitz.io/character/17 | Female |
        | 13              | Alien Googah | Alien   | unknown | https://vue-aknxx1.stackblitz.io/character/13 | unknown |

      Scenario: El usuario navega hacia una nueva vista
        When el usuario abre una nueva vista con el botton add
        Then el usuario vera un formulario

      Scenario: El usuario usa el boton top para volver hasta el inicio de la pagina
        When el usuario hace scroll down
        Then el usuario utiliza el boton top para volver hasta el inicio