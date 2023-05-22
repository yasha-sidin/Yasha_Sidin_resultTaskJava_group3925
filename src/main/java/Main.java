
import java.util.*;

import static java.util.Arrays.*;

public class Main {
    public static void main(String[] args) {

        LinkedList<Laptop> laptopsData = new LinkedList<Laptop>(asList(
                new Laptop(1, "Samsung", "Black", 6, 1000, "Windows", 20000, 15, 80000),
                new Laptop(2, "Lenovo", "White", 6, 500, "Windows", 25000, 20, 30000),
                new Laptop(3, "Apple", "Yellow", 4, 1000, "Windows", 26000, 19, 45000),
                new Laptop(4, "Apple", "Black", 6, 1000, "Windows", 28000, 15, 29000),
                new Laptop(5, "Apple", "Black", 8, 500, "Windows", 20000, 19, 80000),
                new Laptop(6, "Samsung", "Black", 8, 1000, "Windows", 20000, 20, 39000),
                new Laptop(7, "Samsung", "Red", 8, 1000, "Windows", 25000, 19, 80000),
                new Laptop(8, "Tecno", "White", 6, 2000, "Windows", 29000, 17, 60000),
                new Laptop(9, "Samsung", "White", 2, 250, "Windows", 20000, 21, 20000),
                new Laptop(10, "Lenovo", "White", 8, 1000, "Windows", 27000, 18, 100000),
                new Laptop(11, "Lenovo", "Black", 16, 1000, "Windows", 22000, 14, 150000),
                new Laptop(12, "Apple", "Yellow", 16, 1000, "Windows", 30000, 20, 100000),
                new Laptop(13, "Samsung", "White", 16, 1000, "Windows", 27000, 20, 110000)
        ));

        LinkedList<String> filterParams = new LinkedList<>(Arrays.asList(
                1 + " -> Brand" + "\n",
                2 + " -> Color" + "\n",
                3 + " -> SystemMemory" + "\n",
                4 + " -> HardDiskCapacity" + "\n",
                5 + " -> OperatingSystem" + "\n",
                6 + " -> VolumeOfAccumulator" + "\n",
                7 + " -> Diagonal" + "\n",
                8 + " -> Salary" + "\n"
        ));

        List<Integer> commandList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        while (true) {
            Scanner iScanner = new Scanner(System.in);
            System.out.print("По скольким параметрам вы хотите отфильтровать ноутбуки?(MAX = 8): ");
            try {
                int whichTimesToFilter = iScanner.nextInt();
                if (whichTimesToFilter >= 0 && whichTimesToFilter <= 8) {
                    LinkedList<String> filterParamsInCicle = new LinkedList<>();
                    filterParamsInCicle.addAll(filterParams);
                    List<Integer> commandListInCicle = new LinkedList<>();
                    commandListInCicle.addAll(commandList);
                    LinkedList<Laptop> laptopsFiltered = new LinkedList<>();
                    laptopsFiltered.addAll(laptopsData);
                    for (int i = 0; i < whichTimesToFilter; i++) {
                        System.out.println("Параметры:");
                        for(String item : filterParamsInCicle) {
                            System.out.print(item);
                        }
                        System.out.printf("Выберите %d-й параметр фильтрации: ", i + 1);
                        int filterParam = iScanner.nextInt();

                        if (1 <= filterParam && filterParam <= 8 && !commandListInCicle.contains(filterParam)) {
                            System.out.println("Вы уже использовали данный фильтр, попробуйте еще раз");
                            i--;
                        }

                        if (1 <= filterParam && filterParam <= 8 && commandListInCicle.contains(filterParam)) {
                            if (filterParam == 1) {
                                System.out.print("Введите название бренда(in english): ");
                                String brand = iScanner.next();
                                laptopsFiltered = filterBrand(brand, laptopsFiltered);
                                filterParamsInCicle.remove(filterParamsInCicle.lastIndexOf(1 + " -> Brand" + "\n"));
                            }
                            if (filterParam == 2) {
                                System.out.print("Введите цвет(in english): ");
                                String color = iScanner.next();
                                laptopsFiltered = filterColor(color, laptopsFiltered);
                                filterParamsInCicle.remove(filterParamsInCicle.lastIndexOf(2 + " -> Color" + "\n"));
                            }
                            if (filterParam == 3) {
                                System.out.print("Введите минимальное значение оперативной памяти: ");
                                int minRange = iScanner.nextInt();
                                System.out.print("Введите максимальное значение оперативной памяти: ");
                                int maxRange = iScanner.nextInt();
                                laptopsFiltered = filterSystemMemory(minRange, maxRange, laptopsFiltered);
                                filterParamsInCicle.remove(filterParamsInCicle.lastIndexOf(3 + " -> SystemMemory" + "\n"));
                            }
                            if (filterParam == 4) {
                                System.out.print("Введите минимальное значение пямяти: ");
                                int minRange = iScanner.nextInt();
                                System.out.print("Введите максимальное значение памяти: ");
                                int maxRange = iScanner.nextInt();
                                laptopsFiltered = filterHardDiskCapacity(minRange, maxRange, laptopsFiltered);
                                filterParamsInCicle.remove(filterParamsInCicle.lastIndexOf(4 + " -> HardDiskCapacity" + "\n"));
                            }
                            if (filterParam == 5) {
                                System.out.print("Введите название операционной системы(in english): ");
                                String operatingSystem = iScanner.next();
                                laptopsFiltered = filterOperatingSystem(operatingSystem, laptopsFiltered);
                                filterParamsInCicle.remove(filterParamsInCicle.lastIndexOf(5 + " -> OperatingSystem" + "\n"));
                            }
                            if (filterParam == 6) {
                                System.out.print("Введите минимальное значение ёмкости аккумулятора: ");
                                int minRange = iScanner.nextInt();
                                System.out.print("Введите максимальное значение ёмкости аккумулятора: ");
                                int maxRange = iScanner.nextInt();
                                laptopsFiltered = filterVolumeOfAccumulator(minRange, maxRange, laptopsFiltered);
                                filterParamsInCicle.remove(filterParamsInCicle.lastIndexOf(6 + " -> VolumeOfAccumulator" + "\n"));
                            }
                            if (filterParam == 7) {
                                System.out.print("Введите минимальное значение диагонали: ");
                                int minRange = iScanner.nextInt();
                                System.out.print("Введите максимальное значение диагонали: ");
                                int maxRange = iScanner.nextInt();
                                laptopsFiltered = filterDiagonal(minRange, maxRange, laptopsFiltered);
                                filterParamsInCicle.remove(filterParamsInCicle.lastIndexOf(7 + " -> Diagonal" + "\n"));
                            }
                            if (filterParam == 8) {
                                System.out.print("Введите минимальное значение цены: ");
                                int minRange = iScanner.nextInt();
                                System.out.print("Введите максимальное значение цены: ");
                                int maxRange = iScanner.nextInt();
                                laptopsFiltered = filterSalary(minRange, maxRange, laptopsFiltered);
                                filterParamsInCicle.remove(filterParamsInCicle.lastIndexOf(8 + " -> Salary" + "\n"));
                            }
                            commandListInCicle.remove(commandList.indexOf(filterParam));
                        }
                        if (1 > filterParam || filterParam > 8) {
                            System.out.println("Такого фильтра нет, попробуйте еще раз");
                            i--;
                        }
                    }
                    if (laptopsFiltered.isEmpty()) {
                        System.out.println("К сожалению, нет ноутбуков, подходяхих под данные фильтры");
                    } else {
                        System.out.println("Вот вариант(ы), подходящий(ие) под фильтр(ы): ");
                        printLaptops(laptopsFiltered);
                    }
                } else {
                    System.out.println("Всего фильтров 8, попробуйте еще раз");
                }
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели не целое число, попробуйте еще раз");
            }
        }
    }

