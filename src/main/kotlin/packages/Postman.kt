package packages

fun main() {
    val myLetter = Parcel("Letter", "ZKB", "Destination Street 42")
    val myPackage = Parcel("Package", "ZKB", "Destination Street 42")
    val myNewspaper = Parcel("NewsPaper", "20min", "Destination Street 42")

    // Print label on parcel for postman
    println("Labeling parcels")
    println("----------------")
    Postman.labelParcel(myLetter)
    Postman.labelParcel(myPackage)
    Postman.labelParcel(myNewspaper)

    // Deliver parcel
    println("Delivering parcels")
    println("------------------")
    Postman.deliverParcel(myLetter, Mailbox("Destination Street 42", false))
    Postman.deliverParcel(myPackage, Mailbox("Destination Street 42", false))
    Postman.deliverParcel(myNewspaper, Mailbox("Destination Street 42", false))
}

object Postman {
    fun labelParcel(parcel: Parcel) {
        var frontLabel = ""
        var backLabel = ""
        if (parcel.type == "Letter") {
            frontLabel = """
                ${parcel.sender}
                ${parcel.destination}
                """.trimIndent()
            backLabel = ""
        }
        if (parcel.type == "Package") {
            frontLabel = parcel.sender
            backLabel = parcel.destination
        }
        if (parcel.type == "Newspaper") {
            frontLabel = " "
            backLabel = " "
        }
        if (!frontLabel.isEmpty()) {
            println("Front Label for " + parcel.type + ": " + frontLabel) // pseudo code
        }
        if (!backLabel.isEmpty()) {
            println("Back Label for " + parcel.type + ": " + backLabel) // pseudo code
        }
    }

    fun deliverParcel(parcel: Parcel, mailbox: Mailbox) {
        // Calculate label again, easier than parsing image from physical parcel
        var frontLabel = ""
        var backLabel = ""
        if (parcel.type == "Letter") {
            frontLabel = """
                ${parcel.sender}
                
                
                ${parcel.destination}
                """.trimIndent()
            backLabel = ""
        }
        if (parcel.type == "Package") {
            frontLabel = parcel.sender
            backLabel = parcel.destination
        }
        if (parcel.type == "Newspaper") {
            frontLabel = ""
            backLabel = ""
        }
        if (parcel.type == "Letter") {
            if (frontLabel.endsWith(mailbox.address)) {
                println("Put " + parcel.type + " in mail slot for " + mailbox.address) // pseudo code
            }
        }
        if (parcel.type == "Package") {
            if (backLabel == mailbox.address) {
                println("Put " + parcel.type + " in package slot" + mailbox.address) // pseudo code
            }
        }
        if (parcel.type == "Newspaper") {
            if (mailbox.allowsAdvertisement) {
                println("Put " + parcel.type + " in mail slot" + mailbox.address) // pseudo code
            }
        }
    }
}
