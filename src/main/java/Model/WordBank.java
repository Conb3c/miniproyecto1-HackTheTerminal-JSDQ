package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Implementation of IWordBank that manages a collection of words organized by difficulty tiers.
 * Words are categorized into five tiers, with each tier corresponding to specific game levels.
 *
 * @author HackTheTerminal Team
 * @version 1.0
 */
public class WordBank implements IWordBank{

    /** List of words for tier 1 (levels 1-9) */
    private ArrayList<String> tier1;
    /** List of words for tier 2 (levels 10-18) */
    private ArrayList<String> tier2;
    /** List of words for tier 3 (levels 19-27) */
    private ArrayList<String> tier3;
    /** List of words for tier 4 (levels 28-36) */
    private ArrayList<String> tier4;
    /** List of words for tier 5 (levels 37-45) */
    private ArrayList<String> tier5;

    /** Random number generator for selecting words */
    private Random random;

    /**
     * Constructs a WordBank and initializes all tiers with programming-related words.
     * Tier 1 contains basic programming terms.
     * Tier 2 contains intermediate programming concepts.
     * Tier 3 contains advanced programming terms.
     * Tier 4 contains complex programming concepts.
     * Tier 5 contains challenging mixed-case terms.
     */
    public WordBank(){
        this.tier1 = new ArrayList<>(Arrays.asList("Código", "Web", "Bug", "Link", "Dato", "App", "Input", "Chat", "Error", "File",
                "Menú", "Icono", "User", "Botón", "Texto", "Click", "Login", "Byte", "Nodo", "Script"));
        this.tier2 = new ArrayList<>(Arrays.asList("Variable", "Función", "Arreglo", "Bucle", "Objeto", "Clase", "Método", "Cadena",
                "Entero", "Booleano", "Evento", "Puerto", "Token", "Commit", "Branch", "Merge",
                "Push", "Pull", "Render", "Syntax"));
        this.tier3 = new ArrayList<>(Arrays.asList("Algoritmo", "Instancia", "Herencia", "Interfaz", "Backend", "Frontend", "Callback",
                "Promesa", "Endpoint", "Librería", "Framework", "Compilador", "Debugger", "Despliegue",
                "Recursión", "Puntero", "Paquete", "Consulta", "Servidor", "Repositorio"));
        this.tier4 = new ArrayList<>(Arrays.asList("Polimorfismo", "Abstracción", "Encapsulamiento", "Asincronismo", "Concurrencia",
                "Microservicios", "Inmutabilidad", "Serialización", "Contenedor", "Middleware",
                "Orquestación", "Normalización", "Refactorización", "Escalabilidad", "Autenticación",
                "Autorización", "Dependencia", "Persistencia", "Paralelismo", "Optimización"));
        this.tier5 = new ArrayList<>(Arrays.asList("HyPeRvIsOr", "mUlTiThReAdInG", "dEiNtErLeAvInG", "cRyPtOgRaPhY", "iNsTrUnTiOnSeT",
                "mEmOrYlEaK", "kUbErNeTeS", "bInArYtReE", "rEgIsTrYkEy", "pIpElInInG",
                "bAcKtRaCkInG", "dIsAsSeMbLeR", "gArBaGeCoLlEcToR", "hAsHtAbLe", "vIrTuAlIzAtIoN",
                "mEtApRoGrAmMiNg", "tRaNsPiLeR", "bItMaPpInG", "sTaCkOvErFlOw", "dEaDlOcKiNg"));
        random = new Random();
    }

    /**
     * Retrieves a random word from the appropriate tier based on the current level.
     * Levels 1-9: tier 1
     * Levels 10-18: tier 2
     * Levels 19-27: tier 3
     * Levels 28-36: tier 4
     * Levels 37-45: tier 5
     *
     * @param level the game state (not currently used in selection logic)
     * @param currentLevel the current game level (1-45)
     * @return a randomly selected word from the appropriate tier
     */
    @Override
    public String getRandomWord(GameState level, int currentLevel) {
        int index = 0;
        String word = "";
        if (currentLevel <= 9){
            index = random.nextInt(tier1.size());
            word = tier1.get(index);
        } else if (18 >= currentLevel && currentLevel > 9) {
            index = random.nextInt(tier2.size());
            word = tier2.get(index);
        } else if (27 >= currentLevel && currentLevel > 18) {
            index = random.nextInt(tier3.size());
            word = tier3.get(index);
        } else if (36 >= currentLevel && currentLevel > 27) {
            index = random.nextInt(tier4.size());
            word = tier4.get(index);
        }
        else if (45 >= currentLevel && currentLevel > 36) {
            index = random.nextInt(tier5.size());
            word = tier5.get(index);
        }
        return word;
    }

}
