public class Composition{

    // Kelas Car
    static class Car {
        private Engine engine;

        public Car() {
            this.engine = new Engine();
        }

        public void start() {
            engine.start();
        }

        public Engine getEngine() {
            return engine;
        }
    }

    // Kelas Engine
    static class Engine {
        public void start() {
            System.out.println("Engine starts");
        }
    }

    // Metode main untuk menjalankan contoh Composition
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start(); // Output: Engine starts
    }
}