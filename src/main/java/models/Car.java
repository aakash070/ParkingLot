package models;

/**
 * Created by hemant on 27/7/15.
 */
public class Car {
    private String regNum;
    private String model;
    
    public Car(){

    }

    public Car(String regNum, String model){
        this.regNum = regNum;
        this.model = model;
    }

    public String getRegNum() {
        return regNum;
    }

    public String getModel() {
        return model;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!regNum.equals(car.regNum)) return false;
        return model.equals(car.model);

    }

    @Override
    public int hashCode() {
        int result = regNum.hashCode();
        result = 31 * result + model.hashCode();
        return result;
    }
}