    public static LinkedList<Laptop> filterBrand(String brand, List<Laptop> laptopsData) {
        LinkedList filteredList = new LinkedList<>();
        for (Laptop item : laptopsData) {
            if(item.brand.toLowerCase().equals(brand.toLowerCase())) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }
    public static LinkedList<Laptop> filterColor(String color, List<Laptop> laptopsData) {
        LinkedList filteredList = new LinkedList<>();
        for (Laptop item : laptopsData) {
            if(item.color.toLowerCase().equals(color.toLowerCase())) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    public static LinkedList<Laptop> filterSystemMemory(int minRange, int maxRange, List<Laptop> laptopsData) {
        LinkedList filteredList = new LinkedList<>();
        for (Laptop item : laptopsData) {
            if(minRange <= item.systemMemory && item.systemMemory <= maxRange) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    public static LinkedList<Laptop> filterHardDiskCapacity(int minRange, int maxRange, List<Laptop> laptopsData) {
        LinkedList filteredList = new LinkedList<>();
        for (Laptop item : laptopsData) {
            if(minRange <= item.hardDiskCapacity && item.hardDiskCapacity <= maxRange) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    public static LinkedList<Laptop> filterOperatingSystem(String operatingSystem, List<Laptop> laptopsData) {
        LinkedList filteredList = new LinkedList<>();
        for (Laptop item : laptopsData) {
            if(item.operatingSystem.toLowerCase().equals(operatingSystem.toLowerCase())) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    public static LinkedList<Laptop> filterVolumeOfAccumulator(int minRange, int maxRange, List<Laptop> laptopsData) {
        LinkedList filteredList = new LinkedList<>();
        for (Laptop item : laptopsData) {
            if(minRange <= item.volumeOfAccumulator && item.volumeOfAccumulator <= maxRange) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    public static LinkedList<Laptop> filterDiagonal(int minRange, int maxRange, List<Laptop> laptopsData) {
        LinkedList filteredList = new LinkedList<>();
        for (Laptop item : laptopsData) {
            if(minRange <= item.diagonal && item.diagonal <= maxRange) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    public static LinkedList<Laptop> filterSalary(int minRange, int maxRange, List<Laptop> laptopsData) {
        LinkedList filteredList = new LinkedList<>();
        for (Laptop item : laptopsData) {
            if(minRange <= item.salary && item.salary <= maxRange) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    public static void printLaptops(List<Laptop> laptops) {
        for (Laptop item : laptops) {
            System.out.print("{");
            System.out.printf(
                    "\"brand\": %s, " +
                            "\"color\": %s, " +
                            "\"systemMemory\": %d, " +
                            "\"hardDiskCapacity\": %d, " +
                            "\"operatingSystem\": %s, " +
                            "\"volumeOfAccumulator\": %d, " +
                            "\"diagonal\": %d, \"salary\": %d",
                    item.brand,
                    item.color,
                    item.systemMemory,
                    item.hardDiskCapacity,
                    item.operatingSystem,
                    item.volumeOfAccumulator,
                    item.diagonal,
                    item.salary
            );
            System.out.println("}");
        }
    }





}
