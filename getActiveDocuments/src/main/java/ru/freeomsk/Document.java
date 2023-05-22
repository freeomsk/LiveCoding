package ru.freeomsk;

public class Document {
    int documentId;
    int personId;
    int addressId;
    int type;

    Document(int documentId, int personId, int addressId, int type) {
        this.documentId = documentId;
        this.personId = personId;
        this.addressId = addressId;
        this.type = type;
    }
}
