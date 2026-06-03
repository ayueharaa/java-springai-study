package petshopmanager.src;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BathMachine bathMachine = new BathMachine();
        bathMachine.water_level = 18;
        bathMachine.soap_level = 20;
        bathMachine.have_pet = false;
        bathMachine.is_clean = true;

        new Main().menu(sc, bathMachine);
    }

    public void menu(Scanner sc, BathMachine bathMachine) {
        System.out.println("Welcome to bath machine center!");
        System.out.println("CURRENT MACHINE STATUS:");
        System.out.println("- Water Level: " + bathMachine.getWaterLevel());
        System.out.println("- Soap Level: " + bathMachine.getSoapLevel());
        System.out.println("- Have Pet: " + bathMachine.getHavePet());
        System.out.println("- Is Clean: " + bathMachine.getIsClean());
        System.out.println("-----------------------------");
        System.out.println("What would you like to do?");
        System.out.println("1. Fill water");
        System.out.println("2. Fill soap");
        System.out.println("3. Start bath");
        System.out.println("4. End bath");
        System.out.println("5. Start self cleaning mode");
        int menuOption = sc.nextInt();

        switch (menuOption){
            case 1:
                fillWater(sc, bathMachine);
                replayMenu(sc, bathMachine);
                break;
            case 2:
                fillSoap(sc, bathMachine);
                replayMenu(sc, bathMachine);
                break;
            case 3:
                startBath(bathMachine);
                replayMenu(sc, bathMachine);
                break;
            case 4:
                endBath(bathMachine);
                replayMenu(sc, bathMachine);
                break;
            case 5:
                selfCleaningMode(bathMachine);
                replayMenu(sc, bathMachine);
                break;
            
        }
    }

    public void replayMenu(Scanner sc, BathMachine bathMachine) {
        System.out.println("Would you like to perform another action? (Y/N)");
        String replayChoice = sc.next();
        if(replayChoice.equalsIgnoreCase("Y")) {
            menu(sc, bathMachine);
        } else {
            System.out.println("Thank you for using our services!");
        }
    }

    public void fillWater(Scanner sc, BathMachine bathMachine) {
        System.out.println("How many liters of water would you like to fill? (Max 2L at a time)");
        int amount = sc.nextInt();
        bathMachine.fillWater(amount);
    }

    public void fillSoap(Scanner sc, BathMachine bathMachine) {
        System.out.println("How many liters of soap would you like to fill? (Max 2L at a time)");
        int amount = sc.nextInt();
        bathMachine.fillSoap(amount);
    }

    public void startBath(BathMachine bathMachine) {
        bathMachine.giveBath();
    }

    public void endBath(BathMachine bathMachine) {
        bathMachine.toggleHavePet();
    }

    public void selfCleaningMode(BathMachine bathMachine) {
        bathMachine.cleanMachine();
    }

}
