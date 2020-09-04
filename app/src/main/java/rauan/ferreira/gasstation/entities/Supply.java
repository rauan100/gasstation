package rauan.ferreira.gasstation.entities;

public class Supply {
    private int id;
    private String vehicleName;
    private Float gasPrice;
    private Float litters;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Float getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(Float gasPrice) {
        this.gasPrice = gasPrice;
    }

    public Float getLitters() {
        return litters;
    }

    public void setLitters(Float litters) {
        this.litters = litters;
    }

    public Float getTotal() {
        return gasPrice * litters;
    }
}
