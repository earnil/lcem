package org.lcem.web.client;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.lcem.web.shared.model.Emission;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.media.client.Audio;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Lcem implements EntryPoint {
	
	protected Button sendButton;
	protected TextBox nameField;
	protected Label errorLabel;
	protected DialogBox dialogBox;
	protected Button closeButton;
	protected HTML serverResponseLabel;
	

	protected TextBox searchField;
	protected Button searchButton;
	protected VerticalPanel searchBox;
	
	protected Button playButton;
	protected Button pauseButton;
	protected Button stopButton;
	protected Audio lecteur;	
	protected Tree emissionTree;
	

	private final EmissionServiceAsync emissionService = GWT.create(EmissionService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		sendButton = new Button("Send");
		nameField = new TextBox();
		nameField.setText("GWT User");
		errorLabel = new Label();
		
		searchField = new TextBox();
		searchButton = new Button("Search");	
		searchBox = new VerticalPanel();
	    RootPanel.get().add(searchField);
	    RootPanel.get().add(searchButton);
	    RootPanel.get().add(searchBox);
		SearchHandler handler = new SearchHandler(this);
		searchButton.addClickHandler(handler);
		searchField.addKeyUpHandler(handler);
		
		
		emissionTree = new Tree();
		lecteur = Audio.createIfSupported();		
	    RootPanel.get().add(lecteur);	    

		playButton = new Button("Play");
		pauseButton = new Button("Pause");
		stopButton = new Button("Stop");
		

	    RootPanel.get().add(playButton);
	    RootPanel.get().add(pauseButton);
	    RootPanel.get().add(stopButton);
	    
		playButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			    lecteur.play();
			}
		});
		pauseButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			    lecteur.pause();
			}
		});
		stopButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			    lecteur.setSrc(lecteur.getSrc());
			}
		});
		
		emissionService.getEmissionListServer(null, new AsyncCallback<List<Emission>>() {
			public void onFailure(Throwable caught) {}

			@Override
			public void onSuccess(List<Emission> result) {

			    TreeItem root = new TreeItem();
			    root.setText("root");
			    emissionTree.addItem(root);
			    
			    Map<Integer, TreeItem> years = new HashMap<Integer, TreeItem>(); 
			    
			    Iterator<Emission> iterator = result.iterator();
			    while (iterator.hasNext()) {
			    	Emission e = iterator.next();
		        	
		        	if (!years.containsKey(e.getDate().getYear())) {
		        		TreeItem item = new TreeItem();
		        		item.setHTML(Integer.toString(e.getDate().getYear()));
		        		years.put(e.getDate().getYear(), item);
		        		root.addItem(item);
		        	}
		        	
		        	years.get(e.getDate().getYear()).addItem(new DisclosurePanel(e.getName()));
			    	
			    }
			    
			    RootPanel.get().add(emissionTree);
			    emissionTree.addSelectionHandler(new SelectionHandler<TreeItem>() {					
					@Override
					public void onSelection(SelectionEvent<TreeItem> event) {
						TreeItem selItem = event.getSelectedItem();
						TreeItem parent = selItem.getParentItem();
						selItem.getTree().setSelectedItem(parent, false); // null is ok
						if(parent != null)
							parent.setSelected(false);  // not compulsory
						selItem.setState(!selItem.getState(), false);
						String str = selItem.getHTML();
						if (str.contains("href")) {
							System.out.println(str);
							str = str.substring(str.indexOf("\"")+1, str.length());
							System.out.println(str);
							str = str.substring(0, str.indexOf("\""));
							System.out.println(str);
							lecteur.setSrc(str);
							lecteur.play();
						}
					}
				});				
			}
		});

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
//		RootPanel.get("nameFieldContainer").add(nameField);
//		RootPanel.get("sendButtonContainer").add(sendButton);
//		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
//		nameField.setFocus(true);
//		nameField.selectAll();

		// Create the popup dialog box
		dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Add a handler to send the name to the server
//		LcemHandler handler = new LcemHandler(this);
//		sendButton.addClickHandler(handler);
//		nameField.addKeyUpHandler(handler);
	}
}
