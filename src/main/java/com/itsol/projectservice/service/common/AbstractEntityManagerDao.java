package com.itsol.projectservice.service.common;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;


public class AbstractEntityManagerDao<ID extends Serializable, T> implements GennerEntityManagerDAO<ID,T>{

    @Autowired
    EntityManager entityManager;
    @Autowired
    EntityManagerFactory entityManagerFactory;

    private final static Logger log = LoggerFactory.getLogger(AbstractEntityManagerDao.class);

    private Class<T> persistenceClass;

    // Lấy Entity T trong Generic
    public AbstractEntityManagerDao() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    //	get persistenceClass
    public String getPersistenceClass() {
        return persistenceClass.getSimpleName();
    }

    public List<T> finAllEntity() {
        log.info("find All record from db");
        List<T> list = new ArrayList<T>();
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            StringBuilder sql = new StringBuilder(" from ");
            sql.append(this.getPersistenceClass());
            list = entityManager.createQuery(sql.toString(), persistenceClass).getResultList();

        } catch (HibernateException e) {
            log.info(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return list;
    }

    public void saveEntity(T t) {
        log.info("save object");
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
            log.info(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public T updateEntity(T t) {
        log.info("update object");
        T entity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entity = entityManager.merge(t);
            entityManager.getTransaction().commit();
            return entity;
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
            log.info(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return entity;
    }

    public Integer deleteEntity(ID[] ids) {
        log.info("delete by ids ");
        Integer count = 0;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            for (ID id : ids) {
                T entity = entityManager.find(persistenceClass, id);
                if (entity != null) {
                    entityManager.remove(entity);
                    count++;
                }
            }
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
            log.info(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return count;
    }

    @Override
    public Integer deleteEntityByID(Integer id) {
        log.info("delete by id ");
        Integer count = 0;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            T entity = entityManager.find(persistenceClass, id);
            if (entity != null) {
                entityManager.remove(entity);
                count++;
            }
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
            log.info(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return count;
    }

    @Override
    public T findEntityById(ID id) {
        log.info("find by id");
        T entity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entity = entityManager.find(persistenceClass,id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            log.info(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return entity;
    }

    // 		Tìm kiếm 1 list danh sách theo value sắp xếp theo ASC or DESC size của list
    @Override
    public List<T> finByProperty(String property, Object value, String sortExperssion, String sortDirection) {
        log.info("find by value");
        List<T> list = new ArrayList<T>();
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            StringBuilder sql = new StringBuilder(" from ");
            sql.append(getPersistenceClass());
            if(property!=null && value !=null) {
                sql.append(" where ").append(property).append(" = ?1");
            }
            if(sortExperssion!=null && sortDirection!=null) {
                sql.append(" order by ").append(sortExperssion);
                sql.append(" "+(sortDirection.equals("ASC")?"asc":"desc"));
            }
            TypedQuery<T> query1  = entityManager.createQuery(sql.toString(),persistenceClass);
            list = query1.setParameter(1,value).getResultList();
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
            log.info(e.getMessage());
        }finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return list;
    }

    @Override
    public Object[] getEntityPage(String property, Object value, String sortExperssion, String sortDirection, Integer offset, Integer limit) {
        List<T> list = new ArrayList<T>();
        Object totalItem = 0;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
//            HQL
            StringBuilder sql = new StringBuilder("from ");
            sql.append(getPersistenceClass());
            if (property != null && value != null) {
                sql.append(" where ").append(property).append(" = ?1");
            }
            if (sortExperssion != null && sortDirection != null) {
                sql.append(" order by ").append(sortExperssion);
                sql.append(" " + (sortDirection.equals("ASC") ? "asc" : "desc"));
            }
            TypedQuery<T> query1  = entityManager.createQuery(sql.toString(),persistenceClass);
            if (value != null) {
                query1.setParameter(1,value);
            }
            if(offset!=null &&offset>=0){
                query1.setFirstResult(offset);
            }
            if(limit!=null && limit>0){
                query1.setMaxResults(limit);
            }
            list = query1.getResultList();

            totalItem = finAllEntity().size();

            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return new Object[]{totalItem, list};
    }
}
