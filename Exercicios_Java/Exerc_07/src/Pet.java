public class Pet {

    private  static String nome ;

    private  static boolean limpo;

    public Pet(String _nome) {
        nome = _nome;
        limpo = false;
    }
    
    //################ Sets e Gets ##################
    public static String getNome() {
        return nome;
    }
    public static void setNome(String _nome) {
        Pet.nome = _nome;
    }        
    public static boolean isLimpo() {
        return limpo;
    }
    public static void setLimpo(boolean limpo) {
        Pet.limpo = limpo;
    }
    // Constructor ############
}
