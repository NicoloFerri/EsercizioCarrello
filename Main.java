package javabasics.Online_shopping_cart;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class Main {
    private static List<Product> carrello = new ArrayList<>();
    // dichiaro la variabile carerllo all'interno della classe ma fuori dal main perche altriemnti potrebbe essere utilizzata solo
    //all'interno del main dato che è del tipo static
    //in questo modo può essere utilizzata da tutti i metodi della classe

    public static void main(String[] args) {

        //dichiaro e inizializzo una lista per i prodotti e i relativi prezzi
        ArrayList<String> list = new ArrayList<>();
        list.add("Pizza");
        list.add("Hamburger");
        list.add("Acqua");
        list.add("Coca-Cola");
        list.add("Biscotti");
        list.add("Gelato");

        ArrayList<Double> prezzo = new ArrayList<>();
        prezzo.add(5.50);
        prezzo.add(3.50);
        prezzo.add(6.50);
        prezzo.add(1.50);
        prezzo.add(2.50);
        prezzo.add(4.50);

        int l=list.size();

        Scanner scanner = new Scanner(System.in);
        int counter = 0;

        System.out.println("Welcome to the Online Shopping Cart!");

        while (counter != 5) {
            System.out.println("1) Mostra i prodotti all'interno del carrello");
            System.out.println("2) Aggiungi un prodotto al carrello");
            System.out.println("3) Rimuovi un prodotto dal carrello");
            System.out.println("4) Calcola il costo totale della spesa");
            System.out.println("5) Esci!");

            System.out.print("Scegli cosa fare : ");
            counter = scanner.nextInt();
            scanner.nextLine();

            switch (counter) {
                case 1:
                    VisualizzazzioneCarrello();
                    break;
                case 2:
                    aggiuntaProdotto(scanner,l,list,prezzo);
                    break;
                case 3:
                    rimozioneProdotto(scanner);
                    break;
                case 4:
                    calcoloCostoTotale();
                    break;
                case 5:
                    System.out.println("Grazie e arrivederci");
                    break;
                default:
                    System.out.println("Inserimento non corretto, riprova");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void VisualizzazzioneCarrello() {
        if (carrello.isEmpty()) {
            System.out.println("Il tuo carrello è vuoto. Aggiungi qualcosa!");
        } else {
            System.out.println("Prodotti presenti nel carrello = ");
            int index = 1;
            for (Product product : carrello) {
                System.out.println(index + ") Prodotto : " + product.getName() + ", Prezzo = " + product.getPrice()
                        + "€ , Quantità: " + product.getQuantity());
                index++;
            }
        }
    }

    private static void aggiuntaProdotto(Scanner scanner , int l , List<String> x , List<Double> y) {
        System.out.println("Questi sono i prosotti che puoi acquistare con il prezzo affianco : ");
       for ( int i=0 ; i<l ; i++){
           System.out.println((i+1)+") " +x.get(i)+  " " + y.get(i));
       }
        System.out.print("Inserisci il numero corrispondente : ");
        int number = scanner.nextInt();

        System.out.print("inserisci la quantità che vuoi : ");
        int quantity = scanner.nextInt();

        // qua avevo un problema perche x.get() è un oggetto e le variabili chge devo passare all'oggetto prodotto
        //sono String e double, si risolve mettendo List<String> e List<Double> quando dichiaro le variabili che utilizzo
        // dentro la funzione addProduct
        Product product = new Product(x.get(number-1), y.get(number-1), quantity);
        carrello.add(product);

        System.out.println("Ho aggiunto " + quantity + " unità di " + x.get(number-1) + " al carrello");
    }

    private static void rimozioneProdotto(Scanner scanner) {
        System.out.print("Scegli quale prodotto rimuovere dal carrello inserendo il nome del prodotto: ");
        VisualizzazzioneCarrello();
        String name = scanner.nextLine();

        boolean removed = false;
        for (Product product : carrello) {
            if (product.getName().equalsIgnoreCase(name)) {
                carrello.remove(product);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Il prodotto '" + name + " è stato rimosso con successod al carrello");
        } else {
            System.out.println("Il prodotto che hai inserito non è presente nel carrello");
        }
    }

    private static void calcoloCostoTotale() {
        double totalCost = 0;
        for (Product product : carrello) {
            totalCost += product.getTotalPrice();
        }

        System.out.println("Il costo totale degli elementi del carrello è : " + totalCost + "€");
    }
}