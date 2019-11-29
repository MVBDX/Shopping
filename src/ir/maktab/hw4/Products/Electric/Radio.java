package ir.maktab.hw4.Products.Electric;

public class Radio extends ElectricDevice {
    private boolean headphoneOutput;
    private boolean recordCassette;
    private int batteryNo;

    public Radio(String name, int price, String category, String brand, double weight, int number, String soundSystem, int speakersNo, int outputSoundPower, boolean usbInput, boolean childLock, boolean headphoneOutput, boolean recordCassette, int batteryNo) {
        super(name, price, category, brand, weight, number, soundSystem, speakersNo, outputSoundPower, usbInput, childLock);
        this.headphoneOutput = headphoneOutput;
        this.recordCassette = recordCassette;
        this.batteryNo = batteryNo;
    }

    public boolean isHeadphoneOutput() {
        return headphoneOutput;
    }

    public void setHeadphoneOutput(boolean headphoneOutput) {
        this.headphoneOutput = headphoneOutput;
    }

    public boolean isRecordCassette() {
        return recordCassette;
    }

    public void setRecordCassette(boolean recordCassette) {
        this.recordCassette = recordCassette;
    }

    public int getBatteryNo() {
        return batteryNo;
    }

    public void setBatteryNo(int batteryNo) {
        this.batteryNo = batteryNo;
    }
}
