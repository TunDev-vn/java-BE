package buoi7.btvn.bai1;

import java.util.Scanner;

public class ManagerAnimal {

    private Animal[] animals;
    // số lượng con vật hiện tại
    private int currentAnimal;
    // tổng số lượng con con vật có thể chứa trong mảng
    private int totalAnimal;
    // tạo ra 1 biến hằng với giá trị mặc định = 10
    private final int DEFAULT_NEW_SIZE = 10;

    // Khoi tao doi tương, cac gia tri trong object
    public ManagerAnimal(int totalAnimal){
        this.totalAnimal = totalAnimal;
        animals = new Animal[this.totalAnimal];
    }

    public void search(){
        System.out.println("Nhập tên động vật: ");
        String name = new Scanner(System.in).nextLine();
        for (int i = 0; i < currentAnimal; i++) {
//            if (animals[i].getName().equals(name))
            // nếu tên nhập vào không trùng tên của phần tử i => bỏ qua và tiếp tục
            if (!name.equalsIgnoreCase(animals[i].getName())){
                continue;
            }
            System.out.println("Đã tìm thấy tại index: " + i);
            animals[i].showInfo();
        }
    }

    public void delete(){
        System.out.println("Nhập tên động vật để xóa: ");
        String name = new Scanner(System.in).nextLine();
        for (int i = 0; i < currentAnimal; i++) {
            if (animals[i] == null){
                continue;
            }
            // nếu tên con vật tại phần tử thứ i không trùng với tên được nhập vào => tiếp tục duyệt
            if (!name.equalsIgnoreCase(animals[i].getName())){
                continue;
            }
            // trùng => xóa
            for (int j = i; j < currentAnimal; j++) {
                if (j == currentAnimal - 1){
                     animals[j] = null;
                }else {
                    // xóa
                    animals[j] = animals[j + 1];
                }
            }
            this.currentAnimal--;
        }
    }

    public void addAnimal(){
        System.out.println("Nhap vao loai dong vat muon them: ");
        int type = 0;
        do {
            System.out.println("1: Lion");
            System.out.println("2: Elephant");
            System.out.println("3: Monkey");
            System.out.println("4: Dừng nhập");
            type = new Scanner(System.in).nextInt();
            Animal animal = null;
            switch (type){
                case 1:
                    animal = new Lion();
                    break;
                case 2:
                    animal = new Elephant();
                    break;
                case 3:
                    animal = new Monkey();
                    break;
                case 4:
                    System.out.println("Dừng nhập!");
                    break;
                default:
                    System.out.println("Nhập sai định dạng, đề nghị nhập lại");
                    type = 1;
            }
            if (animal != null){
                animal.enterInfo();
                reSizeArrayAnimal();
                this.animals[currentAnimal] = animal;
                this.currentAnimal++;
                System.out.println("Đã thêm con vật thứ :" + currentAnimal + " thành công");
            }
        }while (type < 4);
    }
    public void reSizeArrayAnimal(){
        // nếu trường hợp đã đầy số lượng phần tử của mảng = số lượng phần tử hiện tại
        if (currentAnimal == totalAnimal){
            // mở rộng mảng theo yêu cầu ý d
            this.totalAnimal = this.totalAnimal + DEFAULT_NEW_SIZE;
            // copy lại mảng sang mang mới
            this.animals = copyArray(totalAnimal,this.animals);
        }
    }
    public Animal[] copyArray(int newSize,Animal[] oldArray){
        Animal[] newArray = new Animal[newSize];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    public void showAllAnimal(){
        for (int i = 0; i < currentAnimal; i++) {
            if (animals[i] == null){
                continue;
            }
            System.out.println("------------- animal: " + i);
            animals[i].showInfo();
        }
    }

}
