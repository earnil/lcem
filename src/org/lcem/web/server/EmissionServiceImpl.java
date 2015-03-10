package org.lcem.web.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.lcem.web.client.EmissionService;
import org.lcem.web.server.dao.EmissionDao;
import org.lcem.web.shared.model.Emission;
import org.lcem.web.utils.Node;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class EmissionServiceImpl extends RemoteServiceServlet implements EmissionService {

	private static final Logger log = LogManager.getLogger(EmissionDao.class);
	
	private EmissionDao emissionDao = new EmissionDao();
	
	@Override
	public Node<String> getEmissionTreeServer(String name) throws IllegalArgumentException {		
		log.info("getEmissionTreeServer");
		return emissionDao.getEmissionsTree();
	}

	@Override
	public List<Emission> searchEmissionServer(String search) throws IllegalArgumentException {
		log.info("searchEmissionServer");
		List<Emission> searchResults = new ArrayList<Emission>();
		
		Iterator<Emission> iterator = emissionDao.getEmissions().iterator();
		while (iterator.hasNext()) {
			Emission emission = iterator.next();
			if (searchEmission(emission, search)) {
				searchResults.add(emission);
			}
		}	
		
		if (searchResults.isEmpty())
			searchResults.add(new Emission(didYouMean(search), null));
		
		log.info(searchResults);
		return searchResults;
	}

	private String didYouMean(String search) {
		
		
		
		return null;
	}

	private boolean searchEmission(Emission emission, String search) {


		
		return false;
	}

}
