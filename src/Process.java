import java.io.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.io.Serializable;
import java.util.Scanner;

public class Process {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, FileNotFoundException {
        Model model = (Model)Naming.lookup("rmi://localhost:8989/BookMethod");
        model.initData();
        Scanner input = new Scanner(System.in);
        System.out.print(menu());
        String choose = input.next();
        while (!choose.equals("0")) {
            switch (choose) {
                case "1" -> {
                    String ynControl = "n";
                    while (ynControl.equals("n") || ynControl.equals("N")) {
                        Car car = new Car();
                        System.out.print("Serial number of new car: ");  // 新车序列号
                        String carSerialNumber = input.next();
                        car.setCarSerialNumber(carSerialNumber);
                        System.out.print("Brand: ");  // 新车品牌
                        String carBrand = input.next();
                        car.setCarBrand(carBrand);
                        System.out.print("Model: ");  // 新车型号
                        String carModel = input.next();
                        car.setCarModel(carModel);
                        System.out.print("Color: ");  // 新车颜色
                        String carColor = input.next();
                        car.setCarColor(carColor);
                        System.out.print("Year: ");  // 新车年份
                        String carYear = input.next();
                        car.setCarYear(carYear);
                        System.out.print("Weight<kg>: ");  // 新车重量
                        String carWeight = input.next();
                        car.setCarWeight(carWeight);
                        System.out.print("Price: ");  // 新车价格
                        String carPrice = input.next();
                        car.setCarPrice(carPrice);

                        System.out.print("\n---------");
                        System.out.print("The information you entered");
                        System.out.print("---------\n");

                        System.out.println("Serial number of new car: " + car.getCarSerialNumber());
                        System.out.println("Brand: " + car.getCarBrand());
                        System.out.println("Model: " + car.getCarModel());
                        System.out.println("Color: " + car.getCarColor());
                        System.out.println("Year: " + car.getCarYear());
                        System.out.println("Weight<kg>: " + car.getCarWeight());
                        System.out.println("Price: " + car.getCarPrice());
                        System.out.print("yes[Y/N]? ");
                        ynControl = input.next();

                        String inputResult = "unCorrect";
                        while (inputResult.equals("unCorrect")) {
                            if (ynControl.equals("y") || ynControl.equals("Y")) {
                            if (model.addCar(car)) {
                                System.out.println("Car add successful. \n");
                            } else {
                                System.out.println("Car ddd Fail. \n");
                            }
                                break;
                            }
                            if (ynControl.equals("n") || ynControl.equals("N")) {
                                inputResult = "Correct";
                                continue;
                            }
                            System.out.print("Input error, please input again! yes[Y/N]? ");
                            ynControl = input.next();
                        }
                    }

                }
                case "2" -> {
                    String ynControl = "n";
                    while (ynControl.equals("n") || ynControl.equals("N")) {
                        Receipt receipt = new Receipt();
                        System.out.print("Receipt ID: ");  // 收据ID
                        String receiptID = input.next();
                        receipt.setReceiptID(receiptID);
                        System.out.print("Receipt purchaser: ");  // 购买人
                        String receiptPurchaser = input.next();
                        receipt.setReceiptPurchaser(receiptPurchaser);
                        System.out.print("Receipt date: ");  // 购买日期
                        String receiptDate = input.next();
                        receipt.setReceiptDate(receiptDate);
                        System.out.print("Serial number of car: ");  // 购买车辆编号
                        String carSerialNumber = input.next();
                        receipt.setCarSerialNumber(carSerialNumber);

                        System.out.print("\n---------");
                        System.out.print("The information you entered");
                        System.out.print("---------\n");

                        System.out.println("Receipt ID: " + receipt.getReceiptID());
                        System.out.println("Receipt purchaser: " + receipt.getReceiptPurchaser());
                        System.out.println("Receipt date: " + receipt.getReceiptDate());
                        System.out.println("Serial number of car: " + receipt.getCarSerialNumber());

                        System.out.print("yes[Y/N]? ");
                        ynControl = input.next();

                        String inputResult = "unCorrect";
                        while (inputResult.equals("unCorrect")) {
                            if (ynControl.equals("y") || ynControl.equals("Y")) {
                            if (model.addReceipt(receipt)) {
                                System.out.println("Receipt add successful. \n");
                            } else {
                                System.out.println("Receipt add Fail. \n");
                            }
                                break;
                            }
                            if (ynControl.equals("n") || ynControl.equals("N")) {
                                inputResult = "Correct";
                                continue;
                            }
                            System.out.print("Input error, please input again! yes[Y/N]? ");
                            ynControl = input.next();
                        }
                    }
                }
                case "3" -> {
                    System.out.println("please input book_name to query it\n");
                    String queryBookKeyword = input.next();
//                    BookList list = method.queryByName(queryBookKeyword);
//                    if (list != null) {
//                        System.out.println("*******book list *********\n");
//                        list.showInfo();
//                    } else {
//                        System.out.println("this book isnot existing");
//                    }
                }
                case "4" -> {
                    System.out.println("please input book_id to delete it\n");
                    int deleteID = input.nextInt();
//                    if (method.delete(deleteID)) {
//                        System.out.println("del sucessful\n");
//                    } else {
//                        System.out.println("del failed\n");
//                    }
                }
//                case 5 -> System.out.println(method.booksInfo());

                case "5" ->
                    System.out.print(" ");


                case "6" ->
                    System.out.print(" ");


                default -> System.out.println("Input error, please input again!\n");
            }

                System.out.print(menu());
                choose = input.next();

        }
        System.out.print("Application terminal. \n");
    }
    public static String menu() {
        return  "\n1. New car.\n"  // 注册一辆新车信息
                + "2. New reception.\n"  // 生成新的收据信息
                + "3. Search a car by serial number.\n" // 通过序列号搜索车辆信息
                + "4. Search a car by brand.\n" // 通过品牌搜索车辆信息
                + "5. Search a reception by ID.\n"  // 通过ID搜索发票信息
                + "6. Search a reception by  purchaser.\n"  // 通过购买者名字搜索发票信息
                + "0. Terminal.\n"  // 终止程序
                + "?  ";
    }
}
