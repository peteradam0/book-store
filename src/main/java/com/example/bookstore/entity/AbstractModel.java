package com.example.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class AbstractModel implements Serializable {
    @Column(name = "uuid", unique = true)
    private String uuid;

    public AbstractModel() {
        this(null);
    }

    public AbstractModel(final String uuid) {
        this.uuid = uuid;
    }

    private void ensureUuid() {
        if (uuid == null) {
            setUuid(UUID.randomUUID().toString());
        }
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
        }
        return uuid;
    }

    @PrePersist
    public void onPrePersist() {
        ensureUuid();
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractModel that = (AbstractModel) o;
        return Objects.equals(uuid, that.uuid);
    }

}
