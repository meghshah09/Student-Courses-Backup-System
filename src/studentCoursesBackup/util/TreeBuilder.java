/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursesBackup.util;


import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.OPERATION;

/**
 *
 * @author Megh Shah
 */
public class TreeBuilder {

    //private FileProcessor fp;
    private String buID;
    private String courses;
    private Node root;
    private Node backup1Root;
    private Node backup2Root;
    
/**
 * Default Constructor
 */    
    public TreeBuilder(){
        root=null;
        backup1Root = null;
        backup2Root = null;
    }
/**
 * 
 * @param lineIn - line fetched from the file
 * @param t indicates the operation
 */
    public void buildTree(String lineIn,OPERATION t) {
    
        splitLine(lineIn);
        if(t.equals(OPERATION.I)){
            insert(Integer.parseInt(this.getBuID()),this.getCourses());
        }
        else if(t.equals(OPERATION.D)){
            delete(Integer.parseInt(this.getBuID()),this.getCourses());
        }
        
    }
       /**
     * 
     * @return the root node 
     */
    public Node getRoot() {
        return root;
    }

    /**
     * 
     * @return the backup1Root node 
     */
    public Node getBackup1Root() {
        return backup1Root;
    }

    /**
     * 
     * @return the backup2Root Node.
     */
    public Node getBackup2Root() {
        return backup2Root;
    }
    /**
     * 
     * @param strIn String on which split is performed
     */
    private void splitLine(String strIn) {
       strIn= strIn.trim(); // precaution if file contains ant white spaces.
        String[] output = strIn.split(":");
        this.setBuID(output[0]);
        this.setCourse(output[1]);
    }
/**
 * 
 * @param stringIn Bu ID no. 
 */
    private void setBuID(String stringIn) {
        buID = stringIn;
    }
/**
 * 
 * @param stringIn Course to be added
 */
    private void setCourse(String stringIn) {
        courses = stringIn;
    }
    
    /**
     * 
     * @return string as a buID
     */
    public String getBuID() {
        return buID;
    }
    /**
     * 
     * @return string as Course name 
     */
    public String getCourses() {
        return courses;
    }
    /**
     * 
     * @param id BUID to be inserted
     * @param cIn Course to be added
     */
    public void insert(int id, String cIn){
		
		if(root==null){
                        Node newNode = new Node(id,cIn);
                        backup1Root = new Node(id,cIn);
                        backup2Root = new Node(id,cIn);
			root = newNode;
                        newNode.attach(this.backup1Root);
                        newNode.attach(this.backup2Root);
			return;
		}
		Node current = root;
                Node current1 = backup1Root;
                Node current2 = backup2Root;

		while(true){
			Node parent = current;
                        Node parent1 = current1;
                        Node parent2 = current2;
                        
			if(id<current.getData()){				
				current = current.getLeft();
                                current1 = current1.getLeft();
                                current2 = current2.getLeft();
				if(current==null){
                                    Node newNode = new Node(id,cIn);
                                    Node newNode1 = new Node(id,cIn);
                                    Node newNode2 = new Node(id,cIn);
                                    parent.setLeft(newNode);
                                    parent1.setLeft(newNode1);
                                    parent2.setLeft(newNode2);
                                        newNode.attach(newNode1);
                                        newNode.attach(newNode2);
					return;
				}
			}else if(id == current.getData()){
                            
                            parent.setCourses(cIn);
                            parent.notifyAllObserver(cIn,OPERATION.I);
                            return;
                        }
                        else {
				current = current.getRight();
                                current1 = current1.getRight();
                                current2 = current2.getRight();
				if(current==null){
                                    Node newNode = new Node(id,cIn);
                                    Node newNode1 = new Node(id,cIn);
                                    Node newNode2 = new Node(id,cIn);
                                    parent.setRight(newNode);
                                    parent1.setRight(newNode1);
                                    parent2.setRight(newNode2);
                                        newNode.attach(newNode1);
                                        newNode.attach(newNode2);
					return;
				}
			}
		}
	
    }
    /**
     * 
     * @param rIn reference to the Results class
     * @param i tag to indicate which tree to be printed
     Helper method for performing Display to stdout and write to file
     */
    public void printNodes(Results rIn, Node nIn){
        
        if(nIn == root){
            System.out.println("Printing Original Tree :");
            display(root,rIn);
        }
        else if(nIn == backup1Root){
            System.out.println("Printing Backup Tree 1 :");
            display(backup1Root,rIn);
        }
        else if(nIn == backup2Root){
            System.out.println("Printing Backup Tree 2 :");
            display(backup2Root,rIn);
        }
    }
    
    /**
     * 
     * @param root Reference to the node from which to print
     * @param rIn reference to results class for calling the respective method
     */
    //Display of the tree
    public void display(Node root,Results rIn){
		if(root!=null){
			display(root.getLeft(),rIn);
			rIn.stdoutDisplay(root);
                        rIn.fileDisplay(root);
			display(root.getRight(),rIn);
		}
    }
    /**
     * 
     * @param id indicates the buID (data) of the Node
     * @return 
     */
    //Searching in the tree ( helper function for delete functionality.
    public Node find(int id){
		Node current = root;
		while(current!=null){
			if(current.getData()==id){
				return current;
			}else if(current.getData()>id){
				current = current.getLeft();
			}else{
				current = current.getRight();
			}
		}
		return null;
	}
    
    /**\
     * 
     * @param idIn buId(node) for identifying the node 
     * @param cIn course to be deleted from particular id.
     */
    public void delete(int idIn, String cIn){
        Node found = find(idIn);
        
        if(found != null){
            if(found.getCourses().contains(cIn)){
                found.getCourses().remove(cIn);
                found.notifyAllObserver(cIn,OPERATION.D);
                /*if(found.getCourses().isEmpty()){
                    found.setData(-1); // node empty
                } */// Not necessary in this project
            }
            else{
                //Course Not Found on particular buID.
            }
        }
        else{
            //buId not found
        }
        
    }
   
    /**
     *
     * @return well formatted string to identify what object contains
     */
    @Override
    public String toString(){
        
        String str="";
        str = "Original Root Node data : " + root.getData() + " : " + root.getCourses();
        str += " \n ";
        str += "Backup 1 Root Node data : " + backup1Root.getData() + " : " + backup1Root.getCourses();
        str += "\n";
        str += "Backup 2 Root Node Data : " + backup2Root.getData() + " : " + backup2Root.getCourses();
        
        return str;
    }
    
    
}
