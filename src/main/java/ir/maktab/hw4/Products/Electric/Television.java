package ir.maktab.hw4.Products.Electric;

public class Television extends ElectricDevice {
    private String operatingSystemName;
    private boolean support3d;
    private int inch;
    private int cpuCores;
    private boolean webBrowser;
    private boolean dbbTuner;

    public Television(String name, int price, String category, String brand, double weight, int number, String soundSystem, int speakersNo, int outputSoundPower, boolean usbInput, boolean childLock, String operatingSystemName, boolean support3d, int inch, int cpuCores, boolean webBrowser, boolean dbbTuner) {
        super(name, price, category, brand, weight, number, soundSystem, speakersNo, outputSoundPower, usbInput, childLock);
        this.operatingSystemName = operatingSystemName;
        this.support3d = support3d;
        this.inch = inch;
        this.cpuCores = cpuCores;
        this.webBrowser = webBrowser;
        this.dbbTuner = dbbTuner;
    }

    public String getOperatingSystemName() {
        return operatingSystemName;
    }

    public void setOperatingSystemName(String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
    }

    public boolean isSupport3d() {
        return support3d;
    }

    public void setSupport3d(boolean support3d) {
        this.support3d = support3d;
    }

    public int getInch() {
        return inch;
    }

    public void setInch(int inch) {
        this.inch = inch;
    }

    public int getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(int cpuCores) {
        this.cpuCores = cpuCores;
    }

    public boolean isWebBrowser() {
        return webBrowser;
    }

    public void setWebBrowser(boolean webBrowser) {
        this.webBrowser = webBrowser;
    }

    public boolean isDbbTuner() {
        return dbbTuner;
    }

    public void setDbbTuner(boolean dbbTuner) {
        this.dbbTuner = dbbTuner;
    }
}
