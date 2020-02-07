package com.itsol.projectservice.service.common;

import java.io.Serializable;
import java.util.List;

public interface GennerEntityManagerDAO <ID extends Serializable, T> {
    List<T> finAllEntity();
    void saveEntity(T entity);
    T updateEntity(T entity);
    Integer deleteEntity(ID[] ids);
    Integer deleteEntityByID(Integer id);
    T findEntityById(ID id);
    List<T> finByProperty(String property, Object value, String sortExperssion, String sortDirection);
    Object[] getEntityPage(String property, Object value, String sortExperssion, String sortDirection,Integer offset, Integer limit);

}
