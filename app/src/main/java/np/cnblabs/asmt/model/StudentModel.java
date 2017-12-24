package np.cnblabs.asmt.model;

/**
 * Created by sanjogstha on 12/15/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class StudentModel {
    private String name, address;
    private int roll, phone;

    public StudentModel(String name, String address,
                        int roll, int phone){
        this.name = name;
        this.address = address;
        this.roll = roll;
        this.phone = phone;
    }

    public StudentModel(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
