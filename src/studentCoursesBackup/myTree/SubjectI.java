/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursesBackup.myTree;

/**
 *
 * @author Megh Shah
 */
public interface SubjectI {
    /**
     * abstract method update
     * @param observer  to be added to the observer list
     */
    void attach(Node observer);
    /**
     * abstract method notifyAlllObserver
     * @param courseIn to be added for all observers
     * @param t denotes the kind of operation
     */
    void notifyAllObserver(String courseIn,OPERATION t);
    
    
}
