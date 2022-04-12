/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.dao;

import vendingmachine.dto.Drink;

import java.io.*;
import java.util.*;
import vendingmachine.dto.Change;

/**
 *
 * @author 17202
 */
public class VendingMachineFI implements VendingMachineDao {
    public final String DRINKS_FILE;
    public static final String DELIMITER = "::";

    public VendingMachineFI(){
        DRINKS_FILE = "drinks.txt";
    }

    public VendingMachineFI(String textFile){
        DRINKS_FILE = textFile;
    }

    private Map<String, Drink> drinks = new HashMap<>();
    
    Change userMoney = new Change(0);
    
    //change method

    
    public void addMoney(int amount) {
        this.userMoney.setTotal(userMoney.getTotal()+amount);
    }
    
    public double viewMoney() {
        return userMoney.getTotal()/100;
    }

    @Override
    public Drink addDrink(Drink drink) throws VendingMachineDaoEx {
        loadDrinks();
        Drink newDrink = drinks.put(drink.getName(), drink);
        writeDrinks();
        return newDrink;
    }

    @Override
    public List<Drink> getAllDrinks() throws VendingMachineDaoEx {
        loadDrinks();
        return new ArrayList(drinks.values());
    }

    @Override
    public Drink getDrink(String name) throws VendingMachineDaoEx {
        loadDrinks();
        return drinks.get(name);
    }

    @Override
    public Drink removeDrink(String name) throws VendingMachineDaoEx  {
        loadDrinks();
        Drink removedDrink = drinks.remove(name);
        writeDrinks();
        return removedDrink;
    }

    @Override
    public Drink stockDrink(Drink drink, int quantity) throws VendingMachineDaoEx {
        int temp = drink.getQuantity();
        drink.setQuantity(temp + quantity);

        return addDrink(drink);
    }

    @Override
    public Drink sellDrink(Drink drink) throws VendingMachineDaoEx {
        int temp = drink.getQuantity();
        drink.setQuantity(temp - 1);

        return addDrink(drink);
    }

    private Drink unmarshallDrink(String drinkAsText){
        String[] drinkTokens = drinkAsText.split(DELIMITER);

        // Given the pattern above, the drink name is in index 0 of the array.
        String drinkName = drinkTokens[0];

        // Which we can then use to create a new Drink object to satisfy
        // the requirements of the Drink constructor.
        Drink drinkFromFile = new Drink(drinkName);


        // Index 1 - Price
        drinkFromFile.setPrice(Integer.parseInt(drinkTokens[1]));

        // Index 2 - Quantity
        drinkFromFile.setQuantity(Integer.parseInt(drinkTokens[2]));

        // Index 3 - Change
//        drinkFromFile.setChange(Integer.parseInt(drinkTokens[3]);

        // We have now created a drink! Return it!
        return drinkFromFile;
    }

    public void loadDrinks() throws VendingMachineDaoEx {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DRINKS_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachineDaoEx(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        Drink currentDrink;
        // Go through ROSTER_FILE line by line, decoding each line into a
        // Drink object by calling the unmarshallDrink method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Drink
            currentDrink = unmarshallDrink(currentLine);

            // We are going to use the student id as the map key for our drink object.
            // Put currentDrink into the map using name as the key
            drinks.put(currentDrink.getName(), currentDrink);
        }
        // close scanner
        scanner.close();
    }

    private String marshallDrink(Drink aDrink){
        // We need to turn a Drink object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // coke::129::5

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer.

        // Start with the drink name, since that's supposed to be first.
        String drinkAsText = aDrink.getName() + DELIMITER;

        // add the rest of the properties in the correct order:

        // Price
        drinkAsText += aDrink.getPricePenny() + DELIMITER;

        // Quantity
        drinkAsText += aDrink.getQuantity();

        // Change - don't forget to skip the DELIMITER here.
//        drinkAsText += aDrink.getChange();

        // We have now turned a drink to text! Return it!
        return drinkAsText;
    }

    private void writeDrinks() throws VendingMachineDaoEx {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DRINKS_FILE));
        } catch (IOException e) {
            throw new VendingMachineDaoEx(
                    "Could not save student data.", e);
        }

        // Write out the Drinks objects to the Drinks file.
        // NOTE TO THE APPRENTICES: We could just grab the drink map,
        // get the Collection of Drinks and iterate over them but we've
        // already created a method that gets a List of Drinks so
        // we'll reuse it.
        String drinkAsText;
        List<Drink> drinkList = this.getAllDrinks();
        for (Drink currDrink : drinkList) {
            // turn a Drink into a String
            drinkAsText = marshallDrink(currDrink);
            // write the Drink object to the file
            out.println(drinkAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
