package edu.javacourse.jpa.manager;

import edu.javacourse.jpa.entity.Region;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CityManager {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
        System.out.println(entityManagerFactory.getClass().getSimpleName());
        entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManager.getClass().getSimpleName());
    }

    public List<Region> getRegionList() {
        return entityManager.createQuery("select c from City c").getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
