package chapter.three;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem6Test {

    @Test
    public void animalQueueTest() throws InterruptedException {
        Problem6.Dog dog1 = new Problem6.Dog("Buster", true);
        Problem6.Dog dog2 = new Problem6.Dog("Fido", true);
        Problem6.Dog dog3 = new Problem6.Dog("Rex", false);
        Problem6.Dog dog4 = new Problem6.Dog("Spot", false);

        Problem6.Cat cat1 = new Problem6.Cat("Chloe", 4);
        Problem6.Cat cat2 = new Problem6.Cat("Louie", 4);
        Problem6.Cat cat3 = new Problem6.Cat("Callie", 3);
        Problem6.Cat cat4 = new Problem6.Cat("Max", 3);

        Problem6.AnimalQueue aq = new Problem6.AnimalQueue();
        aq.enqueue(dog1);
        Thread.sleep(1000); // thread.sleep ensures arrival timestamp is in expected order for testing
        aq.enqueue(cat1);
        Thread.sleep(1000);
        aq.enqueue(dog2);
        Thread.sleep(1000);
        aq.enqueue(cat2);
        Thread.sleep(1000);
        aq.enqueue(dog3);
        Thread.sleep(1000);
        aq.enqueue(cat3);
        Thread.sleep(1000);
        aq.enqueue(dog4);
        Thread.sleep(1000);
        aq.enqueue(cat4);

        assertEquals(cat1, aq.dequeueCat());
        assertEquals(dog1, aq.dequeueAny());
        assertEquals(dog2, aq.dequeueAny());
        assertEquals(cat2, aq.dequeueAny());
        assertEquals(dog3, aq.dequeueDog());
        assertEquals(cat3, aq.dequeueAny());
        assertEquals(dog4, aq.dequeueAny());
        assertEquals(cat4, aq.dequeueAny());
        assertNull(aq.dequeueAny());
        assertNull(aq.dequeueDog());
        assertNull(aq.dequeueCat());
    }

}