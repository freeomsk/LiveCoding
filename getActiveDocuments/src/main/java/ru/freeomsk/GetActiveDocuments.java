package ru.freeomsk;

import java.util.*;

public class GetActiveDocuments {
    public static void main(String[] args) {
//        (3, 1, 2, 3)
//(4, 2, 1, 3)
//(5, 3, 1, 3)
        List<Document> documents = new ArrayList<>(Arrays.asList(
                new Document(1, 1, 1, 3),
                new Document(2, 1, 1, 11),
                new Document(3, 1, 2, 3),
                new Document(4, 2, 1, 3),
                new Document(5, 3, 1, 3)));

        List<Integer> documentIds = new ArrayList<>(Arrays.asList(1, 2, 3, 5));

        List<Document> activeDocuments = getActiveDocuments(documents, documentIds);
        for (Document document : activeDocuments) {
            System.out.println("(" + document.documentId + ", " + document.personId + ", " + document.addressId + ", " + document.type + ")");
        }
    }

    static List<Document> getActiveDocuments(List<Document> documents, List<Integer> documentIds) {
        Map<Integer, Document> personToDocument = new HashMap<>();
        for (Document document : documents) {
            if (document.type == 3) {
                personToDocument.put(document.personId, document);
            } else if (document.type == 11) {
                Document currentDocument = personToDocument.get(document.personId);
                if (currentDocument != null && currentDocument.addressId == document.addressId) {
                    personToDocument.remove(document.personId);
                }
            }
        }

        List<Document> activeDocuments = new ArrayList<>();
        for (Integer documentId : documentIds) {
            Document document = personToDocument.get(documentId);
            if (document != null) {
                activeDocuments.add(document);
            }
        }
        return activeDocuments;
    }
}