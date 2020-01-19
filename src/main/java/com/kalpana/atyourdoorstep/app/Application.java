/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalpana.atyourdoorstep.app;

import com.kalpana.atyourdoorstep.dao.UserDao;
import com.kalpana.atyourdoorstep.entity.UserAddress;
import com.kalpana.atyourdoorstep.entity.UserDetails;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Manoj
 */
public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AtYourDoorStep");
        EntityManager em = emf.createEntityManager();
        try {
            codeToVerifyUserDetailsInsertion(em);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    private static UserDetails getUserDetails() {
        UserDetails details = new UserDetails();
        details.setEmail("naglekalpana@gmail.com");
        details.setUserCreatedOn(new java.util.Date());
        details.setIsPrime(false);
        details.setUserFirstName("Kalpana");
        details.setUserLastName("Nagle");
        details.setUserAddress(getUserAddress());
        return details;
    }

    private static void codeToVerifyUserDetailsInsertion(EntityManager em) {

        UserDao dao = new UserDao(em);

        UserDetails details = getUserDetails();
        details = dao.insertUserDetails(details);
        System.out.println(details.getUserId());
    }

    private static UserAddress getUserAddress() {
        UserAddress userAddress = new UserAddress();
        userAddress.setAddressLine1("address line 1");
        userAddress.setAddressLine2("address line 2");
        userAddress.setAddressType("Home");
        userAddress.setCity("Pune");
        userAddress.setCountry("India");
        userAddress.setStateName("MH");
        userAddress.setZip(411028);
        return userAddress;
    }

}
