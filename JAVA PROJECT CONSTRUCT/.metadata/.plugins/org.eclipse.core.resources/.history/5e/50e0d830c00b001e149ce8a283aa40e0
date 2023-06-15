package com.masai.dao;

import com.masai.entity.*;
import jakarta.persistence.*;
import java.util.Optional;

public class CSRDaoImpl implements CSRDao {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");

    @Override
    public void saveCSR(CSR csr) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(csr);
            et.commit();
            System.out.println("CSR saved successfully!");
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            System.out.println("Error saving CSR: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void updateCSR(CSR csr) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(csr);
            et.commit();
            System.out.println("CSR updated successfully!");
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            System.out.println("Error updating CSR: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteCSR(String csrId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            CSR csr = em.find(CSR.class, csrId);
            if (csr != null) {
                em.remove(csr);
                et.commit();
                System.out.println("CSR deleted successfully!");
            } else {
                System.out.println("No CSR found with the provided ID: " + csrId);
            }
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            System.out.println("Error deleting CSR: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public CSR getCSRById(String csrId) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(CSR.class, csrId);
        } catch (Exception e) {
            System.out.println("Error retrieving CSR: " + e.getMessage());
        } finally {
            em.close();
        }
        return null;
    }
}
