package petshopmanager.src;

public class BathMachine {

    public int water_level;
    public int soap_level;
    public boolean have_pet;
    public boolean is_clean;

    public int getWaterLevel() {
        return water_level;
    }

    public int getSoapLevel() {
        return soap_level;
    }

    public boolean getHavePet() {
        return have_pet;
    }

    public boolean getIsClean() {
        return is_clean;
    }

    public void toggleHavePet() {
        this.have_pet = !this.have_pet;
    }

    public void fillWater(int amount) {
        if(this.water_level + amount < 30){
            if(amount > 2){
                System.out.println("Cannot fill more than 2L of water at a time.");
                this.water_level += 2;
                return;
            }else {
                this.water_level += amount;
            }
        }else {
            if(amount > 2){
                System.out.println("Cannot fill more than 2L of water at a time and the machine water reservatory will be too full. Returning excess...");
                this.water_level = 30;
                return;
            }else {
                this.water_level = 30;
            }
        }   
    }

    public void fillSoap(int amount) {
        if(this.soap_level + amount < 10){
            if(amount > 2){
                System.out.println("Cannot fill more than 2L of soap at a time.");
                this.soap_level += 2;
                return;
            }else {
                this.soap_level += amount;
            }
        }else {
            if(amount > 2){
                System.out.println("Cannot fill more than 2L of soap at a time and the machine soap reservatory will be too full. Returning excess...");
                this.soap_level = 10;
                return;
            }else {
                this.soap_level = 10;
            }
        }      
    }

    public void giveBath(){
        if(this.water_level < 10 || this.soap_level < 2){
            System.out.println("Not enough water or soap to give a bath.");
            return;
        } else if (this.is_clean == false){
            System.out.println("The machine is not clean. Please clean the machine before giving a bath.");
            return;
        }else{
            this.toggleHavePet();
            this.is_clean = false;
            this.water_level -= 10;
            this.soap_level -= 2;
        }
    }

    public void cleanMachine(){
        if(this.water_level < 3 || this.soap_level < 1){
            System.out.println("Not enough water or soap to clean the machine.");
            return;
        }else{
            this.water_level -= 3;
            this.soap_level -= 1;
            this.is_clean = true;
        }
    }

}
