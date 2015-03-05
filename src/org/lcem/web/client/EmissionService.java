package org.lcem.web.client;

import java.util.List;

import org.lcem.web.shared.model.Emission;
import org.lcem.web.utils.Node;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("emission")
public interface EmissionService extends RemoteService {
	Node<String> getEmissionTreeServer(String name) throws IllegalArgumentException;
	List<Emission> searchEmissionServer(String search) throws IllegalArgumentException;
}
