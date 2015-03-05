package org.lcem.web.client;

import java.util.Iterator;
import java.util.List;

import org.lcem.web.shared.FieldVerifier;
import org.lcem.web.shared.model.Emission;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;

public class SearchHandler implements ClickHandler, KeyUpHandler {
	
	private Lcem entryPoint;
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	private final EmissionServiceAsync emissionService = GWT.create(EmissionService.class);
	
	public SearchHandler (Lcem entryPoint) {
		this.entryPoint = entryPoint;
	}
	
	/**
	 * Fired when the user clicks on the sendButton.
	 */
	public void onClick(ClickEvent event) {
		System.out.println("onclick");
		searchEmission();
	}

	/**
	 * Fired when the user types in the nameField.
	 */
	public void onKeyUp(KeyUpEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
			searchEmission();
		}
	}

	/**
	 * Send the name from the nameField to the server and wait for a response.
	 */
	private void searchEmission() {
		// First, we validate the input.
		entryPoint.errorLabel.setText("");
		String searchText = entryPoint.searchField.getText();
		
		// Then, we send the input to the server.
		entryPoint.sendButton.setEnabled(false);
		entryPoint.serverResponseLabel.setText("");
		emissionService.searchEmissionServer(searchText,
				new AsyncCallback<List<Emission>>() {
					@Override
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						entryPoint.dialogBox
								.setText("Remote Procedure Call - Failure");
						entryPoint.serverResponseLabel
								.addStyleName("serverResponseLabelError");
						entryPoint.serverResponseLabel.setHTML(SERVER_ERROR);
						entryPoint.dialogBox.center();
						entryPoint.closeButton.setFocus(true);
					}

					@Override
					public void onSuccess(List<Emission> result) {
						entryPoint.searchBox.clear();
						Iterator<Emission> iterator = result.iterator();
						while (iterator.hasNext()) {
							entryPoint.searchBox.add(new HTML(iterator.next().getLink()));							
						}
					}
				});
	}
}
