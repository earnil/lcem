package org.lcem.web.utils;

import java.util.Iterator;

import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

public class Utils {
	
	public static void populateTree(Node<String> node, Tree tree) {

	    TreeItem root = new TreeItem();
	    root.setText(node.getData());
	    Iterator<Node<String>> iterator = node.getChildren().iterator();
	    while (iterator.hasNext()) {
	    	populateTreeRec(iterator.next(), root);
	    }
	    tree.addItem(root);
		
	}
	
	private static void populateTreeRec(Node<String> node, TreeItem treeItem) {

	    Iterator<Node<String>> iterator = node.getChildren().iterator();
    	TreeItem item = new TreeItem();
    	item.setHTML(node.getData());
    	treeItem.addItem(item);
	    while (iterator.hasNext()) {
	    	populateTreeRec(iterator.next(), item);
	    }
		
	}
	
	
}
