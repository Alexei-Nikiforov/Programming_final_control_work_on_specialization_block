import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PetRegistry {
    private List<Animals> animals = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void registerPet(Counters counter) {
        System.out.print("Введите тип животного (Camel/Cat/Dog/Donkey/Hamster/Horse): ");
        String type = scanner.nextLine();
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        Animals animal;
        switch (type) {
            case "Camel":
                animal = new Camels(name);
                break;
            case "Cat":
                animal = new Cats(name);
                break;
            case "Dog":
                animal = new Dogs(name);
                 break;
            case "Donkey":
                animal = new Donkeys(name);
                break;
            case "Hamster":
                animal = new Hamsters(name);
                break;
            case "Horse":
                animal = new Horses(name);
                break;
            default:
                throw new IllegalStateException("Не получилось зарегистрировать животное. Неизвестный тип животного: " + type);
        }

        if (animal != null) {
            animals.add(animal);
            counter.add();
            System.out.println("Животное " + animal.getName() + " добавлено.");
        }
    }

    public void listCommands() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        boolean flag = true;

        for (Animals animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.println("Список команд для " + animal.getName() + " следующий: " + animal.getCommands());
                flag = false;
                return;
            }
        }

        if (flag) {
            System.out.println("Животное не найдено.");
        }   
    }

    public void teachCommand() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        for (Animals animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.print("Введите новую обученную команду: ");
                String command = scanner.nextLine();
                animal.addCommands(command);
                System.out.println("Животное " + animal.getName() + " обучено команде: " + command);
                return;
            } else {
                System.out.println("Животное не найдено.");
            }
        }
    }

    public void showMenu() {
        System.out.println("   Выберите пункт из меню:");
        System.out.println("1. Завести новое животное");
        System.out.println("2. Показать список команд животного");
        System.out.println("3. Обучить животное новой команде");
        System.out.println("4. Выйти");
    }
}