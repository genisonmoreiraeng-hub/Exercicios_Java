/*
# Escreva um código onde temos o controle de 
banho de um petshop, a maquina de banhos dos 
pets deve ter as seguintes operações:
- Dar banho no pet;
- Abastecer com água;
- Abastecer com shampoo;
- verificar nivel de água;
- verificar nivel de shampoo;
- verificar se tem pet no banho;
- colocar pet na maquina;
- retirar pet da máquina;
- limpar maquina.

# Siga as seguintes regras para implementação

A maquina de banho deve permitir somente 1 pet por vez;
Cada banho realizado irá consumir 10 litros de água e 2 litros de shampoo;
A máquina tem capacidade máxima de 30 litros de água e 10 litros de shampoo;
Se o pet for retirado da maquina sem estar limpo será necessário limpar a máquina para permitir a entrada de outro pet;
A limpeza da máquina ira consumir 3 litros de água e 1 litro de shampoo;
O abastecimento de água e shampoo deve permitir 2 litros por vez que for acionado;


*/
public class MaquinaBanho {

    private int nivelAgua;
    private int nivelShampoo;
    private Pet pet;
    private boolean precisaLimpeza;

    public MaquinaBanho(){

    }

    //################ Contructor ##################
    public MaquinaBanho(int nivelAgua, int nivelShampoo, Pet pet, boolean precisaLimpeza) {
        this.nivelAgua = nivelAgua;
        this.nivelShampoo = nivelShampoo;
        this.pet = pet;
        this.precisaLimpeza = precisaLimpeza;
    }

    //################ Sets e Gets ##################
    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }   

    public int getNivelAgua() {
        return nivelAgua;
    }

    public void setNivelAgua(int nivelAgua) {
        this.nivelAgua = nivelAgua;
    }

    public int getNivelShampoo() {
        return nivelShampoo;
    }

    public void setNivelShampoo(int nivelShampoo) {
        this.nivelShampoo = nivelShampoo;
    }
    
    public boolean isPrecisaLimpeza() {
        return precisaLimpeza;
    }

    public void setPrecisaLimpeza(boolean precisaLimpeza) {
        this.precisaLimpeza = precisaLimpeza;
    }
    //##############################
    //######### Metodos ############
    //##############################

    public void abastecerAgua() {
        this.nivelAgua+=2;       
    }

    public void abastecerShampoo() {
        this.nivelShampoo += 2; 
    }

    public int verificarNivelAgua() {
        return nivelAgua;
    }

    public int verificarNivelShampoo() {
        return nivelShampoo;
    }

    public boolean temPet() {
        return pet != null;
    }

    public void colocarPet(Pet pet) {
        setPet(pet);
        System.out.println("Pet de Nome : " + Pet.getNome() + " esta na Maquina" );
    }

    public Pet retirarPet() {
        setPet(pet);
        System.out.println("Pet de Nome : " + Pet.getNome() + " foi retirado da Maquina" );
        return null;
    }

    public void darBanho() {
        // implementar
    }

    public void limparMaquina() {
        // implementar
    }
}
