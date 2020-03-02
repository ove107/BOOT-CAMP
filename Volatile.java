package JavaMultithreading;

import java.util.Scanner;

public class Volatile extends Thread{

        private volatile boolean running = true;

        public void run() {
            while (running) {
                System.out.println("Running");

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutdown() {
            running = false;
        }
    }

    class App {

        public static void main(String[] args) {
            Volatile vol = new Volatile();
            vol.start();
            // Wait for the enter key
            System.out.println("Enter something to stop the thread,\nVolatile variable running will be forced to true :");
            new Scanner(System.in).nextLine();
            vol.shutdown();
        }
    }


