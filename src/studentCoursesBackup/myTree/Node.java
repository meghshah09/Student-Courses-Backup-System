/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursesBackup.myTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Megh Shah
 */
public class Node implements ObserverI,SubjectI{
    
    private int data;
    private Set<String> courses= new HashSet<>();
    private List<Node> observers = new ArrayList<>();
    
    private Node left;
    private Node right;
    
    /**
     * 
     * @param dataIn buId to identify the node
     * @param coursesIn course to added for a particular buID
     */
    public Node(int dataIn, String coursesIn){
        this.data = dataIn;
        this.courses.add(coursesIn);
        left = null;
        right = null;
        //update(coursesIn,OPERATION.I);
    }
    
    /**
     * 
     * @param dIn sets the buID
     */
    
    public void setData(int dIn){
        this.data = dIn;
    }
    
    /**
     * 
     * @return getter for the buID
     */
    public int getData(){
        return this.data;
    }

    /**
     * 
     * @param cIn setter for the courses 
     */
    public void setCourses(String cIn){
        this.courses.add(cIn);
    }

    
    /**
     * 
     * 
     * @return getter for the courses.
     */
    public Set getCourses(){
        return this.courses;
    }
    
    /**
     * 
     * @param nIn setter for left Node 
     */
    public void setLeft(Node nIn){
        this.left = nIn;
    }
    
    /**
     * 
     * @return getter for the left node
     */
    public Node getLeft(){
        return this.left;
    }
    /**
     * 
     * @param nIn setter for the right node
     */
    public void setRight(Node nIn){
        this.right= nIn;
    }
    /**
     * 
     * @return getter for the right node 
     */
    public Node getRight(){
        return this.right;
    }

    /**
     * 
     * @param courseIn specify the course to be added in the particular observer
     * @param tIn denotes the kind of operation
     */
    @Override
    public void update(String courseIn, OPERATION tIn) {
        if(tIn.equals(OPERATION.I)){
            courses.add(courseIn);
        }
        else if(tIn.equals(OPERATION.D)){
            courses.remove(courseIn);
        }
    }

    /**
     * 
     * @param observer to be added to the observer list 
     */
    @Override
    public void attach(Node observer) {
        observers.add(observer);
    }

    /**
     * 
     * @param courseIn to be added for all observers
     * @param tIn denotes the kind of operation
     */
    @Override
    public void notifyAllObserver(String courseIn,OPERATION tIn) {
        
            for(Node observer: observers)
                observer.update(courseIn,tIn);
    }    
    
    /**
     * 
     * @return the well formated string with list of courses. 
     */
    @Override
    public String toString(){
        String list="";
        for(String str : courses){
            list += str;
            list +=" ";
        }
        return list;
    }
}
