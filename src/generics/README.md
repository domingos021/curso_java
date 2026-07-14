    # Generics em Java
    
    ## Conceito
    
    Generics permitem que classes, interfaces e métodos trabalhem com
    diferentes tipos, mantendo a segurança de tipos (**type safety**).
    
    Beneficios
    *Reuso
    * (**type safety**)
    *Performance

    Uso comum: coleções
    Ex: List<String> list = new ArrayList<>()
    list.add("Maria");
    String name = list.get(0)
    
    Em vez de criar várias classes para cada tipo de dado diferente,
    podemos criar uma única estrutura reutilizável que funciona com vários
    tipos.
    
    Exemplo:
    
    Sem Generics:
    
    
    IntegerBox
    StringBox
    DoubleBox
    
    
    Nesse caso, seria necessário criar uma classe diferente para cada tipo
    de dado.
    
    Com Generics:
    
    
    Box<Integer>
    Box<String>
    Box<Double>
    
    A mesma classe pode trabalhar com diferentes tipos, e o tipo é definido
    no momento em que o objeto é criado.
