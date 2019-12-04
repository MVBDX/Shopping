package ir.maktab.hw4.Products.Electric;

import ir.maktab.hw4.Products.Product;

public abstract class ElectricDevice extends Product {
    private String soundSystem;
    private int speakersNo;
    private int outputSoundPower;
    private boolean usbInput;
    private boolean childLock;

    public ElectricDevice(String name, int price, String category, String brand, double weight, int number, String soundSystem, int speakersNo, int outputSoundPower, boolean usbInput, boolean childLock) {
        super(name, price, category, brand, weight, number);
        this.soundSystem = soundSystem;
        this.speakersNo = speakersNo;
        this.outputSoundPower = outputSoundPower;
        this.usbInput = usbInput;
        this.childLock = childLock;
    }

    public String getSoundSystem() {
        return soundSystem;
    }

    public void setSoundSystem(String soundSystem) {
        this.soundSystem = soundSystem;
    }

    public int getSpeakersNo() {
        return speakersNo;
    }

    public void setSpeakersNo(int speakersNo) {
        this.speakersNo = speakersNo;
    }

    public int getOutputSoundPower() {
        return outputSoundPower;
    }

    public void setOutputSoundPower(int outputSoundPower) {
        this.outputSoundPower = outputSoundPower;
    }

    public boolean isUsbInput() {
        return usbInput;
    }

    public void setUsbInput(boolean usbInput) {
        this.usbInput = usbInput;
    }

    public boolean isChildLock() {
        return childLock;
    }

    public void setChildLock(boolean childLock) {
        this.childLock = childLock;
    }
}
