package ilisi;

import jade.core.Agent;

public class MathAgent extends Agent {

    @Override
    protected void setup() {
        // Récupérer les arguments passés à l'agent
        Object[] args = getArguments();

        if (args != null && args.length >= 3) {
            try {
                // Extraire les paramètres
                String operation = args[0].toString(); // Opération (addition, soustraction, etc.)
                double number1 = Double.parseDouble(args[1].toString()); // Nombre 1
                double number2 = Double.parseDouble(args[2].toString()); // Nombre 2
                
                double result = 0.0;
                // Effectuer l'opération en fonction des paramètres
                switch (operation.toLowerCase()) {
                    case "addition":
                        result = number1 + number2;
                        break;
                    case "soustraction":
                        result = number1 - number2;
                        break;
                    case "multiplication":
                        result = number1 * number2;
                        break;
                    case "division":
                        if (number2 != 0) {
                            result = number1 / number2;
                        } else {
                            System.out.println("Erreur : Division par zéro.");
                            return;
                        }
                        break;
                    default:
                        System.out.println("Opération non reconnue. Veuillez utiliser : addition, soustraction, multiplication, ou division.");
                        return;
                }
                
                System.out.println("Résultat de l'opération " + operation + " : " + result);
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Les paramètres Nombre 1 et Nombre 2 doivent être numériques.");
            }
        } else {
            System.out.println("Veuillez fournir les paramètres dans cet ordre :");
            System.out.println("1. Opération (addition, soustraction, multiplication, division)");
            System.out.println("2. Nombre 1 (valeur numérique)");
            System.out.println("3. Nombre 2 (valeur numérique)");
        }
    }
}
