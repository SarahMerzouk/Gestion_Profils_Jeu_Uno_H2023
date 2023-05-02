package uno.frontal.evenements;

import ca.ntro.app.frontend.events.EventNtro;
import uno.frontal.fragments.FragmentProfil;

public class EvtAfficherInformations extends EventNtro {
	
	private String idProfil;
	
	public EvtAfficherInformations() {
		
	}

	public String getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(String idProfil) {
		this.idProfil = idProfil;
	}
	
}
