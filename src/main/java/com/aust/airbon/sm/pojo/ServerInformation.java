package com.aust.airbon.sm.pojo;

/**
 * Created by no one on 2017/12/24.
 *
 */
public class ServerInformation {

    private String CPU;             //模拟的CPU型号
    private int memory;             //模拟的内存大小
    private int disk;               //模拟的磁盘空间

    private String IP;              //虚拟服务器IP地址, 唯一标识
    private int maxAllowedThreads;  //能运行的最大线程数

    /*运行状态，会随系统随时改变 */
    private boolean online;         //虚拟服务器的状态，online时Socket服务正常运行，offline关闭
    private int usedCPU;            //CPU使用率
    private int usedMemory;         //内存状态
    private int usedDisk;           //磁盘使用量
    private int currentThreads;     //当前运行的线程数

    private ServerInformation() {
    }

    public ServerInformation(String CPU, int memory, int disk, String IP, int maxAllowedThreads,
                             boolean online, int usedCPU, int usedMemory, int usedDisk, int currentThreads) {
        this.CPU = CPU;
        this.memory = memory;
        this.disk = disk;
        this.IP = IP;
        this.maxAllowedThreads = maxAllowedThreads;
        this.online = online;
        this.usedCPU = usedCPU;
        this.usedMemory = usedMemory;
        this.usedDisk = usedDisk;
        this.currentThreads = currentThreads;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getMaxAllowedThreads() {
        return maxAllowedThreads;
    }

    public void setMaxAllowedThreads(int maxAllowedThreads) {
        this.maxAllowedThreads = maxAllowedThreads;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public int getUsedCPU() {
        return usedCPU;
    }

    public void setUsedCPU(int usedCPU) {
        this.usedCPU = usedCPU;
    }

    public int getUsedDisk() {
        return usedDisk;
    }

    public void setUsedDisk(int usedDisk) {
        this.usedDisk = usedDisk;
    }

    public int getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(int usedMemory) {
        this.usedMemory = usedMemory;
    }

    public int getCurrentThreads() {
        return currentThreads;
    }

    public void setCurrentThreads(int currentThreads) {
        this.currentThreads = currentThreads;
    }

}
