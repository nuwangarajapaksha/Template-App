/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author NUWAA
 */
abstract class Steps { // Template Class

    String[] info = new String[7];

    public void name(String name) {
        info[0] = name;
    }

    public void address(String address) {
        info[2] = address;
    }

    public void contactNo(String contactNo) {
        info[6] = contactNo;
    }

    public abstract void input2(String data2);
    public abstract void input4(String data4);

    void process(String name, String data2, String address, String data4, String contactNo) { //Template Method
        name(name);
        input2(data2);
        address(address);
        
        if (doInput4()) {
            input4(data4);
        }
        
        contactNo(contactNo);

        MemberDetails md = new MemberDetails(info);
        md.setVisible(true);
    }

    public boolean doInput4() {
        return true;
    }

}

class Adult extends Steps {

    @Override
    public void input2(String nic) {
        info[1] = nic;
    }

    @Override
    public void input4(String workPlace) {
        info[3] = workPlace;

    }

}

class Child extends Steps {

    @Override
    public void input2(String parent) {
        info[5] = parent;
    }

    @Override
    public void input4(String school) {
        info[4] = school;
    }

}

public class Context {

    Adult adult1 = new Adult() {
        @Override
        public boolean doInput4() {
            return true;
        }
    };
    
    Adult adult2 = new Adult() {
        @Override
        public boolean doInput4() {
            return false;
        }
    };
    
    Child child1 = new Child();
    
}
