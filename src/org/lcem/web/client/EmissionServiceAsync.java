package org.lcem.web.client;

import java.util.List;

import org.lcem.web.shared.model.Emission;
import org.lcem.web.utils.Node;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EmissionServiceAsync {
	void getEmissionTreeServer(String input, AsyncCallback<Node<String>> callback) throws IllegalArgumentException;
	void searchEmissionServer(String search, AsyncCallback<List<Emission>> callback) throws IllegalArgumentException;
}
