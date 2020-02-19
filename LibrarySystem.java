package JavaIntro2;

public class LibrarySystem {
}

public enum BookStatus {
    AVAILABLE,
    RESERVED,
    LOANED,
    LOST
}


public enum AccountStatus{
    ACTIVE,
    CLOSED,
    CANCELED,
    BLACKLISTED,
    NONE
}

public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}

public class Person {
    private String name;
    private Address address;
    private String email;
    private String phone;
}


public abstract class Account {
    private String id;
    private String password;
    private AccountStatus status;
    private Person person;

    public boolean resetPassword();
}

public class Librarian extends Account {
    public boolean addBookItem(BookItem bookItem);

    public boolean blockMember(Member member);

    public boolean unBlockMember(Member member);
}

public class Member extends Account {
    private Date dateOfMembership;
    private int totalBooksCheckedout;

    public int getTotalBooksCheckedout();

    public boolean reserveBookItem(BookItem bookItem);

    private void incrementTotalBooksCheckedout();


    private void checkForFine(String bookItemBarcode) {
        }
    }




}
