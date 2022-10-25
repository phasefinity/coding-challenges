package packages;

public class Postman {

    public static void main(String[] args) {
        var myLetter = new Parcel("Letter", "ZKB", "Destination Street 42");
        var myPackage = new Parcel("Package", "ZKB", "Destination Street 42");
        var myNewspaper = new Parcel("NewsPaper", "20min", "Destination Street 42");

        // Print label on parcel for postman
        System.out.println("Labeling parcels");
        System.out.println("----------------");
        labelParcel(myLetter);
        labelParcel(myPackage);
        labelParcel(myNewspaper);

        // Deliver parcel
        System.out.println("Delivering parcels");
        System.out.println("------------------");
        deliverParcel(myLetter, new Mailbox("Destination Street 42", false));
        deliverParcel(myPackage, new Mailbox("Destination Street 42", false));
        deliverParcel(myNewspaper, new Mailbox("Destination Street 42", false));
    }

    public static void labelParcel(Parcel parcel) {
        String frontLabel = "";
        String backLabel = "";
        if (parcel.type().equals("Letter")) {
            frontLabel = parcel.sender() + "\n" + parcel.destination();
            backLabel = "";
        }
        if (parcel.type().equals("Package")) {
            frontLabel = parcel.sender();
            backLabel = parcel.destination();
        }
        if (parcel.type().equals("Newspaper")) {
            frontLabel = " ";
            backLabel = " ";
        }

        if (!frontLabel.isEmpty()) {
            System.out.println("Front Label for " + parcel.type() + ": " + frontLabel); // pseudo code
        }
        if (!backLabel.isEmpty()) {
            System.out.println("Back Label for " + parcel.type() + ": " + backLabel); // pseudo code
        }
    }

    public static void deliverParcel(Parcel parcel, Mailbox mailbox) {
        // Calculate label again, easier than parsing image from physical parcel
        String frontLabel = "";
        String backLabel = "";
        if (parcel.type().equals("Letter")) {
            frontLabel = parcel.sender() + "\n\n\n" + parcel.destination();
            backLabel = "";
        }
        if (parcel.type().equals("Package")) {
            frontLabel = parcel.sender();
            backLabel = parcel.destination();
        }
        if (parcel.type().equals("Newspaper")) {
            frontLabel = "";
            backLabel = "";
        }

        if (parcel.type().equals("Letter")) {
            if (frontLabel.endsWith(mailbox.address())) {
                System.out.println("Put " + parcel.type() + " in mail slot for " + mailbox.address()); // pseudo code
            }
        }
        if (parcel.type().equals("Package")) {
            if (backLabel.equals(mailbox.address())) {
                System.out.println("Put " + parcel.type() + " in package slot" + mailbox.address()); // pseudo code
            }
        }
        if (parcel.type().equals("Newspaper")) {
            if (mailbox.allowsAdvertisement()) {
                System.out.println("Put " + parcel.type() + " in mail slot" + mailbox.address()); // pseudo code
            }
        }
    }
}
