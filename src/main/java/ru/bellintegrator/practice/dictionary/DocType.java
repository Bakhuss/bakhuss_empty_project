package ru.bellintegrator.practice.dictionary;

import ru.bellintegrator.practice.user.model.Document;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import java.util.Set;

/**
 * Тип документа
 */
@Entity
public class DocType {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Integer version;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String code;

    @OneToMany(mappedBy = "docType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Document> documents;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public void addDocument(Document document) {
        getDocuments().add(document);
        document.setDocType(this);
    }

    public void removeDocument(Document document) {
        getDocuments().remove(document);
        document.setDocType(null);
    }
}
