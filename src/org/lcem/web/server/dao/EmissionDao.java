package org.lcem.web.server.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.lcem.web.shared.model.Emission;
import org.lcem.web.utils.Node;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class EmissionDao {

	private static final Logger log = LogManager.getLogger(EmissionDao.class);
	
	public Node<String> getEmissionsTree() {

		List<Node<String>> children2009 = new ArrayList<Node<String>>();
		children2009.add(new Node<String>("<a href=\"\">01/01/2009 azeaze</a>"));
		children2009.add(new Node<String>("<a href=\"\">01/06/2009 qsdqsd</a>"));
		children2009.add(new Node<String>("<a href=\"\">01/12/2009 wxcwxc</a>"));
		

		List<Node<String>> children2010 = new ArrayList<Node<String>>();
		children2010.add(new Node<String>("<a href=\"\">01/01/2010 azeaze</a>"));
		children2010.add(new Node<String>("<a href=\"http://canalb.org/podcast/le-cinema-est-mort/le-cinema-est-mort_2015.02.05.mp3\"><b>01/03/2010 qsdqsd</b></a>"));
		children2010.add(new Node<String>("<a href=\"http://canalb.org/podcast/le-cinema-est-mort/le-cinema-est-mort_2015.02.26.mp3\"><b>01/06/2010 wxcwxc</b></a>"));
		children2010.add(new Node<String>("<a href=\"\">01/09/2010 rtyrty</a>"));
		children2010.add(new Node<String>("<a href=\"\">01/12/2010 fghfgh</a>"));
		

		List<Node<String>> children2011 = new ArrayList<Node<String>>();
		children2011.add(new Node<String>("<a href=\"\">01/01/2011 uiouio</a>"));
		children2011.add(new Node<String>("<a href=\"\">01/04/2011 jkljkl</a>"));
		children2011.add(new Node<String>("<a href=\"\">01/08/2011 ,;:,;:</a>"));
		children2011.add(new Node<String>("<a href=\"\">01/12/2011 rfvrfv</a>"));
		

		List<Node<String>> children2012 = new ArrayList<Node<String>>();
		children2012.add(new Node<String>("<a href=\"\">01/01/2012 aze</a>"));
		children2012.add(new Node<String>("<a href=\"\">01/02/2012 qsd</a>"));
		children2012.add(new Node<String>("<a href=\"\">01/03/2012 qsd</a>"));
		children2012.add(new Node<String>("<a href=\"\">01/04/2012 rty</a>"));
		children2012.add(new Node<String>("<a href=\"\">01/05/2012 fgh</a>"));
		children2012.add(new Node<String>("<a href=\"\">01/06/2012 vbn</a>"));
		children2012.add(new Node<String>("<a href=\"\">01/07/2012 uio</a>"));
		children2012.add(new Node<String>("<a href=\"\">01/08/2012 jkl</a>"));
		children2012.add(new Node<String>("<a href=\"\">01/09/2012 aqw</a>"));
		children2012.add(new Node<String>("<a href=\"\">01/10/2012 zsx</a>"));
		children2012.add(new Node<String>("<a href=\"\">01/11/2012 edc</a>"));
		children2012.add(new Node<String>("<a href=\"\">01/12/2012 rfv</a>"));
		
		List<Node<String>> children = new ArrayList<Node<String>>();
		Node<String> node = new Node<String>("2009", children2009);
		children.add(node);
		Node<String> node1 = new Node<String>("2010", children2010);
		children.add(node1);
		Node<String> node2 = new Node<String>("2011", children2011);
		children.add(node2);
		Node<String> node3 = new Node<String>("2012", children2012);
		children.add(node3);
		
		Node<String> tree = new Node<String>("root", children);
		
		log.info(tree);
		
		return tree;
		
	}
	
	public List<Emission> getEmissions() {
		ArrayList<Emission> emissions = new ArrayList<Emission>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Emission qsd = new Emission("qsdqsd", new Date(sdf.parse("05/02/2015").getTime()));
			Emission wxc = new Emission("wxcwxc", new Date(sdf.parse("26/02/2015").getTime()));
			
			qsd.setLink("http://canalb.org/podcast/le-cinema-est-mort/le-cinema-est-mort_2015.02.05.mp3");
			wxc.setLink("http://canalb.org/podcast/le-cinema-est-mort/le-cinema-est-mort_2015.02.26.mp3");
			
			emissions.add(qsd);
			emissions.add(wxc);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		}	
		log.info(emissions);
		
		return emissions;
	}
	
}
