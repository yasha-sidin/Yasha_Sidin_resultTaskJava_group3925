
import java.util.*;

public class Laptop {
    public int id;
    public String brand;
    public String color;
    public int systemMemory;
    public int hardDiskCapacity;
    public String operatingSystem;
    public int volumeOfAccumulator;
    public int diagonal;
    public long salary;

    public Laptop (int id, String brand, String color, int systemMemory, int hardDiskCapacity, String operatingSystem, int volumeOfAccumulator, int diagonal, long salary) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.systemMemory = systemMemory;
        this.hardDiskCapacity = hardDiskCapacity;
        this.operatingSystem = operatingSystem;
        this.volumeOfAccumulator = volumeOfAccumulator;
        this.diagonal = diagonal;
        this.salary = salary;

    }

    @Override
    public String toString() {
        LinkedHashMap laptopMap = new LinkedHashMap<>();
        laptopMap.put("brand", brand);
        laptopMap.put("color", color);
        laptopMap.put("systemMemory", systemMemory);
        laptopMap.put("hardDiskCapacity", hardDiskCapacity);
        laptopMap.put("operatingSystem", operatingSystem);
        laptopMap.put("volumeOfAccumulator", volumeOfAccumulator);
        laptopMap.put("diagonal", diagonal);
        laptopMap.put("salary", salary);
        return laptopMap.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, color, systemMemory, hardDiskCapacity, operatingSystem, volumeOfAccumulator, diagonal, salary);
    }
}
