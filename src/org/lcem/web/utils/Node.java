package org.lcem.web.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Node<T> implements Serializable {
	
	private static final long serialVersionUID = 1609850896968537179L;
	
	private T data;
    private Node<T> parent;
    private List<Node<T>> childrens;  
    
	public Node() {
		this.data = null;
		this.parent = null;
		this.childrens = new ArrayList<Node<T>>();
	}
    	
	public Node(T data) {
		this.data = data;
		this.parent = null;
		this.childrens = new ArrayList<Node<T>>();
	}
	
	public Node(T data, List<Node<T>> children) {
		this.data = data;
		this.parent = null;
		this.childrens = children;
		Iterator<Node<T>> iterator = children.iterator();
		while (iterator.hasNext()) {
			iterator.next().parent = this;
		}
	}
	
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * @return the parent
	 */
	public Node<T> getParent() {
		return parent;
	}
	
	/**
	 * @param parent the parent to set
	 */
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	
	/**
	 * @return the children
	 */
	public List<Node<T>> getChildrens() {
		return childrens;
	}
	
	/**
	 * @return the children
	 */
	public Node<T> getChildrenByData(T data) {
		Iterator<Node<T>> iterator = childrens.iterator();
		while (iterator.hasNext()) {
			Node<T> node = iterator.next();
			if (node.getData().equals(data))
				return node;
		}
		return null;
	}
	
	/**
	 * @param children the children to set
	 */
	public void setChildrens(List<Node<T>> childrens) {
		this.childrens = childrens;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node<?>))
    	   return false;
		if (obj == this)
			return true;

		@SuppressWarnings("unchecked")
		Node<T> node = (Node<T>) obj;
		return this.data.equals(node.getData());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [data=" + data + ", parent=" + (parent==null?"":parent.getData()) + ", children="
				+ childrens + "]";
	} 	

}
