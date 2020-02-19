package JavaIntro1;


    enum House {
        Mansion(900),Bungalow(20),BeachHouse(500),Appartment(15),Castle(1200);
        private int price;
        House(int p) {
            price = p;
        }
        int getPrice() {
            return price;
        }
    }

    public class EnumExample {
        public static void main(String args[]){
            System.out.println("All House prices:");
            for (House c : House.values()) System.out.println(
                    c + " costs " + c.getPrice() + " thousand dollars.");
        }
    }

