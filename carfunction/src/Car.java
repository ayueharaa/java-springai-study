package carfunction.src;

public class Car {

    public boolean isRunning;
    public int speed;
    public int gear;

    public void getSpeed() {
        System.out.println(speed);
    }

    public void getIsRunning() {
        System.out.println(isRunning);
    }

    public void getGear() {
        System.out.println(gear);
    }

    public void toggleIsRunning() {
        if(this.isRunning==true &&( this.speed != 0 || this.gear != 0)) {
            System.out.println("Cannot turn off the car while it is moving or in gear.");
            return;
        }else{
            this.isRunning = !this.isRunning;
        }
    }

    public void increaseSpeed(int increment) {
        if(Math.abs(increment) > 20) {
            System.out.println("Cannot change speed by more than 20 units at a time due to gear change.");
            return;
        } else {
            if(this.speed + increment < 0) {
                this.speed = 0;
                System.out.println("Cannot decrease speed below 0.");
                changeGear();
            } else if (this.speed + increment >=120) {
                this.speed = 120;
                changeGear();
            }else {
                this.speed += increment;
                changeGear();
            }
        }
    }

    public void changeGear() {
        int newGear;

        if(this.speed > 0 && this.speed <= 20) {
            newGear = 1;
        } else if(this.speed > 20 && this.speed <= 40) {
            newGear = 2;
        } else if(this.speed > 40 && this.speed <= 60) {
            newGear = 3;
        } else if(this.speed > 60 && this.speed <= 80) {
            newGear = 4;
        } else if(this.speed >80 && this.speed <= 100) {
            newGear = 5;
        } else if(this.speed >100 && this.speed <= 120) {
            newGear = 6;
        } else {
            newGear = 0;
        }
        if (Math.abs(this.gear - newGear)!= 1) {
            System.out.println("Cannot change to gear " + newGear + " from gear " + this.gear + " due to speed.");
        } else {
            this.gear = newGear;
        }
    }

}
