public class Zoo{
    public void averageAge(Animal list[]){
        double sum = 0;
        for(int i = 0; i < list.length; i++){
            sum += list[i].getAge();
        }
        System.out.println("Average age of the animals: "+ sum/list.length);
    }

    public void displayDetails(Animal list[]){
        System.out.println("The list of animals:");
        for(int i = 0; i < list.length; i++){
            System.out.println("----------------------------------------------------------------");
            System.out.println("Name: "+ list[i].getName()+ " | Age: "+ list[i].getAge()+ " | Species: "+ list[i].getSpecies()+ " | Makes sounds like: \b");
            list[i].makeSound();
        }
    }
    public static void main(String[] args){
        Zoo zoo = new Zoo();
        Animal animals[] = new Animal[]{
            new Lion("Icardi", 30),
            new Elephant("Dombil", 15),
            new Giraffe("Ballor", 7),
            new Penguin("Kark", 3)
        };

        zoo.displayDetails(animals);
        System.out.println("");
        zoo.averageAge(animals);
    }
}
