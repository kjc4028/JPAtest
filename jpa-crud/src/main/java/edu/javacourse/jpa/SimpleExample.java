package edu.javacourse.jpa;

import edu.javacourse.jpa.entity.City;
import edu.javacourse.jpa.entity.Region;
import edu.javacourse.jpa.manager.CityManager;
import edu.javacourse.jpa.manager.RegionManager;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class SimpleExample {

    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	boolean power = true;
    	Scanner scan0 = new Scanner(System.in);
    	System.out.println("1:Region 2:City");
    	String work = scan0.nextLine();
    	
    	if(work.equals("1")){
    		while(power){
        		System.out.println("1:insert 2:update 3:delete 4:select");
        		
        		Scanner scan = new Scanner(System.in);
            	Scanner scan2 = new Scanner(System.in);
            	String input = scan.nextLine();
            	
                RegionManager rm = new RegionManager();
                rm.init();
                EntityManager em = rm.getEntityManager();
                
                @SuppressWarnings("unused")
				int id = 0;
                Region fromDb = new Region();
                
                selectRegions(em);
                
                //insert '1'
                if(input.equals("1")){
                	System.out.println("insert");
                	Region region = new Region();
                	System.out.println("Data input : ");
                	String name = scan.nextLine();
                	if(name != null){
                		region.setRegionName(name);
                		createRegion(em, region);
                		selectRegions(em);
                	}
                }
                //update '2'
                else if(input.equals("2")){
                	System.out.println("update");
                	System.out.println("update ID : ");
                	int idData = scan.nextInt();
                	System.out.println("Data input : ");
                	fromDb = getRegion(em, idData);
                	String nameData = scan2.nextLine();
                	if(nameData != null){
                		System.out.println("fromDb pre = " + fromDb);
                		fromDb.setRegionName(nameData);
                		fromDb = updateRegion(em, fromDb);
                	}
                	System.out.println("fromDb updated = " + fromDb);
                } 
                //delete '3'
                else if(input.equals("3")){
                	System.out.println("delete");
                	System.out.println("Delete ID");
                	int deleteId = scan.nextInt();
                	if(deleteId != 0){
                		fromDb = getRegion(em, deleteId);
                		removeRegion(em, fromDb);
                	}
                }
                //select '4'
                else if(input.equals("4")){
                	System.out.println("select");
                	selectRegions(em);
                	Region region = new Region();
                      @SuppressWarnings("unchecked")
					List<City> cityList = em.createQuery("select r from City r").getResultList();
                	region.setCityList(cityList);
                	System.out.println(region.getCityList());
                	for(City i : cityList){
                		System.out.println(i.getCityId() + " - " + i.getCityName());
                	}
                }
                
                em.close();
                
                System.out.println("end");
                System.out.println("1:restart 2:off");
                String powerSelect = scan2.nextLine();
                
                if(powerSelect.equals("1")){
                	power=true;
                	System.out.println("restart");
                }else if(powerSelect.equals("2")){
                	power=false;
                	 scan.close();
                     scan2.close();
                     System.out.println("off");
                     return;
                }
               
        	}
    	} else if(work.equals("2")){
    		
    			CityManager cm = new CityManager();
    	        cm.init();
    	        EntityManager em2 = cm.getEntityManager();
    	        int id2 = 0;
    	        selectCitys(em2);
    	        Scanner scan3 = new Scanner(System.in);
    	        System.out.println("Data Input : ");
    	        String data = scan3.nextLine();
    	        System.out.println("region Number : ");
    	        Integer regionNum = scan3.nextInt();
    	        
    	        if(data != null){
    	            City city = new City();
        	        Region region = new Region();
        	        region = new Region(regionNum);
        	        city.setCityName(data);
        	        city.setRegionId(region);
        	        createCity(em2, city);
        	        selectCitys(em2);
    	        }
    	 
    	        scan3.close();
    	        em2.close();
    	}

    }

    
   /*юлго method */
    
    
    private static int createRegion(EntityManager em, Region region) {
        em.getTransaction().begin();
        em.persist(region);
        em.getTransaction().commit();
        return region.getRegionId();
    }

    private static Region getRegion(EntityManager em, Integer id) {
        Region region = em.find(Region.class, id);
        return region;
    }

    private static Region updateRegion(EntityManager em, Region region) {
        em.getTransaction().begin();
        em.merge(region);
        em.getTransaction().commit();
        return region;
    }

    private static void removeRegion(EntityManager em, Region region) {
        em.getTransaction().begin();
        em.remove(region);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
	private static void selectRegions(EntityManager em) {
        System.out.println("Select Region List");
        List<Region> result = em.createQuery("select r from Region r").getResultList();
        for(Region r : result) {
            System.out.println(r);
        }
        System.out.println("=============================");
    }
    
    //============================================================
    
    private static int createCity(EntityManager em, City city) {
        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();
        return city.getCityId();
    }

    private static City getCity(EntityManager em, Integer id) {
        City city = em.find(City.class, id);
        return city;
    }

    @SuppressWarnings("unused")
	private static City updateCity(EntityManager em, City city) {
        em.getTransaction().begin();
        em.merge(city);
        em.getTransaction().commit();
        return city;
    }

    @SuppressWarnings("unused")
	private static void removeCity(EntityManager em, City city) {
        em.getTransaction().begin();
        em.remove(city);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
	private static void selectCitys(EntityManager em) {
        System.out.println("Select City List");
        List<City> result = em.createQuery("select r from City r").getResultList();
        for(City r : result) {
            System.out.println(r.toString());
        }
        System.out.println("=============================");
    }

}
