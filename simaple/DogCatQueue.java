package code_03.simaple;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DogCatQueue {

    public static class Pet{
        private String type;

        public Pet(String type){
            this.type = type;
        }

        public String getType(){
            return this.type;
        }
    }

    public static class Dog extends Pet{

        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet{

        public Cat() {
            super("cat");
        }
    }

    public static class PetQueue{
        private Pet pet;
        private int count;

        public PetQueue(Pet pet,int count){
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet(){
            return this.pet;
        }

        public int getCount(){
            return this.count;
        }

        public String getPetType(){
            return this.pet.getType();
        }
    }

    public static class DogAndCatQueue{
        private Queue<PetQueue> dogQueue;
        private Queue<PetQueue> catQueue;
        int count;

        public DogAndCatQueue(){
            this.dogQueue = new LinkedList<PetQueue>();
            this.catQueue = new LinkedList<PetQueue>();
            this.count = 0;
        }

        public void add(Pet pet){
            if(pet.getType().equals("dog")){
                dogQueue.add(new PetQueue(pet,count++));
            }else if(pet.getType().equals("cat")){
                catQueue.add(new PetQueue(pet,count++));
            }else{
                throw new RuntimeException("");
            }
        }
        public Pet pollAll(){
            if(dogQueue.isEmpty() && catQueue.isEmpty()){
                return null;
            }
            if(dogQueue.isEmpty()){
                return catQueue.poll().getPet();
            }
            if(catQueue.isEmpty()){
                return dogQueue.poll().getPet();
            }
            if(catQueue.peek().getCount() > dogQueue.peek().getCount()){
                return dogQueue.poll().getPet();
            }else{
                return catQueue.poll().getPet();
            }
        }

        public Pet pollDog(){
            if(dogQueue.isEmpty()){
                throw new RuntimeException("");
            }
            return dogQueue.poll().getPet();
        }

        public Pet pollCat(){
            if(catQueue.isEmpty()){
                throw new RuntimeException("");
            }
            return catQueue.poll().getPet();
        }

        public boolean isEmpty(){
            if(dogQueue.isEmpty() && catQueue.isEmpty()){
                return true;
            }
            return false;
        }

        public boolean isDogEmpty(){
            if(dogQueue.isEmpty()){
                return true;
            }
            return false;
        }

        public boolean isCatEmpty(){
            if(catQueue.isEmpty()){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        DogAndCatQueue test = new DogAndCatQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
     /*   while (!test.isDogEmpty()) {
            System.out.println(test.pollDog().getType());
        }*/
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getType());
        }
    }

}
