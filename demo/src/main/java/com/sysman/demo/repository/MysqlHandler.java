package com.sysman.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sysman.demo.entity.CityDB;
import com.sysman.demo.entity.CountiesDB;
import com.sysman.demo.entity.MaterialDB;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.Query;


@Service
public class MysqlHandler {
    private EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    /**
     * @return List<MaterialDB>
     */
    @SuppressWarnings("unchecked")
    public List<MaterialDB> allMaterial() {
        EntityManager eM = this.getEntityManagerFactory().createEntityManager();
        List<MaterialDB> lMDB = new ArrayList<MaterialDB>();
        try {
            eM.getTransaction().begin();
            Query query = eM.createNativeQuery("select * from material",
                    MaterialDB.class);
            lMDB = query.getResultList();
            eM.getTransaction().commit();

            return lMDB;

        } catch (Exception e) {
            eM.getTransaction().rollback();
            eM.close();
            return lMDB;

        } finally {
            if (eM != null) {
                eM.close();
            }
        }
    }

    /**
     * @param lID List<Integer>
     * @return List<CityDB>
     */
    @SuppressWarnings("unchecked")
    public List<CityDB> cityFindByIdIn(List<Integer> lID) {
        EntityManager eM = this.getEntityManagerFactory().createEntityManager();
        List<CityDB> lCiDB = new ArrayList<CityDB>();
        try {
            eM.getTransaction().begin();
            Query query = eM.createNativeQuery("select * from city where city.id IN(:ids)",
                    CityDB.class);
            query.setParameter("ids", lID);
            lCiDB =  query.getResultList();
            eM.getTransaction().commit();

            return lCiDB;

        } catch (Exception e) {
            eM.getTransaction().rollback();
            eM.close();
            return lCiDB;

        } finally {
            if (eM != null) {
                eM.close();
            }
        }
    }

    /**
     * @param lID List<Integer>
     * @return  List<CountiesDB>
     */
    @SuppressWarnings("unchecked")
    public List<CountiesDB> countiesFindByIdIn(List<Integer> lID) {
        EntityManager eM = this.getEntityManagerFactory().createEntityManager();
        List<CountiesDB> lCoDB = new ArrayList<CountiesDB>();
        try {
            eM.getTransaction().begin();
            Query query = eM.createNativeQuery("select * from counties where  counties.id IN(:ids)",
                    CountiesDB.class);
            query.setParameter("ids", lID);
            lCoDB =  query.getResultList();
            eM.getTransaction().commit();

            return lCoDB;

        } catch (Exception e) {
            eM.getTransaction().rollback();
            eM.close();
            return lCoDB;

        } finally {
            if (eM != null) {
                eM.close();
            }
        }
    }
}
