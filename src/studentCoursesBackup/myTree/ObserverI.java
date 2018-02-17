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
public interface ObserverI {
    /**
     * abstract method update.
     * @param courseIn specify the course to be added in the particular observer
     * @param t denotes the kind of operation
     */
    void update(String courseIn, OPERATION t);
    
}
