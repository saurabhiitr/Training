package com.tbitsglobal.model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
 
@ManagedBean(name = "documentService")
@ApplicationScoped
public class DocumentService {
     
    public TreeNode createDocuments() {
        TreeNode root = new DefaultTreeNode(new Document("Files", "-", "Folder"), null);
         
        TreeNode documents = new DefaultTreeNode(new Document("Documents", "-", "Folder"), root);
        TreeNode invoice1 = new DefaultTreeNode(new Document("Invoice 1", "-", "Folder"), documents);
        TreeNode invoice2 = new DefaultTreeNode(new Document("Invoce 2", "-", "Folder"), documents);
        TreeNode invoice3 = new DefaultTreeNode(new Document("Invoice 3", "-", "Folder"), documents);
        
         
        //Invoice 1
        TreeNode in1_pg1 = new DefaultTreeNode("picture", new Document("page 1.jpg", "30 KB", "JPEG Image"), invoice1);
        TreeNode in1_pg2 = new DefaultTreeNode("picture", new Document("page 2.jpg", "45 KB", "JPEG Image"), invoice1);
        TreeNode in1_pg3 = new DefaultTreeNode("picture", new Document("page 3.png", "96 KB", "PNG Image"), invoice1);
         
        //Invoice 2
        TreeNode in2_pg1 = new DefaultTreeNode("picture", new Document("page 1.jpg", "30 KB", "JPEG Image"), invoice2);
        TreeNode in2_pg2 = new DefaultTreeNode("picture", new Document("page 2.jpg", "45 KB", "JPEG Image"), invoice2);
        TreeNode in2_pg3 = new DefaultTreeNode("picture", new Document("page 3.png", "96 KB", "PNG Image"), invoice2);
        
         //Invoice 3
        TreeNode in3_pg1 = new DefaultTreeNode("picture", new Document("Page 1.jpg", "30 KB", "JPEG Image"), invoice3);
        TreeNode in3_pg2 = new DefaultTreeNode("picture", new Document("Page 2.jpg", "45 KB", "JPEG Image"), invoice3);
        TreeNode in3_pg3 = new DefaultTreeNode("picture", new Document("Page 3.png", "96 KB", "PNG Image"), invoice3);
       
        return root;
    }
     
   
}