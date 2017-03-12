package com.garrytrue.repository;

import com.garrytrue.model.Student;

/**
 * Created by garrytrue on 12.03.17.
 */
public abstract class AbstractRepository implements CRUDRepository<Student> {
    private final CRUDRepository<Student> succesor;

    public AbstractRepository(CRUDRepository<Student> succesor) {
        this.succesor = succesor;
    }

    protected CRUDRepository<Student> getSuccesor() {
        return succesor;
    }

    protected boolean hasSuccesor() {
        return succesor != null;
    }
}
