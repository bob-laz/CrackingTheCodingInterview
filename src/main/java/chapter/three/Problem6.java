package chapter.three;

import java.util.Date;
import java.util.LinkedList;

/*
    An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis. People must
    adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they
    would prefer a dog or a cat (and will receive the oldest animal of tha type). They cannot select which specific
    animal they would like. Create th data structures to maintain this system and implement operations such as enqueue,
    dequeueAny, dequeueDog, and dequeueCat. You may use the built-in LinkedList data structure.
 */
public class Problem6 {

    public static class AnimalQueue {
        private final LinkedList<Cat> catList;
        private final LinkedList<Dog> dogList;

        public AnimalQueue() {
            catList = new LinkedList<>();
            dogList = new LinkedList<>();
        }

        public void enqueue(Animal animal) {
            animal.arrivalTime = new Date();
            if (animal instanceof Cat) {
                catList.addLast((Cat) animal);
            } else {
                dogList.addLast((Dog) animal);
            }
        }

        public Dog dequeueDog() {
            return dogList.poll();
        }

        public Cat dequeueCat() {
            return catList.poll();
        }

        public Animal dequeueAny() {
            if (catList.isEmpty()) {
                return dogList.pollFirst();
            } else if (dogList.isEmpty()) {
                return catList.pollFirst();
            } else if (catList.peek().arrivalTime.before(dogList.peek().arrivalTime)) {
                return catList.pollFirst();
            } else {
                return dogList.pollFirst();
            }
        }
    }

    abstract static class Animal {
        Date arrivalTime;

        @Override
        public String toString() {
            return "Animal{" +
                    "arrivalTime=" + arrivalTime +
                    ", name='" + name + '\'' +
                    '}';
        }

        String name;
    }

    static class Cat extends Animal {
        int numPaws;

        @Override
        public String toString() {
            return "Cat{" +
                    "arrivalTime=" + arrivalTime +
                    ", name='" + name + '\'' +
                    ", numPaws=" + numPaws +
                    '}';
        }

        public Cat(String name, int numPaws) {
            this.name = name;
            this.numPaws = numPaws;
        }
    }

    static class Dog extends Animal {
        boolean barky;

        @Override
        public String toString() {
            return "Dog{" +
                    "arrivalTime=" + arrivalTime +
                    ", name='" + name + '\'' +
                    ", barky=" + barky +
                    '}';
        }

        public Dog(String name, boolean barky) {
            this.name = name;
            this.barky = barky;
        }
    }
}
